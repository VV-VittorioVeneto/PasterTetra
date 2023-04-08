package com.vv.pastertetra;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PTItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainPastertetra.MOD_ID);

    public static final RegistryObject<Item> JUNGLE_PORE_BOTTLE = register("jungle_spore_bottle",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> NETHERITE_MOLTENGOLD_INGOT = register("netherite_moltengold_ingot",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> SPORE_BLOSSOM_PASTE = register("spore_blossom_paste",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> TIDE_INGOT = register("tide_ingot",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> RAW_TIDE_INGOT = register("raw_tide_ingot",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> NETHERITE_MOLTENGOLD_BING = register("netherite_moltengold_bing",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> MOLTENGOLD_STAR = register("moltengold_star",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> DYEDREAM_CRYSTAL = register("dyedream_crystal",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> TIDE_HEART = register("tide_heart",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> TRUE_GRASS_SWORD_FOR_BREAK = register("true_grass_sword_for_break",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    public static final RegistryObject<Item> SPORE_ESSENCE = register("spore_essence",
    () -> new Item(new Item.Properties().tab(MainPastertetra.PASTERTETRA_TAB)));
    
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
