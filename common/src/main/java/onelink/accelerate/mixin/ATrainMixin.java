package onelink.accelerate.mixin;

import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.infrastructure.config.AllConfigs;
import onelink.accelerate.config.AConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Train.class)
public abstract class ATrainMixin {

    @Shadow
    public int fuelTicks;


    /**
     * @author OneLink
     * @reason Allow custom tracks to return higher speeds
     */

    @Overwrite()
    public float acceleration() {
        float baseAccel = (fuelTicks > 0
                ? AllConfigs.server().trains.poweredTrainAcceleration.getF()
                : AllConfigs.server().trains.trainAcceleration.getF());

        if (this.onHighSpeedTrack()) { // Add methods to integrate properly
            return (float) ((baseAccel * AConfig.COMMON.HighSpeedTrackMultiplier.get()) / 400);
        }

        else if (this.onMaglevTrack()) { // See above
            return (float) ((baseAccel * AConfig.COMMON.MaglevTrackMultiplier.get()) / 400);
        }

        else {
            return baseAccel / 400;
        }


    }
}
