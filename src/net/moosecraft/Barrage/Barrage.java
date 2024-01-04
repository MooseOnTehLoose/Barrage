package net.moosecraft.Barrage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class Barrage extends JavaPlugin implements Listener {
    public class ArrowID {
        int id;
        ArrowType type;
        Player shooter;

        public ArrowID(int id, ArrowType type, Player shooter){
            this.id = 0;
            this.type = ArrowType.Arrow;
            this.shooter = null;
            this.id = id;
            this.type = type;
            this.shooter = shooter;
        }
    }

    public enum ArrowType{
    	Arrow, GlassHead, APmax, Torch, Net, Water, Fire, Lightning, Mudslinger, Warp, Poison, Frag, Impact, Bugbomb, PlanetCracker, Meteor;
    }

    
    private HashMap<Player, ArrowType> activeArrowType;
    private HashMap<ArrowType, String> enabledArrowList;
    private List<ArrowID> arrowList;
    static int poisonSec = 240;
    static int fireSec = 120;
    static int explosiveRadius = 2;
    static int force = 4;
    static int bypass = 3;
    static Double maxcrit = Double.valueOf(2D);
    static int crackradius = 15;
    static int crackpoison = 45;
    String nocost;


    public Barrage(){
        activeArrowType = new HashMap<Player, ArrowType >(14);
        enabledArrowList = new HashMap<ArrowType, String>(14);
        arrowList = new ArrayList<ArrowID>();
        nocost = "FREE";
    }
    
    @Override
    public void onEnable(){
        getLogger().info("Barrage has been enabled");
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        ArrowType aarrowtype[];
        int j = (aarrowtype = ArrowType.values()).length;
        for(int i = 0; i < j; i++){
            ArrowType type = aarrowtype[i];
            String cost = String.valueOf(getConfig().getString(type.name())).replaceAll(" ", "_").toUpperCase();
            if(cost != null && !cost.equals("NULL")){
                getLogger().info((new StringBuilder()).append(type).append(" : ").append(cost).toString());
                enabledArrowList.put(type, cost);
            } else if(cost != null && cost.equals(nocost)){
                getLogger().info((new StringBuilder()).append(type).append(" : ").append(nocost).toString());
                enabledArrowList.put(type, nocost);
            } else if(cost != null && cost.equals("NULL") && type == ArrowType.Arrow){
                getLogger().info((new StringBuilder()).append(type).append(" : ").append(nocost).toString());
                enabledArrowList.put(type, nocost);
            }
        }

    }
    
    @Override
    public void onDisable(){
        getLogger().info("Barrage has been disabled");
    }

    public static void msgPlayer(Player player, String msg){
        player.sendMessage((new StringBuilder()).append(ChatColor.AQUA).append(msg).toString());
    }
    
    //this method checks if a player has enough materials to fire an arrow

	public Boolean invCheck(Player player, String cost, Boolean remove){
        if(cost.equals(nocost)){
            return Boolean.valueOf(true);
        }
        
        HashMap<Material, Integer> matRequirements = new HashMap<>();
        HashMap<Material, Integer> matInventory = new HashMap<>();
        String items[] = cost.split(",");
        int k = items.length;
        for(int j = 0; j < k; j++){
            String item = items[j];
            String nameAndCost[] = item.split(":");
            String mat = nameAndCost[0].toUpperCase();
            Integer num;
            try{
                num = Integer.valueOf(Integer.parseInt(nameAndCost[1]));
            }
            catch(NumberFormatException e){
                num = Integer.valueOf(0);
            }
            if(num.intValue() > 64){
                num = Integer.valueOf(64);
            }
            if(!mat.equals(nocost)){
                matRequirements.put(Material.valueOf(mat), num);
            }
        }
        
        //find out whats in the hotbar
        for(int i = 0; i < 9; i++){
            ItemStack item = player.getInventory().getItem(i);
            if(item != null){
                Integer inInv = Integer.valueOf(item.getAmount());
                if(inInv == null){
                    inInv = Integer.valueOf(0);
                }
                Material name = item.getType();
                if(matInventory.containsKey(name)){
                    Integer previousAmt = (Integer)matInventory.get(name);
                    inInv = Integer.valueOf(previousAmt.intValue() + inInv.intValue());
                }
                matInventory.put(name, inInv);
            }
        }
        
        //find out if theres at least as much items in inventory as cost requires
        int reqcounter = 0;
        
        for(Iterator<Entry<Material, Integer>> iterator = matRequirements.entrySet().iterator(); iterator.hasNext();)
        {
            Entry<Material, Integer> entry = (Entry<Material, Integer>)iterator.next();
            Material key = (Material)entry.getKey();
            Integer matAmt = (Integer)entry.getValue();
            Integer invAmt = (Integer)matInventory.get(key);
            if(invAmt == null)
            {
                invAmt = Integer.valueOf(0);
            }
            int valueReq = matAmt.intValue();
            int valueMat = invAmt.intValue();
            if(valueReq <= valueMat)
            {
                reqcounter++;
            }
        }

        if(reqcounter == matRequirements.size())
        {
            if(remove.booleanValue())
            {
                Entry<Material, Integer> entry;
                for(Iterator<Entry<Material, Integer>> iterator1 = matRequirements.entrySet().iterator(); iterator1.hasNext(); player.getInventory().removeItem(new ItemStack[] {
    new ItemStack((Material)entry.getKey(), ((Integer)entry.getValue()).intValue())
}))
                {
                    entry = (Entry<Material, Integer>)iterator1.next();
                }

                player.updateInventory();
            }
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
    	
        Player player = event.getPlayer();
        if(event.getItem() != null && event.getItem().getType() == Material.BOW && (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR))
        {
            if(!activeArrowType.containsKey(player))
            {
                activeArrowType.put(player, ArrowType.Arrow);
            }
            
            ArrowType active = (ArrowType)activeArrowType.get(player);
            
            ArrayList<ArrowType> invContains = new ArrayList<ArrowType>();
            
            for(Iterator<Entry<ArrowType, String>> iterator = enabledArrowList.entrySet().iterator(); iterator.hasNext();)
            {
                Entry<ArrowType, String> entry = (Entry<ArrowType, String>)iterator.next();
                ArrowType key = (ArrowType)entry.getKey();
                String value = (String)entry.getValue();
                if(value.equals(nocost))
                {
                    invContains.add(key);
                } else
                if(invCheck(player, value, Boolean.valueOf(false)).booleanValue())
                {
                    invContains.add(key);
                }
            }

            int invSize = invContains.size() - 1;
            int newPos = 0;
            for(Iterator<ArrowType> iterator1 = invContains.iterator(); iterator1.hasNext();)
            {
                ArrowType arrow = (ArrowType)iterator1.next();
                if(active.name().equals(arrow.name()))
                {
                    newPos = invContains.indexOf(arrow);
                }
            }

            if(newPos == invSize)
            {
                active = (ArrowType)invContains.get(0);
            } else
            {
                active = (ArrowType)invContains.get(newPos + 1);
            }
            activeArrowType.put(player, active);
            if(active.name().equals("Arrow"))
            {
                msgPlayer(event.getPlayer(), "Equipping Arrows");
            } else
            {
                msgPlayer(event.getPlayer(), (new StringBuilder("Equipping ")).append(active.name()).append(" Arrows").toString());
            }
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void playerBowShoot(EntityShootBowEvent e)
    {
    	
        if(e.getEntity() instanceof Player)
        {
            Entity entity = e.getEntity();
            Entity arrow = e.getProjectile();
            Player player = (Player)entity;
            ArrowType arrowType = (ArrowType)activeArrowType.get(player);
            ArrowID newArrow = new ArrowID(arrow.getEntityId(), ArrowType.Arrow, player);
            String cost = (String)enabledArrowList.get(arrowType);
            if(invCheck(player, cost, Boolean.valueOf(true)).booleanValue())
            {
                newArrow = new ArrowID(arrow.getEntityId(), arrowType, player);
                if (arrowType.equals(ArrowType.Meteor)){
                	MeteorArrowEffect mEffect = new MeteorArrowEffect ((Arrow)arrow);
                	mEffect.runTaskLater(this, 20);

                
                }
            }
            
            
            arrowList.add(newArrow);
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onProjectileHit(ProjectileHitEvent event)
    {
        ArrowType arrowType = ArrowType.Arrow;
        if(!(event.getEntity() instanceof Arrow))
        {
            return;
        }
        Arrow arrow = (Arrow)event.getEntity();
        if(!(arrow.getShooter() instanceof Player))
        {
            return;
        }
        for(Iterator<ArrowID> iterator = arrowList.iterator(); iterator.hasNext();)
        {
            ArrowID aid = (ArrowID)iterator.next();
            if(aid.id == event.getEntity().getEntityId())
            {
                arrowType = aid.type;
            }
        }

        List<Entity> entities = arrow.getNearbyEntities(1.0D, 1.0D, 1.0D);
        int entCount = entities.size();
        for(Iterator<Entity> iterator1 = entities.iterator(); iterator1.hasNext();)
        {
            Entity ent = (Entity)iterator1.next();
            if((ent instanceof Arrow) || (ent instanceof Item) || ent == arrow.getShooter())
            {
                entCount--;
            }
        }

        try
        {
            if(entCount == 0 && arrowType != ArrowType.Arrow)
            {
                ArrowEffect arrowEffect = null;
                String className = (new StringBuilder("net.moosecraft.Barrage.")).append(arrowType.toString()).append("ArrowEffect").toString();
                try
                {
                    arrowEffect = (ArrowEffect)Class.forName(className).newInstance();
                }
                catch(ClassNotFoundException e)
                {
                    getLogger().warning((new StringBuilder("Failed to find class ")).append(className).toString());
                }
                catch(InstantiationException e)
                {
                    getLogger().warning((new StringBuilder("Could not instantiate class ")).append(className).toString());
                }
                catch(IllegalAccessException e)
                {
                    getLogger().warning((new StringBuilder("Could not access class ")).append(className).toString());
                }
                arrowEffect.onGroundHitEvent(arrow);
                if(arrowList.size() > 50)
                {
                    for(; arrowList.size() > 50; arrowList.remove(0)) { }
                }
            }
        }
        catch(Exception ex)
        {
            return;
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamage(EntityDamageEvent event)
    {
        ArrowType arrowType = ArrowType.Arrow;
       
        if(event.getCause() != org.bukkit.event.entity.EntityDamageEvent.DamageCause.PROJECTILE)
        {
            return;
        }
        
        if(!(event instanceof EntityDamageByEntityEvent))
        {
            return;
        }
        
        EntityDamageByEntityEvent ebe;
        
        Arrow arrow;
        
        try
        {
            ebe = (EntityDamageByEntityEvent)event;
            
            if(!(ebe.getDamager() instanceof Arrow))
            {
                return;
            }
        }
        catch(Exception ex)
        {
            return;
        }
        
        arrow = (Arrow)ebe.getDamager();
        
        if(!(arrow.getShooter() instanceof Player))
        {
            return;
        }
        
        ebe = (EntityDamageByEntityEvent)event;
        if(!(ebe.getDamager() instanceof Arrow))
        {
            return;
        }
       arrow = (Arrow)ebe.getDamager();
        if(!(arrow.getShooter() instanceof Player))
        {
            return;
        }
        for(Iterator<ArrowID> iterator = arrowList.iterator(); iterator.hasNext();)
        {
            ArrowID aid = (ArrowID)iterator.next();
            if(aid.id == arrow.getEntityId())
            {
                arrowType = aid.type;
            }
        }

        try
        {
            if(arrowType != ArrowType.Arrow)
            {
                ArrowEffect arrowEffect = null;
                if(arrowType == ArrowType.Impact)
                {
                    event.setDamage(0);
                }
                if(arrowType == ArrowType.APmax)
                {
                    event.setDamage(3);
                }
                if(arrowType == ArrowType.Poison)
                {
                    event.setDamage(0);
                }
                if(arrowType == ArrowType.Torch)
                {
                    event.setDamage(0);
                }
                if(arrowType == ArrowType.Bugbomb)
                {
                    event.setDamage(0);
                }
                if(arrowType == ArrowType.Net)
                {
                    event.setDamage(0);
                }
                String className = (new StringBuilder("net.moosecraft.Barrage.")).append(arrowType.toString()).append("ArrowEffect").toString();
                try
                {
                    arrowEffect = (ArrowEffect)Class.forName(className).newInstance();
                }
                catch(ClassNotFoundException e)
                {
                    getLogger().warning((new StringBuilder("Failed to find class ")).append(className).toString());
                }
                catch(InstantiationException e)
                {
                    getLogger().warning((new StringBuilder("Could not instantiate class ")).append(className).toString());
                }
                catch(IllegalAccessException e)
                {
                    getLogger().warning((new StringBuilder("Could not access class ")).append(className).toString());
                }
                arrowEffect.onEntityHitEvent(arrow, event.getEntity());
            }
            if(arrowList.size() > 50)
            {
                for(; arrowList.size() > 50; arrowList.remove(0)) { }
            }
        }
        catch(Exception ex)
        {
            return;
        }
        return;
    }
    

}
