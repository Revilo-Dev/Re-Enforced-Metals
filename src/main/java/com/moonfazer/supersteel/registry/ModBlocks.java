package com.moonfazer.supersteel.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ModBlocks {
    private static final String MOD_ID = "supersteel";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MOD_ID);

    public static final DeferredHolder<Block, Block> STEEL_BLOCK = BLOCKS.register("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 3_600_000.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredHolder<Block, Block> ROSE_GOLD_BLOCK = BLOCKS.register("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final DeferredHolder<Block, Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REINFORCED_DEEPSLATE)));

    public static final DeferredHolder<Block, Block> PLATINUM_ORE = BLOCKS.register("platinum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE)));

    public static final DeferredHolder<Block, Block> DEEPSLATE_PLATINUM_ORE = BLOCKS.register("deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COPPER_ORE)));

    private ModBlocks() {
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
