package com.kielson.jewelry_slots;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.*;

public class JewelryAttributeHandler {
    private static EquipmentSlotGroup getCustomGroup(String name) {
        for (EquipmentSlotGroup group : EquipmentSlotGroup.values()) {
            if (group.name().equals(name)) {
                return group;
            }
        }
        return EquipmentSlotGroup.ANY;
    }

    private static EquipmentSlotGroup GROUP_RING;
    private static EquipmentSlotGroup GROUP_BRACELET;
    private static EquipmentSlotGroup GROUP_NECKLACE;
    private static EquipmentSlotGroup GROUP_JEWELRY;

    public static void ensureGroupsLoaded() {
        if (GROUP_RING == null) {
            GROUP_RING = getCustomGroup("RING");
            GROUP_BRACELET = getCustomGroup("BRACELET");
            GROUP_NECKLACE = getCustomGroup("NECKLACE");
            GROUP_JEWELRY = getCustomGroup("JEWELRY");
        }
    }

    public static void refresh(Player player) {
        ensureGroupsLoaded();

        PlayerJewelrySlots slots = (PlayerJewelrySlots) player;
        Set<Identifier> previous = slots.getAppliedJewelryModifiers();
        AttributeMap attributes = player.getAttributes();

        for (Holder.Reference<Attribute> holder : BuiltInRegistries.ATTRIBUTE.listElements().toList()) {
            AttributeInstance instance = attributes.getInstance(holder);
            if (instance != null) {
                for (Identifier id : previous) {
                    instance.removeModifier(id);
                }
            }
        }
        previous.clear();

        JewelryContainer jewelry = slots.getJewelrySlotsContainer();

        for (int i = 0; i < jewelry.getContainerSize(); i++) {
            ItemStack stack = jewelry.getItem(i);
            if (stack.isEmpty()) continue;

            EquipmentSlotGroup expectedGroup = getGroupForSlot(i);

            ItemAttributeModifiers modifiersComponent = stack.getOrDefault(
                    DataComponents.ATTRIBUTE_MODIFIERS,
                    ItemAttributeModifiers.EMPTY
            );

            for (ItemAttributeModifiers.Entry entry : modifiersComponent.modifiers()) {
                EquipmentSlotGroup slotGroup = entry.slot();

                if (slotGroup == expectedGroup || slotGroup == GROUP_JEWELRY || slotGroup == EquipmentSlotGroup.ANY) {
                    AttributeInstance instance = attributes.getInstance(entry.attribute());
                    if (instance != null) {
                        instance.removeModifier(entry.modifier().id());
                        instance.addTransientModifier(entry.modifier());
                        previous.add(entry.modifier().id());
                    }
                }
            }
        }
    }

    private static EquipmentSlotGroup getGroupForSlot(int slotIndex) {
        return switch (slotIndex) {
            case PlayerJewelrySlots.RING_SLOT -> GROUP_RING;
            case PlayerJewelrySlots.BRACELET_SLOT -> GROUP_BRACELET;
            case PlayerJewelrySlots.NECKLACE_SLOT -> GROUP_NECKLACE;
            default -> EquipmentSlotGroup.ANY;
        };
    }
}