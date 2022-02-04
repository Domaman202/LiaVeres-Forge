package com.algorithmlx.liaveres.common.event;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

//FIXME

//@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CraftingEvent {
//    @SubscribeEvent
    public void init(EntityJoinWorldEvent event) {
        Entity e = event.getEntity();
        EntityType<?> et = e.getType();
        if (et == EntityType.LIGHTNING_BOLT) {
            BlockPos pos = event.getEntity().blockPosition();
            Level level = event.getWorld();

            ItemEntity itemEntity = (ItemEntity) e;
            Item item = itemEntity.getItem().getItem();

            if (!(item == Registration.EMPTY_ARTIFACT.get())) {
                int x = itemEntity.getBlockX();
                int y = itemEntity.getBlockY();
                int z = itemEntity.getBlockZ();

                List<ItemEntity> itemEntityList =
                        level.getEntitiesOfClass(ItemEntity.class, new AABB(pos.mutable().move(x, y, z)));
                for (ItemEntity entity : itemEntityList) {
                    if (entity.getItem().getItem() == Registration.EMPTY_ARTIFACT.get())
                        entity.spawnAtLocation(Registration.LIGHTNING_ARTIFACT.get(), 1);
                }
            }
        }
    }
}
