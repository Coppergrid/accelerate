package onelink.accelerate.registry;

import com.simibubi.create.content.trains.bogey.BogeyBlockEntityRenderer;
import com.simibubi.create.content.trains.bogey.BogeyBlockEntityVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import onelink.accelerate.Accelerate;
import onelink.accelerate.content.bogey.HighSpeedBogeyBlockEntity;

public class ABlockEntityTypes {

    public static final BlockEntityEntry<HighSpeedBogeyBlockEntity> HIGH_SPEED_BOGEY = Accelerate.REGISTRATE
            .blockEntity("high_speed_bogey", HighSpeedBogeyBlockEntity::new)
            .visual(() -> BogeyBlockEntityVisual::new, false)
            .renderer(() -> BogeyBlockEntityRenderer::new)
            .validBlocks(ABlocks.SMALL_HIGH_SPEED_BOGEY, ABlocks.LARGE_HIGH_SPEED_BOGEY)
            .register();

    public static void init() {}
}
