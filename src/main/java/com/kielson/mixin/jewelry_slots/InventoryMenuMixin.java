package com.kielson.mixin.jewelry_slots;

import com.kielson.RingsAndThingsTags;
import com.kielson.jewelry_slots.JewelrySlot;
import com.kielson.jewelry_slots.PlayerJewelrySlots;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryMenu.class)
public abstract class InventoryMenuMixin {

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/InventoryMenu;addSlot(Lnet/minecraft/world/inventory/Slot;)Lnet/minecraft/world/inventory/Slot;", shift = At.Shift.AFTER, ordinal = 1))
    private void initCustomSlot(Inventory inventory, boolean active, Player owner, CallbackInfo ci) {
        SimpleContainer customContainer = ((PlayerJewelrySlots) owner).getJewelrySlotsContainer();
        AbstractContainerMenu containerMenu = (AbstractContainerMenu)(Object)this;

        containerMenu.addSlot(new JewelrySlot(customContainer, PlayerJewelrySlots.RING_SLOT, 77, 44, "container/slot/ring", RingsAndThingsTags.RINGS));
        containerMenu.addSlot(new JewelrySlot(customContainer, PlayerJewelrySlots.BRACELET_SLOT, 77, 26, "container/slot/bracelet", RingsAndThingsTags.BRACELETS));
        containerMenu.addSlot(new JewelrySlot(customContainer, PlayerJewelrySlots.NECKLACE_SLOT, 77, 8, "container/slot/necklace", RingsAndThingsTags.NECKLACES));
    }

    @Inject(method = "quickMoveStack", at = @At("HEAD"), cancellable = true)
    private void handleShiftClickCrash(Player player, int slotIndex, CallbackInfoReturnable<ItemStack> cir) {
        AbstractContainerMenu containerMenu = (AbstractContainerMenu)(Object)this;

        if (slotIndex >= 46 && slotIndex <=48) {
            Slot slot = containerMenu.slots.get(slotIndex);

            if (slot.hasItem()) {
                ItemStack originalStack = slot.getItem();
                ItemStack newStack = originalStack.copy();

                if (!containerMenu.moveItemStackTo(originalStack, 9, 45, false)) {
                    cir.setReturnValue(ItemStack.EMPTY);
                    return;
                }

                if (originalStack.isEmpty()) {
                    slot.set(ItemStack.EMPTY);
                }
                slot.setChanged();
                cir.setReturnValue(newStack);
            }
        }
    }
}
