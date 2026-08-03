package com.kielson.jewelry_slots;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;

public class JewelryContainer extends SimpleContainer {

    private final Player player;

    public JewelryContainer(Player player) {
        super(3);
        this.player = player;
    }

    @Override
    public void setChanged() {
        super.setChanged();

        if (!player.level().isClientSide()) {
            JewelryAttributeHandler.refresh(player);
        }
    }
}
