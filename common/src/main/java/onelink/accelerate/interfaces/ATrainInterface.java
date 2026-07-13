package onelink.accelerate.interfaces;

import onelink.accelerate.infrastructure.train.TrainType;

public interface ATrainInterface {
    TrainType accelerate$getTrainType();
    void accelerate$setTrainType(TrainType type);
}
