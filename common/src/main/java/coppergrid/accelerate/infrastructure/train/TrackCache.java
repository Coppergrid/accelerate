package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.graph.TrackEdge;
import com.simibubi.create.content.trains.track.TrackMaterial;

public class TrackCache {

    private TrackEdge trackEdge;
    private TrackMaterial trackMaterial;

    public TrackEdge getTrackEdge() {
        return trackEdge;
    }

    public TrackMaterial getTrackMaterial() {
        return trackMaterial;
    }

    public void updateCache(TrackEdge newEdge) {
        if (newEdge != trackEdge) {
            trackEdge = newEdge;
            if (newEdge != null) {
                trackMaterial = newEdge.getTrackMaterial();
            } else {
                trackMaterial = null;
            }
        }
    }

}
