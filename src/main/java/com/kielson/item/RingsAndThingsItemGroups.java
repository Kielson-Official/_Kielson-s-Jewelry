package com.kielson.item;

import com.kielson.util.JewelryComponent;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.ArrayList;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsItemGroups {
    public static final ResourceKey<CreativeModeTab> RINGS_AND_THINGS_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID)
    );

    public static final CreativeModeTab RINGS_AND_THINGS_TAB = FabricCreativeModeTab.builder()
            .icon(() -> JewelryComponent.setGem(new ItemStack(RingsAndThingsItems.STONE_RING), JewelryComponent.Gem.EMERALD))
            .title(Component.translatable("itemGroup." + MOD_ID))
            .displayItems((_, output) -> {

                for(ItemStack itemStack : getJewelryStacks()){
                    output.accept(itemStack);
                }

            })
            .build();

    private static void addItemsToToolsAndUtilities() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {

            for(ItemStack itemStack : getJewelryStacks()){
                content.insertAfter(Items.GOAT_HORN, itemStack);
            }

        });
    }

    private static ArrayList<ItemStack> getJewelryStacks(){
        Item[][] jewelry = new Item[][]{
                {RingsAndThingsItems.STONE_RING, RingsAndThingsItems.COPPER_RING, RingsAndThingsItems.IRON_RING, RingsAndThingsItems.GOLDEN_RING, RingsAndThingsItems.NETHERITE_RING},
                {RingsAndThingsItems.STONE_BRACELET, RingsAndThingsItems.COPPER_BRACELET, RingsAndThingsItems.IRON_BRACELET, RingsAndThingsItems.GOLDEN_BRACELET, RingsAndThingsItems.NETHERITE_BRACELET},
                {RingsAndThingsItems.STONE_NECKLACE, RingsAndThingsItems.COPPER_NECKLACE, RingsAndThingsItems.IRON_NECKLACE, RingsAndThingsItems.GOLDEN_NECKLACE, RingsAndThingsItems.NETHERITE_NECKLACE}
        };
        ArrayList<ItemStack> items = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(JewelryComponent.Gem gem : JewelryComponent.Gem.values()){
                for(Item ringItem : jewelry[i]){
                    items.add(JewelryComponent.setGem(new ItemStack(ringItem), gem));
                }
            }
        }

        return items;
    }

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RINGS_AND_THINGS_KEY, RINGS_AND_THINGS_TAB);
        addItemsToToolsAndUtilities();
    }
}
