package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModRoseGoldToolItems {
    private static final String MOD_ID = "supersteel";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("rose_gold_sword",
            () -> new SwordItem(ModToolTiers.ROSE_GOLD, new Item.Properties()
                    .stacksTo(1)
                    .attributes(SwordItem.createAttributes(ModToolTiers.ROSE_GOLD, 3, -2.4F))));
    public static final DeferredHolder<Item, Item> PICKAXE = ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ROSE_GOLD, new Item.Properties()
                    .stacksTo(1)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ROSE_GOLD, 1.0F, -2.8F))));
    public static final DeferredHolder<Item, Item> AXE = ITEMS.register("rose_gold_axe",
            () -> new AxeItem(ModToolTiers.ROSE_GOLD, new Item.Properties()
                    .stacksTo(1)
                    .attributes(AxeItem.createAttributes(ModToolTiers.ROSE_GOLD, 6.0F, -3.1F))));
    public static final DeferredHolder<Item, Item> SHOVEL = ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(ModToolTiers.ROSE_GOLD, new Item.Properties()
                    .stacksTo(1)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ROSE_GOLD, 1.5F, -3.0F))));
    public static final DeferredHolder<Item, Item> HOE = ITEMS.register("rose_gold_hoe",
            () -> new HoeItem(ModToolTiers.ROSE_GOLD, new Item.Properties()
                    .stacksTo(1)
                    .attributes(HoeItem.createAttributes(ModToolTiers.ROSE_GOLD, -2.0F, -1.0F))));

    private ModRoseGoldToolItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
