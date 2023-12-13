package com.vv.pastertetra;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PTTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MainPastertetra.MOD_ID);
    
    public static final RegistryObject<CreativeModeTab> PASTERTETRA_TAB = 
        CREATIVE_MODE_TABS.register("pastertetra_tab", 
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(PTItem.NETHERITE_MOLTENGOLD_INGOT.get()))
                    .title(Component.translatable(MainPastertetra.MOD_ID))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(PTItem.JUNGLE_PORE_BOTTLE.get());
                        pOutput.accept(PTItem.NETHERITE_MOLTENGOLD_INGOT.get());
                        pOutput.accept(PTItem.SPORE_BLOSSOM_PASTE.get());
                        pOutput.accept(PTItem.TIDE_INGOT.get());
                        pOutput.accept(PTItem.RAW_TIDE_INGOT.get());
                        pOutput.accept(PTItem.NETHERITE_MOLTENGOLD_BING.get());
                        pOutput.accept(PTItem.MOLTENGOLD_STAR.get());
                        pOutput.accept(PTItem.DYEDREAM_CRYSTAL.get());
                        pOutput.accept(PTItem.TIDE_HEART.get());
                        pOutput.accept(PTItem.TRUE_GRASS_SWORD_FOR_BREAK.get());
                        pOutput.accept(PTItem.SPORE_ESSENCE.get());
                    })
                    .build()
        );
}
