package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.items.*;
import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);
//#######################################################ARMOR#############################################################################################
    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEMS.register("matter_crystal_helmet", () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD, new Item.Properties().group(LiaVeres.lv_itemgroup)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEMS.register("matter_crystal_chestplate", () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD, new Item.Properties().group(LiaVeres.lv_itemgroup)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEMS.register("matter_crystal_leggings", () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD, new Item.Properties().group(LiaVeres.lv_itemgroup)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEMS.register("matter_crystal_boots", () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD, new Item.Properties().group(LiaVeres.lv_itemgroup)));
//#######################################################ITEMS############################################################################################
    public static final RegistryObject<Crystalline> Crystalline = ITEMS.register("crystalline", Crystalline::new);
    public static final RegistryObject<MatterCrystal> MATTER_CRYSTAL = ITEMS.register("matter_crystal", MatterCrystal::new);
    public static final RegistryObject<Matter> MATTER = ITEMS.register("matter", Matter::new);
    public static final RegistryObject<MatterCrystalAxe> MATTER_CRYSTAl_AXE = ITEMS.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<MatterCrystalPickaxe> MATTER_CRYSTAL_PICKAXE = ITEMS.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<MatterCrystalShovel> MATTER_CRYSTAL_SHOVEL = ITEMS.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<MatterCrystalSword> MATTER_CRYSTAL_SWORD = ITEMS.register("matter_crystal_sword", MatterCrystalSword::new);
}
