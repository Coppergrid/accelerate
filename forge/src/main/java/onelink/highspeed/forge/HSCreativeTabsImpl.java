package onelink.highspeed.forge;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import onelink.highspeed.HSBlocks;
import onelink.highspeed.HighSpeed;

public class HSCreativeTabsImpl {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HighSpeed.MOD_ID);

    private static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB =
            CREATIVE_TABS.register("main", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable(HighSpeed.MOD_ID + "." + "creative_tab.main"))
                            .icon(HSBlocks.HIGH_SPEED_TRACK_BLOCK::asStack)
                            .build()
            );

    public static ResourceKey<CreativeModeTab> getBaseTab() {
        return BASE_CREATIVE_TAB.getKey();
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
    }
}