package com.kielson.mixin.jewelry_slots;

import com.kielson.jewelry_slots.PlayerJewelrySlots;
import net.minecraft.network.protocol.game.ServerboundSetCreativeModeSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.SimpleContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {

    @Shadow
    public ServerPlayer player;

    @Inject(method = "handleSetCreativeModeSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ServerboundSetCreativeModeSlotPacket;slotNum()S"), cancellable = true)
    private void addCustomSlotHandling(ServerboundSetCreativeModeSlotPacket packet, CallbackInfo ci){
        if (packet.slotNum() >= 46 && packet.slotNum() <= 48) {
            SimpleContainer jewelry = ((PlayerJewelrySlots) player).getJewelrySlotsContainer();
            jewelry.setItem(packet.slotNum() - 46, packet.itemStack());
            player.inventoryMenu.broadcastChanges();
            ci.cancel();
        }
    }
}
