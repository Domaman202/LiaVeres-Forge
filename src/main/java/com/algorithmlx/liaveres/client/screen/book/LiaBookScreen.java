package com.algorithmlx.liaveres.client.screen.book;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.client.screen.button.ButtonBase;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class LiaBookScreen extends Screen {
    private static final int imgWidth = 512;
    private static final int imgHeight = 256;

    private static final ResourceLocation TEXTURE = new ResourceLocation(LiaVeres.ModId, "textures/gui/lia_book.png");

    public LiaBookScreen() {
        super(new TranslatableComponent("book." + LiaVeres.ModId + ".liaBook"));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(new ButtonBase(37, 23, 31, 26,
                "", pButton -> Minecraft.getInstance().setScreen(this),
                new ResourceLocation(LiaVeres.ModId, "textures/gui/button/page_button.png")
            )
        );
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        // x - width
        // y - height

        int j = ((this.width / 2) - (imgWidth / 2));
        int k = ((this.height / 2) - (imgHeight / 2));

        this.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0, TEXTURE);
        blit(pPoseStack, j, k, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
        super.render(pPoseStack, 0, 0, pPartialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static void open() {
        Minecraft.getInstance().setScreen(new LiaBookScreen());
    }
}
