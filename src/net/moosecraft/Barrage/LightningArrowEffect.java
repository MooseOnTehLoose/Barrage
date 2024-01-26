package net.moosecraft.Barrage;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class LightningArrowEffect
    implements ArrowEffect
{

    public LightningArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        arrow.getWorld().strikeLightning(arrow.getLocation());
        arrow.remove();
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        arrow.getWorld().strikeLightning(arrow.getLocation());
        arrow.remove();
    }
}
