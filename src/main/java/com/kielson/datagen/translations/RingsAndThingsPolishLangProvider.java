package com.kielson.datagen.translations;

import com.kielson.item.RingsAndThingsItemGroups;
import com.kielson.item.RingsAndThingsItems;
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

        translationBuilder.add(RingsAndThingsItems.STONE_RING, "Kamienny pierścień");
        translationBuilder.add(RingsAndThingsItems.COPPER_RING, "Miedziany pierścień");
        translationBuilder.add(RingsAndThingsItems.IRON_RING, "Żelazny pierścień");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_RING, "Złoty pierścień");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_RING, "Netherytowy pierścień");

        translationBuilder.add(RingsAndThingsItems.STONE_BRACELET, "Kamienna bransoletka");
        translationBuilder.add(RingsAndThingsItems.COPPER_BRACELET, "Miedziana bransoletka");
        translationBuilder.add(RingsAndThingsItems.IRON_BRACELET, "Żelazna bransoletka");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_BRACELET, "Złota bransoletka");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_BRACELET, "Netherytowa bransoletka");

        translationBuilder.add(RingsAndThingsItems.STONE_NECKLACE, "Kamienny naszyjnik");
        translationBuilder.add(RingsAndThingsItems.COPPER_NECKLACE, "Miedziany naszyjnik");
        translationBuilder.add(RingsAndThingsItems.IRON_NECKLACE, "Żelazny naszyjnik");
        translationBuilder.add(RingsAndThingsItems.GOLDEN_NECKLACE, "Złoty naszyjnik");
        translationBuilder.add(RingsAndThingsItems.NETHERITE_NECKLACE, "Netherytowy naszyjnik");
    }
}
