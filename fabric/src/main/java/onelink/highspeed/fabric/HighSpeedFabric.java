package onelink.highspeed.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import onelink.highspeed.HSBlocks;
import onelink.highspeed.HSItems;
import onelink.highspeed.HighSpeed;
import net.fabricmc.api.ModInitializer;

public class HighSpeedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HighSpeed.init();
        HighSpeed.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), HighSpeed.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        HSBlocks.REGISTRATE.register();
        HSItems.REGISTRATE.register();
    }
}
