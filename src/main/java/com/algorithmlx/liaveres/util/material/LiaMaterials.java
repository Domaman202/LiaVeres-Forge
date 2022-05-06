package com.algorithmlx.liaveres.util.material;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.util.registring.Registry;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class LiaMaterials {
    public static final ItemArmor.ArmorMaterial MATTER_ARMOR_MATERIAL =
            EnumHelper.addArmorMaterial(
                            LiaVeresLegacy.MOD_ID + ":matter_crystal_armor",
                            LiaVeresLegacy.MOD_ID + ":matter_crystal_armor",
                            9,
                            new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                            7,
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F
                    )
                    .setRepairItem(
                            new ItemStack(
                                    Item.getItemFromBlock(
                                            Registry.MATTER_CRYSTAL_BLOCK
                                    )
                            )
                    );
    public static final Item.ToolMaterial MATTER_TOOL_MATERIAL =
            EnumHelper.addToolMaterial(
                    LiaVeresLegacy.MOD_ID + ":matter_crystal_tool",
                    Integer.MAX_VALUE,
                    -1,
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE
            );
}
