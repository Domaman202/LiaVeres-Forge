package com.algorithmlx.liaveres.common.world.structures;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import java.util.Optional;

@SuppressWarnings("all")
public class AmdanorBaseStructure extends StructureFeature<JigsawConfiguration> {
    public static final Codec<JigsawConfiguration> CODEC = RecordCodecBuilder.create((codec) -> {
        return codec.group(
                StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(JigsawConfiguration::startPool),
                Codec.intRange(0, 30).fieldOf("size").forGetter(JigsawConfiguration::maxDepth)
        ).apply(codec, JigsawConfiguration::new);
    });

    public AmdanorBaseStructure() {
        super(CODEC, AmdanorBaseStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        ChunkPos chunkpos = context.chunkPos();

        return !context.chunkGenerator().hasFeatureChunkInRange(BuiltinStructureSets.OCEAN_MONUMENTS, context.seed(), chunkpos.x, chunkpos.z, 10);
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        if (!AmdanorBaseStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        blockpos = blockpos.above(60);
        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
                        PoolElementStructurePiece::new,
                        blockpos,
                        false,
                        true
                );


        if(structurePiecesGenerator.isPresent()) {
            LiaVeres.LOGGER.info(new TranslatableComponent("msg." + LiaVeres.ModId + ".structureLogging.amdanor").toString(), blockpos);
        } else {
            LiaVeres.LOGGER.error("Fatal. Reasion: Structure");
            Minecraft.crash(new CrashReport("LiaVeres: Sorry! I Don't generate this("+ Registration.AMDANOR_BASE.get().getRegistryName().getPath() +"). Please, inform the mod developer",
                    new Throwable("LiaVeres Generated CrashReport")));
        }

        return structurePiecesGenerator;
    }
}
