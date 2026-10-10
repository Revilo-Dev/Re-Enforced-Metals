package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModSteelArmorItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> HELMET = ITEMS.register("steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> LEGGINGS = ITEMS.register("steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> BOOTS = ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    private ModSteelArmorItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
