package com.kielson.item;

import com.kielson.util.JewelryComponent;
import com.kielson.util.RingsAndThingsComponents;
import net.minecraft.world.item.Item;

public class RingItem extends Item {
    private JewelryComponent.Material material = null;
    private JewelryComponent.Gem gem = null;

    public RingItem(Properties properties) {
        super(properties);

        /*if(components().has(RingsAndThingsComponents.JEWELRY_COMPONENT)){
            JewelryComponent component = components().get(RingsAndThingsComponents.JEWELRY_COMPONENT);
            assert component != null;
            material = JewelryComponent.Material.valueOf(component.material());
            gem = JewelryComponent.Gem.valueOf(component.gem());
        }*/
    }
}
