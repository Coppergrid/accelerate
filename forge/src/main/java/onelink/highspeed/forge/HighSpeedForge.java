package onelink.highspeed.forge;

import onelink.highspeed.HighSpeed;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HighSpeed.MOD_ID)
public class HighSpeedForge {
    public HighSpeedForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        HSCreativeTabsImpl.register(eventBus);
        HighSpeed.REGISTRATE.registerEventListeners(eventBus);
        HighSpeed.init();
    }
}
