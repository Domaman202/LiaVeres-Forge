package com.algorithmlx.liaveres.common.integrated;

import com.algorithmlx.liaveres.common.LiaVeres;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JeiModPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(LiaVeres.ModId, "jei_plugin");
    }
}
