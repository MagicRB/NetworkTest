package com.magic_rb.networktest.base;

import com.magic_rb.networktest.NetworkTest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class IMachine extends INetworkNode {


    public IMachine(Material material) {
        super(material);
    }

    public void Discover(World worldIn, BlockPos pos, ArrayList<BlockPos> checkedPositions) {
        ArrayList<BlockPos> queue = new ArrayList<>();
        ArrayList<BlockPos> discovered = new ArrayList<>();

        BlockPos currentPos = pos;
        Block currentBlock;
        int validNeighbours = 0;

        queue.add(pos);
        discovered.add(pos);

        while (!queue.isEmpty()) {
            currentPos = queue.get(queue.size() - 1);
            currentBlock = worldIn.getBlockState(currentPos).getBlock();

            validNeighbours = 0;

            INetworkNode[] iNetworkNodes;

            if (INetworkNode.class.isAssignableFrom(currentBlock.getClass())) {
                if (worldIn.isRemote && NetworkTest.DEBUG)
                    NetworkTest.logger.info("Looking up neighbours around "  + currentPos + " at block " + currentBlock);

                iNetworkNodes = ((INetworkNode)currentBlock).getAdjecentNetworkNodes(worldIn, currentPos);

                BlockPos tmpPos = new BlockPos(0, 0, 0);

                for (int i = 0; i < 6; i++) {
                    if (iNetworkNodes[i] == null) continue;
                    if (!INetworkNode.class.isAssignableFrom(iNetworkNodes[i].getClass())) continue;
                    switch (i) {
                        case 0:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).up();
                            break;
                        case 1:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).down();
                            break;
                        case 2:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).north();
                            break;
                        case 3:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).south();
                            break;
                        case 4:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).west();
                            break;
                        case 5:
                            tmpPos = queue.get(queue.size() - 1 - validNeighbours).east();
                            break;
                    }
                    if (!discovered.contains(tmpPos)) {
                        if (worldIn.isRemote && NetworkTest.DEBUG)
                            NetworkTest.logger.info("Found NetworkNode on: " + tmpPos + " i: " + i + " name: " +iNetworkNodes[i].getClass().getName());
                        discovered.add(tmpPos);
                        queue.add(tmpPos);
                        validNeighbours++;
                    }
                }
                if (validNeighbours == 0) {
                    queue.remove(queue.size() - 1);
                    if (worldIn.isRemote && NetworkTest.DEBUG)
                        NetworkTest.logger.info("Poping one 1 element form queue, current size is: " + queue.size());
                }
            }
        }

        for (BlockPos blockPos : discovered) {
            Block block = worldIn.getBlockState(blockPos).getBlock();
            if (IMachine.class.isAssignableFrom(block.getClass()) && worldIn.isRemote)
                NetworkTest.logger.info("Found " + block + " on: " + blockPos);
        }
    }
}
