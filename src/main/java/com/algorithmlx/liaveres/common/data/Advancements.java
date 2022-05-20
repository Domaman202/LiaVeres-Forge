package com.algorithmlx.liaveres.common.data;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import core.liquid.objects.data.gen.AdvancementGenerator;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class Advancements extends AdvancementGenerator implements Consumer<Consumer<Advancement>> {
    String m = LiaVeres.ModId;

    public Advancements(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement main = Advancement.Builder.advancement().display(Registration.CRYSTALLINE.get(),
                        new TranslatableComponent("advancement." + LiaVeres.ModId + ".main"),
                        new TranslatableComponent("advancement." + LiaVeres.ModId + ".main.desc"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("crystalline", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CRYSTALLINE.get()))
                .save(advancementConsumer, m + "/main/main");

        advancement(main, Registration.AMDANOR_UNLOCKER_KEY.get(), "get_key", FrameType.TASK, true, true, false, m);

    }
}
