package coppergrid.accelerate.registry;

import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ABuilderTransformers {

    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogey() {
        return b -> b.initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(pickaxeOnly())
                .loot((p, l) -> p.dropOther(l, ABlocks.HIGH_SPEED_RAILWAY_CASING.get()));
    }

    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevBogeyBlock, P>> maglevBogey() {
        return b -> b.initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(pickaxeOnly())
                .loot((p, l) -> p.dropOther(l, ABlocks.MAGLEV_RAILWAY_CASING.get()));
    }
}
