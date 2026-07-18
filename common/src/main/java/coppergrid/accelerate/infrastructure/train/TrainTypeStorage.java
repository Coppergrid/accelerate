package coppergrid.accelerate.infrastructure.train;

import com.simibubi.create.content.trains.entity.Train;
import coppergrid.accelerate.interfaces.ATrainInterface;

public class TrainTypeStorage {

    public static void set(Train train, TrainType type) {
        ((ATrainInterface)train).accelerate$setTrainType(type);
    }

    public static TrainType get(Train train) {
        return ((ATrainInterface)train).accelerate$getTrainType();
    }
}
