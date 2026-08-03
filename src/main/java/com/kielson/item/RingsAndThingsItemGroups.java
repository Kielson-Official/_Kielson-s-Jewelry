package com.kielson.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsItemGroups {
    public static final ResourceKey<CreativeModeTab> RINGS_AND_THINGS_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "rings_and_things")
    );

    public static final CreativeModeTab RINGS_AND_THINGS_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(RingsAndThingsItems.RING)).title(Component.translatable("itemGroup." + MOD_ID))
            .displayItems((_, output) -> {
                output.accept(RingsAndThingsItems.RING);
            }).build();

    private static void addItemsToToolsAndUtilities() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {

        });
    }

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RINGS_AND_THINGS_KEY, RINGS_AND_THINGS_TAB);
        addItemsToToolsAndUtilities();
    }
}
