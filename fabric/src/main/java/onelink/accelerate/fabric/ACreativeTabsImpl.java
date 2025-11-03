package onelink.accelerate.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import onelink.accelerate.Accelerate;
import onelink.accelerate.ABlocks;

public class ACreativeTabsImpl {
    public static ResourceKey<CreativeModeTab> getBaseTab() {
        return ResourceKey.create(
                Registries.CREATIVE_MODE_TAB,
                Accelerate.id("main")
        );
    }

    public static void register() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                getBaseTab(),
                FabricItemGroup.builder()
                        .title(Component.translatable(Accelerate.MOD_ID + "." + "creative_tab.main"))
                        .icon(ABlocks.HIGH_SPEED_TRACK_BLOCK::asStack)
                        .build()
        );
    }
}