package com.kielson.datagen;

import com.kielson.RingsAndThingsTags;
import com.kielson.item.RingsAndThingsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RingsAndThingsTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public RingsAndThingsTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        this.builder(RingsAndThingsTags.RINGS)
                .add(RingsAndThingsItems.STONE_RING.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.COPPER_RING.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.IRON_RING.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.GOLDEN_RING.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.NETHERITE_RING.builtInRegistryHolder().key());

        this.builder(RingsAndThingsTags.BRACELETS)
                .add(RingsAndThingsItems.STONE_BRACELET.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.COPPER_BRACELET.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.IRON_BRACELET.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.GOLDEN_BRACELET.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.NETHERITE_BRACELET.builtInRegistryHolder().key());

        this.builder(RingsAndThingsTags.NECKLACES)
                .add(RingsAndThingsItems.STONE_NECKLACE.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.COPPER_NECKLACE.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.IRON_NECKLACE.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.GOLDEN_NECKLACE.builtInRegistryHolder().key())
                .add(RingsAndThingsItems.NETHERITE_NECKLACE.builtInRegistryHolder().key());
    }
}
