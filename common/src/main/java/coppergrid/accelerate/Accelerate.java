package coppergrid.accelerate;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import coppergrid.accelerate.registry.ABlockEntityTypes;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.ABogeyStyles;
import coppergrid.accelerate.registry.AItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;


public class Accelerate {
    public static final String MOD_ID = "accelerate";
    public static final String NAME = "Create: Accelerate";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String VERSION = "0.0.1 ALPHA";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Accelerate.MOD_ID).defaultCreativeTab(ACreativeTabs.getBaseTab());

    public static ResourceLocation asResource(@Nonnull String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void init() {
        LOGGER.info("{} initializing! Version {} on {} loader.", NAME, Accelerate.VERSION, AExpectPlatform.platformName());
        // General Purpose
        ABlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        AItems.init(); // hold registrate in a separate class to avoid loading early on forge
        ABlockEntityTypes.init();

        // Bogey Specific
        ABogeyStyles.init();

        // load config

    }

}
