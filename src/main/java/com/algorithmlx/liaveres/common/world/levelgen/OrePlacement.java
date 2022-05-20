package com.algorithmlx.liaveres.common.world.levelgen;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.List;

@EventBusSubscriber
public class OrePlacement {
    public static Holder<PlacedFeature> CRYSTALLITE_OVERWORLD;
    public static Holder<PlacedFeature> CRYSTALLITE_DIM;

    public static void register() {
        CRYSTALLITE_OVERWORLD = PlacementUtils.register(
                "crystallite_cluster",
                OreConfigured.CRYSTALLITE,
                orePlacement(1,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(20)
                        )
                )
        );

        CRYSTALLITE_DIM = PlacementUtils.register(
                "crystallite_dim",
                OreConfigured.CRYSTALLITE_DIM,
                orePlacement(1,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(256)
                        )
                )
        );
    }
    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent loadingEvent) {
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(CRYSTALLITE_OVERWORLD);
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(CRYSTALLITE_DIM);
    }

    private static List<PlacementModifier> orePlace(PlacementModifier placementModifier, PlacementModifier modifier) {
        return List.of(placementModifier, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> orePlacement(int size, PlacementModifier placementModifier) {
        return orePlace(CountPlacement.of(size), placementModifier);
    }
}
