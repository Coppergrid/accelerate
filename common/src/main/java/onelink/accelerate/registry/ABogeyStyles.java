package onelink.accelerate.registry;

import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import onelink.accelerate.Accelerate;
import onelink.accelerate.content.bogey.HighSpeedBogeyRenderer;
import onelink.accelerate.content.bogey.HighSpeedBogeyVisual;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ABogeyStyles {
//    public static final Map<ResourceLocation, BogeyStyle> BOGEY_STYLES = new HashMap<>();
//    public static final Map<ResourceLocation, Map<ResourceLocation, BogeyStyle>> CYCLE_GROUPS = new HashMap<>();
//    private static final Map<ResourceLocation, BogeyStyle> EMPTY_GROUP = Collections.emptyMap();

    public static final ResourceLocation HIGH_SPEED_CYCLE_GROUP = Accelerate.asResource("high_speed");

    public static final BogeyStyle HIGH_SPEED
            = builder("high_speed", HIGH_SPEED_CYCLE_GROUP).displayName(Component.translatable("accelerate.bogey.style.high_speed"))
            .size(BogeySizes.SMALL, ABlocks.SMALL_HIGH_SPEED_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new HighSpeedBogeyRenderer.Small(), HighSpeedBogeyVisual.Small::new))
            .size(BogeySizes.LARGE, ABlocks.LARGE_HIGH_SPEED_BOGEY, () -> () -> new BogeyStyle.SizeRenderer(new HighSpeedBogeyRenderer.Large(), HighSpeedBogeyVisual.Large::new))
            .build();

//    public static Map<ResourceLocation, BogeyStyle> getCycleGroup(ResourceLocation cycleGroup) {
//        return CYCLE_GROUPS.getOrDefault(cycleGroup, EMPTY_GROUP);
//    }

    private static BogeyStyle.Builder builder(String name, ResourceLocation cycleGroup) {
        return new BogeyStyle.Builder(Accelerate.asResource(name), cycleGroup);
    }

    @ApiStatus.Internal
    public static void init() {
    }
}
