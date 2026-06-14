package com.anaphan.dispenserplanting;

import com.anaphan.dispenserplanting.datagen.ModItemTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class DispenserPlantingDatagen {
    public static void onGatherClientData(GatherDataEvent.Client event) {
        event.createProvider(ModItemTagsProvider::new);
    }

    private DispenserPlantingDatagen () {}
}
