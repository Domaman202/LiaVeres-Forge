package com.algorithmlx.liaveres.common.world.levelgen.feature;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;

public class StructureConfigured {
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_AMDANOR_BASE = Registration.AMDANOR_BASE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(LiaVeres.ModId, "configured_amdanor_base"), CONFIGURED_AMDANOR_BASE);
    }
}
