package onelink.accelerate.registry;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import com.simibubi.create.AllTags.AllBlockTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import onelink.accelerate.Accelerate;
import onelink.accelerate.datagen.CustomTrackBlockStateGenerator;

public class ABlocks {

    public static final BlockEntry<TrackBlock> HIGH_SPEED_TRACK_BLOCK = Accelerate.REGISTRATE.block("high_speed_track", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), ATrackMaterials.HIGH_SPEED))
            .tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
            .tag(AllBlockTags.TRACKS.tag)
            .tag(AllBlockTags.GIRDABLE_TRACKS.tag)
            .blockstate(new CustomTrackBlockStateGenerator("high_speed")::generate)
            .item(TrackBlockItem::new)
            .lang("High Speed Track")
            .build()
            .register();

    public static final BlockEntry<TrackBlock> MAGLEV_TRACK_BLOCK = Accelerate.REGISTRATE.block("maglev_track", properties -> new TrackBlock(Block.Properties.of().strength(2.0f), ATrackMaterials.MAGLEV))
			.tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
			.tag(AllBlockTags.TRACKS.tag)
			.tag(AllBlockTags.GIRDABLE_TRACKS.tag)
            .blockstate(new CustomTrackBlockStateGenerator("maglev")::generate)
            .item(TrackBlockItem::new)
            .lang("Maglev Track")
			.build()
			.register();

    public static final BlockEntry<Block> RAW_COBALT_BLOCK = Accelerate.REGISTRATE.block("raw_cobalt_block", Block::new)
            .item(BlockItem::new)
            .lang("Block of Raw Cobalt")
            .build()
            .register();

    public static final BlockEntry<Block> COBALT_BLOCK = Accelerate.REGISTRATE.block("cobalt_block", Block::new)
            .item(BlockItem::new)
            .lang("Block of Cobalt")
            .build()
            .register();

    public static final BlockEntry<Block> AUTOMATED_DRIVING_MODULE = Accelerate.REGISTRATE.block("automated_driving_module", Block::new)
            .item(BlockItem::new)
            .lang("Automated Driving Module")
            .build()
            .register();

	public static void init() {
		// load the class and register everything
		Accelerate.LOGGER.info("Registering blocks for " + Accelerate.NAME);
	}
}