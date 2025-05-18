package net.createmaglev;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.AllTags.AllItemTags;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import com.simibubi.create.content.trains.track.TrackBlock;

public class MaglevBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateMaglev.MOD_ID);

	public static final BlockEntry<TrackBlock> MAGLEV_RAIL_BLOCK = REGISTRATE.block("maglev_rail", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), TrackMaterial.ANDESITE))
			.tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
			.tag(AllBlockTags.TRACKS.tag)
			.tag(AllBlockTags.GIRDABLE_TRACKS.tag)
			.lang("Maglev Track")
			.item(TrackBlockItem::new)
			.build()
			.register();

	public static final ItemEntry<Item> CHARGED_COBALT_MAGNET = REGISTRATE.item("charged_cobalt_magnet", Item::new)
			.lang("Charged Cobalt Magnet")
			.register();

	public static final ItemEntry<Item> COBALT_INGOT = REGISTRATE.item("cobalt_ingot", Item::new)
			.lang("Cobalt Ingot")
			.register();

	public static final ItemEntry<Item> RAW_COBALT = REGISTRATE.item("raw_cobalt", Item::new)
			.lang("Raw Cobalt")
			.register();

	public static void init() {
		// load the class and register everything
		CreateMaglev.LOGGER.info("Registering blocks for " + CreateMaglev.NAME);
	}
}