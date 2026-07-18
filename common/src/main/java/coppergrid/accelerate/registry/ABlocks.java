package coppergrid.accelerate.registry;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;
import coppergrid.accelerate.content.components.AutomatedDrivingModule;
import coppergrid.accelerate.content.track.HighSpeedTrackBlock;
import coppergrid.accelerate.content.track.MaglevTrackBlock;
import coppergrid.accelerate.datagen.CustomTrackBlockStateGenerator;

import static com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour.interactionBehaviour;

public class ABlocks {

    // TRACK BLOCKS
    public static final BlockEntry<HighSpeedTrackBlock> HIGH_SPEED_TRACK_BLOCK = Accelerate.REGISTRATE.block("high_speed_track", HighSpeedTrackBlock::new)
            .tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
            .tag(AllBlockTags.TRACKS.tag)
            .tag(AllBlockTags.GIRDABLE_TRACKS.tag)
            .blockstate(new CustomTrackBlockStateGenerator("high_speed")::generate)
            .item(TrackBlockItem::new)
            .lang("High Speed Track")
            .build()
            .register();

    public static final BlockEntry<MaglevTrackBlock> MAGLEV_TRACK_BLOCK = Accelerate.REGISTRATE.block("maglev_track", MaglevTrackBlock::new)
			.tag(AllBlockTags.RELOCATION_NOT_SUPPORTED.tag)
			.tag(AllBlockTags.TRACKS.tag)
			.tag(AllBlockTags.GIRDABLE_TRACKS.tag)
            .blockstate(new CustomTrackBlockStateGenerator("maglev")::generate)
            .item(TrackBlockItem::new)
            .lang("Maglev Track")
			.build()
			.register();

    // CASING BLOCKS
    public static final BlockEntry<CasingBlock> HIGH_SPEED_RAILWAY_CASING = Accelerate.REGISTRATE.block("high_speed_railway_casing", CasingBlock::new)
            .transform(BuilderTransformers.layeredCasing(() -> ASpriteShifts.HIGH_SPEED_RAILWAY_CASING_SIDE,
                    () -> ASpriteShifts.HIGH_SPEED_RAILWAY_CASING))
            .properties(properties -> properties.sound(SoundType.NETHERITE_BLOCK))
            .tag(AllBlockTags.CASING.tag)
            .lang("High Speed Train Casing")
            .register();

    public static final BlockEntry<CasingBlock> MAGLEV_RAILWAY_CASING = Accelerate.REGISTRATE.block("maglev_railway_casing", CasingBlock::new)
            .transform(BuilderTransformers.layeredCasing(() -> ASpriteShifts.MAGLEV_RAILWAY_CASING_SIDE,
                    () -> ASpriteShifts.MAGLEV_RAILWAY_CASING))
            .properties(properties -> properties.sound(SoundType.NETHERITE_BLOCK))
            .tag(AllBlockTags.CASING.tag)
            .lang("Maglev Train Casing")
            .register();

    // BOGEY BLOCKS
    public static final BlockEntry<HighSpeedBogeyBlock> SMALL_HIGH_SPEED_BOGEY = Accelerate.REGISTRATE.block("small_high_speed_bogey", p -> new HighSpeedBogeyBlock(p, BogeySizes.SMALL))
            .transform(ABuilderTransformers.highSpeedBogey())
            .register();

    public static final BlockEntry<HighSpeedBogeyBlock> LARGE_HIGH_SPEED_BOGEY = Accelerate.REGISTRATE.block("large_high_speed_bogey", p -> new HighSpeedBogeyBlock(p, BogeySizes.LARGE))
            .transform(ABuilderTransformers.highSpeedBogey())
            .register();

    // STANDARD BLOCKS
    public static final BlockEntry<Block> RAW_COBALT_BLOCK = Accelerate.REGISTRATE.block("raw_cobalt_block", Block::new)
            .item(BlockItem::new)
            .lang("Block of Raw Cobalt")
            .build()
            .register();

    public static final BlockEntry<Block> COBALT_BLOCK = Accelerate.REGISTRATE.block("cobalt_block", Block::new)
            .properties(properties -> properties.sound(SoundType.METAL))
            .item(BlockItem::new)
            .lang("Block of Cobalt")
            .build()
            .register();

    public static final BlockEntry<Block> AUTOMATED_DRIVING_MODULE = Accelerate.REGISTRATE.block("automated_driving_module", Block::new)
            .properties(properties -> properties.sound(SoundType.NETHERITE_BLOCK))
            .onRegister(interactionBehaviour(new AutomatedDrivingModule()))
            .item(BlockItem::new)
            .lang("Automated Driving Module")
            .build()
            .register();

	public static void init() {
		// load the class and register everything
		Accelerate.LOGGER.info("Registering blocks for " + Accelerate.NAME);
	}
}