package com.algorithmlx.liaveres.setup;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.block.AmdanorSpawner;
import com.algorithmlx.liaveres.block.MatterCrystalBlock;
import com.algorithmlx.liaveres.entity.AmdanorMob;
import com.algorithmlx.liaveres.item.armor.MatterArmor;
import com.algorithmlx.liaveres.item.armor.MatterCrystalArmor;
import com.algorithmlx.liaveres.item.artifact.EmptyArtifact;
import com.algorithmlx.liaveres.item.artifact.LightningArtifact;
import com.algorithmlx.liaveres.item.basic.*;
import com.algorithmlx.liaveres.item.egg.AmdanorSpawnEgg;
import com.algorithmlx.liaveres.item.food.EnchantedApple;
import com.algorithmlx.liaveres.item.tool.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.material.Fluid;
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
    public static final DeferredRegister<StructureFeature<?>> STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, LiaVeres.ModId);
    public static final DeferredRegister<Biome> BIOME = DeferredRegister.create(ForgeRegistries.BIOMES, LiaVeres.ModId);
    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, LiaVeres.ModId);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEM.register(bus);
        BLOCK.register(bus);
        ENTITY.register(bus);
        BLOCK_ENTITY.register(bus);
        STRUCTURE.register(bus);
        BIOME.register(bus);
        FLUID.register(bus);
    }
    public static final RegistryObject<Block> MATTER_CRYSTAL_BLOCK = BLOCK.register("matter_crystal_block", MatterCrystalBlock::new);
    public static final RegistryObject<Block> AMDANOR_SPAWNER = BLOCK.register("amdanor_spawner", AmdanorSpawner::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_HELMET = ITEM.register("matter_crystal_helmet", ()-> new MatterCrystalArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> MATTER_CRYSTAL_CHESTPLATE = ITEM.register("matter_crystal_chestplate", ()-> new MatterCrystalArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> MATTER_CRYSTAL_LEGS = ITEM.register("matter_crystal_leggings", ()-> new MatterCrystalArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> MATTER_CRYSTAL_BOOTS = ITEM.register("matter_crystal_boots", ()-> new MatterCrystalArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> MATTER_CRYSTAL = ITEM.register("matter_crystal", MatterCrystal::new);
    public static final RegistryObject<Item> MATTER = ITEM.register("matter", Matter::new);
    public static final RegistryObject<Item> MATTER_SHARD = ITEM.register("matter_shard", Matter::new);
    public static final RegistryObject<Item> AMDANOR_SKELETON_EGG = ITEM.register("amdanor_skeleton_egg", AmdanorSpawnEgg::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_SWORD = ITEM.register("matter_crystal_sword", MatterCrystalSword::new);
    public static final RegistryObject<Item> MATTER_HELMET = ITEM.register("matter_helmet", () -> new MatterArmor(EquipmentSlot.HEAD, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER_CHESTPLATE = ITEM.register("matter_chestplate", () -> new MatterArmor(EquipmentSlot.CHEST, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER_LEGS = ITEM.register("matter_leggings", () -> new MatterArmor(EquipmentSlot.LEGS, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> MATTER_BOOTS = ITEM.register("matter_boots", () -> new MatterArmor(EquipmentSlot.FEET, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB)));
    public static final RegistryObject<Item> CRYSTALLINE = ITEM.register("crystalline", Crystalline::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_AXE = ITEM.register("matter_crystal_axe", MatterCrystalAxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_PICKAXE = ITEM.register("matter_crystal_pickaxe", MatterCrystalPickaxe::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_SHOVEL = ITEM.register("matter_crystal_shovel", MatterCrystalShovel::new);
    public static final RegistryObject<Item> MATTER_CRYSTAL_HOE = ITEM.register("matter_crystal_hoe", MatterCrystalHoe::new);
    public static final RegistryObject<Item> EFFECT_CATALYST = ITEM.register("effect_catalyst", EffectCatalyst::new);
    public static final RegistryObject<Item> ENCHANTED_APPLE = ITEM.register("enchanted_apple", EnchantedApple::new);
    public static final RegistryObject<Item> LIGHTNING_ARTIFACT = ITEM.register("lightning_artifact", LightningArtifact::new);
    public static final RegistryObject<Item> EMPTY_ARTIFACT = ITEM.register("empty_artifact", EmptyArtifact::new);
    public static final RegistryObject<EntityType<AmdanorMob>> AMDANOR_SKELETON = ENTITY.register("amdanor_skeleton",
            ()-> EntityType.Builder.of(AmdanorMob::new, MobCategory.MONSTER)
                    .sized(0.55f, 1.5f)
                    .fireImmune()
                    .immuneTo(Blocks.WITHER_ROSE)
                    .clientTrackingRange(16)
                    .build("amdanor_skeleton")
    );
    public static final RegistryObject<AmdanorUnlockerKey> AMDANOR_UNLOCKER_KEY = ITEM.register("amdanor_unlocker_key", AmdanorUnlockerKey::new);
}
