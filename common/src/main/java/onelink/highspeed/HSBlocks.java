package onelink.highspeed;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class HSBlocks {

    public static final BlockEntry<TrackBlock> HIGH_SPEED_TRACK_BLOCK = HighSpeed.REGISTRATE.block("high_speed_track", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), TrackMaterial.ANDESITE))
            .tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
            .tag(AllBlockTags.TRACKS.tag)
            .tag(AllBlockTags.GIRDABLE_TRACKS.tag)
            .item(TrackBlockItem::new)
            .lang("High Speed Track")
            .build()
            .register();

    public static final BlockEntry<TrackBlock> MAGLEV_TRACK_BLOCK = HighSpeed.REGISTRATE.block("maglev_track", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), TrackMaterial.ANDESITE))
			.tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
			.tag(AllBlockTags.TRACKS.tag)
			.tag(AllBlockTags.GIRDABLE_TRACKS.tag)
			.item(TrackBlockItem::new)
            .lang("Maglev Track")
			.build()
			.register();

	public static void init() {
		// load the class and register everything
		HighSpeed.LOGGER.info("Registering blocks for " + HighSpeed.NAME);
	}
}