package coppergrid.accelerate.fabric;

import com.simibubi.create.content.trains.bogey.BogeyBlockEntityRenderer;
import com.simibubi.create.content.trains.bogey.BogeyBlockEntityVisual;
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
import coppergrid.accelerate.fabric.datagen.CustomTrackBlockStateGenerator;
import coppergrid.accelerate.fabric.registry.ABuilderTransformersImpl;
import coppergrid.accelerate.registry.ABlocks;
import net.fabricmc.loader.api.FabricLoader;

public class AExpectPlatformImpl {
    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedTrackBlock, P>> highSpeedTrackDatagen() {
        return b -> b.blockstate(
                new CustomTrackBlockStateGenerator("high_speed")::generate
        );
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevTrackBlock, P>> maglevTrackDatagen() {
        return b -> b.blockstate(
                new CustomTrackBlockStateGenerator("maglev")::generate
        );
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogeyDatagen() {
        return ABuilderTransformersImpl.highSpeedBogey();
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevBogeyBlock, P>> maglevBogeyDatagen() {
        return ABuilderTransformersImpl.maglevBogey();
    }

    public static BlockEntityEntry<HighSpeedBogeyBlockEntity> registerHighSpeedBogeyBlockEntity() {
        return Accelerate.REGISTRATE
                .blockEntity("high_speed_bogey", HighSpeedBogeyBlockEntity::new)
                .visual(() -> BogeyBlockEntityVisual::new, false)
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
                .visual(() -> BogeyBlockEntityVisual::new, false)
                .renderer(() -> BogeyBlockEntityRenderer::new)
                .validBlocks(
                        ABlocks.SMALL_MAGLEV_BOGEY,
                        ABlocks.LARGE_MAGLEV_BOGEY
                )
                .register();
    }

	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}
}
