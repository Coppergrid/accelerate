package coppergrid.accelerate.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.infrastructure.train.TrackCacheStorage;
import coppergrid.accelerate.infrastructure.train.TrainType;
import coppergrid.accelerate.infrastructure.train.TrainTypeStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Train.class, remap = false)
public abstract class TrainStatsMixin {

    @ModifyReturnValue(method = "acceleration", at = @At("RETURN"))
    private float accelerate$modifyAcceleration(float original) {
        Train train = (Train) (Object) this;
        TrainType trainType = TrainTypeStorage.get(train);
        return (float) (original * trainType.accelerationMultiplier());
    }

    @ModifyReturnValue(method = "maxSpeed", at = @At("RETURN"))
    private float accelerate$modifyMaxSpeed(float original) {
        Train train = (Train) (Object) this;

        TrainType trainType = TrainTypeStorage.get(train);

        double trainSpeedMultiplier = trainType.speedMultiplier();

        double trackSpeedMultiplier = TrackCacheStorage.get(train).getSpeedMultiplier(train);

        return (float) (original * (Math.min(trainSpeedMultiplier, trackSpeedMultiplier)));
    }

    @ModifyReturnValue(method = "maxTurnSpeed", at = @At("RETURN"))
    private float accelerate$modifyMaxTurnSpeed(float original) {
        Train train = (Train) (Object) this;

        TrainType trainType = TrainTypeStorage.get(train);

        double trainSpeedMultiplier = trainType.speedMultiplier();

        double trackSpeedMultiplier = TrackCacheStorage.get(train).getSpeedMultiplier(train);

        return (float) (original * (Math.min(trainSpeedMultiplier, trackSpeedMultiplier)));
    }
}
