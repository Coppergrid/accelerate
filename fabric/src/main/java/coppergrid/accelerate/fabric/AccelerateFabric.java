package coppergrid.accelerate.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import coppergrid.accelerate.Accelerate;
import net.fabricmc.api.ModInitializer;
import coppergrid.accelerate.fabric.config.AConfigFabric;

public class AccelerateFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Accelerate.init();
        Accelerate.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), Accelerate.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        ACreativeTabsImpl.register();
        Accelerate.REGISTRATE.register();
        AConfigFabric.register();
    }
}
