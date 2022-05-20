package com.algorithmlx.liaveres.common.data;


import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {
    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, LiaVeres.ModId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.GILDED_NETHERITE_BLOCK.get());
    }
}
