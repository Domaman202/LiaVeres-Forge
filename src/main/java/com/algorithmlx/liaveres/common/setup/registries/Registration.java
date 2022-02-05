package com.algorithmlx.liaveres.common.setup.registries;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.block.*;
import com.algorithmlx.liaveres.common.container.BasicBackpackContainer;
import com.algorithmlx.liaveres.common.entity.AmdanorMob;
import com.algorithmlx.liaveres.common.item.api.LVToolMaterial;
import com.algorithmlx.liaveres.common.item.armor.GildedNetheriteArmor;
import com.algorithmlx.liaveres.common.item.armor.MatterArmor;
import com.algorithmlx.liaveres.common.item.armor.MatterCrystalArmor;
import com.algorithmlx.liaveres.common.item.artifact.LightningArtifact;
import com.algorithmlx.liaveres.common.item.backpack.BasicBackpack;
import com.algorithmlx.liaveres.common.item.basic.*;
import com.algorithmlx.liaveres.common.item.food.EnchantedApple;
import com.algorithmlx.liaveres.common.item.tool.*;
import com.algorithmlx.liaveres.common.setup.Constants;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import com.algorithmlx.liaveres.common.world.structures.AmdanorBaseStructure;
import com.algorithmlx.liaveres.server.command.BookCommand;
import com.algorithmlx.liaveres.server.command.DimensionCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, LiaVeres.ModId);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, LiaVeres.ModId);
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, LiaVeres.ModId);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, LiaVeres.ModId);
    public static final DeferredRegister<Biome> BIOME = DeferredRegister.create(ForgeRegistries.BIOMES, LiaVeres.ModId);
    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, LiaVeres.ModId);
    public static final DeferredRegister<StructureFeature<?>> STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, LiaVeres.ModId);
    public static final DeferredRegister<MenuType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, LiaVeres.ModId);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEM.register(bus);
        BLOCK.register(bus);
        ENTITY.register(bus);
        BLOCK_ENTITY.register(bus);
        BIOME.register(bus);
        FLUID.register(bus);
        STRUCTURE.register(bus);
        CONTAINER.register(bus);
    }
    public static final RegistryObject<Block> MATTER_CRYSTAL_BLOCK = BLOCK.register("matter_crystal_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(Float.MAX_VALUE, Float.MAX_VALUE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AMDANOR_SPAWNER = BLOCK.register("amdanor_spawner", AmdanorSpawner::new);
    public static final RegistryObject<Block> GILDED_NETHERITE_BLOCK = BLOCK.register("gilded_netherite_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(80f, 240000f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRYSTALLITE = BLOCK.register("crystallite", Crystallite::new);
    public static final RegistryObject<Block> MATTER_BLOCK = BLOCK.register("matter_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(500f, 700000000f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEM.register("matter_crystal_helmet", ()-> new MatterCrystalArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEM.register("matter_crystal_chestplate", ()-> new MatterCrystalArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEM.register("matter_crystal_leggings", ()-> new MatterCrystalArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEM.register("matter_crystal_boots", ()-> new MatterCrystalArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> MATTER_CRYSTAL = ITEM.register("matter_crystal", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER = ITEM.register("matter", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER_SHARD = ITEM.register("matter_shard", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> AMDANOR_SKELETON_EGG = ITEM.register("amdanor_skeleton_egg", ()-> new ForgeSpawnEggItem(Registration.AMDANOR_SKELETON, 0x000000, 0xffffff, new Item.Properties().tab(ModSetup.MOBS_TAB)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_SWORD = ITEM.register("matter_crystal_sword", MatterCrystalSword::new);
    public static final RegistryObject<Item> MATTER_HELMET = ITEM.register("matter_helmet", ()-> new MatterArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> MATTER_CHESTPLATE = ITEM.register("matter_chestplate", ()-> new MatterArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> MATTER_LEGS = ITEM.register("matter_leggings", ()-> new MatterArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> MATTER_BOOTS = ITEM.register("matter_boots", ()-> new MatterArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> CRYSTALLINE = ITEM.register("crystalline", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER_CRYSTAL_AXE = ITEM.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_PICKAXE = ITEM.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_SHOVEL = ITEM.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<Item> MATTER_CRYSTALR_HOE = ITEM.register("matter_crystal_hoe", MatterCrystalHoe::new);
    public static final RegistryObject<Item> EFFECT_CATALYST = ITEM.register("effect_catalyst", EffectCatalyst::new);
    public static final RegistryObject<Item> ENCHANTED_APPLE = ITEM.register("enchanted_apple", EnchantedApple::new);
    public static final RegistryObject<Item> LIGHTNING_ARTIFACT = ITEM.register("lightning_artifact", LightningArtifact::new);
    public static final RegistryObject<Item> EMPTY_ARTIFACT = ITEM.register("empty_artifact", ()-> new Item(new Item.Properties().tab(ModSetup.ARTIFACT_TAB)));
    public static final RegistryObject<Item> AMDANOR_UNLOCKER_KEY = ITEM.register("amdanor_unlocker_key", AmdanorUnlockerKey::new);
    public static final RegistryObject<Item> WITHERING_BONE = ITEM.register("withering_bone", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB).fireResistant()));
    public static final RegistryObject<Item> LIA_BOOK = ITEM.register("lia_book", LiaBook::new);
    public static final RegistryObject<Item> GILDED_NETHERITE_INGOT = ITEM.register("gilded_netherite_ingot", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = ITEM.register("gilded_netherite_helmet", ()-> new GildedNetheriteArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = ITEM.register("gilded_netherite_chestplate", ()-> new GildedNetheriteArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGS = ITEM.register("gilded_netherite_leggings", ()-> new GildedNetheriteArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = ITEM.register("gilded_netherite_boots", ()-> new GildedNetheriteArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEM.register("gilded_netherite_sword", ()-> new SwordItem(LVToolMaterial.GILDED_NETHERITE, 12, 10F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary)));
    public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEM.register("gilded_netherite_pickaxe", ()-> new PickaxeItem(LVToolMaterial.GILDED_NETHERITE, 4, 12F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary)));
    public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEM.register("gilded_netherite_axe", ()-> new AxeItem(LVToolMaterial.GILDED_NETHERITE, 20F, 11.2F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary)));
    public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEM.register("gilded_netherite_shovel", ()-> new ShovelItem(LVToolMaterial.GILDED_NETHERITE, 6F, 12F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary)));
    public static final RegistryObject<Item> GILDED_NETHERITE_HOE = ITEM.register("gilded_netherite_hoe", ()-> new HoeItem(LVToolMaterial.GILDED_NETHERITE, -16, 0F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary)));
    public static final RegistryObject<Item> BASIC_BACKPACK = ITEM.register("basic_backpack", BasicBackpack::new);

    public static final RegistryObject<EntityType<AmdanorMob>> AMDANOR_SKELETON = ENTITY.register("amdanor_skeleton", ()-> EntityType.Builder.of(AmdanorMob::new, MobCategory.MONSTER).sized(0.55f, 1.5f).fireImmune().immuneTo(Blocks.WITHER_ROSE).clientTrackingRange(16).build("amdanor_skeleton"));
//    public static final RegistryObject<EntityType<MHNO3>> MHNO3_BOSS = ENTITY.register("mhno3", ()-> EntityType.Builder.of(MHNO3::new, MobCategory.MONSTER).sized(1.1f, 3.0f).fireImmune().immuneTo(Blocks.GRAVEL, Blocks.TNT, Blocks.SAND, Blocks.WITHER_ROSE).clientTrackingRange(16).build("mhno3"));

    public static final RegistryObject<StructureFeature<JigsawConfiguration>> AMDANOR_BASE = STRUCTURE.register("amdanor_base", ()-> new AmdanorBaseStructure(JigsawConfiguration.CODEC));

    public static final RegistryObject<MenuType<BasicBackpackContainer>> BASIC_BACKPACK_CONTAINER = CONTAINER.register("basic_backpack",
            ()-> IForgeMenuType.create((windowId, inv, data)-> new BasicBackpackContainer(windowId, inv, InteractionHand.MAIN_HAND)));


}
