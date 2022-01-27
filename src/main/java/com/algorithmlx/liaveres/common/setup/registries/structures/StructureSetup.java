package com.algorithmlx.liaveres.common.setup.registries.structures;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;

import java.util.HashMap;
import java.util.Map;

public class StructureSetup {
    public static void setupStructures() {
        setupMapSpacingAndLand(Registration.AMDANOR_BASE.get(), new StructureFeatureConfiguration(5000, 2, 1234567890), true);
    }

    public static <F extends StructureFeature<?>> void setupMapSpacingAndLand(F structure, StructureFeatureConfiguration structureFeatureConfiguration, boolean transformSurroundingLand) {
        StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        if (transformSurroundingLand) {
            StructureFeature.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<StructureFeature<?>>builder()
                            .addAll(StructureFeature.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }


        StructureSettings.DEFAULTS =
                ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
                        .putAll(StructureSettings.DEFAULTS)
                        .put(structure, structureFeatureConfiguration)
                        .build();

        BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = settings.getValue().structureSettings().structureConfig();

            if (structureMap instanceof ImmutableMap) {
                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureFeatureConfiguration);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else {
                structureMap.put(structure, structureFeatureConfiguration);
            }
        });
    }
}
