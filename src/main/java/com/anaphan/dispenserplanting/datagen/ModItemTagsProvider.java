package com.anaphan.dispenserplanting.datagen;

import com.anaphan.dispenserplanting.DispenserPlanting;
import com.anaphan.dispenserplanting.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DispenserPlanting.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider lookupProvider) {
        this.tag(ModTags.NETHER_FUNGI)
                .add(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS);

        this.tag(ModTags.DISPENSABLE_PLANTS)
                .addTag(ItemTags.SAPLINGS)
                .addTag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .addTag(ModTags.NETHER_FUNGI)
                .addTag(Tags.Items.MUSHROOMS);
    }
}