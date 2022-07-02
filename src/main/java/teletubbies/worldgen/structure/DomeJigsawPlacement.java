package teletubbies.worldgen.structure;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.lang3.mutable.MutableObject;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;

public class DomeJigsawPlacement {

	// From JigsawPlacement
	public static Optional<PieceGenerator<JigsawConfiguration>> addPieces(PieceGeneratorSupplier.Context<JigsawConfiguration> context, JigsawPlacement.PieceFactory factory, BlockPos chunkBlockPos, WorldgenRandom worldgenrandom, Rotation rotation) {
		RegistryAccess registryaccess = context.registryAccess();
		JigsawConfiguration jigsawconfiguration = context.config();
		ChunkGenerator chunkgenerator = context.chunkGenerator();
		StructureManager structuremanager = context.structureManager();
		LevelHeightAccessor levelheightaccessor = context.heightAccessor();
		Predicate<Holder<Biome>> predicate = context.validBiome();
		StructureFeature.bootstrap();
		Registry<StructureTemplatePool> registry = registryaccess.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY);
		StructureTemplatePool structuretemplatepool = jigsawconfiguration.startPool().value();
		StructurePoolElement structurepoolelement = structuretemplatepool.getRandomTemplate(worldgenrandom);
		
		if (structurepoolelement == EmptyPoolElement.INSTANCE) {
			return Optional.empty();
		} else {
			PoolElementStructurePiece poolelementstructurepiece = factory.create(structuremanager, structurepoolelement, chunkBlockPos, structurepoolelement.getGroundLevelDelta(), rotation, structurepoolelement.getBoundingBox(structuremanager, chunkBlockPos, rotation));
			BoundingBox boundingbox = poolelementstructurepiece.getBoundingBox();
			int i = (boundingbox.maxX() + boundingbox.minX()) / 2;
			int j = (boundingbox.maxZ() + boundingbox.minZ()) / 2;
			int k = chunkBlockPos.getY() + chunkgenerator.getFirstFreeHeight(i, j, Heightmap.Types.WORLD_SURFACE_WG, levelheightaccessor);

			if (!predicate.test(chunkgenerator.getNoiseBiome(QuartPos.fromBlock(i), QuartPos.fromBlock(k), QuartPos.fromBlock(j)))) {
				return Optional.empty();
			} else {
				int l = boundingbox.minY() + poolelementstructurepiece.getGroundLevelDelta();
				poolelementstructurepiece.move(0, k - l, 0);
				return Optional.of((p_210282_, p_210283_) -> {
					List<PoolElementStructurePiece> list = Lists.newArrayList();
					list.add(poolelementstructurepiece);
					if (jigsawconfiguration.maxDepth() > 0) {
						int i1 = 80;
						AABB aabb = new AABB((double) (i - 80), (double) (k - 80), (double) (j - 80), (double) (i + 80 + 1), (double) (k + 80 + 1), (double) (j + 80 + 1));
						JigsawPlacement.Placer jigsawplacement$placer = new JigsawPlacement.Placer(registry, jigsawconfiguration.maxDepth(), factory, chunkgenerator, structuremanager, list, worldgenrandom);
						jigsawplacement$placer.placing.addLast(new JigsawPlacement.PieceState(poolelementstructurepiece, new MutableObject<>(Shapes.join(Shapes.create(aabb), Shapes.create(AABB.of(boundingbox)), BooleanOp.ONLY_FIRST)), 0));

						while (!jigsawplacement$placer.placing.isEmpty()) {
							JigsawPlacement.PieceState jigsawplacement$piecestate = jigsawplacement$placer.placing.removeFirst();
							jigsawplacement$placer.tryPlacingChildren(jigsawplacement$piecestate.piece, jigsawplacement$piecestate.free, jigsawplacement$piecestate.depth, false, levelheightaccessor);
						}

						list.forEach(p_210282_::addPiece);
					}
				});
			}
		}
	}
}