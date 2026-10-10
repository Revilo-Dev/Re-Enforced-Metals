package com.moonfazer.enforcedmetals.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    public static final TagKey<Item> ROSE_GOLD_GEAR = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("enforcedmetals", "rose_gold_gear"));

    private ModItemTags() {
    }
}
