package onelink.highspeed;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class HSItems {

    public static final ItemEntry<Item> RAW_COBALT = HighSpeed.REGISTRATE.item("raw_cobalt", Item::new)
            .lang("Raw Cobalt")
            .register();

    public static final ItemEntry<Item> COBALT_INGOT = HighSpeed.REGISTRATE.item("cobalt_ingot", Item::new)
            .lang("Cobalt Ingot")
            .register();

    public static final ItemEntry<Item> CHARGED_COBALT_INGOT = HighSpeed.REGISTRATE.item("charged_cobalt_ingot", Item::new)
            .lang("Charged Cobalt Ingot")
            .register();

    public static final ItemEntry<Item> MAGNETIZED_COBALT_INGOT = HighSpeed.REGISTRATE.item("magnetized_cobalt_ingot", Item::new)
            .lang("Magnetized Cobalt Ingot")
            .register();

    public static final ItemEntry<SequencedAssemblyItem>

            INCOMPLETE_HIGH_SPEED_TRACK = sequencedIngredient("incomplete_high_speed_track"),
            INCOMPLETE_MAGLEV_TRACK = sequencedIngredient("incomplete_maglev_track");

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return HighSpeed.REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }
    public static void init() {
        // load the class and register everything
        HighSpeed.LOGGER.info("Registering items for " + HighSpeed.NAME);
    }
}
