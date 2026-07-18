package coppergrid.accelerate.mixin;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.station.StationBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = StationBlockEntity.class, remap = false)
public class TrainAssemblyMixin {

    @Shadow
    AbstractBogeyBlock<?>[] bogeyTypes;

    @Shadow
    int bogeyCount;

}
