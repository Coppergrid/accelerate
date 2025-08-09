package onelink.createmaglev.forge;

import onelink.createmaglev.MaglevBlocks;
import onelink.createmaglev.MaglevItems;
import onelink.createmaglev.CreateMaglev;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateMaglev.MOD_ID)
public class CreateMaglevForge {
    public CreateMaglevForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MaglevCreativeTabsImpl.register(eventBus);
        MaglevBlocks.REGISTRATE.registerEventListeners(eventBus);
        MaglevItems.REGISTRATE.registerEventListeners(eventBus);
        CreateMaglev.init();
    }
}
