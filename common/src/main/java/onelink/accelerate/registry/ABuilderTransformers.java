package onelink.accelerate.registry;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import onelink.accelerate.content.bogey.HighSpeedBogeyBlock;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ABuilderTransformers {

    public static <B extends AbstractBogeyBlock, P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogey() {
        return b -> b.initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(pickaxeOnly())
                .blockstate((c, p) -> BlockStateGen.horizontalAxisBlock(c, p, s -> p.models()
                        .getExistingFile(p.modLoc("block/bogey/high_speed/top"))))
                .loot((p, l) -> p.dropOther(l, ABlocks.HIGH_SPEED_RAILWAY_CASING.get()))
                .onRegister(
                        block -> AbstractBogeyBlock.registerStandardBogey(CatnipServices.REGISTRIES.getKeyOrThrow(block)));
    }
}
