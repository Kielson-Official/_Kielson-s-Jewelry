package com.kielson.datagen.translations;

import com.kielson.item.RingsAndThingsItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RingsAndThingsPolishLangProvider extends FabricLanguageProvider {
    public RingsAndThingsPolishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "pl_pl", registryLookup);
    };

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        translationBuilder.add(RingsAndThingsItemGroups.RINGS_AND_THINGS_KEY, "Rings & Things");
        translationBuilder.add("item.modifiers.ring", "Gdy w miejscu na pierścień:");
        translationBuilder.add("item.modifiers.bracelet", "Gdy w miejscu na bransoletkę:");
        translationBuilder.add("item.modifiers.necklace", "Gdy w miejscu na naszyjnik:");
        translationBuilder.add("item.modifiers.jewelry", "Gdy w dowolnym miejscu na biżuterię:");
    }
}
