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

public final class ModCopperToolItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .stacksTo(1)
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 2, -2.4F))));
    public static final DeferredHolder<Item, Item> PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .stacksTo(1)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1.0F, -2.8F))));
    public static final DeferredHolder<Item, Item> AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .stacksTo(1)
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 5.0F, -3.1F))));
    public static final DeferredHolder<Item, Item> SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .stacksTo(1)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.0F, -3.0F))));
    public static final DeferredHolder<Item, Item> HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .stacksTo(1)
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -2.0F, -1.0F))));

    private ModCopperToolItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
