package com.moonfazer.enforcedmetals.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    private static final String MOD_ID = "enforcedmetals";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STEEL = CREATIVE_MODE_TABS.register("steel",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.enforcedmetals.steel"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.ROSE_GOLD.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.STEEL_NUGGET.get());
                        output.accept(ModItems.RAW_PLATINUM.get());
                        output.accept(ModItems.PLATINUM_INGOT.get());
                        output.accept(ModItems.ROSE_GOLD.get());
                        output.accept(ModItems.ASTRITE_SCRAP.get());
                        output.accept(ModItems.ASTRITE_INGOT.get());
                        output.accept(ModItems.ASTRITE_UPGRADE.get());

                        output.accept(ModItems.STEEL_BLOCK.get());
                        output.accept(ModItems.STEEL_BARS.get());
                        output.accept(ModItems.PLATINUM_BLOCK.get());
                        output.accept(ModItems.ROSE_GOLD_BLOCK.get());
                        output.accept(ModItems.PLATINUM_ORE.get());
                        output.accept(ModItems.DEEPSLATE_PLATINUM_ORE.get());
                        output.accept(ModItems.ASTRITE_BLOCK.get());
                        output.accept(ModItems.ASTRITE_ORE.get());

                        output.accept(ModSteelToolItems.SWORD.get());
                        output.accept(ModSteelToolItems.PICKAXE.get());
                        output.accept(ModSteelToolItems.AXE.get());
                        output.accept(ModSteelToolItems.SHOVEL.get());
                        output.accept(ModSteelToolItems.HOE.get());

                        output.accept(ModCopperToolItems.SWORD.get());
                        output.accept(ModCopperToolItems.PICKAXE.get());
                        output.accept(ModCopperToolItems.AXE.get());
                        output.accept(ModCopperToolItems.SHOVEL.get());
                        output.accept(ModCopperToolItems.HOE.get());

                        output.accept(ModPlatinumToolItems.SWORD.get());
                        output.accept(ModPlatinumToolItems.PICKAXE.get());
                        output.accept(ModPlatinumToolItems.AXE.get());
                        output.accept(ModPlatinumToolItems.SHOVEL.get());
                        output.accept(ModPlatinumToolItems.HOE.get());
                        output.accept(ModRoseGoldToolItems.SWORD.get());
                        output.accept(ModRoseGoldToolItems.PICKAXE.get());
                        output.accept(ModRoseGoldToolItems.AXE.get());
                        output.accept(ModRoseGoldToolItems.SHOVEL.get());
                        output.accept(ModRoseGoldToolItems.HOE.get());

                        output.accept(ModAstriteToolItems.SWORD.get());
                        output.accept(ModAstriteToolItems.PICKAXE.get());
                        output.accept(ModAstriteToolItems.AXE.get());
                        output.accept(ModAstriteToolItems.SHOVEL.get());
                        output.accept(ModAstriteToolItems.HOE.get());

                        output.accept(ModSteelArmorItems.HELMET.get());
                        output.accept(ModSteelArmorItems.CHESTPLATE.get());
                        output.accept(ModSteelArmorItems.LEGGINGS.get());
                        output.accept(ModSteelArmorItems.BOOTS.get());

                        output.accept(ModCopperArmorItems.HELMET.get());
                        output.accept(ModCopperArmorItems.CHESTPLATE.get());
                        output.accept(ModCopperArmorItems.LEGGINGS.get());
                        output.accept(ModCopperArmorItems.BOOTS.get());

                        output.accept(ModPlatinumArmorItems.HELMET.get());
                        output.accept(ModPlatinumArmorItems.CHESTPLATE.get());
                        output.accept(ModPlatinumArmorItems.LEGGINGS.get());
                        output.accept(ModPlatinumArmorItems.BOOTS.get());

                        output.accept(ModRoseGoldArmorItems.HELMET.get());
                        output.accept(ModRoseGoldArmorItems.CHESTPLATE.get());
                        output.accept(ModRoseGoldArmorItems.LEGGINGS.get());
                        output.accept(ModRoseGoldArmorItems.BOOTS.get());

                        output.accept(ModAstriteArmorItems.HELMET.get());
                        output.accept(ModAstriteArmorItems.CHESTPLATE.get());
                        output.accept(ModAstriteArmorItems.LEGGINGS.get());
                        output.accept(ModAstriteArmorItems.BOOTS.get());
                    })
                    .build());

    private ModCreativeTabs() {
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
