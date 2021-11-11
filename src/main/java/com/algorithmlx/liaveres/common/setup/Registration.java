package com.algorithmlx.liaveres.common.setup;

import com.algorithmlx.liaveres.common.block.MatterCrystalBlock;
import com.algorithmlx.liaveres.common.item.*;
import com.algorithmlx.liaveres.common.item.armor.MatterArmor;
import com.algorithmlx.liaveres.common.item.armor.MatterCrystalArmor;
import com.algorithmlx.liaveres.common.item.artifact.LightningArtifact;
import com.algorithmlx.liaveres.common.item.artifact.EmptyArtifact;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class Registration {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<MatterCrystalBlock> MATTER_CRYSTAL_BLOCK = BLOCKS.register("matter_crystal_block", MatterCrystalBlock::new);

    public static final RegistryObject<Item> MATTER_CRYSTAL_BLOCK_ITEM = ITEMS.register("matter_crystal_block", () -> new BlockItem(MATTER_CRYSTAL_BLOCK.get(), new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));

    public static final RegistryObject<MatterCrystalArmor> MATTER_CRYSTAL_HELMET = ITEMS.register("matter_crystal_helmet", () -> new MatterCrystalArmor(EquipmentSlot.HEAD, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterCrystalArmor> MATTER_CRYSTAL_CHESTPLATE = ITEMS.register("matter_crystal_chestplate", () -> new MatterCrystalArmor(EquipmentSlot.CHEST, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterCrystalArmor> MATTER_CRYSTAL_LEGS = ITEMS.register("matter_crystal_leggings", () -> new MatterCrystalArmor(EquipmentSlot.LEGS, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterCrystalArmor> MATTER_CRYSTAL_BOOTS = ITEMS.register("matter_crystal_boots", () -> new MatterCrystalArmor(EquipmentSlot.FEET, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterArmor> MATTER_HELMET = ITEMS.register("matter_helmet", () -> new MatterArmor(EquipmentSlot.HEAD, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterArmor> MATTER_CHESTPLATE = ITEMS.register("matter_chestplate", () -> new MatterArmor(EquipmentSlot.CHEST, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterArmor> MATTER_LEGS = ITEMS.register("matter_leggings", () -> new MatterArmor(EquipmentSlot.LEGS, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<MatterArmor> MATTER_BOOTS = ITEMS.register("matter_boots", () -> new MatterArmor(EquipmentSlot.FEET, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Crystalline> CRYSTALLINE = ITEMS.register("crystalline", Crystalline::new);
    public static final RegistryObject<MatterCrystal> MATTER_CRYSTAL = ITEMS.register("matter_crystal", MatterCrystal::new);
    public static final RegistryObject<Matter> MATTER = ITEMS.register("matter", Matter::new);
    public static final RegistryObject<MatterCrystalAxe> MATTER_CRYSTAL_AXE = ITEMS.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<MatterCrystalPickaxe> MATTER_CRYSTAL_PICKAXE = ITEMS.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<MatterCrystalShovel> MATTER_CRYSTAL_SHOVEL = ITEMS.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<MatterCrystalSword> MATTER_CRYSTAL_SWORD = ITEMS.register("matter_crystal_sword", MatterCrystalSword::new);
    public static final RegistryObject<MatterCrystalHoe> MATTER_CRYSTAL_HOE = ITEMS.register("matter_crystal_hoe", MatterCrystalHoe::new);
    public static final RegistryObject<EffectCatalyst> EFFECT_CATALYST = ITEMS.register("effect_catalyst", EffectCatalyst::new);
    public static final RegistryObject<EnchantedApple> ENCHANTED_APPLE = ITEMS.register("enchanted_apple", EnchantedApple::new);
    public static final RegistryObject<LightningArtifact> LIGHTNING_ARTIFACT = ITEMS.register("lightning_artifact", LightningArtifact::new);
    public static final RegistryObject<EmptyArtifact> EMPTY_ARTIFACT = ITEMS.register("empty_artifact", EmptyArtifact::new);
}
