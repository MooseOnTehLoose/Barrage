package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class TorchArrowEffect
    implements ArrowEffect
{

    private Material torch;
    private Material dirt;
    private Material air;

    public TorchArrowEffect()
    {
        torch = Material.TORCH;
        dirt = Material.DIRT;
        air = Material.AIR;
    }
    
    @SuppressWarnings("deprecation")
	public void setTorch(Arrow arrow) {
    	Location blockLoc = arrow.getLocation();
        Block b = blockLoc.getBlock();

        
        if( b.getType().equals(air) && (b.getRelative(BlockFace.DOWN)).getType().equals(air)) {
        	b.getRelative(BlockFace.DOWN).setType(dirt);
        	b.setType(torch);
        	
        	Block n = b.getRelative(BlockFace.NORTH);
        	Block s = b.getRelative(BlockFace.SOUTH);
        	Block e = b.getRelative(BlockFace.EAST);
        	Block w = b.getRelative(BlockFace.WEST);
        		
        	if (!e.getType().equals(air)) {

        		b.setData( (byte)2);
        		b.getRelative(BlockFace.DOWN).setType(air);
        			
        	}
        	else if (!w.getType().equals(air)) {

        		b.setData( (byte)1);
        		b.getRelative(BlockFace.DOWN).setType(air);
        	}
        	else if (!s.getType().equals(air)) {

        		b.setData( (byte)4);
        		b.getRelative(BlockFace.DOWN).setType(air);
     
        	}
        	else if (!n.getType().equals(air)) {

        		b.setData( (byte)3);
        		b.getRelative(BlockFace.DOWN).setType(air);
        			
        	}
        }
        else if (b.getType().equals(air) && !(b.getRelative(BlockFace.DOWN)).getType().equals(air) ) {
        	b.setType(torch);
        }
        	
        
        
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        if(!(target instanceof LivingEntity))
        {
        	//setTorch(arrow);   
        }
    }

    public void onGroundHitEvent(Arrow arrow)
    {
    	setTorch(arrow);   
    }
}
