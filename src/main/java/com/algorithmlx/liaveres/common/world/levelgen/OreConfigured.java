package com.algorithmlx.liaveres.common.world.levelgen;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import core.liquid.world.FeatureConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class OreConfigured {
    public static Holder<ConfiguredFeature<OreConfiguration,?>> CRYSTALLITE;
    public static Holder<ConfiguredFeature<OreConfiguration,?>> CRYSTALLITE_DIM;

    public static void register() {
        CRYSTALLITE = FeatureUtils.register("crystalline_cluster",
                Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(
                                OreFeatures.STONE_ORE_REPLACEABLES,
                                Registration.CRYSTALLITE.get().defaultBlockState()
                        ),
                        OreConfiguration.target(
                                OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                                Registration.CRYSTALLITE.get().defaultBlockState()
                        )
                ), 1)
        );

        CRYSTALLITE_DIM = FeatureUtils.register(
                "crystalline_cluster_dim",
                Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        OreFeatures.NETHER_ORE_REPLACEABLES,
                                        Registration.CRYSTALLITE.get().defaultBlockState()
                                ),
                                OreConfiguration.target(
                                        OreFeatures.NETHERRACK,
                                        Registration.CRYSTALLITE.get().defaultBlockState()
                                ),
                                OreConfiguration.target(
                                        FeatureConfig.Fill.END_STONE,
                                        Registration.CRYSTALLITE.get().defaultBlockState()
                                )
                        ),

                        2
                )
        );
    }
}
