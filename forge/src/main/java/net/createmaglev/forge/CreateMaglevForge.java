package net.createmaglev.forge;

import net.createmaglev.MaglevBlocks;
import net.createmaglev.MaglevItems;
import net.createmaglev.CreateMaglev;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateMaglev.MOD_ID)
public class CreateMaglevForge {
    public CreateMaglevForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MaglevBlocks.REGISTRATE.registerEventListeners(eventBus);
        MaglevItems.REGISTRATE.registerEventListeners(eventBus);
        CreateMaglev.init();
    }
}
