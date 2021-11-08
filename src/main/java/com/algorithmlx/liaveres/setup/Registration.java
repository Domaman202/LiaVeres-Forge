package com.algorithmlx.liaveres.setup;

import com.algorithmlx.liaveres.block.MatterCrystalBlock;
import com.algorithmlx.liaveres.item.*;
import com.algorithmlx.liaveres.item.armor.MatterArmor;
import com.algorithmlx.liaveres.item.armor.MatterCrystalArmor;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class Registration {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<MatterCrystalBlock> MATTER_CRYSTAL_BLOCK = BLOCKS.register("matter_crystal_block", MatterCrystalBlock::new);

    public static final RegistryObject<Item> MATTER_CRYSTAL_BLOCK_ITEM = ITEMS.register("matter_crystal_block", () -> new BlockItem(MATTER_CRYSTAL_BLOCK.get(), new Item.Properties().fireResistant().tab(LIAVERES_ALL)));

    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEMS.register("matter_crystal_helmet", () -> new MatterCrystalArmor(EquipmentSlotType.HEAD, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEMS.register("matter_crystal_chestplate", () -> new MatterCrystalArmor(EquipmentSlotType.CHEST, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEMS.register("matter_crystal_leggings", () -> new MatterCrystalArmor(EquipmentSlotType.LEGS, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEMS.register("matter_crystal_boots", () -> new MatterCrystalArmor(EquipmentSlotType.FEET, new Item.Properties().fireResistant().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_HELMET = ITEMS.register("matter_helmet", () -> new MatterArmor(EquipmentSlotType.HEAD, new Item.Properties().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_CHESTPLATE = ITEMS.register("matter_chestplate", () -> new MatterArmor(EquipmentSlotType.CHEST, new Item.Properties().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_LEGS = ITEMS.register("matter_leggings", () -> new MatterArmor(EquipmentSlotType.LEGS, new Item.Properties().tab(LIAVERES_ALL)));
    public static final RegistryObject<Item> MATTER_BOOTS = ITEMS.register("matter_boots", () -> new MatterArmor(EquipmentSlotType.FEET, new Item.Properties().tab(LIAVERES_ALL)));

    public static final RegistryObject<Crystalline> CRYSTALLINE = ITEMS.register("crystalline", Crystalline::new);
    public static final RegistryObject<MatterCrystal> MATTER_CRYSTAL = ITEMS.register("matter_crystal", MatterCrystal::new);
    public static final RegistryObject<Matter> MATTER = ITEMS.register("matter", Matter::new);
    public static final RegistryObject<MatterCrystalAxe> MATTER_CRYSTAL_AXE = ITEMS.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<MatterCrystalPickaxe> MATTER_CRYSTAL_PICKAXE = ITEMS.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<MatterCrystalShovel> MATTER_CRYSTAL_SHOVEL = ITEMS.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<MatterCrystalSword> MATTER_CRYSTAL_SWORD = ITEMS.register("matter_crystal_sword", MatterCrystalSword::new);
    public static final RegistryObject<EffectCatalyst> EFFECT_CATALYST = ITEMS.register("effect_catalyst", EffectCatalyst::new);

}
