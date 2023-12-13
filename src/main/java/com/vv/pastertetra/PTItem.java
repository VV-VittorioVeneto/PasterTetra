package com.vv.pastertetra;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PTItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainPastertetra.MOD_ID);
    
    public static final RegistryObject<Item> JUNGLE_PORE_BOTTLE = register("jungle_spore_bottle");
    public static final RegistryObject<Item> NETHERITE_MOLTENGOLD_INGOT = register("netherite_moltengold_ingot");
    public static final RegistryObject<Item> SPORE_BLOSSOM_PASTE = register("spore_blossom_paste");
    public static final RegistryObject<Item> TIDE_INGOT = register("tide_ingot");
    public static final RegistryObject<Item> RAW_TIDE_INGOT = register("raw_tide_ingot");
    public static final RegistryObject<Item> NETHERITE_MOLTENGOLD_BING = register("netherite_moltengold_bing");
    public static final RegistryObject<Item> MOLTENGOLD_STAR = register("moltengold_star");
    public static final RegistryObject<Item> DYEDREAM_CRYSTAL = register("dyedream_crystal");
    public static final RegistryObject<Item> TIDE_HEART = register("tide_heart");
    public static final RegistryObject<Item> TRUE_GRASS_SWORD_FOR_BREAK = register("true_grass_sword_for_break");
    public static final RegistryObject<Item> SPORE_ESSENCE = register("spore_essence");
    
    private static RegistryObject<Item> register(final String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
