package com.algorithmlx.liaveres.common.gata;

import com.algorithmlx.liaveres.common.gata.generators.advancement.AdvancementBase;
import com.algorithmlx.liaveres.common.gata.generators.BlockStates;
import com.algorithmlx.liaveres.common.gata.generators.ItemModels;
import com.algorithmlx.liaveres.common.gata.generators.Recipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new Recipes(generator));
            generator.addProvider(new AdvancementBase(generator));
        }

        if (event.includeClient()) {
            generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
        }
    }
}
