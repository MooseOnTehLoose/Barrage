package net.moosecraft.Barrage;


import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class BugbombArrowEffect
    implements ArrowEffect
{

    public BugbombArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        target.getWorld().spawnEntity(target.getLocation(), EntityType.CAVE_SPIDER);
        target.getWorld().spawnEntity(target.getLocation(), EntityType.SILVERFISH);
        target.getWorld().spawnEntity(target.getLocation(), EntityType.SILVERFISH);
        target.getWorld().spawnEntity(target.getLocation(), EntityType.SILVERFISH);
        target.getWorld().spawnEntity(target.getLocation(), EntityType.SILVERFISH);
        target.getWorld().spawnEntity(target.getLocation(), EntityType.SILVERFISH);
        arrow.remove();
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.CAVE_SPIDER);
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SILVERFISH);
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SILVERFISH);
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SILVERFISH);
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SILVERFISH);
        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SILVERFISH);
        arrow.remove();
    }
}
