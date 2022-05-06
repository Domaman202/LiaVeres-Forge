package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.AxeBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MatterCrystalAxe extends AxeBase {
    public MatterCrystalAxe(String id) {
        super(id, LiaMaterials.MATTER_CRYSTAL_TOOL, Integer.MAX_VALUE, Integer.MAX_VALUE,Tabs.LIAVERES);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Unbreakable");
    }
}
