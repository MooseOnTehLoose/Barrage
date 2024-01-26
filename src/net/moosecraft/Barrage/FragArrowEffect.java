package net.moosecraft.Barrage;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

// Referenced classes of package moosecraft:
//            ArrowEffect, Barrage

public class FragArrowEffect
    implements ArrowEffect
{

    public FragArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        org.bukkit.Location location = arrow.getLocation();
        arrow.getWorld().createExplosion(location, Barrage.explosiveRadius);
        arrow.remove();
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        org.bukkit.Location location = arrow.getLocation();
        arrow.getWorld().createExplosion(location, Barrage.explosiveRadius);
        arrow.remove();
    }
}
