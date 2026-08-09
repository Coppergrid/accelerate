package coppergrid.accelerate.fabric;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.content.track.HighSpeedTrackBlock;
import coppergrid.accelerate.content.track.MaglevTrackBlock;
import coppergrid.accelerate.fabric.datagen.CustomTrackBlockStateGenerator;
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
	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}
}
