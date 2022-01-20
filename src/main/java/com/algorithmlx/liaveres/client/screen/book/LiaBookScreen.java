package com.algorithmlx.liaveres.client.screen.book;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.client.screen.button.BaseButton;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LiaBookScreen extends Screen {
    private static final int imgWidth = 512;
    private static final int imgHeight = 256;

    private static final ResourceLocation TEXTURE = new ResourceLocation(LiaVeres.ModId, "textures/gui/lia_book.png");

    public LiaBookScreen() {
        super(new TranslatableComponent("book." + LiaVeres.ModId + ".liaBook"));
    }

    @Override
    protected void init() {
        this.addWidget(new BaseButton(37, 23, 32, 52,
                new TranslatableComponent("button." + LiaVeres.ModId + ".liaBook.buttonMain"), pButton -> {
                    Minecraft.getInstance().setScreen(this);
                }, new ResourceLocation(LiaVeres.ModId, "textures/gui/button/page_button.png")));
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
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
}
