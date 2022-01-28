package com.algorithmlx.liaveres.common.gata.generators.advancement;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class Advancements implements Consumer<Consumer<Advancement>> {

    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement main = Advancement.Builder.advancement()
                .display(Registration.CRYSTALLINE.get(),
                        new TranslatableComponent("advancement." + LiaVeres.ModId + ".main"),
                        new TranslatableComponent("advancement." + LiaVeres.ModId + ".main.desc"),
                        new ResourceLocation("minecraft", "textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("crystalline", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CRYSTALLINE.get()))
                .save(advancementConsumer, LiaVeres.ModId + "/main/main");
//        AdvancementBase.advancement();
    }
}
