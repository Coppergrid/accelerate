package coppergrid.accelerate.mixin;

import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.infrastructure.train.TrackCache;
import coppergrid.accelerate.interfaces.ACacheInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = Train.class, remap = false)
public class TrackCacheMixin implements ACacheInterface {
    @Unique
    private final TrackCache accelerate$trackCache = new TrackCache();

    @Override
    public TrackCache accelerate$getTrackCache() {
        return accelerate$trackCache;
    }
}
