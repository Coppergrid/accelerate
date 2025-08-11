package onelink.highspeed;

import com.simibubi.create.Create;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighSpeed {
    public static final String MOD_ID = "highspeed";
    public static final String NAME = "Create: Highspeed";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String VERSION = "0.0.1 ALPHA";


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, HighSpeed.VERSION, HSExpectPlatform.platformName());
        HSBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        HSItems.init(); // hold registrate in a separate class to avoid loading early on forge
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
