package com.kielson.jewelry_slots;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;

import java.util.Set;

public interface PlayerJewelrySlots {
    int RING_SLOT = 0;
    int BRACELET_SLOT = 1;
    int NECKLACE_SLOT = 2;

    JewelryContainer getJewelrySlotsContainer();
    Set<Identifier> getAppliedJewelryModifiers();

    static EquipmentSlotGroup getCustomGroup(String name) {
        for (EquipmentSlotGroup group : EquipmentSlotGroup.values()) {
            if (group.name().equals(name)) {
                return group;
            }
        }
        return EquipmentSlotGroup.ANY;
    }
}
