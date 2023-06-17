package com.rexbas.teletubbies.worldgen.structure;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DomeJigsawPlacement {

	// From JigsawPlacement
	public static Optional<Structure.GenerationStub> addPieces(Structure.GenerationContext context, Holder<StructureTemplatePool> startPool, BlockPos chunkBlockPos, WorldgenRandom worldgenrandom, Rotation rotation) {
		RegistryAccess registryaccess = context.registryAccess();
		ChunkGenerator chunkgenerator = context.chunkGenerator();
		StructureTemplateManager structuretemplatemanager = context.structureTemplateManager();
		LevelHeightAccessor levelheightaccessor = context.heightAccessor();
		Registry<StructureTemplatePool> registry = registryaccess.registryOrThrow(Registries.TEMPLATE_POOL);
		StructureTemplatePool structuretemplatepool = startPool.value();
		StructurePoolElement structurepoolelement = structuretemplatepool.getRandomTemplate(worldgenrandom);
		
		if (structurepoolelement == EmptyPoolElement.INSTANCE) {
			return Optional.empty();
		} else {
			Vec3i vec3i = chunkBlockPos.subtract(chunkBlockPos);
			BlockPos blockpos1 = chunkBlockPos.subtract(vec3i);
			PoolElementStructurePiece poolelementstructurepiece = new PoolElementStructurePiece(structuretemplatemanager, structurepoolelement, blockpos1, structurepoolelement.getGroundLevelDelta(), rotation, structurepoolelement.getBoundingBox(structuretemplatemanager, blockpos1, rotation));
			BoundingBox boundingbox = poolelementstructurepiece.getBoundingBox();
			int i = (boundingbox.maxX() + boundingbox.minX()) / 2;
			int j = (boundingbox.maxZ() + boundingbox.minZ()) / 2;
			int k = chunkBlockPos.getY() + chunkgenerator.getFirstFreeHeight(i, j, Heightmap.Types.WORLD_SURFACE_WG, levelheightaccessor, context.randomState());
			int l = boundingbox.minY() + poolelementstructurepiece.getGroundLevelDelta();
			poolelementstructurepiece.move(0, k - l, 0);
			int i1 = k + vec3i.getY();
			return Optional.of(new Structure.GenerationStub(new BlockPos(i, i1, j), (p_227237_) -> {
				List<PoolElementStructurePiece> list = Lists.newArrayList();
				list.add(poolelementstructurepiece);

				AABB aabb = new AABB(i - 1, (i1 - 1), (j - 1), (i + 2), (i1 + 2), (j + 2));
				VoxelShape voxelshape = Shapes.join(Shapes.create(aabb), Shapes.create(AABB.of(boundingbox)), BooleanOp.ONLY_FIRST);
				JigsawPlacement.addPieces(context.randomState(), 1, false, chunkgenerator, structuretemplatemanager, levelheightaccessor, worldgenrandom, registry, poolelementstructurepiece, list, voxelshape);
				list.forEach(p_227237_::addPiece);
			}));
		}
	}
}