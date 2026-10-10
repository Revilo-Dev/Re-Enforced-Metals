package com.moonfazer.supersteel.registry;

import java.util.EnumMap;
import java.util.List;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModArmorMaterials {
    private static final String MOD_ID = "supersteel";

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> STEEL = ARMOR_MATERIALS.register("steel",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), defense -> {
                        defense.put(ArmorItem.Type.BOOTS, 2);
                        defense.put(ArmorItem.Type.LEGGINGS, 5);
                        defense.put(ArmorItem.Type.CHESTPLATE, 6);
                        defense.put(ArmorItem.Type.HELMET, 2);
                        defense.put(ArmorItem.Type.BODY, 5);
                    }),
                    9,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    () -> Ingredient.of(ModItems.STEEL_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MOD_ID, "steel"))),
                    1.0F,
                    0.1F));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> COPPER = ARMOR_MATERIALS.register("copper",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), defense -> {
                        defense.put(ArmorItem.Type.BOOTS, 2);
                        defense.put(ArmorItem.Type.LEGGINGS, 5);
                        defense.put(ArmorItem.Type.CHESTPLATE, 6);
                        defense.put(ArmorItem.Type.HELMET, 2);
                        defense.put(ArmorItem.Type.BODY, 5);
                    }),
                    9,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    () -> Ingredient.of(Items.COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MOD_ID, "copper"))),
                    0.0F,
                    0.0F));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PLATINUM = ARMOR_MATERIALS.register("platinum",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), defense -> {
                        defense.put(ArmorItem.Type.BOOTS, 3);
                        defense.put(ArmorItem.Type.LEGGINGS, 6);
                        defense.put(ArmorItem.Type.CHESTPLATE, 8);
                        defense.put(ArmorItem.Type.HELMET, 3);
                        defense.put(ArmorItem.Type.BODY, 6);
                    }),
                    15,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(ModItems.PLATINUM_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MOD_ID, "platinum"))),
                    2.0F,
                    0.0F));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ROSE_GOLD = ARMOR_MATERIALS.register("rose_gold",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), defense -> {
                        defense.put(ArmorItem.Type.BOOTS, 2);
                        defense.put(ArmorItem.Type.LEGGINGS, 4);
                        defense.put(ArmorItem.Type.CHESTPLATE, 5);
                        defense.put(ArmorItem.Type.HELMET, 2);
                        defense.put(ArmorItem.Type.BODY, 6);
                    }),
                    15,
                    SoundEvents.ARMOR_EQUIP_GOLD,
                    () -> Ingredient.of(ModItems.ROSE_GOLD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MOD_ID, "rose_gold"))),
                    0.0F,
                    0.0F));

    private ModArmorMaterials() {
    }

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
