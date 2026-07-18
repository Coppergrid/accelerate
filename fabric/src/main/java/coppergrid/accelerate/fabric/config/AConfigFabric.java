package coppergrid.accelerate.fabric.config;

import net.minecraftforge.fml.config.ModConfig;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.config.AConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;

public class AConfigFabric {
    public static void register() {
        Accelerate.LOGGER.info("Registering configs with Forge Config API Port");
        ForgeConfigRegistry.INSTANCE.register(
                Accelerate.MOD_ID, ModConfig.Type.SERVER, AConfig.SERVER_SPEC);
    }
}