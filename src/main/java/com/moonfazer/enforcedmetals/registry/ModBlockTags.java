package com.moonfazer.enforcedmetals.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> DIAMOND_REQUIRES_PLATINUM = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath("enforcedmetals", "diamond_requires_platinum"));

    private ModBlockTags() {
    }
}
