package net.moosecraft.Barrage;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

// Referenced classes of package moosecraft:
//            ArrowEffect, Barrage

public class PoisonArrowEffect
    implements ArrowEffect
{

    public PoisonArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        LivingEntity e = (LivingEntity)target;
        e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Barrage.poisonSec, 1));
    }

    public void onGroundHitEvent(Arrow arrow1)
    {
    }
}
