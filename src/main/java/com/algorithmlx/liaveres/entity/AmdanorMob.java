package com.algorithmlx.liaveres.entity;

import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.Random;

public class AmdanorMob extends AbstractSkeleton {
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);

    public AmdanorMob(EntityType<? extends AbstractSkeleton> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
//        MinecraftForge.EVENT_BUS.addListener(this::cancelDamage);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.WITHER_SKELETON_STEP;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal( 1, new NearestAttackableTargetGoal<>( this, Player.class, true ) );
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));

    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WITHER_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_DEATH;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.3F;
    }

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.33F;
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Registration.MATTER_SHARD.get()));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        SpawnGroupData spawnGroupData = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.reassessWeaponGoal();
        return spawnGroupData;
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (!super.doHurtTarget(entityIn)) {
            return false;
        } else {
            if (entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 200));
            }

            return true;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() instanceof AmdanorMob)
            amount *= 0.2f;
        return !this.isInvulnerableTo(source) && super.hurt(source, amount);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
        return mobEffectInstance.getEffect() != MobEffects.WITHER && super.canBeAffected(mobEffectInstance);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 860.3d)
                .add(Attributes.MAX_HEALTH, 1000000.0d)
                .add(Attributes.FOLLOW_RANGE, 400.0d)
                .add(Attributes.MOVEMENT_SPEED, 5.0d)
                .add(Attributes.ATTACK_KNOCKBACK, 3.5d);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pDamageSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pDamageSource, pLooting, pRecentlyHit);
        ItemEntity itemEntity = this.spawnAtLocation(Registration.MATTER_SHARD.get(), 4);
        if (itemEntity != null) {
            itemEntity.setExtendedLifetime();
        }
    }

    @Override
    protected void dropAllDeathLoot(DamageSource pDamageSource) {
        super.dropAllDeathLoot(pDamageSource);
    }

//    public void cancelDamage(LivingDamageEvent event) {
//        LivingEntity entity = event.getEntityLiving();
//        Random random = new Random();
//
//        ItemStack mainHand = entity.getItemBySlot(EquipmentSlot.MAINHAND);
//        ItemStack offHand = entity.getItemBySlot(EquipmentSlot.OFFHAND);
//
//        boolean isLiaSword = (mainHand != null && mainHand.getItem() == Registration.MATTER_CRYSTAL_SWORD.get())
//                || (offHand != null && offHand.getItem() == Registration.MATTER_CRYSTAL_SWORD.get());
//
//        if (isLiaSword && (event.isCanceled() || event.getAmount() <= 0 || event.getEntityLiving().level.isClientSide)) {
//            return;
//        }
//
//        if (!isLiaSword) return;
//
//
//        if (isLiaSword && (random.nextInt(Integer.MAX_VALUE) > 0)) {
//            event.setCanceled(true);
//        } else if (!isLiaSword && (random.nextInt(Integer.MAX_VALUE) > 0)) {
//            event.setCanceled(false);
//        }
//    }


    @Override
    public void tick() {
        super.tick();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public BossEvent.BossBarColor getBarColor() {
        return BossEvent.BossBarColor.BLUE;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }
}
