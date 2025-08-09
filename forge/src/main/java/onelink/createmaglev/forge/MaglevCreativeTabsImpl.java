package onelink.createmaglev.forge;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import onelink.createmaglev.MaglevBlocks;
import onelink.createmaglev.CreateMaglev;

public class MaglevCreativeTabsImpl {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMaglev.MOD_ID);

    private static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB =
            CREATIVE_TABS.register("main", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable(CreateMaglev.MOD_ID + "." + "creative_tab.main"))
                            .icon(MaglevBlocks.MAGLEV_TRACK_BLOCK::asStack)
                            .build()
            );

    public static ResourceKey<CreativeModeTab> getBaseTab() {
        return BASE_CREATIVE_TAB.getKey();
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
    }
}