package com.moonfazer.enforcedmetals.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModAstriteArmorItems {
    private static final String MOD_ID = "enforcedmetals";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> HELMET = ITEMS.register("astrite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ASTRITE, ArmorItem.Type.HELMET, armorProperties(ArmorItem.Type.HELMET)));
    public static final DeferredHolder<Item, Item> CHESTPLATE = ITEMS.register("astrite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ASTRITE, ArmorItem.Type.CHESTPLATE, armorProperties(ArmorItem.Type.CHESTPLATE)));
    public static final DeferredHolder<Item, Item> LEGGINGS = ITEMS.register("astrite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ASTRITE, ArmorItem.Type.LEGGINGS, armorProperties(ArmorItem.Type.LEGGINGS)));
    public static final DeferredHolder<Item, Item> BOOTS = ITEMS.register("astrite_boots",
            () -> new ArmorItem(ModArmorMaterials.ASTRITE, ArmorItem.Type.BOOTS, armorProperties(ArmorItem.Type.BOOTS)));

    private static Item.Properties armorProperties(ArmorItem.Type type) {
        return new Item.Properties().fireResistant().durability(type.getDurability(45));
    }

    private ModAstriteArmorItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
