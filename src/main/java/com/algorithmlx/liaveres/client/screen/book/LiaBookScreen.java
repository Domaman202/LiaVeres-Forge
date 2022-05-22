package com.algorithmlx.liaveres.client.screen.book;

import com.algorithmlx.liaveres.client.screen.book.page.LiaBookMainPage;
import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.client.screen.button.ButtonBase;
import com.algorithmlx.liaveres.common.setup.Registration;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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
                        "", new Button.OnPress() {
                    @Override
                    public void onPress(Button pButton) {
                        minecraft.setScreen(new LiaBookMainPage());
                    }
                },
                        new ItemStack(Registration.GILDED_NETHERITE_AXE.get()).getItem().getRegistryName()
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
        texts();
        super.render(pPoseStack, 0, 0, pPartialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static void open() {
        Minecraft.getInstance().setScreen(new LiaBookScreen());
    }

    private static void texts() {
        text("standardPage", 0, 0);
        text("standardPage1", 2, 2);
    }

    private static void text(String translateText, int x, int y) {
        PoseStack poseStack = new PoseStack();
        Minecraft.getInstance().font.draw(poseStack, new TranslatableComponent("text." + LiaVeres.ModId + "liaBook." + translateText), x, y, -100);
    }
}
