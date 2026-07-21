package coppergrid.accelerate.registry;

import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import coppergrid.accelerate.content.bogey.MaglevBogeyRenderer;
import coppergrid.accelerate.content.bogey.MaglevBogeyVisual;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyRenderer;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyVisual;
import org.jetbrains.annotations.ApiStatus;

public class ABogeyStyles {

    public static final ResourceLocation HIGH_SPEED_CYCLE_GROUP = Accelerate.asResource("high_speed");

    public static final BogeyStyle HIGH_SPEED
            = builder("high_speed", HIGH_SPEED_CYCLE_GROUP).displayName(Component.translatable("accelerate.bogey.style.high_speed"))
            .size(BogeySizes.SMALL, ABlocks.SMALL_HIGH_SPEED_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new HighSpeedBogeyRenderer.Small(), HighSpeedBogeyVisual.Small::new))
            .size(BogeySizes.LARGE, ABlocks.LARGE_HIGH_SPEED_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new HighSpeedBogeyRenderer.Large(), HighSpeedBogeyVisual.Large::new))
            .build();

    public static final ResourceLocation MAGLEV_CYCLE_GROUP = Accelerate.asResource("maglev");

    public static final BogeyStyle MAGLEV
            = builder("maglev", MAGLEV_CYCLE_GROUP).displayName(Component.translatable("accelerate.bogey.style.maglev"))
            .size(BogeySizes.SMALL, ABlocks.SMALL_MAGLEV_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new MaglevBogeyRenderer.Small(), MaglevBogeyVisual.Small::new))
            .size(BogeySizes.LARGE, ABlocks.LARGE_MAGLEV_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new MaglevBogeyRenderer.Large(), MaglevBogeyVisual.Large::new))
            .build();

    private static BogeyStyle.Builder builder(String name, ResourceLocation cycleGroup) {
        return new BogeyStyle.Builder(Accelerate.asResource(name), cycleGroup);
    }

    @ApiStatus.Internal
    public static void init() {
    }
}
