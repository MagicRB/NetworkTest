package com.magic_rb.networktest.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
    public BlockBase(Material material) {
        super(material);
    }

    public ItemBlock getItemBlock() { return null; }
}
