package com.vv.pastertetra;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MainPastertetra.MOD_ID)
public class MainPastertetra
{
    public static final String MOD_ID = "pastertetra";
    public static final Logger LOGGER = LogManager.getLogger();
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final CreativeModeTab PASTERTETRA_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PTItem.NETHERITE_MOLTENGOLD_INGOT.get());
        }
    };

    public MainPastertetra()
    {
        PTItem.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(new PTSkillandEffect());
    }
    
}