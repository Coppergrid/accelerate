package onelink.accelerate.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.simibubi.create.content.trains.entity.Train;
import onelink.accelerate.config.AConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Train.class, remap = false)
public abstract class ATrainMixin {

    @Unique
    boolean create_accelerate$onHighSpeedTrack = true; // TEMPORARY - DEV TESTING

    @Unique
    boolean create_accelerate$onMaglevTrack = false; // See Above

    @ModifyReturnValue(method = "acceleration", at = @At("RETURN"))
    private float accelerate$modifyAcceleration(float original) {
        if (create_accelerate$onHighSpeedTrack) {
            return (float) (original * AConfig.SERVER.HighSpeedAccelMultiplier.get());
        }
        else if (create_accelerate$onMaglevTrack) {
            return (float) (original * AConfig.SERVER.MaglevAccelMultiplier.get());
        }
        else {
            return original;
        }
    }

    @ModifyReturnValue(method = "maxSpeed", at = @At("RETURN"))
    private float accelerate$modifyMaxSpeed(float original) {
        if (create_accelerate$onHighSpeedTrack) {
            return (float) (original * AConfig.SERVER.HighSpeedSpeedMultiplier.get());
        }
        else if (create_accelerate$onMaglevTrack) {
            return (float) (original * AConfig.SERVER.MaglevSpeedMultiplier.get());
        }
        else {
            return original;
        }
    }

    @ModifyReturnValue(method = "maxTurnSpeed", at = @At("RETURN"))
    private float accelerate$modifyMaxTurnSpeed(float original) {
        if (create_accelerate$onHighSpeedTrack) {
            return (float) (original * AConfig.SERVER.HighSpeedSpeedMultiplier.get());
        }
        else if (create_accelerate$onMaglevTrack) {
            return (float) (original * AConfig.SERVER.MaglevSpeedMultiplier.get());
        }
        else {
            return original;
        }
    }
}
