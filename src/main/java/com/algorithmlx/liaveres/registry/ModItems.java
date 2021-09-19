package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.armor.MatterCrystalArmor;
import com.algorithmlx.liaveres.items.Crystalline;
import com.algorithmlx.liaveres.items.Matter;
import com.algorithmlx.liaveres.items.MatterCrystalAxe;
import com.algorithmlx.liaveres.items.MatterCrystalPickaxe;
import com.algorithmlx.liaveres.items.MatterCrystalShovel;
import com.algorithmlx.liaveres.items.MatterCrystalSword;
import com.algorithmlx.liaveres.items.MatterCrystal;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

@Mod.EventBusSubscriber(modid = ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    //public static final RegistryObject<Item> MATTER_HELMET  = register("matter_helmet", () -> new MatterCrystalArmor(EquipmentSlotType.HEAD));
   //public static final RegistryObject<Item> MATTER_CHEST = ITEMS.register("matter_chest",  () -> new MatterCrystalArmor(EquipmentSlotType.CHEST));
   //public static final RegistryObject<Item> MATTER_LEGGINGS  = ITEMS.register("matter_legs",() -> new MatterCrystalArmor(EquipmentSlotType.LEGS));
   //public static final RegistryObject<Item> MATTER_BOOTS  = ITEMS.register("matter_boots",  () -> new MatterCrystalArmor(EquipmentSlotType.FEET));

    public static Item MatterCrystal = new MatterCrystal();
    public static Item MatterCrystalSword = new MatterCrystalSword();
    public static Item MatterCrystalPickaxe = new MatterCrystalPickaxe();
    public static Item Matter = new Matter();
    public static Item Crystalline = new Crystalline();
    public static Item MatterCrystalAxe = new MatterCrystalAxe();
    public static Item MatterCrystalShovel = new MatterCrystalShovel();
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        register(e, MatterCrystal);
        register(e, MatterCrystalSword);
        register(e, MatterCrystalPickaxe);
        register(e, Matter);
        register(e, Crystalline);
        register(e, MatterCrystalAxe);
        register(e, MatterCrystalShovel);
    }

    private static void register(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }
}