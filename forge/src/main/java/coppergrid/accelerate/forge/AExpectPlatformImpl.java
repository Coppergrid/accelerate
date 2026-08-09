package coppergrid.accelerate.forge;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.content.track.HighSpeedTrackBlock;
import coppergrid.accelerate.content.track.MaglevTrackBlock;

public class AExpectPlatformImpl {

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedTrackBlock, P>> highSpeedTrackDatagen() {
        return b -> b;
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevTrackBlock, P>> maglevTrackDatagen() {
        return b -> b;
    }

	public static String platformName() {
		return "Forge";
	}
}
