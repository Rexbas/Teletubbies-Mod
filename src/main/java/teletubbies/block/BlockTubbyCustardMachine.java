package teletubbies.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTubbyCustardMachine extends BlockContainer{

	public BlockTubbyCustardMachine(){
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.setBlockName("TubbyCustardMachine");
        this.setBlockTextureName("teletubbies:TubbyCustardMachine");
        this.setHardness(0.5F);
        this.setResistance(10.0F);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack){
		super.onBlockPlacedBy(world, x, y, z, player, itemstack);
	    int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	    
	    if(direction == 0 || direction == 2){
    		world.setBlock(x - 1, y, z, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x + 1, y, z, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x -1, y + 1, z, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x + 1, y + 1, z, Teletubbies.tubbyCustardMachine);
    		
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(x - 1, y, z);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(x + 1, y, z);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(x - 1, y + 1, z);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(x + 1, y + 1, z);
    		
    		te1.setMasterData(x, y, z, direction, false);
    		te2.setMasterData(x, y, z, direction, false);
    		te3.setMasterData(x, y, z, direction, false);
    		te4.setMasterData(x, y, z, direction, false);
	    }
	    if(direction == 1 || direction == 3){
    		world.setBlock(x, y, z - 1, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x, y, z + 1, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x, y + 1, z - 1, Teletubbies.tubbyCustardMachine);
    		world.setBlock(x, y + 1, z + 1, Teletubbies.tubbyCustardMachine);
    		
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y, z - 1);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y, z + 1);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y + 1, z - 1);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y + 1, z + 1);
    		
    		te1.setMasterData(x, y, z, direction, false);
    		te2.setMasterData(x, y, z, direction, false);
    		te3.setMasterData(x, y, z, direction, false);
    		te4.setMasterData(x, y, z, direction, false);
	    }
	    
	    TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine)world.getTileEntity(x, y, z);
		te.setMasterData(x, y, z, direction, true);
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y, z);
        if(te == null || player.isSneaking()) {  
        	return false;
        }
	
        if(player.getHeldItem() != null){
    		String hand = player.getHeldItem().getUnlocalizedName();
    		String tubbyBowl = Teletubbies.tubbyBowl.getUnlocalizedName();
    		if(hand.equals(tubbyBowl)){
    			int slot = player.inventory.currentItem;
    			int size = player.inventory.getStackInSlot(slot).stackSize;
    			ItemStack stack0 = player.inventory.getStackInSlot(slot);
    			ItemStack custard = new ItemStack(Teletubbies.tubbyCustard, 1);
    			
    			if(size == 1){
    				player.inventory.setInventorySlotContents(slot, custard);
    				return false;
    			}
    			
    			if(player.inventory.getFirstEmptyStack() > -1){
    				--stack0.stackSize;
    				player.inventory.addItemStackToInventory(custard);
    				return false;
    			}
    		}
    		else if(world.isRemote){
    			ChatComponentText msg = new ChatComponentText(StatCollector.translateToLocal("teletubbies.TubbyCustardMachine.message"));
    			player.addChatMessage(msg);
    		}
        }
		else if(world.isRemote){
			ChatComponentText msg = new ChatComponentText(StatCollector.translateToLocal("teletubbies.TubbyCustardMachine.message"));
			player.addChatMessage(msg);
		}
		return true;
	}
		
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_){
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine)world.getTileEntity(x, y, z);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z){
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine) world.getTileEntity(x, y, z);
		if(te.getMasterDirection() == null){
			
		}
		if(te.getMasterDirection() == 0 || te.getMasterDirection() == 2){
			world.setBlockToAir(x - 1, y, z);
			world.setBlockToAir(x + 1, y, z);
			world.setBlockToAir(x - 1, y + 1, z);
			world.setBlockToAir(x + 1, y + 1, z);
		}
		if(te.getMasterDirection() == 1 || te.getMasterDirection() == 3){
			world.setBlockToAir(x, y, z - 1);
			world.setBlockToAir(x, y, z + 1);
			world.setBlockToAir(x, y + 1, z - 1);
			world.setBlockToAir(x, y + 1, z + 1);
		}
	
		world.setBlockToAir(x, y, z);
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
    	return new TileEntityTubbyCustardMachine();
    }
    
    @Override
    public int getRenderType() {
    	return -1;
    }
    
    @Override
    public int quantityDropped(Random par1Random){
    	return 1;
    }

    @Override
    public boolean isOpaqueCube() {
    	return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg){
    	this.blockIcon = reg.registerIcon("teletubbies:icon_TubbyCustardMachine");
    }
}