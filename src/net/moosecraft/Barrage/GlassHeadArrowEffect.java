package net.moosecraft.Barrage;

import java.util.Random;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

// Referenced classes of package moosecraft:
//            ArrowEffect, Barrage

public class GlassHeadArrowEffect
    implements ArrowEffect
{

    public GlassHeadArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        if(target instanceof LivingEntity)
        {
            Double damage = Double.valueOf(((LivingEntity)target).getLastDamage());
            Double maxdamage = Double.valueOf(damage.doubleValue() * Barrage.maxcrit.doubleValue());
            Random r = new Random();
            double randDamage = damage.doubleValue() + (maxdamage.doubleValue() - damage.doubleValue()) * r.nextDouble();
            ((LivingEntity)target).setLastDamage(randDamage);
        }
    }

    public void onGroundHitEvent(Arrow arrow1)
    {
    }
}
