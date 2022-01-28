package com.algorithmlx.liaveres.common.item.artifact;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

@Deprecated
public class EmptyArtifact extends Item {
    public EmptyArtifact() {
        super(new Item.Properties().tab(ModSetup.ARTIFACT_TAB).rarity(Rarity.RARE).fireResistant());
    }
}
