package onelink.accelerate.content.track;

import com.simibubi.create.content.trains.track.TrackBlock;
import onelink.accelerate.registry.ATrackMaterials;

public class MaglevTrackBlock extends TrackBlock {
    public MaglevTrackBlock(Properties properties) {
        super(properties, ATrackMaterials.MAGLEV);
    }
}