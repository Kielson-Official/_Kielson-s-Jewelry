package com.kielson.item;

import com.kielson.util.ItemHelper;
import com.kielson.util.JewelryComponent;
import net.minecraft.world.item.Item;

import static com.kielson.RingsAndThings.MOD_ID;

public class RingsAndThingsItems {
    public static final Item STONE_RING = ItemHelper.registerItem(MOD_ID, "stone_ring", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item COPPER_RING = ItemHelper.registerItem(MOD_ID, "copper_ring", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item IRON_RING = ItemHelper.registerItem(MOD_ID, "iron_ring", properties ->
            new JewelryItem(JewelryComponent.Material.IRON, properties), new Item.Properties());
    public static final Item GOLDEN_RING = ItemHelper.registerItem(MOD_ID, "golden_ring", properties ->
            new JewelryItem(JewelryComponent.Material.GOLDEN, properties), new Item.Properties());
    public static final Item NETHERITE_RING = ItemHelper.registerItem(MOD_ID, "netherite_ring", properties ->
            new JewelryItem(JewelryComponent.Material.NETHERITE, properties.fireResistant()), new Item.Properties().fireResistant());


    public static final Item STONE_BRACELET = ItemHelper.registerItem(MOD_ID, "stone_bracelet", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item COPPER_BRACELET = ItemHelper.registerItem(MOD_ID, "copper_bracelet", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item IRON_BRACELET = ItemHelper.registerItem(MOD_ID, "iron_bracelet", properties ->
            new JewelryItem(JewelryComponent.Material.IRON, properties), new Item.Properties());
    public static final Item GOLDEN_BRACELET = ItemHelper.registerItem(MOD_ID, "golden_bracelet", properties ->
            new JewelryItem(JewelryComponent.Material.GOLDEN, properties), new Item.Properties());
    public static final Item NETHERITE_BRACELET = ItemHelper.registerItem(MOD_ID, "netherite_bracelet", properties ->
            new JewelryItem(JewelryComponent.Material.NETHERITE, properties.fireResistant()), new Item.Properties().fireResistant());


    public static final Item STONE_NECKLACE = ItemHelper.registerItem(MOD_ID, "stone_necklace", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item COPPER_NECKLACE = ItemHelper.registerItem(MOD_ID, "copper_necklace", properties ->
            new JewelryItem(JewelryComponent.Material.COPPER, properties), new Item.Properties());
    public static final Item IRON_NECKLACE = ItemHelper.registerItem(MOD_ID, "iron_necklace", properties ->
            new JewelryItem(JewelryComponent.Material.IRON, properties), new Item.Properties());
    public static final Item GOLDEN_NECKLACE = ItemHelper.registerItem(MOD_ID, "golden_necklace", properties ->
            new JewelryItem(JewelryComponent.Material.GOLDEN, properties), new Item.Properties());
    public static final Item NETHERITE_NECKLACE = ItemHelper.registerItem(MOD_ID, "netherite_necklace", properties ->
            new JewelryItem(JewelryComponent.Material.NETHERITE, properties.fireResistant()), new Item.Properties().fireResistant());

    public static void initialize(){}
}
