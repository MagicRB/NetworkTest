package com.magic_rb.networktest.graph;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class NodeConnection {
    ArrayList<NodeConnection> nodeConnections = new ArrayList<>();
    BlockPos pos;
    int resistance;
}
