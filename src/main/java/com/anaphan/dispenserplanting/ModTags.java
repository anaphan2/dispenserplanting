package com.anaphan.dispenserplanting;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> NETHER_FUNGI = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("dispenserplanting", "nether_fungi")
    );

    public static final TagKey<Item> DISPENSABLE_PLANTS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("dispenserplanting", "dispensable_plants")
    );
}