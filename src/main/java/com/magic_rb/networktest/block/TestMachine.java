package com.magic_rb.networktest.block;

import com.magic_rb.networktest.Itemblock.TestMachineItem;
import com.magic_rb.networktest.NetworkTest;
import com.magic_rb.networktest.base.IMachine;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class TestMachine extends IMachine implements ITileEntityProvider {
    private ItemBlock itemBlock;

    public TestMachine() {
        super(Material.ROCK);

        setUnlocalizedName("test_machine");
        setRegistryName("test_machine");

        itemBlock = new TestMachineItem(this);
    }

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
            NetworkTest.logger.info("Starting Dicover!");

        Discover(worldIn, pos, new ArrayList<>());

        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
