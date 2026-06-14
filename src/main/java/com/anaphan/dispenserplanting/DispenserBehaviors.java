package com.anaphan.dispenserplanting;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.bus.api.SubscribeEvent;


@EventBusSubscriber(modid = DispenserPlanting.MODID)
public final class DispenserBehaviors {

    @SubscribeEvent
    public static void onTagsUpdated(TagsUpdatedEvent.ServerDataLoad event) {
        PlantableDispenseBehavior behavior = new PlantableDispenseBehavior();
        event.getRegistries().lookupOrThrow(Registries.ITEM)
                .getOrThrow(ModTags.DISPENSABLE_PLANTS)
                .stream()
                .map(Holder::value)
                .forEach(item -> DispenserBlock.registerBehavior(item, behavior));
    }

    private DispenserBehaviors() {}
}