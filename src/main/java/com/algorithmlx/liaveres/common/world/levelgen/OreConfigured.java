package com.algorithmlx.liaveres.common.world.levelgen;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.world.levelgen.feature.FeatureConfig;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class OreConfigured {
    public static ConfiguredFeature<?,?> CRYSTALLITE;
    public static ConfiguredFeature<?,?> CRYSTALLITE_DEEPSLATE;
    public static ConfiguredFeature<?,?> CRYSTALLITE_NETHER;
    public static ConfiguredFeature<?,?> CRYSTALLITE_END;

    public static void register() {
        CRYSTALLITE = Feature.ORE.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Registration.CRYSTALLITE.get().defaultBlockState(), 1));
        CRYSTALLITE_DEEPSLATE = Feature.ORE.configured(new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Registration.CRYSTALLITE.get().defaultBlockState(), 1));
        CRYSTALLITE_NETHER = Feature.ORE.configured(new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, Registration.CRYSTALLITE.get().defaultBlockState(), 4));
        CRYSTALLITE_END = Feature.ORE.configured(new OreConfiguration(FeatureConfig.Fill.END_STONE, Registration.CRYSTALLITE.get().defaultBlockState(), 4));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster"), CRYSTALLITE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_deepslate"), CRYSTALLITE_DEEPSLATE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_nether"), CRYSTALLITE_NETHER);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeres.ModId, "crystalline_cluster_end"), CRYSTALLITE_END);
    }
}
