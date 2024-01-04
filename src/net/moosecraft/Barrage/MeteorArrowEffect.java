package net.moosecraft.Barrage;



import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitRunnable;

public class MeteorArrowEffect extends BukkitRunnable {

    private final Arrow arrow;

    public MeteorArrowEffect(Arrow arrow) {

        this.arrow = arrow;
    }

    @Override
    public void run() {
        // What you want to schedule goes here
       Block center =  arrow.getLocation().getBlock();
       		   Block b1 = center.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH);
    		   Block b2 = center.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH);
    		   Block b3 = center.getRelative(BlockFace.EAST).getRelative(BlockFace.EAST);
    		   Block b4 = center.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST);
    		   Block b5 = b1.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH);
    		   Block b6 = b2.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH);
    		   Block b7 = b3.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH);
    		   Block b8 = b4.getRelative(BlockFace.SOUTH).getRelative(BlockFace.SOUTH);
    		   Block b9 = b3.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH);
    		   Block b10 = b4.getRelative(BlockFace.NORTH).getRelative(BlockFace.NORTH);
    		   Block b11 = b4.getRelative(BlockFace.WEST).getRelative(BlockFace.WEST);
    		   Block b12 = b3.getRelative(BlockFace.EAST).getRelative(BlockFace.EAST);
    		   
       
       
       
       arrow.getWorld().spawnFallingBlock(center.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b1.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b2.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b3.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b4.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b5.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b6.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b7.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b8.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b9.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b10.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b11.getLocation(), Material.MAGMA, (byte)0 );
       arrow.getWorld().spawnFallingBlock(b12.getLocation(), Material.MAGMA, (byte)0 );
       
      
    }

}
