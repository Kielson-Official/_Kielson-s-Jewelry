package com.kielson.item;

import com.kielson.util.JewelryComponent;
import com.kielson.util.RingsAndThingsComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class JewelryItem extends Item {
    private final JewelryComponent.Material material;
    private final JewelryComponent.Gem gem = null;

    public JewelryItem(JewelryComponent.Material material, Properties properties) {
        super(properties.stacksTo(1).component(RingsAndThingsComponents.JEWELRY_COMPONENT, new JewelryComponent(JewelryComponent.Gem.NONE.name)));
        this.material = material;
    }

    @Override
    public @NonNull ItemStack getDefaultInstance() {
        return JewelryComponent.setGem(super.getDefaultInstance(), JewelryComponent.Gem.NONE);
    }
}
