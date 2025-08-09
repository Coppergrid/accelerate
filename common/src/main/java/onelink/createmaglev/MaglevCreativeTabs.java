package onelink.createmaglev;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class MaglevCreativeTabs {
    @ExpectPlatform
    public static ResourceKey<CreativeModeTab> getBaseTab() {
        throw new AssertionError();
    }
}