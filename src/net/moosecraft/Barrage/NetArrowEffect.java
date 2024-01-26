package net.moosecraft.Barrage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

// Referenced classes of package moosecraft:
//            ArrowEffect

public class NetArrowEffect
    implements ArrowEffect
{

    private Block changedBlocks[];
    private int blockIndex;
    private Material web;

    public NetArrowEffect()
    {
        web = Material.COBWEB;
    }

    public void onEntityHitEvent(Arrow arrow, Entity target)
    {
        Location blockLoc = target.getLocation();
        Block b = blockLoc.getBlock();
        changedBlocks = new Block[20];
        blockIndex = 0;
        for(; b.getType() == Material.AIR; b = blockLoc.getBlock())
        {
            blockLoc.subtract(0.0D, 1.0D, 0.0D);
        }

        blockLoc.add(0.0D, 1.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            b.setType(web);
            changedBlocks[blockIndex] = b;
            blockIndex++;
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
    }

    public void onGroundHitEvent(Arrow arrow)
    {
        Location blockLoc = arrow.getLocation();
        Block b = blockLoc.getBlock();
        changedBlocks = new Block[20];
        blockIndex = 0;
        for(; b.getType() == Material.AIR; b = blockLoc.getBlock())
        {
            blockLoc.subtract(0.0D, 1.0D, 0.0D);
        }

        blockLoc.add(0.0D, 1.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            b.setType(web);
            changedBlocks[blockIndex] = b;
            blockIndex++;
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.subtract(0.0D, 0.0D, 1.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
        blockLoc.add(1.0D, 0.0D, 0.0D);
        b = blockLoc.getBlock();
        if(b.getType() == Material.AIR)
        {
            if(b.getRelative(0, -1, 0).getType() == Material.AIR)
            {
                b.getRelative(0, -1, 0).setType(web);
                changedBlocks[blockIndex] = b.getRelative(0, -1, 0);
                blockIndex++;
            } else
            {
                b.setType(web);
                changedBlocks[blockIndex] = b;
                blockIndex++;
            }
        }
    }
}
