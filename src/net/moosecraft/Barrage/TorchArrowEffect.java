package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class TorchArrowEffect
    implements ArrowEffect
{

    private Material torch;

    public TorchArrowEffect()
    {
        torch = Material.TORCH;
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        if(!(target instanceof LivingEntity))
        {
            Location blockLoc = arrow.getLocation();
            Block b = blockLoc.getBlock();
            b.setType(torch);
        }
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Location blockLoc = arrow.getLocation();
        Block b = blockLoc.getBlock();
        b.setType(torch);
    }
}
