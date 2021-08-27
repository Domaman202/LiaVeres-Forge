package com.algorithmlx.liaveres.common.registry;

import com.algorithmlx.liaveres.common.object.armor.MatterCrystalArmor;
import com.algorithmlx.liaveres.common.object.items.item.Crystalline;
import com.algorithmlx.liaveres.common.object.items.item.Matter;
import com.algorithmlx.liaveres.common.object.items.tools.MatterCrystalAxe;
import com.algorithmlx.liaveres.common.object.items.tools.MatterCrystalPickaxe;
import com.algorithmlx.liaveres.common.object.items.tools.MatterCrystalShovel;
import com.algorithmlx.liaveres.common.object.items.tools.MatterCrystalSword;
import com.algorithmlx.liaveres.common.object.items.item.MatterCrystal;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static net.minecraftforge.registries.ForgeRegistries.ITEMS;

@Mod.EventBusSubscriber(modid = ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
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