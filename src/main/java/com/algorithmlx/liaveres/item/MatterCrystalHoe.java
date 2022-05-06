package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.HoeBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MatterCrystalHoe extends HoeBase {
    public MatterCrystalHoe(String id) {
        super(id, LiaMaterials.MATTER_CRYSTAL_TOOL, Tabs.LIAVERES);
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Unbreakable");
    }
}
