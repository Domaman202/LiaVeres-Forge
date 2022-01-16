package com.algorithmlx.liaveres.event;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.entity.AmdanorMob;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributes {
    @SubscribeEvent
    public static void registryEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(Registration.AMDANOR_SKELETON.get(), AmdanorMob.prepareAttributes().build());
    }
}
