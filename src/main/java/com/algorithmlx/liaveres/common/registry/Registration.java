package com.algorithmlx.liaveres.common.registry;

import com.algorithmlx.liaveres.common.blocks.MatterCrystalBlock;
import com.algorithmlx.liaveres.common.items.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;
import static com.algorithmlx.liaveres.common.setup.ModSetup.LIAVERES_ALL;

public class Registration {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<MatterCrystalBlock> MATTER_CRYSTAL_BLOCK = BLOCKS.register("matter_crystal_block", MatterCrystalBlock::new);

    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEMS.register("matter_crystal_helmet",
            () -> new MatterCrystalArmor(EquipmentSlot.HEAD, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEMS.register("matter_crystal_chestplate",
            () -> new MatterCrystalArmor(EquipmentSlot.CHEST, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEMS.register("matter_crystal_leggings",
            () -> new MatterCrystalArmor(EquipmentSlot.LEGS, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEMS.register("matter_crystal_boots",
            () -> new MatterCrystalArmor(EquipmentSlot.FEET, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));

    public static final RegistryObject<Item> MATTER_CRYSTAL_BLOCK_ITEM = ITEMS.register("matter_crystal_block", () -> new BlockItem(MATTER_CRYSTAL_BLOCK.get(), new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> CRYSTALLINE = ITEMS.register("crystalline", Crystalline::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL = ITEMS.register("matter_crystal", MatterCrystal::new);
    public static final RegistryObject<Item> MATTER = ITEMS.register("matter", Matter::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_AXE = ITEMS.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_PICKAXE = ITEMS.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_SHOVEL = ITEMS.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_SWORD = ITEMS.register("matter_crystal_sword", MatterCrystalSword::new);
    public static final RegistryObject<Item> EFFECT_CATALYST = ITEMS.register("effect_catalyst", EffectCatalyst::new);

    }
