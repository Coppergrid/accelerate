package coppergrid.accelerate.infrastructure.track;

import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.track.TrackMaterial;

import java.util.concurrent.atomic.AtomicReference;

public class TrackHelper {
    public static TrackMaterial getCurrentTrackMaterial(Train train) {
        AtomicReference<TrackMaterial> material = new AtomicReference<>();

        train.forEachTravellingPoint(tp -> {

            material.set(tp.edge.getTrackMaterial());

        });

        return material.get();
    }
}
