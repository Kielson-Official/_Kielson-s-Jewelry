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
                .add(RingsAndThingsItems.RING.builtInRegistryHolder().key());
    }
}
