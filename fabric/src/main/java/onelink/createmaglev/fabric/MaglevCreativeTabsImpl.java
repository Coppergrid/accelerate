package onelink.createmaglev.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import onelink.createmaglev.MaglevBlocks;
import onelink.createmaglev.CreateMaglev;

public class MaglevCreativeTabsImpl {
    public static ResourceKey<CreativeModeTab> getBaseTab() {
        return ResourceKey.create(
                Registries.CREATIVE_MODE_TAB,
                CreateMaglev.id("main")
        );
    }

    public static void register() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                getBaseTab(),
                FabricItemGroup.builder()
                        .title(Component.translatable(CreateMaglev.MOD_ID + "." + "creative_tab.main"))
                        .icon(MaglevBlocks.MAGLEV_TRACK_BLOCK::asStack)
                        .build()
        );
    }
}