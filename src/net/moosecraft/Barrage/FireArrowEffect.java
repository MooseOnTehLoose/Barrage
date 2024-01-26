package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

// Referenced classes of package moosecraft:
//            ArrowEffect, Barrage

public class FireArrowEffect
    implements ArrowEffect
{

    public FireArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        Entity e = (LivingEntity)target;
        e.setFireTicks(Barrage.fireSec);
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Location blockLoc = arrow.getLocation();
        arrow.remove();
        Block start = blockLoc.getBlock();
        Material a = Material.AIR;
        Material u = start.getRelative(BlockFace.UP).getType();
        Material d = start.getRelative(BlockFace.DOWN).getType();
        Material n = start.getRelative(BlockFace.NORTH).getType();
        Material s = start.getRelative(BlockFace.SOUTH).getType();
        Material e = start.getRelative(BlockFace.EAST).getType();
        Material w = start.getRelative(BlockFace.WEST).getType();
        if(a.equals(u))
        {
            blockLoc.getBlock().getRelative(BlockFace.UP).setType(Material.FIRE);
        }
        if(a.equals(n))
        {
            blockLoc.getBlock().getRelative(BlockFace.NORTH).setType(Material.FIRE);
        }
        if(a.equals(s))
        {
            blockLoc.getBlock().getRelative(BlockFace.SOUTH).setType(Material.FIRE);
        }
        if(a.equals(e))
        {
            blockLoc.getBlock().getRelative(BlockFace.EAST).setType(Material.FIRE);
        }
        if(a.equals(w))
        {
            blockLoc.getBlock().getRelative(BlockFace.WEST).setType(Material.FIRE);
        }
        if(a.equals(d))
        {
            blockLoc.getBlock().getRelative(BlockFace.DOWN).setType(Material.FIRE);
        }
    }
}
