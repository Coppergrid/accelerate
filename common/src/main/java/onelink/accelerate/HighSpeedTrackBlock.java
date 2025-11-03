package onelink.accelerate;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackMaterial;

public class HighSpeedTrackBlock extends TrackBlock {
    public HighSpeedTrackBlock(Properties properties) {
        super(properties, ATrackMaterials.HIGH_SPEED);
    }

    @Override
    public TrackMaterial getMaterial() {
        return ATrackMaterials.HIGH_SPEED;
    }
}