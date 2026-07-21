package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.infrastructure.track.TrackHelper;

public class TrackCache {

    private boolean valid = false;
    private double speedMultiplier = 1.0;
//    private TrackEdge trackEdge;
//    private TrackMaterial trackMaterial;
//
//    public TrackEdge getTrackEdge() {
//        return trackEdge;
//    }
//
//    public TrackMaterial getTrackMaterial() {
//        return trackMaterial;
//    }

    public void invalidate() {
        valid = false;
    }

    public double getSpeedMultiplier(Train train) {
        if (!valid) {
            recalculateCache(train);
            valid = true;
        }

        return speedMultiplier;
    }

    private void recalculateCache(Train train) {
        speedMultiplier = TrackHelper.getCurrentTrackSpeedMultiplier(train);
    }

}

