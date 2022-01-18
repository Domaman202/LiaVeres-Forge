package com.algorithmlx.liaveres.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class AmdanorMobModel<T extends Mob & RangedAttackMob> extends HumanoidModel<T> {
    public AmdanorMobModel(ModelPart p_170677_) {
        super(p_170677_);
    }

    @Override
    public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.rightArmPose = HumanoidModel.ArmPose.EMPTY;
        this.leftArmPose = HumanoidModel.ArmPose.EMPTY;
        ItemStack itemstack = entityIn.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemstack.getItem() == Items.DIAMOND_SWORD && entityIn.isAggressive()) {
            if (entityIn.getMainArm() == HumanoidArm.LEFT) {
                this.rightArmPose = HumanoidModel.ArmPose.ITEM;
            }
        }

        super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmiunt, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entityIn, limbSwing, limbSwingAmiunt, ageInTicks, netHeadYaw, headPitch);
        ItemStack itemStack = entityIn.getMainHandItem();
        if (entityIn.isAggressive() && (itemStack.isEmpty() || itemStack.getItem() != Items.DIAMOND_SWORD)) {
            float f = Mth.sin(this.attackTime * (float)Math.PI);
            float f1 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float)Math.PI);
            this.rightArm.zRot = 0.0F;
            this.leftArm.zRot = 0.0F;
            this.rightArm.yRot = -(0.1F - f * 0.6F);
            this.leftArm.yRot = 0.1F - f * 0.6F;
            this.rightArm.xRot = (-(float)Math.PI / 2F);
            this.leftArm.xRot = (-(float)Math.PI / 2F);
            this.rightArm.xRot -= f * 1.2F - f1 * 0.4F;
            this.leftArm.xRot -= f * 1.2F - f1 * 0.4F;
            AnimationUtils.bobArms(this.rightArm, this.leftArm, ageInTicks);
        }
    }

    @Override
    public void translateToHand(HumanoidArm sideIn, PoseStack poseStack) {
        float f = sideIn == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        ModelPart part = this.getArm(sideIn);
        part.x += f;
        part.translateAndRotate(poseStack);
        part.x -= f;
    }
}
