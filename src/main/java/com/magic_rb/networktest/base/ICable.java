package com.magic_rb.networktest.base;

import net.minecraft.block.material.Material;

public class ICable extends INetworkNode {
    public ICable(Material material) {
        super(material);
    }

    private boolean ranThrough;

    public boolean isRanThrough() {
        return ranThrough;
    }

    public void setRanThrough(boolean ranThrough) {
        this.ranThrough = ranThrough;
    }
}
