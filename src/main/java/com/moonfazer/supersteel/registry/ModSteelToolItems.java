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

public final class ModSteelToolItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, new Item.Properties()
                    .stacksTo(1)
                    .attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 3, -2.4F))));
    public static final DeferredHolder<Item, Item> PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .stacksTo(1)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 1.0F, -2.8F))));
    public static final DeferredHolder<Item, Item> AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .stacksTo(1)
                    .attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 6.0F, -3.1F))));
    public static final DeferredHolder<Item, Item> SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, new Item.Properties()
                    .stacksTo(1)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STEEL, 1.5F, -3.0F))));
    public static final DeferredHolder<Item, Item> HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties()
                    .stacksTo(1)
                    .attributes(HoeItem.createAttributes(ModToolTiers.STEEL, -2.0F, -1.0F))));

    private ModSteelToolItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
