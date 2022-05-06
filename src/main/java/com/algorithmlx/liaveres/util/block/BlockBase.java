package com.algorithmlx.liaveres.util.block;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.util.handler.Model;
import com.algorithmlx.liaveres.init.RegistryArray;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements Model {
    public BlockBase(String id, Material material, CreativeTabs tabs) {
        super(material);
        this.setRegistryName(id);
        this.setUnlocalizedName(LiaVeresLegacy.MOD_ID + "." + id);
        this.setCreativeTab(tabs);
        RegistryArray.BLOCKS.add(this);
        RegistryArray.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        LiaVeresLegacy.proxy.getRender(Item.getItemFromBlock(this), 0, "inventory");
    }
}
