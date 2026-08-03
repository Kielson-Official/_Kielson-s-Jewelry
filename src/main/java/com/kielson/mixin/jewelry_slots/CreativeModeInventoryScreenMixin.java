package com.kielson.mixin.jewelry_slots;

import com.kielson.jewelry_slots.PlayerJewelrySlots;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin extends AbstractContainerScreen<CreativeModeInventoryScreen.ItemPickerMenu> {

    public CreativeModeInventoryScreenMixin() {
        super(null, null, null);
    }

    @ModifyArgs(method = "selectTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/CreativeModeInventoryScreen$SlotWrapper;<init>(Lnet/minecraft/world/inventory/Slot;III)V"))
    private void modifyCustomSlotCoordinates(Args args) {
        Slot originalSlot = args.get(0);

        Minecraft mc = Minecraft.getInstance();

        if (mc.player != null) {
            SimpleContainer customContainer = ((PlayerJewelrySlots) mc.player).getJewelrySlotsContainer();

            if (originalSlot.container == customContainer) {
                switch (originalSlot.getContainerSlot()) {
                    case PlayerJewelrySlots.RING_SLOT -> {
                        args.set(2, 127);
                        args.set(3, 20);
                    }
                    case PlayerJewelrySlots.BRACELET_SLOT -> {
                        args.set(2, 145);
                        args.set(3, 20);
                    }
                    case PlayerJewelrySlots.NECKLACE_SLOT -> {
                        args.set(2, 17);
                        args.set(3, 20);
                    }
                }
            }
        }
    }

    @Inject(method = "extractBackground", at = @At("TAIL"))
    private void renderCustomSlotBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a, CallbackInfo ci) {
        for (Slot slot : this.menu.slots) {
            if (slot.container instanceof SimpleContainer && slot.isActive() && slot.y == 20) {
                if(slot.x == 127){
                    Identifier slotTexture = Identifier.parse("container/slot");
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, slotTexture, this.leftPos + 126, this.topPos + 19, 18, 18);
                }
                if(slot.x == 145){
                    Identifier slotTexture = Identifier.parse("container/slot");
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, slotTexture, this.leftPos + 144, this.topPos + 19, 18, 18);
                }
                if(slot.x == 17){
                    Identifier slotTexture = Identifier.parse("container/slot");
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, slotTexture, this.leftPos + 16, this.topPos + 19, 18, 18);
                }
            }
        }
    }
}
