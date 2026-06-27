package onelink.accelerate.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class ACreativeTabs {
    @ExpectPlatform
    public static ResourceKey<CreativeModeTab> getBaseTab() {
        throw new AssertionError();
    }
}