package com.kielson.util;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsComponents {
    public static final DataComponentType<JewelryComponent> JEWELRY_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(MOD_ID, "jewelry"),
            DataComponentType.<JewelryComponent>builder().persistent(JewelryComponent.CODEC).build()
    );

    public static void initialize(){}
}
