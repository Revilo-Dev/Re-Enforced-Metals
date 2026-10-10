package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCopperArmorItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    private ModCopperArmorItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
