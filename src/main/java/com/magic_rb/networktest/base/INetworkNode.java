package com.magic_rb.networktest.base;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class INetworkNode extends BlockBase {
    public INetworkNode(Material material) {
        super(material);
    }

    public ICable[] getAdjecentCables(World worldIn, BlockPos pos) {
        ICable[] iCables = new ICable[6];
        iCables[0] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.up()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.up()).getBlock() : null;
        iCables[1] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.down()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.down()).getBlock() : null;
        iCables[2] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.north()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.north()).getBlock() : null;
        iCables[3] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.south()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.south()).getBlock() : null;
        iCables[4] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.west()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.west()).getBlock() : null;
        iCables[5] = ICable.class.isAssignableFrom(worldIn.getBlockState(pos.east()).getBlock().getClass()) ? (ICable) worldIn.getBlockState(pos.east()).getBlock() : null;

        return iCables;
    }

    public INetworkNode[] getAdjecentNetworkNodes(World worldIn, BlockPos pos) {
        INetworkNode[] iNetworkNodes = new INetworkNode[6];
        iNetworkNodes[0] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.up()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.up()).getBlock() : null;
        iNetworkNodes[1] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.down()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.down()).getBlock() : null;
        iNetworkNodes[2] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.north()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.north()).getBlock() : null;
        iNetworkNodes[3] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.south()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.south()).getBlock() : null;
        iNetworkNodes[4] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.west()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.west()).getBlock() : null;
        iNetworkNodes[5] = INetworkNode.class.isAssignableFrom(worldIn.getBlockState(pos.east()).getBlock().getClass()) ? (INetworkNode) worldIn.getBlockState(pos.east()).getBlock() : null;

        return iNetworkNodes;
    }

    public IMachine[] getAdjecentMachines(World worldIn, BlockPos pos) {
        IMachine[] iMachines = new IMachine[6];
        iMachines[0] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.up()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.up()).getBlock() : null;
        iMachines[1] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.down()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.down()).getBlock() : null;
        iMachines[2] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.north()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.north()).getBlock() : null;
        iMachines[3] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.south()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.south()).getBlock() : null;
        iMachines[4] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.west()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.west()).getBlock() : null;
        iMachines[5] = IMachine.class.isAssignableFrom(worldIn.getBlockState(pos.east()).getBlock().getClass()) ? (IMachine) worldIn.getBlockState(pos.east()).getBlock() : null;

        return iMachines;
    }
}
