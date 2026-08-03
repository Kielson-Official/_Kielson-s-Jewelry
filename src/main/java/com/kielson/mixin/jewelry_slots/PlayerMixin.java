package com.kielson.mixin.jewelry_slots;

import com.kielson.jewelry_slots.PlayerJewelrySlots;
import com.kielson.jewelry_slots.JewelryAttributeHandler;
import com.kielson.jewelry_slots.JewelryContainer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

@Mixin(Player.class)
public class PlayerMixin implements PlayerJewelrySlots {

    @Unique private final JewelryContainer jewelrySlots = new JewelryContainer((Player)(Object)this);
    @Unique private final Set<Identifier> appliedJewelryModifiers = new HashSet<>();

    @Override
    public JewelryContainer getJewelrySlotsContainer() {
        return jewelrySlots;
    }

    @Override
    public Set<Identifier> getAppliedJewelryModifiers() {
        return appliedJewelryModifiers;
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void writeCustomSlotData(ValueOutput output, CallbackInfo ci) {
        ItemStack ringItem = this.jewelrySlots.getItem(PlayerJewelrySlots.RING_SLOT);
        ItemStack braceletItem = this.jewelrySlots.getItem(PlayerJewelrySlots.BRACELET_SLOT);
        ItemStack necklaceItem = this.jewelrySlots.getItem(PlayerJewelrySlots.NECKLACE_SLOT);
        if (!ringItem.isEmpty()) {
            output.store("ringSlot", ItemStack.CODEC, ringItem);
        }
        if (!braceletItem.isEmpty()) {
            output.store("braceletSlot", ItemStack.CODEC, braceletItem);
        }
        if (!necklaceItem.isEmpty()) {
            output.store("necklaceSlot", ItemStack.CODEC, necklaceItem);
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readCustomSlotData(ValueInput input, CallbackInfo ci) {
        input.read("ringSlot", ItemStack.CODEC).ifPresent(stack -> {
            this.jewelrySlots.setItem(PlayerJewelrySlots.RING_SLOT, stack);
        });
        input.read("braceletSlot", ItemStack.CODEC).ifPresent(stack -> {
            this.jewelrySlots.setItem(PlayerJewelrySlots.BRACELET_SLOT, stack);
        });
        input.read("necklaceSlot", ItemStack.CODEC).ifPresent(stack -> {
            this.jewelrySlots.setItem(PlayerJewelrySlots.NECKLACE_SLOT, stack);
        });

        if (!((Player)(Object)this).level().isClientSide()) {
            JewelryAttributeHandler.refresh((Player)(Object)this);
        }
    }

    @Inject(method = "dropEquipment", at = @At("TAIL"))
    private void dropCustomSlotItemOnDeath(CallbackInfo ci) {
        Player player = (Player) (Object) this;
        ItemStack ringItem = this.jewelrySlots.getItem(PlayerJewelrySlots.RING_SLOT);
        ItemStack braceletItem = this.jewelrySlots.getItem(PlayerJewelrySlots.BRACELET_SLOT);
        ItemStack necklaceItem = this.jewelrySlots.getItem(PlayerJewelrySlots.NECKLACE_SLOT);

        if (!ringItem.isEmpty()) {
            player.drop(ringItem, true, false);
        }
        if(!braceletItem.isEmpty()){
            player.drop(braceletItem, true, false);
        }
        if(!necklaceItem.isEmpty()){
            player.drop(necklaceItem, true, false);
        }
        this.jewelrySlots.clearContent();
    }

    @Inject(method = "die", at = @At("TAIL"))
    private void refreshAttributesOnDeath(CallbackInfo ci) {
        Player player = (Player) (Object) this;
        JewelryAttributeHandler.refresh(player);
    }
}
