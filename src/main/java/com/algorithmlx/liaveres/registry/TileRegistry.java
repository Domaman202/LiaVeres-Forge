package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.tile.EnergyFurnaceTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class TileRegistry {

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModId);

    public static void init() {
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<EnergyFurnaceTile>> ENERGY_FURNACE_TILE_TYPE = TILES.register("ef_tile", () -> TileEntityType.Builder.create(EnergyFurnaceTile::new, ModBlocks.ENERGY_FURNACE.get()).build(null));
}