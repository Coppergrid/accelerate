package onelink.highspeed;

import com.simibubi.create.Create;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighSpeed {
    public static final String MOD_ID = "createmaglev";
    public static final String NAME = "Create: Maglev";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, HSExpectPlatform.platformName());
        HSBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        HSItems.init(); // hold registrate in a separate class to avoid loading early on forge
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
