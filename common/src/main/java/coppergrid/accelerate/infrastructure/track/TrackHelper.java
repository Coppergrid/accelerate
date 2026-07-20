package coppergrid.accelerate.infrastructure.track;

import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.track.TrackMaterial;
import coppergrid.accelerate.config.AConfig;
import coppergrid.accelerate.registry.ATrackMaterials;
import org.apache.commons.lang3.mutable.MutableDouble;

import java.util.concurrent.atomic.AtomicReference;

public class TrackHelper {

    public static double getSpeedMultiplier(TrackMaterial trackMaterial) {
        if (trackMaterial == ATrackMaterials.HIGH_SPEED)
            return AConfig.SERVER.HighSpeedSpeedMultiplier.get();

        if (trackMaterial == ATrackMaterials.MAGLEV)
            return AConfig.SERVER.MaglevSpeedMultiplier.get();

        return 1.0;
    }

    public static double getCurrentTrackSpeedMultiplier(Train train) {
        MutableDouble multiplier = new MutableDouble(Double.MAX_VALUE);

        train.forEachTravellingPoint(tp -> {

            if (tp.edge == null)
                return;

            double current = getSpeedMultiplier(tp.edge.getTrackMaterial());

            multiplier.setValue(Math.min(multiplier.getValue(), current));

        });

        return multiplier.getValue() == Double.MAX_VALUE ? 1.0 : multiplier.getValue();
    }
}
