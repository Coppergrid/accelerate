package coppergrid.accelerate.fabric.registry;

import com.simibubi.create.foundation.data.BlockStateGen;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlock;

public class ABuilderTransformersImpl {

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogey() {
        return b -> b.blockstate(
                (c, p) -> BlockStateGen.horizontalAxisBlock(
                        c,
                        p,
                        s -> p.models().getExistingFile(
                                p.modLoc("block/bogey/high_speed/top")
                        )
                )
        );
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevBogeyBlock, P>> maglevBogey() {
        return b -> b.blockstate(
                (c, p) -> BlockStateGen.horizontalAxisBlock(
                        c,
                        p,
                        s -> p.models().getExistingFile(
                                p.modLoc("block/bogey/maglev/top")
                        )
                )
        );
    }
}
