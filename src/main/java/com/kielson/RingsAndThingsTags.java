package com.kielson;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsTags {

    public static final TagKey<Item> RINGS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "rings"));
    public static final TagKey<Item> BRACELETS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "bracelets"));
    public static final TagKey<Item> NECKLACES = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "necklaces"));

    public static void initialize() {}
}
