package com.kielson.util;

import com.kielson.KielsonsAPIAttributes;
import com.kielson.RingsAndThingsTags;
import com.kielson.jewelry_slots.PlayerJewelrySlots;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.apache.commons.lang3.tuple.Pair;

import static com.kielson.RingsAndThings.MOD_ID;

public record JewelryComponent(String gem) {

    public static final Codec<JewelryComponent> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(Codec.STRING.fieldOf("gem").forGetter(JewelryComponent::gem)
    ).apply(builder, JewelryComponent::new));

    public static ItemStack setGem(ItemStack itemStack, Gem gem){
        int i;
        EquipmentSlotGroup slotGroup;
        if (itemStack.is(RingsAndThingsTags.RINGS)) {
            i = 0;
            slotGroup = PlayerJewelrySlots.getCustomGroup("ring");
        }
        else if (itemStack.is(RingsAndThingsTags.BRACELETS)) {
            i = 1;
            slotGroup = PlayerJewelrySlots.getCustomGroup("bracelet");
        }
        else if (itemStack.is(RingsAndThingsTags.NECKLACES)) {
            i = 2;
            slotGroup = PlayerJewelrySlots.getCustomGroup("necklace");
        }
        else return itemStack;

        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        for(Pair<Holder<Attribute>, AttributeModifier> pair : gem.attributeModifiers[i]){
            builder.add(pair.getLeft(), pair.getRight(), slotGroup);
        }
        itemStack.set(DataComponents.ATTRIBUTE_MODIFIERS, builder.build());
        itemStack.set(RingsAndThingsComponents.JEWELRY_COMPONENT, new JewelryComponent(gem.name));
        return itemStack;
    }

    public enum Material {
        STONE("stone"),
        COPPER("copper"),
        IRON("iron"),
        GOLDEN("golden"),
        NETHERITE("netherite");

        public final String name;

        Material(String name){
            this.name = name;
        }
    }
    public enum Gem {
        NONE("none", new Pair[][]{
                {},{},{}
        }, 0x000000),
        DIAMOND("diamond", new Pair[][]{
                {createPair(Attributes.MAX_HEALTH, 6, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.PASSIVE_REGENERATION, 0.25, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.HEALING_MULTIPLIER, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.POISON_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.WITHER_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xa4fdf0),
        EMERALD("emerald", new Pair[][]{
                {createPair(Attributes.LUCK, 5, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.TRADE_DISCOUNT_MULTIPLIER, -0.33, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                        createPair(KielsonsAPIAttributes.EXPERIENCE_MULTIPLIER, 2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.ILLAGER_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.PIGLIN_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0x82f6ad),
        AMETHYST("amethyst", new Pair[][]{
                {createPair(Attributes.ATTACK_DAMAGE, 1.5, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.ATTACK_SPEED, 0.75, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.RANGED_DAMAGE, 2, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.PULL_TIME, -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.BLINDNESS_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.DARKNESS_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xcfa0f3),
        RESIN("resin", new Pair[][]{
                {createPair(Attributes.BURNING_TIME, -0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.FREEZING_RESISTANCE, 0.5, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.VOID_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xf3791b),
        PRISMARINE("prismarine", new Pair[][]{
                {createPair(KielsonsAPIAttributes.SWIMMING_SPEED, 1.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(Attributes.OXYGEN_BONUS, 1, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.SUBMERGED_MINING_SPEED, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.WATER_MOB_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xa4d1c2),
        OBSIDIAN("obsidian", new Pair[][]{
                {createPair(Attributes.ARMOR, 3, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.ARMOR_TOUGHNESS, 3, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(Attributes.KNOCKBACK_RESISTANCE, 0.4, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 0.67, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.WEAKNESS_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.MINING_FATIGUE_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xaa0f01),
        QUARTZ("quartz", new Pair[][]{
                {createPair(Attributes.MOVEMENT_SPEED, 0.33, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(Attributes.MOVEMENT_EFFICIENCY, 0.75, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.SNEAKING_SPEED, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(KielsonsAPIAttributes.SLOWNESS_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xeae5de),
        GLOWSTONE("glowstone", new Pair[][]{
                {createPair(Attributes.JUMP_STRENGTH, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)},
                {createPair(Attributes.FALL_DAMAGE_MULTIPLIER, -0.4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                        createPair(Attributes.SAFE_FALL_DISTANCE, 1.5, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.LEVITATION_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xffc95e),
        REDSTONE("redstone", new Pair[][]{
                {createPair(Attributes.BLOCK_BREAK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                        createPair(Attributes.MINING_EFFICIENCY, 5, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(Attributes.ENTITY_INTERACTION_RANGE, 1.5, AttributeModifier.Operation.ADD_VALUE),
                        createPair(Attributes.BLOCK_INTERACTION_RANGE, 1.5, AttributeModifier.Operation.ADD_VALUE),
                        createPair(KielsonsAPIAttributes.ITEM_PICK_UP_RANGE, 1, AttributeModifier.Operation.ADD_VALUE)},
                {createPair(KielsonsAPIAttributes.CREEPER_IMMUNITY, BooleanAttribute.TRUE, AttributeModifier.Operation.ADD_VALUE)}
        }, 0xff0000);

        public final String name;
        public final Pair<Holder<Attribute>, AttributeModifier>[][] attributeModifiers;
        public final int colorHex;

        Gem(String name, Pair<Holder<Attribute>, AttributeModifier>[][] attributeModifiers, int colorHex){
            this.name = name;
            this.attributeModifiers = attributeModifiers;
            this.colorHex = colorHex;
        }

        private static Pair<Holder<Attribute>, AttributeModifier> createPair(Holder<Attribute> attribute, double value, AttributeModifier.Operation operation){
            return Pair.of(attribute,
                    new AttributeModifier(
                            Identifier.fromNamespaceAndPath(
                                    MOD_ID,
                                    attribute.getRegisteredName().replaceFirst("(minecraft:)|(rings_and_things:)|(kielsonsapi:)", "") + "_ring"
                            ),
                            value,
                            operation
                    )
            );
        }
    }
}
