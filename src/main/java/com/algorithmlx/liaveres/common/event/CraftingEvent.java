package com.algorithmlx.liaveres.common.event;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CraftingEvent {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void init(EntityStruckByLightningEvent event) {
        lightningBolt(event);
    }

    private void lightningBolt(@NotNull EntityStruckByLightningEvent event) {
        Level level = event.getLightning().getLevel();
        if (event.getEntity() instanceof ItemEntity entity) {
            Item item = entity.getItem().getItem();
            int x = entity.getBlockX();
            int y = entity.getBlockY();
            int z = entity.getBlockZ();
            if (item == Registration.LIGHTNING_ARTIFACT.get()) {
                level.getEntities(entity, AABB.ofSize(Vec3.atCenterOf(Vec3i.ZERO), x, y, z));
            }
        }
    }
}
