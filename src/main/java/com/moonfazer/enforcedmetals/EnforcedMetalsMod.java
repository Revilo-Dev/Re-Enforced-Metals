package com.moonfazer.enforcedmetals;

import com.moonfazer.enforcedmetals.registry.ModBlocks;
import com.moonfazer.enforcedmetals.registry.ModArmorMaterials;
import com.moonfazer.enforcedmetals.registry.ModAstriteArmorItems;
import com.moonfazer.enforcedmetals.registry.ModAstriteToolItems;
import com.moonfazer.enforcedmetals.registry.ModBlockTags;
import com.moonfazer.enforcedmetals.registry.ModCopperArmorItems;
import com.moonfazer.enforcedmetals.registry.ModCreativeTabs;
import com.moonfazer.enforcedmetals.registry.ModItems;
import com.moonfazer.enforcedmetals.registry.ModItemTags;
import com.moonfazer.enforcedmetals.registry.ModPlatinumArmorItems;
import com.moonfazer.enforcedmetals.registry.ModPlatinumToolItems;
import com.moonfazer.enforcedmetals.registry.ModSteelArmorItems;
import com.moonfazer.enforcedmetals.registry.ModSteelToolItems;
import com.moonfazer.enforcedmetals.registry.ModCopperToolItems;
import com.moonfazer.enforcedmetals.registry.ModRoseGoldArmorItems;
import com.moonfazer.enforcedmetals.registry.ModRoseGoldToolItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

@Mod(EnforcedMetalsMod.MOD_ID)
public final class EnforcedMetalsMod {
    public static final String MOD_ID = "enforcedmetals";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnforcedMetalsMod(IEventBus modEventBus, ModContainer modContainer) {
        ModArmorMaterials.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModSteelToolItems.register(modEventBus);
        ModCopperToolItems.register(modEventBus);
        ModPlatinumToolItems.register(modEventBus);
        ModRoseGoldToolItems.register(modEventBus);
        ModAstriteToolItems.register(modEventBus);
        ModSteelArmorItems.register(modEventBus);
        ModCopperArmorItems.register(modEventBus);
        ModPlatinumArmorItems.register(modEventBus);
        ModRoseGoldArmorItems.register(modEventBus);
        ModAstriteArmorItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::modifyDefaultComponents);
        NeoForge.EVENT_BUS.addListener(this::onPlayerTick);
        NeoForge.EVENT_BUS.addListener(this::onLeftClickBlock);
        NeoForge.EVENT_BUS.addListener(this::onPlayerLoggedIn);
        NeoForge.EVENT_BUS.addListener(this::onLivingIncomingDamage);
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
            event.accept(ModItems.STEEL_BARS.get());
            event.accept(ModItems.PLATINUM_ORE.get());
            event.accept(ModItems.DEEPSLATE_PLATINUM_ORE.get());
            event.accept(ModItems.ASTRITE_BLOCK.get());
            event.accept(ModItems.ASTRITE_ORE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.STEEL_INGOT.get());
            event.accept(ModItems.STEEL_NUGGET.get());
            event.accept(ModItems.RAW_PLATINUM.get());
            event.accept(ModItems.PLATINUM_INGOT.get());
            event.accept(ModItems.ASTRITE_INGOT.get());
            event.accept(ModItems.ASTRITE_SCRAP.get());
            event.accept(ModItems.ASTRITE_UPGRADE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModSteelToolItems.SWORD.get());
            event.accept(ModCopperToolItems.SWORD.get());
            event.accept(ModPlatinumToolItems.SWORD.get());
            event.accept(ModRoseGoldToolItems.SWORD.get());
            event.accept(ModAstriteToolItems.SWORD.get());

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

            event.accept(ModAstriteArmorItems.HELMET.get());
            event.accept(ModAstriteArmorItems.CHESTPLATE.get());
            event.accept(ModAstriteArmorItems.LEGGINGS.get());
            event.accept(ModAstriteArmorItems.BOOTS.get());
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
            event.accept(ModAstriteToolItems.PICKAXE.get());
            event.accept(ModAstriteToolItems.AXE.get());
            event.accept(ModAstriteToolItems.SHOVEL.get());
            event.accept(ModAstriteToolItems.HOE.get());
        }
    }

    private void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getLevel().getBlockState(event.getPos()).is(ModBlockTags.DIAMOND_REQUIRES_PLATINUM)
                && event.getEntity().getMainHandItem().is(Items.IRON_PICKAXE)) {
            event.setCanceled(true);
            if (event.getAction() == PlayerInteractEvent.LeftClickBlock.Action.START
                    && event.getEntity().level().isClientSide) {
                event.getEntity().displayClientMessage(
                    Component.translatable("message.enforcedmetals.platinum_required"),
                    true);
            }
        }
    }

    private void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            var recipes = serverPlayer.server.getRecipeManager().getRecipes().stream()
                    .filter(recipe -> recipe.id().getNamespace().equals(MOD_ID))
                    .toList();
            serverPlayer.awardRecipes(recipes);
        }
    }

    private void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        for (var ironTool : new Item[]{
                Items.IRON_PICKAXE,
                Items.IRON_AXE,
                Items.IRON_SHOVEL,
                Items.IRON_HOE}) {
            Tool tool = ironTool.components().get(DataComponents.TOOL);
            if (tool == null) {
                continue;
            }

            var slowerRules = tool.rules().stream()
                    .map(rule -> rule.speed().isPresent()
                            ? new Tool.Rule(rule.blocks(), java.util.Optional.of(5.5F), rule.correctForDrops())
                            : rule)
                    .toList();
            event.modify(ironTool, components -> components.set(
                    DataComponents.TOOL,
                    new Tool(slowerRules, tool.defaultMiningSpeed(), tool.damagePerBlock())));
        }
    }

    private void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        if (player.level().isClientSide) {
            return;
        }

        var fortune = player.level().registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.FORTUNE);
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            ItemStack stack = player.getInventory().getItem(slot);
            if (stack.is(ModItemTags.ROSE_GOLD_GEAR) && stack.getEnchantmentLevel(fortune) < 2) {
                stack.enchant(fortune, 2);
            }
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
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, platinumPieces - 1, false, false, true));
        }
    }

    private void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (event.getSource().is(DamageTypes.FELL_OUT_OF_WORLD)
                && event.getEntity().getItemBySlot(EquipmentSlot.HEAD).is(ModAstriteArmorItems.HELMET.get())
                && event.getEntity().getItemBySlot(EquipmentSlot.CHEST).is(ModAstriteArmorItems.CHESTPLATE.get())
                && event.getEntity().getItemBySlot(EquipmentSlot.LEGS).is(ModAstriteArmorItems.LEGGINGS.get())
                && event.getEntity().getItemBySlot(EquipmentSlot.FEET).is(ModAstriteArmorItems.BOOTS.get())) {
            event.setCanceled(true);
        }
    }
}
