package onelink.accelerate.mixin;


import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.graph.DimensionPalette;
import com.simibubi.create.content.trains.graph.TrackGraph;
import net.minecraft.nbt.CompoundTag;
import onelink.accelerate.infrastructure.train.TrainType;
import onelink.accelerate.infrastructure.train.TrainTypeStorage;
import onelink.accelerate.interfaces.ATrainInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.UUID;


@Mixin(value = Train.class, remap = false)
public class TrainTypeMixin implements ATrainInterface {

    @Unique
    private TrainType accelerate$trainType = TrainType.NORMAL;

    @Unique
    public TrainType accelerate$getTrainType() {
        return accelerate$trainType;
    }

    @Unique
    public void accelerate$setTrainType(TrainType type) {
        this.accelerate$trainType = type;
    }

    @Inject(method = "write", at = @At("RETURN"))
    private void accelerate$write(DimensionPalette dimensions, CallbackInfoReturnable<CompoundTag> cir) {
        cir.getReturnValue().putString(
                "AccelerateTrainType",
                accelerate$trainType.name()
        );
    }

    @Inject(method = "read", at = @At("RETURN"))
    private static void accelerate$read(CompoundTag tag, Map<UUID, TrackGraph> trackNetworks,
                                    DimensionPalette dimensions, CallbackInfoReturnable<Train> cir) {
        Train train = cir.getReturnValue();

        if (tag.contains("AccelerateTrainType")) {
            TrainTypeStorage.set(train, TrainType.valueOf(tag.getString("AccelerateTrainType")));
        }

    }
}