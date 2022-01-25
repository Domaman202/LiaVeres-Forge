package com.algorithmlx.liaveres.common.world.levelgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class FeatureConfig {
    public static final Codec<FeatureConfig> CODEC = RecordCodecBuilder.create((featureConfigInstance)
            -> featureConfigInstance.group(RuleTest.CODEC.fieldOf("target").forGetter((featureConfig)
            -> featureConfig.target), BlockState.CODEC.fieldOf("state").forGetter((featureConfig)
            -> featureConfig.state), Codec.intRange(0, 64).fieldOf("size").forGetter((featureConfig)
            -> featureConfig.size)).apply(featureConfigInstance, FeatureConfig::new)
    );
    public final RuleTest target;
    public final int size;
    public final BlockState state;

    public FeatureConfig(RuleTest test, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = test;
    }

    public static final class Fill {
        public static final RuleTest END_STONE = new BlockMatchTest(Blocks.END_STONE);
    }
}
