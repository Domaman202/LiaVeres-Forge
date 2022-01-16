package com.algorithmlx.liaveres.entity;

import com.algorithmlx.liaveres.LiaVeres;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class AmdanorMobRender extends HumanoidMobRenderer<AmdanorMob, AmdanorMobModel<AmdanorMob>> {
    private static final ResourceLocation MOB_TEXTURE = new ResourceLocation(LiaVeres.ModId, "textures/entity/amdanor_skeleton.png");

    public AmdanorMobRender(EntityRendererProvider.Context context) {
        this(context, ModelLayers.SKELETON, ModelLayers.SKELETON_INNER_ARMOR, ModelLayers.SKELETON_OUTER_ARMOR);
    }
    public AmdanorMobRender(EntityRendererProvider.Context context, ModelLayerLocation location, ModelLayerLocation location1, ModelLayerLocation location2) {
        super(context, new AmdanorMobModel<>(context.bakeLayer(location)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new AmdanorMobModel<>(context.bakeLayer(location1)), new AmdanorMobModel<>(context.bakeLayer(location2))));
    }

    @Override
    public ResourceLocation getTextureLocation(AmdanorMob entity) {
        return MOB_TEXTURE;
    }

    @Override
    protected void scale(AmdanorMob mob, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.75F, 0.75F, 0.75F);
    }
}
