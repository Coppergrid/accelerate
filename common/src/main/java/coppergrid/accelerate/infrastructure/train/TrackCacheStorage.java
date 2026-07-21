package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.interfaces.ACacheInterface;

public class TrackCacheStorage {
    public static TrackCache get(Train train) {
        return ((ACacheInterface)train).accelerate$getTrackCache();
    }
}
