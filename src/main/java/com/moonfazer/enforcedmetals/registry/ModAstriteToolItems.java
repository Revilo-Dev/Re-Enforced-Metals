package com.moonfazer.enforcedmetals.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModAstriteToolItems {
    private static final String MOD_ID = "enforcedmetals";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("astrite_sword",
            () -> new SwordItem(ModToolTiers.ASTRITE, new Item.Properties()
                    .fireResistant()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ASTRITE, 6, -2.8F))));
    public static final DeferredHolder<Item, Item> PICKAXE = ITEMS.register("astrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ASTRITE, new Item.Properties()
                    .fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ASTRITE, 2.5F, -3.0F))));
    public static final DeferredHolder<Item, Item> AXE = ITEMS.register("astrite_axe",
            () -> new AxeItem(ModToolTiers.ASTRITE, new Item.Properties()
                    .fireResistant()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ASTRITE, 8.5F, -3.2F))));
    public static final DeferredHolder<Item, Item> SHOVEL = ITEMS.register("astrite_shovel",
            () -> new ShovelItem(ModToolTiers.ASTRITE, new Item.Properties()
                    .fireResistant()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ASTRITE, 3.0F, -3.1F))));
    public static final DeferredHolder<Item, Item> HOE = ITEMS.register("astrite_hoe",
            () -> new HoeItem(ModToolTiers.ASTRITE, new Item.Properties()
                    .fireResistant()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ASTRITE, -2.0F, -0.5F))));

    private ModAstriteToolItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
