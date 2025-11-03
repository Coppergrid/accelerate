package onelink.accelerate;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackMaterial;

public class HighSpeedTrackBlock extends TrackBlock {
    public HighSpeedTrackBlock(Properties properties) {
        super(properties, ATrackMaterials.HIGHSPEED);
    }

    @Override
    public TrackMaterial getMaterial() {
        return ATrackMaterials.HIGHSPEED;
    }
}