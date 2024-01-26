package net.moosecraft.Barrage;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class WarpArrowEffect
    implements ArrowEffect
{

    public WarpArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow1, Entity entity)
    {
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Player player = (Player)arrow.getShooter();
        Location newLoc = arrow.getLocation();
        Location tempLoc = newLoc;
        for(; !newLoc.getBlock().isEmpty() && newLoc.getY() < 127D; newLoc.add(0.0D, 1.0D, 0.0D)) { }
        if(newLoc.getY() - tempLoc.getY() < 3D)
        {
            newLoc.setPitch(0.0F);
            player.teleport(newLoc);
            arrow.remove();
        } else
        {
            player.sendMessage((new StringBuilder()).append(ChatColor.RED).append("It's not safe to teleport into such a small area. Teleport canceled.").toString());
        }
    }
}
