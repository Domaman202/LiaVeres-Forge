package com.algorithmlx.liaveres.common.util.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.pattern.BlockPattern;

public class StructureMobSpawnerBlock extends Block {
    public BlockPattern mobStructureBase;
    public BlockPattern mobStructureFull;

    public StructureMobSpawnerBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public BlockPattern getOrCreateMobBase() {
        return this.mobStructureBase;
    }

    public BlockPattern getOrCreateMobFull() {
        return this.mobStructureFull;
    }
}
