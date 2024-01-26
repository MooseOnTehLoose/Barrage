package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

// Referenced classes of package moosecraft:
//            ArrowEffect, Barrage

public class PlanetCrackerArrowEffect
    implements ArrowEffect
{

    public PlanetCrackerArrowEffect()
    {
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        arrow.remove();
        Location location = target.getLocation();
        target.getWorld().strikeLightning(target.getLocation());
        target.getWorld().strikeLightning(target.getLocation().add(3D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().add(2D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().add(1.0D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().subtract(3D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().subtract(2D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().subtract(1.0D, 0.0D, 0.0D));
        target.getWorld().strikeLightning(target.getLocation().add(0.0D, 0.0D, 3D));
        target.getWorld().strikeLightning(target.getLocation().add(0.0D, 0.0D, 2D));
        target.getWorld().strikeLightning(target.getLocation().add(0.0D, 0.0D, 1.0D));
        target.getWorld().strikeLightning(target.getLocation().subtract(0.0D, 0.0D, 3D));
        target.getWorld().strikeLightning(target.getLocation().subtract(0.0D, 0.0D, 2D));
        target.getWorld().strikeLightning(target.getLocation().subtract(0.0D, 0.0D, 1.0D));
        target.getWorld().createExplosion(location, Barrage.crackradius);
        Player player = (Player)arrow.getShooter();
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Barrage.crackpoison, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Barrage.crackpoison, 1));
        player.setHealth(1.0D);
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Location location = arrow.getLocation();
        arrow.getWorld().strikeLightning(arrow.getLocation());
        arrow.getWorld().strikeLightning(arrow.getLocation().add(3D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().add(2D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().add(1.0D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(3D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(2D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(1.0D, 0.0D, 0.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().add(0.0D, 0.0D, 3D));
        arrow.getWorld().strikeLightning(arrow.getLocation().add(0.0D, 0.0D, 2D));
        arrow.getWorld().strikeLightning(arrow.getLocation().add(0.0D, 0.0D, 1.0D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(0.0D, 0.0D, 3D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(0.0D, 0.0D, 2D));
        arrow.getWorld().strikeLightning(arrow.getLocation().subtract(0.0D, 0.0D, 1.0D));
        arrow.getWorld().createExplosion(location, Barrage.crackradius);
        arrow.remove();
        Player player = (Player)arrow.getShooter();
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Barrage.crackpoison, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Barrage.crackpoison, 1));
        player.setHealth(1.0D);
    }
}
