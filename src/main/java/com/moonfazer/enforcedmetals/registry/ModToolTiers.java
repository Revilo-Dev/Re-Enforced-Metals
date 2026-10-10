package com.moonfazer.enforcedmetals.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

public final class ModToolTiers {
    private static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath("enforcedmetals", "incorrect_for_steel_tool"));

    public static final Tier STEEL = new SimpleTier(
            INCORRECT_FOR_STEEL_TOOL,
            300,
            6.5F,
            3.0F,
            14,
            () -> Ingredient.of(ModItems.STEEL_INGOT.get())
    );
    public static final Tier COPPER = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            220,
            6.0F,
            2.0F,
            10,
            () -> Ingredient.of(Items.COPPER_INGOT)
    );
    public static final Tier PLATINUM = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1500,
            8.5F,
            4.0F,
            18,
            () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())
    );
    public static final Tier ROSE_GOLD = new SimpleTier(
            BlockTags.INCORRECT_FOR_GOLD_TOOL,
            128,
            12.0F,
            0.0F,
            30,
            () -> Ingredient.of(ModItems.ROSE_GOLD.get())
    );
    public static final Tier ASTRITE = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3000,
            10.0F,
            5.0F,
            18,
            () -> Ingredient.of(ModItems.ASTRITE_INGOT.get())
    );

    private ModToolTiers() {
    }
}
