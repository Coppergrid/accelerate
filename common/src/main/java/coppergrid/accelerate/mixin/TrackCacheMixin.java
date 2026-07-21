package coppergrid.accelerate.mixin;

import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.infrastructure.train.TrackCache;
import coppergrid.accelerate.infrastructure.train.TrackCacheStorage;
import coppergrid.accelerate.interfaces.ACacheInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Train.class, remap = false)
public class TrackCacheMixin implements ACacheInterface {
    @Unique
    private final TrackCache accelerate$trackCache = new TrackCache();

    @Override
    public TrackCache accelerate$getTrackCache() {
        return accelerate$trackCache;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void accelerate$invalidateTrackCache(CallbackInfo ci) {
        Train train = (Train) (Object) this;

        TrackCacheStorage.get(train).invalidate();
    }
}
