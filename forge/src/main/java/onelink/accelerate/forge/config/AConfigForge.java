package onelink.accelerate.forge.config;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import onelink.accelerate.Accelerate;
import onelink.accelerate.config.AConfig;

public class AConfigForge {
    public static void register() {
        Accelerate.LOGGER.info("Registering configs with Forge Config API");
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON, AConfig.COMMON_SPEC, Accelerate.MOD_ID + "-common.toml");
    }
}
