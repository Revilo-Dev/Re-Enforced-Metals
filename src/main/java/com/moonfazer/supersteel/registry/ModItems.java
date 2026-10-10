package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    private static final String MOD_ID = "supersteel";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);


    public static final DeferredHolder<Item, Item> STEEL_BLOCK = ITEMS.register("steel_block",
            () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> ROSE_GOLD_BLOCK = ITEMS.register("rose_gold_block",
            () -> new BlockItem(ModBlocks.ROSE_GOLD_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_BLOCK = ITEMS.register("platinum_block",
            () -> new BlockItem(ModBlocks.PLATINUM_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_ORE = ITEMS.register("platinum_ore",
            () -> new BlockItem(ModBlocks.PLATINUM_ORE.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> DEEPSLATE_PLATINUM_ORE = ITEMS.register("deepslate_platinum_ore",
            () -> new BlockItem(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ROSE_GOLD = ITEMS.register("rose_gold",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));

    private ModItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
