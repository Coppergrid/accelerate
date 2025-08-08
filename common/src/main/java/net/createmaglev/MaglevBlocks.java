package net.createmaglev;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class MaglevBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateMaglev.MOD_ID);

	public static final BlockEntry<TrackBlock> MAGLEV_TRACK_BLOCK = REGISTRATE.block("maglev_track", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), TrackMaterial.ANDESITE))
			.tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
			.tag(AllBlockTags.TRACKS.tag)
			.tag(AllBlockTags.GIRDABLE_TRACKS.tag)
			.lang("Maglev Track")
			.item(TrackBlockItem::new)
			.build()
			.register();

	public static void init() {
		// load the class and register everything
		CreateMaglev.LOGGER.info("Registering blocks for " + CreateMaglev.NAME);
	}
}