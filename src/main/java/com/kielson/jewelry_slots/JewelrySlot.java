package com.kielson.jewelry_slots;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import static com.kielson.RingsAndThings.MOD_ID;

public class JewelrySlot extends Slot {
    private final String emptyIconPath;
    private final TagKey<Item> itemTag;

    public JewelrySlot(Container container, int slot, int x, int y, String emptyIconPath, TagKey<Item> itemTag) {
        super(container, slot, x, y);
        this.emptyIconPath = emptyIconPath;
        this.itemTag = itemTag;
    }

    @Override
    public boolean mayPlace(@NonNull ItemStack stack) {
        return stack.is(itemTag);
    }

    @Override
    public @Nullable Identifier getNoItemIcon() {
        return Identifier.fromNamespaceAndPath(MOD_ID, emptyIconPath);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
