package onelink.accelerate.forge;

import onelink.accelerate.Accelerate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Accelerate.MOD_ID)
public class AccelerateForge {
    public AccelerateForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ACreativeTabsImpl.register(eventBus);
        Accelerate.REGISTRATE.registerEventListeners(eventBus);
        Accelerate.init();
    }
}
