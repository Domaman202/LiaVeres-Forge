package com.algorithmlx.liaveres.common.world.levelgen;

import com.algorithmlx.liaveres.common.LiaVeres;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.List;

@EventBusSubscriber
public class OrePlacement {
    public static PlacedFeature CRYSTALLITE_OVERWORLD;
    public static PlacedFeature CRYSTALLITE_DEEPSLATE;
    public static PlacedFeature CRYSTALLITE_NETHER;
    public static PlacedFeature CRYSTALLITE_END;

    public static void register() {
        CRYSTALLITE_OVERWORLD = OreConfigured.CRYSTALLITE
                .placed(orePlacement(1, HeightRangePlacement
                                .uniform(
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(256)
                                )
                        )
                );
        CRYSTALLITE_DEEPSLATE = OreConfigured.CRYSTALLITE_DEEPSLATE
                .placed(orePlacement(1, HeightRangePlacement
                                .uniform(
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(256)
                                )
                        )
                );
        CRYSTALLITE_NETHER = OreConfigured.CRYSTALLITE_NETHER
                .placed(orePlacement(4, HeightRangePlacement
                                .uniform(
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(256)
                                )
                        )
                );
        CRYSTALLITE_END = OreConfigured.CRYSTALLITE_END
                .placed(orePlacement(4, HeightRangePlacement
                                .uniform(
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(256)
                                )
                        )
                );
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster"), CRYSTALLITE_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_deepslate"), CRYSTALLITE_DEEPSLATE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_nether"), CRYSTALLITE_NETHER);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_end"), CRYSTALLITE_END);
    }
    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent loadingEvent) {
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(()-> CRYSTALLITE_OVERWORLD);
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(()-> CRYSTALLITE_DEEPSLATE);
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(()-> CRYSTALLITE_NETHER);
        loadingEvent.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(()-> CRYSTALLITE_END);
    }

    private static List<PlacementModifier> orePlace(PlacementModifier placementModifier, PlacementModifier modifier) {
        return List.of(placementModifier, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> orePlacement(int size, PlacementModifier placementModifier) {
        return orePlace(CountPlacement.of(size), placementModifier);
    }
}
