package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import coppergrid.accelerate.config.AConfig;
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

    public double accelerationMultiplier() {
        return switch (this) {
            case HIGH_SPEED -> AConfig.SERVER.HighSpeedAccelMultiplier.get();
            case MAGLEV -> AConfig.SERVER.MaglevAccelMultiplier.get();
            case null, default -> 1.0;
        };
    }

    public double speedMultiplier() {
        return switch (this) {
            case NORMAL -> 1.0;
            case HIGH_SPEED -> AConfig.SERVER.HighSpeedSpeedMultiplier.get();
            case MAGLEV -> AConfig.SERVER.MaglevSpeedMultiplier.get();

        };
    }
}


