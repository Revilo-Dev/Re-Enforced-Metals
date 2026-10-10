package com.moonfazer.supersteel.registry;

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

public final class ModPlatinumToolItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .stacksTo(1)
                    .attributes(SwordItem.createAttributes(ModToolTiers.PLATINUM, 5, -3.0F))));
    public static final DeferredHolder<Item, Item> PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .stacksTo(1)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PLATINUM, 2.0F, -3.2F))));
    public static final DeferredHolder<Item, Item> AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .stacksTo(1)
                    .attributes(AxeItem.createAttributes(ModToolTiers.PLATINUM, 8.0F, -3.4F))));
    public static final DeferredHolder<Item, Item> SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .stacksTo(1)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PLATINUM, 2.5F, -3.3F))));
    public static final DeferredHolder<Item, Item> HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .stacksTo(1)
                    .attributes(HoeItem.createAttributes(ModToolTiers.PLATINUM, -2.0F, -1.0F))));

    private ModPlatinumToolItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
