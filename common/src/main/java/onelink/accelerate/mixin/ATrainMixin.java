package onelink.accelerate.mixin;

import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.infrastructure.config.AllConfigs;
import onelink.accelerate.config.AConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = Train.class, remap = false)
public abstract class ATrainMixin {

    @Shadow
    public int fuelTicks;

    @Unique
    boolean create_accelerate$onHighSpeedTrack = true;

    @Unique
    boolean create_accelerate$onMaglevTrack = false;

    /**
     * @author OneLink
     * @reason Allow custom tracks to return higher speeds
     */

    @Overwrite
    public float maxSpeed() {
        float baseMaxSpeed = (fuelTicks > 0 ?
                AllConfigs.server().trains.poweredTrainTopSpeed.getF() :
                AllConfigs.server().trains.trainTopSpeed.getF());

        if (create_accelerate$onHighSpeedTrack) {
            return (float) (baseMaxSpeed * AConfig.SERVER.HighSpeedSpeedMultiplier.get()) / 20;
        }
        else if (create_accelerate$onMaglevTrack) {
            return (float) (baseMaxSpeed * AConfig.SERVER.MaglevSpeedMultiplier.get()) / 20;
        }
        else {
            return baseMaxSpeed / 20;
        }
    }

    /**
     * @author OneLink
     * @reason Allow custom tracks to return higher speeds
     */

    @Overwrite
    public float maxTurnSpeed() {
        float baseMaxTurnSpeed = (fuelTicks > 0 ?
                AllConfigs.server().trains.poweredTrainTurningTopSpeed.getF() :
                AllConfigs.server().trains.trainTurningTopSpeed.getF());

        if (create_accelerate$onHighSpeedTrack) {
            return (float) (baseMaxTurnSpeed * AConfig.SERVER.HighSpeedSpeedMultiplier.get()) / 20;
        }
        else if (create_accelerate$onMaglevTrack) {
            return (float) (baseMaxTurnSpeed * AConfig.SERVER.MaglevSpeedMultiplier.get()) / 20;
        }
        else {
            return baseMaxTurnSpeed / 20;
        }
    }

    /**
     * @author OneLink
     * @reason Allow custom tracks to return higher accelerations
     */

    @Overwrite
    public float acceleration() {
        float baseAccel = (fuelTicks > 0 ?
                AllConfigs.server().trains.poweredTrainAcceleration.getF() :
                AllConfigs.server().trains.trainAcceleration.getF());

        if (create_accelerate$onHighSpeedTrack) { // Add methods to integrate properly
            return (float) ((baseAccel * AConfig.SERVER.HighSpeedAccelMultiplier.get()) / 400);
        }

        else if (create_accelerate$onMaglevTrack) { // See above
            return (float) ((baseAccel * AConfig.SERVER.MaglevAccelMultiplier.get()) / 400);
        }

        else {
            return baseAccel / 400;
        }

    }
}
