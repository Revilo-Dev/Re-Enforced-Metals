package com.moonfazer.supersteel;

import com.moonfazer.supersteel.registry.ModBlocks;
import com.moonfazer.supersteel.registry.ModArmorMaterials;
import com.moonfazer.supersteel.registry.ModCopperArmorItems;
import com.moonfazer.supersteel.registry.ModCreativeTabs;
import com.moonfazer.supersteel.registry.ModItems;
import com.moonfazer.supersteel.registry.ModPlatinumArmorItems;
import com.moonfazer.supersteel.registry.ModPlatinumToolItems;
import com.moonfazer.supersteel.registry.ModSteelArmorItems;
import com.moonfazer.supersteel.registry.ModSteelToolItems;
import com.moonfazer.supersteel.registry.ModCopperToolItems;
import com.moonfazer.supersteel.registry.ModRoseGoldArmorItems;
import com.moonfazer.supersteel.registry.ModRoseGoldToolItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

@Mod(SuperSteelMod.MOD_ID)
public final class SuperSteelMod {
    public static final String MOD_ID = "supersteel";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SuperSteelMod(IEventBus modEventBus, ModContainer modContainer) {
        ModArmorMaterials.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModSteelToolItems.register(modEventBus);
        ModCopperToolItems.register(modEventBus);
        ModPlatinumToolItems.register(modEventBus);
        ModRoseGoldToolItems.register(modEventBus);
        ModSteelArmorItems.register(modEventBus);
        ModCopperArmorItems.register(modEventBus);
        ModPlatinumArmorItems.register(modEventBus);
        ModRoseGoldArmorItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        NeoForge.EVENT_BUS.addListener(this::onPlayerTick);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            var steelBlockId = ResourceLocation.fromNamespaceAndPath(MOD_ID, "steel_block");
            var steelId = ResourceLocation.fromNamespaceAndPath(MOD_ID, "steel");
            LOGGER.info("Block registered {}: {}", steelBlockId, BuiltInRegistries.BLOCK.containsKey(steelBlockId));
            LOGGER.info("Item registered {}: {}", steelBlockId, BuiltInRegistries.ITEM.containsKey(steelBlockId));
            LOGGER.info("Item registered {}: {}", steelId, BuiltInRegistries.ITEM.containsKey(steelId));
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.STEEL_BLOCK.get());
            event.accept(ModItems.PLATINUM_ORE.get());
            event.accept(ModItems.DEEPSLATE_PLATINUM_ORE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.STEEL_INGOT.get());
            event.accept(ModItems.RAW_PLATINUM.get());
            event.accept(ModItems.PLATINUM_INGOT.get());
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModSteelToolItems.SWORD.get());
            event.accept(ModCopperToolItems.SWORD.get());
            event.accept(ModPlatinumToolItems.SWORD.get());
            event.accept(ModRoseGoldToolItems.SWORD.get());

            event.accept(ModSteelArmorItems.HELMET.get());
            event.accept(ModSteelArmorItems.CHESTPLATE.get());
            event.accept(ModSteelArmorItems.LEGGINGS.get());
            event.accept(ModSteelArmorItems.BOOTS.get());

            event.accept(ModCopperArmorItems.HELMET.get());
            event.accept(ModCopperArmorItems.CHESTPLATE.get());
            event.accept(ModCopperArmorItems.LEGGINGS.get());
            event.accept(ModCopperArmorItems.BOOTS.get());

            event.accept(ModPlatinumArmorItems.HELMET.get());
            event.accept(ModPlatinumArmorItems.CHESTPLATE.get());
            event.accept(ModPlatinumArmorItems.LEGGINGS.get());
            event.accept(ModPlatinumArmorItems.BOOTS.get());

            event.accept(ModRoseGoldArmorItems.HELMET.get());
            event.accept(ModRoseGoldArmorItems.CHESTPLATE.get());
            event.accept(ModRoseGoldArmorItems.LEGGINGS.get());
            event.accept(ModRoseGoldArmorItems.BOOTS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModSteelToolItems.PICKAXE.get());
            event.accept(ModSteelToolItems.AXE.get());
            event.accept(ModSteelToolItems.SHOVEL.get());
            event.accept(ModSteelToolItems.HOE.get());
            event.accept(ModCopperToolItems.PICKAXE.get());
            event.accept(ModCopperToolItems.AXE.get());
            event.accept(ModCopperToolItems.SHOVEL.get());
            event.accept(ModCopperToolItems.HOE.get());
            event.accept(ModPlatinumToolItems.PICKAXE.get());
            event.accept(ModPlatinumToolItems.AXE.get());
            event.accept(ModPlatinumToolItems.SHOVEL.get());
            event.accept(ModPlatinumToolItems.HOE.get());
            event.accept(ModRoseGoldToolItems.PICKAXE.get());
            event.accept(ModRoseGoldToolItems.AXE.get());
            event.accept(ModRoseGoldToolItems.SHOVEL.get());
            event.accept(ModRoseGoldToolItems.HOE.get());
        }
    }

    private void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        if (player.level().isClientSide) {
            return;
        }

        int platinumPieces = 0;
        if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModPlatinumArmorItems.HELMET.get())) {
            platinumPieces++;
        }
        if (player.getItemBySlot(EquipmentSlot.CHEST).is(ModPlatinumArmorItems.CHESTPLATE.get())) {
            platinumPieces++;
        }
        if (player.getItemBySlot(EquipmentSlot.LEGS).is(ModPlatinumArmorItems.LEGGINGS.get())) {
            platinumPieces++;
        }
        if (player.getItemBySlot(EquipmentSlot.FEET).is(ModPlatinumArmorItems.BOOTS.get())) {
            platinumPieces++;
        }

        if (platinumPieces > 0) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, platinumPieces - 1, false, false, true));
        }
    }
}
