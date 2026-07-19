package coppergrid.accelerate.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.config.AConfig;
import coppergrid.accelerate.infrastructure.train.TrainType;
import coppergrid.accelerate.infrastructure.train.TrainTypeStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Train.class, remap = false)
public abstract class TrainStatsMixin {

    @Unique
    Train accelerate$train = (Train) (Object) this;

    @Unique
    boolean create_accelerate$onHighSpeedTrack = AConfig.SERVER.DevMode.get(); // TEMPORARY - DEV TESTING

    @Unique
    boolean create_accelerate$onMaglevTrack = false; // See Above

    @ModifyReturnValue(method = "acceleration", at = @At("RETURN"))
    private float accelerate$modifyAcceleration(float original) {
        TrainType trainType = TrainTypeStorage.get(accelerate$train);
        return (float) (original * trainType.accelerationMultiplier());
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
