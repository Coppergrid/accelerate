package coppergrid.accelerate.interfaces;

import coppergrid.accelerate.infrastructure.train.TrainType;

public interface ATrainInterface {
    TrainType accelerate$getTrainType();
    void accelerate$setTrainType(TrainType type);
}
