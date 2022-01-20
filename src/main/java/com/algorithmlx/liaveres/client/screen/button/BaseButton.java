package com.algorithmlx.liaveres.client.screen.button;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class BaseButton extends Button {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Component text;
    private final ResourceLocation texLocation;

    public BaseButton(int x, int y, int width, int height, Component text, OnPress onPress, ResourceLocation texture) {
        super(x, y, width, height, text, onPress);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.text = text;
        this.texLocation = texture;
    }

    public BaseButton(int x, int y, int width, int height, String text, OnPress onPress, ResourceLocation texture) {
        this(x, y, width, height, new TextComponent(text), onPress, texture);
    }


    @Override
    public void render(@Nonnull PoseStack stack, int x, int y, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fr = minecraft.font;
        stack.pushPose();
        stack.translate(0.0D, 0.0D, 100.0D);
        fr.draw(stack, this.text, this.x, this.y + this.height / 4f, 0xFFFFFF);
        stack.popPose();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderSystem.setShaderTexture(0, texLocation);

        blit(stack, this.x, this.y, 0, isCursorAtButton(x, y) ? this.height : 0, this.width, this.height, this.width, this.height * 2);
    }

    public boolean isCursorAtButton(int cursorX, int cursorY) {
        return cursorX >= this.x && cursorY >= this.y && cursorX <= this.x + this.width && cursorY <= this.y + this.height;
    }
}
