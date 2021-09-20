package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.tile.EnergyFurnaceTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, LiaVeres.ModId);

    public static final RegistryObject<TileEntityType<EnergyFurnaceTile>> ENERGY_FURNACE_TILE_TYPE = TILE_ENTITY_TYPE
            .register("ef_tile", () -> TileEntityType.Builder.create(EnergyFurnaceTile::new, BlockInit.ENERGY_FURNACE.get()).build(null));
}