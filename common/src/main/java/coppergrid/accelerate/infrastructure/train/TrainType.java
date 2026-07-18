package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;

public enum TrainType {
    NORMAL,
    HIGH_SPEED,
    MAGLEV;

    public static TrainType fromBogey(AbstractBogeyBlock<?> bogey) {
        if (bogey instanceof HighSpeedBogeyBlock)
            return HIGH_SPEED;

//        if (bogey instanceof MaglevBogeyBlock)
//            return MAGLEV;

        return NORMAL;
    }
}


