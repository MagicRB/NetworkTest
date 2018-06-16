package com.magic_rb.networktest.block;

import com.magic_rb.networktest.Itemblock.CableItem;
import com.magic_rb.networktest.base.ICable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class Cable extends ICable {
    private ItemBlock itemBlock;

    public Cable() {
        super(Material.ROCK);

        setUnlocalizedName("cable");
        setRegistryName("cable");

        itemBlock = new CableItem(this);
    }

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock;
    }
}
