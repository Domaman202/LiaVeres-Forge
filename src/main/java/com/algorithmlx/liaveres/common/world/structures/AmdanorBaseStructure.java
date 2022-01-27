package com.algorithmlx.liaveres.common.world.structures;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class AmdanorBaseStructure extends StructureFeature<JigsawConfiguration> {
    public AmdanorBaseStructure(Codec<JigsawConfiguration> CODEC) {
        super(CODEC, AmdanorBaseStructure::createPiecesGenerator);
    }

    @Override
    public @NotNull GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static final Lazy<List<MobSpawnSettings.SpawnerData>> STRUCTURE_CREATURES = Lazy.of(() -> ImmutableList.of(
            new MobSpawnSettings.SpawnerData(EntityType.WOLF, 30, 0, 1)
    ));

    public static void setupStructureSpawns(final StructureSpawnListGatherEvent event) {
        if(event.getStructure() == Registration.AMDANOR_BASE.get()) {
            event.addEntitySpawns(MobCategory.CREATURE, STRUCTURE_CREATURES.get());
        }
    }

    public static @NotNull Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        if (!AmdanorBaseStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        JigsawConfiguration newConfig =
                new JigsawConfiguration(() -> context.registryAccess().ownedRegistryOrThrow(Registry.TEMPLATE_POOL_REGISTRY).get(new ResourceLocation(LiaVeres.ModId, "amdanor_base/start_pool")), 5000
        );
        PieceGeneratorSupplier.Context<JigsawConfiguration> newContext = new PieceGeneratorSupplier.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.heightAccessor(),
                context.validBiome(),
                context.structureManager(),
                context.registryAccess()
        );
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(newContext, PoolElementStructurePiece::new, blockpos, false, true);

        if (structurePiecesGenerator.isPresent()) {
            LiaVeres.LOGGER.debug("Amdanor base spawned in coordinates: " + blockpos);
        }
        return structurePiecesGenerator;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        BlockPos blockPos = context.chunkPos().getWorldPosition();
        int landHeight = context.chunkGenerator().getFirstOccupiedHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(blockPos.getX(), blockPos.getZ(), context.heightAccessor());
        BlockState topBlock = columnOfBlocks.getBlock(landHeight);

        return topBlock.getFluidState().isEmpty();
    }
}
