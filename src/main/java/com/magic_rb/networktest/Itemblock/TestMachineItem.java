package com.magic_rb.networktest.Itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class TestMachineItem extends ItemBlock {
    public TestMachineItem(Block block)
    {
        super(block);

        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
    }
}
