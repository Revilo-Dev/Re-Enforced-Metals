package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModPlatinumArmorItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> HELMET = ITEMS.register("platinum_helmet",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> CHESTPLATE = ITEMS.register("platinum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> LEGGINGS = ITEMS.register("platinum_leggings",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> BOOTS = ITEMS.register("platinum_boots",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    private ModPlatinumArmorItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
