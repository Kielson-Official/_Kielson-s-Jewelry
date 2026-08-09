package com.kielson.datagen.translations;

import com.kielson.item.RingsAndThingsItemGroups;
import com.kielson.item.RingsAndThingsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RingsAndThingsEnglishLangProvider extends FabricLanguageProvider {
    public RingsAndThingsEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    };

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        translationBuilder.add(RingsAndThingsItemGroups.RINGS_AND_THINGS_KEY, "Rings & Things");
        translationBuilder.add("item.modifiers.ring", "When in Ring Slot:");
        translationBuilder.add("item.modifiers.bracelet", "When in Bracelet Slot:");
        translationBuilder.add("item.modifiers.necklace", "When in Necklace Slot:");
        translationBuilder.add("item.modifiers.jewelry", "When in Jewelry Slot:");

        translationBuilder.add(RingsAndThingsItems.STONE_RING, "Stone Ring");
        translationBuilder.add(RingsAndThingsItems.COPPER_RING, "Copper Ring");
        translationBuilder.add(RingsAndThingsItems.IRON_RING, "Iron Ring");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_RING, "Golden Ring");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_RING, "Netherite Ring");

        translationBuilder.add(RingsAndThingsItems.STONE_BRACELET, "Stone Bracelet");
        translationBuilder.add(RingsAndThingsItems.COPPER_BRACELET, "Copper Bracelet");
        translationBuilder.add(RingsAndThingsItems.IRON_BRACELET, "Iron Bracelet");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_BRACELET, "Golden Bracelet");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_BRACELET, "Netherite Bracelet");

        translationBuilder.add(RingsAndThingsItems.STONE_NECKLACE, "Stone Necklace");
        translationBuilder.add(RingsAndThingsItems.COPPER_NECKLACE, "Copper Necklace");
        translationBuilder.add(RingsAndThingsItems.IRON_NECKLACE, "Iron Necklace");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_NECKLACE, "Golden Necklace");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_NECKLACE, "Netherite Necklace");
    }
}
