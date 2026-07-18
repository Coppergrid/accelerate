package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;

public class TrainTypeValidator {

    public static TrainType validate(AbstractBogeyBlock<?>[] bogeys, int count) {
        TrainType currentType = null;

        for (int i = 0; i < count; i++) {
            TrainType bogeyType = TrainType.fromBogey(bogeys[i]);

            if (currentType == null) {
                currentType = bogeyType;
                continue;
            }

            if (currentType != bogeyType) {
                return null;
            }
        }

        return currentType;
    }
}
