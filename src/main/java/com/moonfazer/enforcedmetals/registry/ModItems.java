package com.moonfazer.enforcedmetals.registry;

import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    private static final String MOD_ID = "enforcedmetals";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);


    public static final DeferredHolder<Item, Item> STEEL_BLOCK = ITEMS.register("steel_block",
            () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> ROSE_GOLD_BLOCK = ITEMS.register("rose_gold_block",
            () -> new BlockItem(ModBlocks.ROSE_GOLD_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_BLOCK = ITEMS.register("platinum_block",
            () -> new BlockItem(ModBlocks.PLATINUM_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> ASTRITE_BLOCK = ITEMS.register("astrite_block",
            () -> new BlockItem(ModBlocks.ASTRITE_BLOCK.get(), new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> STEEL_BARS = ITEMS.register("steel_bars",
            () -> new BlockItem(ModBlocks.STEEL_BARS.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_ORE = ITEMS.register("platinum_ore",
            () -> new BlockItem(ModBlocks.PLATINUM_ORE.get(), new Item.Properties()));

    public static final DeferredHolder<Item, Item> DEEPSLATE_PLATINUM_ORE = ITEMS.register("deepslate_platinum_ore",
            () -> new BlockItem(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> ASTRITE_ORE = ITEMS.register("astrite_ore",
            () -> new BlockItem(ModBlocks.ASTRITE_ORE.get(), new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ROSE_GOLD = ITEMS.register("rose_gold",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ASTRITE_INGOT = ITEMS.register("astrite_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> ASTRITE_SCRAP = ITEMS.register("astrite_scrap",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> ASTRITE_UPGRADE = ITEMS.register("astrite_upgrade",
            ModItems::createAstriteUpgradeTemplate);

    private ModItems() {
    }

    private static SmithingTemplateItem createAstriteUpgradeTemplate() {
        return new SmithingTemplateItem(
                Component.translatable("item.enforcedmetals.smithing_template.astrite_upgrade.applies_to"),
                Component.translatable("item.enforcedmetals.smithing_template.astrite_upgrade.ingredients"),
                Component.translatable("upgrade.enforcedmetals.astrite_upgrade"),
                Component.translatable("item.enforcedmetals.smithing_template.astrite_upgrade.base_slot_description"),
                Component.translatable("item.enforcedmetals.smithing_template.astrite_upgrade.additions_slot_description"),
                List.of(
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_hoe")),
                List.of(ResourceLocation.withDefaultNamespace("item/empty_slot_ingot")));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
