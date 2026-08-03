package com.kielson.datagen.translations;

import com.kielson.item.RingsAndThingsItemGroups;
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
    }
}
