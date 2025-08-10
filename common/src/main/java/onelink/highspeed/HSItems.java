package onelink.highspeed;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class HSItems {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(HighSpeed.MOD_ID).defaultCreativeTab(HSCreativeTabs.getBaseTab());

    public static final ItemEntry<Item> COBALT_MAGNET = REGISTRATE.item("cobalt_magnet", Item::new)
            .lang("Cobalt Magnet")
            .register();

    public static final ItemEntry<Item> COBALT_INGOT = REGISTRATE.item("cobalt_ingot", Item::new)
            .lang("Cobalt Ingot")
            .register();

    public static final ItemEntry<Item> RAW_COBALT = REGISTRATE.item("raw_cobalt", Item::new)
            .lang("Raw Cobalt")
            .register();

    public static void init() {
        // load the class and register everything
        HighSpeed.LOGGER.info("Registering items for " + HighSpeed.NAME);
    }
}
