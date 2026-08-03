package com.kielson.mixin.jewelry_slots;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

@Mixin(EquipmentSlotGroup.class)
public abstract class EquipmentSlotGroupMixin {

    @Shadow
    @Final
    @Mutable
    private static EquipmentSlotGroup[] $VALUES;

    @Invoker("<init>")
    private static EquipmentSlotGroup createEquipmentSlotGroup(String internalName, int internalId, int id, String name, Predicate<EquipmentSlot> test) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/EquipmentSlotGroup;$VALUES:[Lnet/minecraft/world/entity/EquipmentSlotGroup;", shift = At.Shift.AFTER, opcode = Opcodes.PUTSTATIC))
    private static void registerJewelrySlotGroups(CallbackInfo ci) {
        ArrayList<EquipmentSlotGroup> values = new ArrayList<>(Arrays.asList($VALUES));

        values.add(createEquipmentSlotGroup("RING", values.size(), values.size(), "ring", slot -> false));
        values.add(createEquipmentSlotGroup("BRACELET", values.size(), values.size(), "bracelet", slot -> false));
        values.add(createEquipmentSlotGroup("NECKLACE", values.size(), values.size(), "necklace", slot -> false));
        values.add(createEquipmentSlotGroup("JEWELRY", values.size(), values.size(), "jewelry", slot -> false));

        $VALUES = values.toArray(new EquipmentSlotGroup[0]);
    }
}
