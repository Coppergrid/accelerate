package coppergrid.accelerate.content.track;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackMaterial;
import coppergrid.accelerate.registry.ATrackMaterials;

public class MaglevTrackBlock extends TrackBlock {
    public MaglevTrackBlock(Properties properties) {
        super(properties, ATrackMaterials.MAGLEV);
    }

    @Override
    public TrackMaterial getMaterial() {
        return ATrackMaterials.MAGLEV;
    }
}