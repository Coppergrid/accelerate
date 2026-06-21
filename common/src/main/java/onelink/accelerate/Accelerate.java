package onelink.accelerate;

import com.google.gson.JsonSyntaxException;
import com.simibubi.create.foundation.data.CreateRegistrate;
import onelink.accelerate.config.AConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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

        try {
            AConfig.getInstance().write();
            LOGGER.info("Attempting to write Accelerate config...");
        } catch (IOException e) {
            System.out.println("Config Exception!");
            throw new RuntimeException(e);
        } catch (JsonSyntaxException e) {
            System.out.println("Config Exception 2!");
            throw new RuntimeException("Config for Tramways is malformed!", e);
        }

    }

}
