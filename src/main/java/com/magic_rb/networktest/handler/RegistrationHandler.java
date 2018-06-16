package com.magic_rb.networktest.handler;

import com.magic_rb.networktest.NetworkTest;
import com.magic_rb.networktest.base.BlockBase;
import com.magic_rb.networktest.block.Cable;
import com.magic_rb.networktest.block.TestMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegistrationHandler {

    public static BlockBase[] Blocks = { new Cable(), new TestMachine()};
    //public static Item ItemList = {  };

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        for (BlockBase block : Blocks) {
            registry.register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        // Items

        // ItemBlocks

        for (BlockBase block : Blocks) {
            registry.register(block.getItemBlock());
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        // Items

        // ItemBlocks

        for (BlockBase block : Blocks) {
            NetworkTest.proxy.registerItemModel(block.getItemBlock(), 0);
        }
    }
}
