package net.moosecraft.Barrage;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

public interface ArrowEffect
{

    public abstract void onEntityHitEvent(Arrow arrow, Entity entity);

    public abstract void onGroundHitEvent(Arrow arrow);
}
