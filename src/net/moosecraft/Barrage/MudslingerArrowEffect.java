package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class MudslingerArrowEffect
    implements ArrowEffect
{

    private Material dirt;

    public MudslingerArrowEffect()
    {
        dirt = Material.SAND;
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        Location blockLoc = arrow.getLocation();
        Block b = blockLoc.getBlock();
        b.setType(dirt);
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Location blockLoc = arrow.getLocation();
        Block b = blockLoc.getBlock();
        b.setType(dirt);
    }
}
