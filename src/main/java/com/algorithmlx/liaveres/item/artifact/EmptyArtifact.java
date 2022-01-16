package com.algorithmlx.liaveres.item.artifact;

import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EmptyArtifact extends Item {
    public EmptyArtifact() {
        super(new Item.Properties().tab(ModSetup.ARTIFACT_TAB).rarity(Rarity.RARE).fireResistant());
    }
}
