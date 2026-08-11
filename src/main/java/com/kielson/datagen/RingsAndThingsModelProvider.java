package com.kielson.datagen;

import com.kielson.item.RingsAndThingsItems;
import com.kielson.util.JewelryComponent;
import com.kielson.util.RingsAndThingsComponents;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class RingsAndThingsModelProvider extends FabricModelProvider {
    public RingsAndThingsModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        generateJewelryItem(RingsAndThingsItems.STONE_RING, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.COPPER_RING, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.IRON_RING, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.GOLDEN_RING, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.NETHERITE_RING, itemModelGenerators);

        generateJewelryItem(RingsAndThingsItems.STONE_BRACELET, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.COPPER_BRACELET, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.IRON_BRACELET, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.GOLDEN_BRACELET, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.NETHERITE_BRACELET, itemModelGenerators);

        generateJewelryItem(RingsAndThingsItems.STONE_NECKLACE, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.COPPER_NECKLACE, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.IRON_NECKLACE, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.GOLDEN_NECKLACE, itemModelGenerators);
        generateJewelryItem(RingsAndThingsItems.NETHERITE_NECKLACE, itemModelGenerators);
    }

    private void generateJewelryItem(Item item, ItemModelGenerators itemModelGenerators){
        itemModelGenerators.itemModelOutput.accept(item, ItemModelUtils.select(
                new ComponentContents<>(RingsAndThingsComponents.JEWELRY_COMPONENT),
                ItemModelUtils.when(new JewelryComponent("none"), ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(
                        item,
                        "_empty",
                        ModelTemplates.FLAT_ITEM))),
                ItemModelUtils.when(new JewelryComponent("diamond"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_diamond").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_diamond")))),
                ItemModelUtils.when(new JewelryComponent("emerald"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_emerald").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_emerald")))),
                ItemModelUtils.when(new JewelryComponent("amethyst"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_amethyst").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_amethyst")))),
                ItemModelUtils.when(new JewelryComponent("resin"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_resin").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_resin")))),
                ItemModelUtils.when(new JewelryComponent("prismarine"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_prismarine").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_prismarine")))),
                ItemModelUtils.when(new JewelryComponent("obsidian"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_obsidian").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_obsidian")))),
                ItemModelUtils.when(new JewelryComponent("quartz"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_quartz").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_quartz")))),
                ItemModelUtils.when(new JewelryComponent("glowstone"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_glowstone").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_glowstone")))),
                ItemModelUtils.when(new JewelryComponent("redstone"), ItemModelUtils.plainModel(itemModelGenerators.generateLayeredItem(
                        TextureMapping.getItemTexture(item, "_redstone").sprite(),
                        TextureMapping.getItemTexture(item),
                        TextureMapping.getItemTexture(item, "_redstone"))))
            )
        );
    }
}
