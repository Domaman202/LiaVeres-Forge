package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmor {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            LiaVeres.ModId);
//#########################################################################################################################################################
    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEMS.register("matter_crystal_helmet",
        () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD,
                new Item.Properties().group(LiaVeres.lv_itemgroup)));

    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEMS.register("matter_crystal_chestplate",
            () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD,
                    new Item.Properties().group(LiaVeres.lv_itemgroup)));

    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEMS.register("matter_crystal_leggings",
            () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD,
                    new Item.Properties().group(LiaVeres.lv_itemgroup)));

    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEMS.register("matter_crystal_boots",
            () -> new ArmorItem(MatterArmorTear.MatterCrystalArm, EquipmentSlotType.HEAD,
                    new Item.Properties().group(LiaVeres.lv_itemgroup)));
}
