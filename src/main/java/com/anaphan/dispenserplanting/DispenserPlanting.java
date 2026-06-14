package com.anaphan.dispenserplanting;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DispenserPlanting.MODID)
public class DispenserPlanting {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "dispenserplanting";

    public DispenserPlanting(IEventBus modEventBus) {
        modEventBus.addListener(DispenserPlantingDatagen::onGatherClientData);
    }
}
