package coppergrid.accelerate.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.AssemblyException;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.station.StationBlockEntity;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.infrastructure.train.TrainType;
import coppergrid.accelerate.infrastructure.train.TrainTypeStorage;
import coppergrid.accelerate.infrastructure.train.TrainTypeValidator;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.UUID;

@Mixin(value = StationBlockEntity.class, remap = false)
public class TrainAssemblyMixin {

    @Shadow
    AbstractBogeyBlock<?>[] bogeyTypes;

    @Shadow
    int bogeyCount;

    @Shadow
    private void exception(AssemblyException exception, int carriage) {
        // compiler satisfied successfully
    }

    @Unique
    private TrainType accelerate$pendingTrainType;

    @Inject(method = "assemble", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/trains/entity/CarriageContraption;removeBlocksFromWorld(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"), cancellable = true)
    private void accelerate$validateTrain(UUID playerUUID, CallbackInfo ci) {
        TrainType type = TrainTypeValidator.validate(bogeyTypes, bogeyCount);

        if (type == null) {
            exception(new AssemblyException(Component.translatable("error.accelerate.mixed_bogey_types")), -1);

            accelerate$pendingTrainType = null;
            ci.cancel();
            return;
        }

        accelerate$pendingTrainType = type;

    }

    @WrapOperation(method = "assemble", at = @At(value = "NEW", target = "com/simibubi/create/content/trains/entity/Train"), remap = false)
    private Train accelerate$registerTrainType(UUID id, UUID owner, TrackGraph graph, List<Carriage> carriages, List<Integer> carriageSpacing, boolean doubleEnded, Operation<Train> original) {
        Train train = original.call(id, owner, graph, carriages, carriageSpacing, doubleEnded);
        if (accelerate$pendingTrainType != null) {
            TrainTypeStorage.set(train, accelerate$pendingTrainType);
            accelerate$pendingTrainType = null;
        }
        return train;
    }

}