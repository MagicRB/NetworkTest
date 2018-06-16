package com.magic_rb.networktest;

import com.magic_rb.networktest.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = NetworkTest.MODID, name = NetworkTest.NAME, version = NetworkTest.VERSION)
public class NetworkTest
{
    public static final String MODID = "networktest";
    public static final String NAME = "Network Test";
    public static final String VERSION = "0.001";
    public static final boolean DEBUG = false;

    @SidedProxy(clientSide = "com.magic_rb.networktest.proxy.ClientProxy", serverSide = "com.magic_rb.networktest.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
