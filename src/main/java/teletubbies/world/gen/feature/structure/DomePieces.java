package teletubbies.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import teletubbies.Teletubbies;
import teletubbies.block.FullGrassBlock;
import teletubbies.init.ModBlocks;
import teletubbies.init.ModWorldGen;

public class DomePieces {
	
	public static final ResourceLocation DOME_TINKYWINKY = new ResourceLocation(Teletubbies.MODID, "dome_tinkywinky");
	public static final ResourceLocation DOME_DIPSY = new ResourceLocation(Teletubbies.MODID, "dome_dipsy");
	public static final ResourceLocation DOME_LAALAA = new ResourceLocation(Teletubbies.MODID, "dome_laalaa");
	public static final ResourceLocation DOME_PO = new ResourceLocation(Teletubbies.MODID, "dome_po");

	public static class Piece extends TemplateStructurePiece {
		
		private ResourceLocation resourceLocation;
		
	    public Piece(TemplateManager manager, ResourceLocation rl, BlockPos pos) {
	        super(ModWorldGen.DOME_PIECE, 0);
	        this.templatePosition = pos;
	        this.resourceLocation = rl;
	        this.setupPiece(manager);
	    }
	
	    public Piece(TemplateManager manager, CompoundNBT nbt) {
	        super(ModWorldGen.DOME_PIECE, nbt);
	        this.resourceLocation = new ResourceLocation(nbt.getString("resourceLocation"));
	        this.setupPiece(manager);
	    }
	
	    private void setupPiece(TemplateManager manager) {
	        Template template = manager.getTemplateDefaulted(this.resourceLocation);
	        PlacementSettings placementsettings = new PlacementSettings();
	        this.setup(template, this.templatePosition, placementsettings);
	    }
	    
        @Override
        protected void readAdditional(CompoundNBT nbt) {
            super.readAdditional(nbt);
            nbt.putString("resourceLocation", this.resourceLocation.toString());
        }
	    
	    @Override
	    public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox mbb, ChunkPos chunkPos, BlockPos pos) {
	    	boolean b = super.func_230383_a_(world, manager, generator, rand, mbb, chunkPos, pos);
	    	
	    	if (b) {	    		
    			// Get all blocks in the sphere of the dome
	        	for (int i = 0; i < mbb.getXSize(); i++) {
	        		for (int j = 0; j < mbb.getZSize(); j++) {	        			
	        			if (this.getBlockStateFromPos(world, i, 0, j, mbb).getBlock() instanceof FullGrassBlock ||
	        				this.getBlockStateFromPos(world, i, 0, j, mbb).getBlock() instanceof RedstoneTorchBlock ||
	        				this.getBlockStateFromPos(world, i, 0, j, mbb).getBlock() instanceof RedstoneLampBlock) {
	            			
	        				this.replaceAirAndLiquidDownwards(world, ModBlocks.FULL_GRASS.get().getDefaultState(), i, -1, j, mbb);
	        				this.replaceAirAndLiquidDownwardsThrough(world, Blocks.AIR.getDefaultState(), i, 8, j, 0, mbb);
	        			}
	        		}
	        	}
	    	}
	    	return b;
	    }
	
		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld world, Random rand, MutableBoundingBox mbb) {
			// Chest spawns but is not functional
			/*if (function.equals("chest")) {
				this.generateChest(world, mbb, rand, pos, TinkyWinkyBagItem.LOOTTABLE, Blocks.CHEST.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH));
			}*/
		}
		
		protected void replaceAirAndLiquidDownwardsThrough(ISeedReader world, BlockState blockstateIn, int x, int yHigh, int z, int yLow, MutableBoundingBox mbb) {
			int i = this.getXWithOffset(x, z);
			int j = this.getYWithOffset(yHigh);
			int k = this.getZWithOffset(x, z);
			final int low = this.getYWithOffset(yLow);
			if (mbb.isVecInside(new BlockPos(i, j, k))) {
				while (j >= low) {
					if ((world.isAirBlock(new BlockPos(i, j, k)) || world.getBlockState(new BlockPos(i, j, k)).getMaterial().isLiquid()) && j > 1) {
						world.setBlockState(new BlockPos(i, j, k), blockstateIn, 2);
					}
					else if ((world.getBlockState(new BlockPos(i, j, k)).hasProperty(BlockStateProperties.WATERLOGGED)) && j > 1) {
						world.setBlockState(new BlockPos(i, j, k), world.getBlockState(new BlockPos(i, j, k)).with(BlockStateProperties.WATERLOGGED, false), 2);
					}
					--j;
				}
			}
		}
	}
}