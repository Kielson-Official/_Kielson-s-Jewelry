package com.kielson.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record JewelryComponent(String material, String gem) {

    public static final Codec<JewelryComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("material").forGetter(JewelryComponent::material),
            Codec.STRING.fieldOf("gem").forGetter(JewelryComponent::gem)
    ).apply(builder, JewelryComponent::new));


    public enum Material {
        COPPER("copper"),
        IRON("iron"),
        GOLDEN("golden"),
        NETHERITE("netherite");

        Material(String name){

        }
    }
    public enum Gem {
        DIAMOND("diamond"),
        EMERALD("emerald"),
        AMETHYST("amethyst"),
        OBSIDIAN("obsidian");

        Gem(String name){

        }
    }
}
