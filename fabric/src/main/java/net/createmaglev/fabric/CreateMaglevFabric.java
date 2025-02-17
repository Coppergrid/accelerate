package net.createmaglev.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.createmaglev.MaglevBlocks;
import net.createmaglev.CreateMaglev;
import net.fabricmc.api.ModInitializer;

public class CreateMaglevFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateMaglev.init();
        CreateMaglev.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CreateMaglev.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        MaglevBlocks.REGISTRATE.register();
    }
}
