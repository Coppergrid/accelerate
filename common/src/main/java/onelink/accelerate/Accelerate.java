package onelink.accelerate;

import com.simibubi.create.foundation.data.CreateRegistrate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accelerate {
    public static final String MOD_ID = "accelerate";
    public static final String NAME = "Create: Accelerate";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String VERSION = "0.0.1 ALPHA";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Accelerate.MOD_ID).defaultCreativeTab(ACreativeTabs.getBaseTab());


    public static void init() {
        LOGGER.info("{} initializing! Version {} on {} loader.", NAME, Accelerate.VERSION, AExpectPlatform.platformName());
        ABlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        AItems.init(); // hold registrate in a separate class to avoid loading early on forge
    }

}
