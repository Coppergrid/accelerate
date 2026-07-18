package coppergrid.accelerate.forge.config;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.config.AConfig;

public class AConfigForge {
    public static void register() {
        Accelerate.LOGGER.info("Registering configs with Forge Config API");
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.SERVER, AConfig.SERVER_SPEC, Accelerate.MOD_ID + "-server.toml");
    }
}
