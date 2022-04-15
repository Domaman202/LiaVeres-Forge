package com.algorithmlx.liaveres.common.setup.registries;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.block.*;
import com.algorithmlx.liaveres.common.block.entity.YarnStationBlockEntity;
import com.algorithmlx.liaveres.common.entity.*;
import com.algorithmlx.liaveres.common.item.api.*;
import com.algorithmlx.liaveres.common.item.armor.*;
import com.algorithmlx.liaveres.common.item.artifact.*;
import com.algorithmlx.liaveres.common.item.basic.*;
import com.algorithmlx.liaveres.common.item.tool.*;
import com.algorithmlx.liaveres.common.item.food.*;
import com.algorithmlx.liaveres.common.recipe.*;
import com.algorithmlx.liaveres.common.setup.*;
import com.algorithmlx.liaveres.common.world.structures.*;
import com.algorithmlx.liaveres.container.YarnStationContainer;
import core.liquid.dynamic.item.DynamicItem;
import core.liquid.objects.data.DynamicContainerData;
import core.liquid.recipes.LiquidRecipeSerializers;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
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
import net.minecraftforge.registries.*;

public class Registration {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, LiaVeres.ModId);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, LiaVeres.ModId);
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, LiaVeres.ModId);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, LiaVeres.ModId);
    public static final DeferredRegister<Biome> BIOME = DeferredRegister.create(ForgeRegistries.BIOMES, LiaVeres.ModId);
    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, LiaVeres.ModId);
    public static final DeferredRegister<StructureFeature<?>> STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, LiaVeres.ModId);
    public static final DeferredRegister<MenuType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, LiaVeres.ModId);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LiaVeres.ModId);

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
        RECIPE.register(bus);
    }
    public static final RegistryObject<Block> MATTER_CRYSTAL_BLOCK = Config.commonModule.get().equals(true) ? BLOCK.register("matter_crystal_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(Float.MAX_VALUE, Float.MAX_VALUE).requiresCorrectToolForDrops())) : null;
    public static final RegistryObject<Block> AMDANOR_SPAWNER = Config.commonModule.get().equals(true) ? BLOCK.register("amdanor_spawner", AmdanorSpawner::new) : null;
    public static final RegistryObject<Block> GILDED_NETHERITE_BLOCK = Config.commonModule.get().equals(true) ? BLOCK.register("gilded_netherite_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(80f, 240000f).requiresCorrectToolForDrops())) : null;
    public static final RegistryObject<Block> CRYSTALLITE = Config.commonModule.get().equals(true) ? BLOCK.register("crystallite", Crystallite::new) : null;
    public static final RegistryObject<Block> MATTER_BLOCK = Config.commonModule.get().equals(true) ? BLOCK.register("matter_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(500f, 700000000f).requiresCorrectToolForDrops())) : null;
    public static final RegistryObject<Block> YARN_STATION = (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? BLOCK.register("yarn_station", YarnStation::new) : null;

    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_helmet", ()-> new MatterCrystalArmor(EquipmentSlot.HEAD)) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_chestplate", ()-> new MatterCrystalArmor(EquipmentSlot.CHEST)) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_leggings", ()-> new MatterCrystalArmor(EquipmentSlot.LEGS)) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_boots", ()-> new MatterCrystalArmor(EquipmentSlot.FEET)) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> MATTER = Config.commonModule.get().equals(true) ? ITEM.register("matter", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> MATTER_SHARD = Config.commonModule.get().equals(true) ? ITEM.register("matter_shard", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> AMDANOR_SKELETON_EGG = Config.commonModule.get().equals(true) ? ITEM.register("amdanor_skeleton_egg", ()-> new ForgeSpawnEggItem(Registration.AMDANOR_SKELETON, 0x000000, 0xffffff, new Item.Properties().tab(ModSetup.MOBS_TAB))) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_SWORD = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_sword", MatterCrystalSword::new) : null;
    public static final RegistryObject<Item> MATTER_HELMET = Config.commonModule.get().equals(true) ? ITEM.register("matter_helmet", ()-> new MatterArmor(EquipmentSlot.HEAD)) : null;
    public static final RegistryObject<Item> MATTER_CHESTPLATE = Config.commonModule.get().equals(true) ? ITEM.register("matter_chestplate", ()-> new MatterArmor(EquipmentSlot.CHEST)) : null;
    public static final RegistryObject<Item> MATTER_LEGS = Config.commonModule.get().equals(true) ? ITEM.register("matter_leggings", ()-> new MatterArmor(EquipmentSlot.LEGS)) : null;
    public static final RegistryObject<Item> MATTER_BOOTS = Config.commonModule.get().equals(true) ? ITEM.register("matter_boots", ()-> new MatterArmor(EquipmentSlot.FEET)) : null;
    public static final RegistryObject<Item> CRYSTALLINE = Config.commonModule.get().equals(true) ? ITEM.register("crystalline", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_AXE = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_axe", MatterCrystalAxe::new) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_PICKAXE = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new) : null;
    public static final RegistryObject<Item> MATTER_CRYSTAL_SHOVEL = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_shovel", MatterCrystalShovel::new) : null;
    public static final RegistryObject<Item> MATTER_CRYSTALR_HOE = Config.commonModule.get().equals(true) ? ITEM.register("matter_crystal_hoe", MatterCrystalHoe::new) : null;
    public static final RegistryObject<Item> EFFECT_CATALYST = Config.commonModule.get().equals(true) ? ITEM.register("effect_catalyst", EffectCatalyst::new) : null;
    public static final RegistryObject<Item> ENCHANTED_APPLE = Config.commonModule.get().equals(true) ? ITEM.register("enchanted_apple", EnchantedApple::new) : null;
    public static final RegistryObject<Item> LIGHTNING_ARTIFACT = Config.artifactModule.get().equals(true) ? ITEM.register("lightning_artifact", LightningArtifact::new) : null;
    public static final RegistryObject<Item> EMPTY_ARTIFACT = Config.artifactModule.get().equals(true) ? ITEM.register("empty_artifact", ()-> new Item(new Item.Properties().tab(ModSetup.ARTIFACT_TAB))) : null;
    public static final RegistryObject<Item> AMDANOR_UNLOCKER_KEY = Config.commonModule.get().equals(true) ? ITEM.register("amdanor_unlocker_key", AmdanorUnlockerKey::new) : null;
    public static final RegistryObject<Item> WITHERING_BONE = Config.commonModule.get().equals(true) ? ITEM.register("withering_bone", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB).fireResistant())) : null;
    public static final RegistryObject<Item> LIA_BOOK = Config.commonModule.get().equals(true) ? ITEM.register("lia_book", LiaBook::new) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_INGOT = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_ingot", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_helmet", ()-> new GildedNetheriteArmor(EquipmentSlot.HEAD)) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_chestplate", ()-> new GildedNetheriteArmor(EquipmentSlot.CHEST)) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGS = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_leggings", ()-> new GildedNetheriteArmor(EquipmentSlot.LEGS)) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_boots", ()-> new GildedNetheriteArmor(EquipmentSlot.FEET)) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_sword", ()-> new SwordItem(LVToolMaterial.GILDED_NETHERITE, 12, 10F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary))) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_pickaxe", ()-> new PickaxeItem(LVToolMaterial.GILDED_NETHERITE, 4, 12F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary))) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_AXE = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_axe", ()-> new AxeItem(LVToolMaterial.GILDED_NETHERITE, 20F, 11.2F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary))) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_shovel", ()-> new ShovelItem(LVToolMaterial.GILDED_NETHERITE, 6F, 12F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary))) : null;
    public static final RegistryObject<Item> GILDED_NETHERITE_HOE = Config.netheriteModule.get().equals(true) ? ITEM.register("gilded_netherite_hoe", ()-> new HoeItem(LVToolMaterial.GILDED_NETHERITE, -16, 0F, new Item.Properties().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary))) : null;
    public static final RegistryObject<Item> LEATHER_STRAP = (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? ITEM.register("leather_strap", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> STITCHED_LEATHER = (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? ITEM.register("stitched_leather", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> STRING_SKEIN = (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? ITEM.register("string_skein", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> EMPTY_SKEIN = (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? ITEM.register("empty_skein", ()-> new Item(new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;
    public static final RegistryObject<Item> BASIC_BACKPACK = Config.backpackModule.get().equals(true) ? ITEM.register("basic_backpack", ()-> new DynamicItem(DynamicContainerData.create("basic", 9, 1, false, SoundEvents.ARMOR_EQUIP_CHAIN), new Item.Properties().tab(ModSetup.CLASSIC_TAB))) : null;

    public static final RegistryObject<BlockEntityType<YarnStationBlockEntity>> YARN_STATION_BLOCK_ENTITY =
            (Config.experimentalModule.get().equals(true) && Config.backpackModule.get().equals(true))
                    ? BLOCK_ENTITY.register("yarn_station",
                    ()-> BlockEntityType.Builder.of(YarnStationBlockEntity::new, YARN_STATION.get()).build(null)) : null;

    public static final RegistryObject<MenuType<YarnStationContainer>> YARN_STATION_CONTAINER =
            (Config.experimentalModule.get().equals(true) && Config.backpackModule.get().equals(true))
            ? CONTAINER.register("yarn_station",
                    ()-> IForgeMenuType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        Level level = inv.player.getCommandSenderWorld();
                        return new YarnStationContainer(windowId, level, pos, inv, inv.player);
                    }))) : null;

    public static final RegistryObject<EntityType<AmdanorMob>> AMDANOR_SKELETON = ENTITY.register("amdanor_skeleton", ()-> EntityType.Builder.of(AmdanorMob::new, MobCategory.MONSTER).sized(0.55f, 1.5f).fireImmune().immuneTo(Blocks.WITHER_ROSE).clientTrackingRange(16).build("amdanor_skeleton"));

    public static final RegistryObject<StructureFeature<JigsawConfiguration>> AMDANOR_BASE = Config.commonModule.get().equals(true) ? STRUCTURE.register("amdanor_base", ()-> new AmdanorBaseStructure(JigsawConfiguration.CODEC)) : null;

    public static final RegistryObject<LiquidRecipeSerializers<YarnRecipe>> YARN_RECIPE =
            (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) ? RECIPE.register("yarn",
                    ()-> new LiquidRecipeSerializers<>(YarnRecipe::new)) : null;
}
