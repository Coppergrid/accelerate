package coppergrid.accelerate.forge;

import com.simibubi.create.content.trains.bogey.BogeyBlockEntityRenderer;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlockEntity;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlock;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlockEntity;
import coppergrid.accelerate.content.track.HighSpeedTrackBlock;
import coppergrid.accelerate.content.track.MaglevTrackBlock;
import coppergrid.accelerate.registry.ABlocks;

public class AExpectPlatformImpl {

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedTrackBlock, P>> highSpeedTrackDatagen() {
        return b -> b;
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevTrackBlock, P>> maglevTrackDatagen() {
        return b -> b;
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogeyDatagen() {
        return b -> b;
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevBogeyBlock, P>> maglevBogeyDatagen() {
        return b -> b;
    }

    public static BlockEntityEntry<HighSpeedBogeyBlockEntity> registerHighSpeedBogeyBlockEntity() {
        return Accelerate.REGISTRATE
                .blockEntity("high_speed_bogey", HighSpeedBogeyBlockEntity::new)
                .renderer(() -> BogeyBlockEntityRenderer::new)
                .validBlocks(
                        ABlocks.SMALL_HIGH_SPEED_BOGEY,
                        ABlocks.LARGE_HIGH_SPEED_BOGEY
                )
                .register();
    }

    public static BlockEntityEntry<MaglevBogeyBlockEntity> registerMaglevBogeyBlockEntity() {
        return Accelerate.REGISTRATE
                .blockEntity("maglev_bogey", MaglevBogeyBlockEntity::new)
                .renderer(() -> BogeyBlockEntityRenderer::new)
                .validBlocks(
                        ABlocks.SMALL_MAGLEV_BOGEY,
                        ABlocks.LARGE_MAGLEV_BOGEY
                )
                .register();
    }

	public static String platformName() {
		return "Forge";
	}
}
