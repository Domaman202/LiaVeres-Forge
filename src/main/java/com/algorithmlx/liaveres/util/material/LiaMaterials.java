package com.algorithmlx.liaveres.util.material;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.init.RegistryArray;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@SuppressWarnings("ALL")
public class LiaMaterials {
    public static final ItemArmor.ArmorMaterial MATTER_CRYSTAL_ARMOR =
            EnumHelper.addArmorMaterial(
                            LiaVeresLegacy.MOD_ID + ":matter_crystal",
                            LiaVeresLegacy.MOD_ID + ":matter_crystal/",
                            -1,
                            new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                            Integer.MAX_VALUE,
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                            Float.MAX_VALUE
                    )
                    .setRepairItem(
                            new ItemStack(
                                    Item.getItemFromBlock(
                                            RegistryArray.MATTER_CRYSTAL_BLOCK
                                    )
                            )
                    );

    public static final ItemArmor.ArmorMaterial MATTER_ARMOR =
            EnumHelper.addArmorMaterial(
                            LiaVeresLegacy.MOD_ID + ":matter",
                            LiaVeresLegacy.MOD_ID + ":matter/",
                            6000,
                            new int[]{5000, 15000, 20000, 10000},
                            6,
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                            20F
                    )
                    .setRepairItem(
                            new ItemStack(
                                    Item.getItemFromBlock(
                                            RegistryArray.MATTER_CRYSTAL_BLOCK
                                    )
                            )
                    );
    public static final Item.ToolMaterial MATTER_CRYSTAL_TOOL =
            EnumHelper.addToolMaterial(
                    LiaVeresLegacy.MOD_ID + ":matter_crystal",
                    Integer.MAX_VALUE,
                    -1,
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE
            );
}
