### Train Type Detection
1. ✅ High-speed tracks
2. ✅ High-speed bogeys
3. → Train assembly detection and validation
4. High-speed gameplay (speed, acceleration, restrictions)
5. Polish and test High-Speed thoroughly
6. Implement Maglev using the same assembly pipeline
7. Add Maglev-specific mechanics and polish

### Dev Changes
1. Enum carries behavior
```java
// DECLARATION
public enum TrainType {
    NORMAL,
    HIGH_SPEED,
    MAGLEV;

    public double accelerationMultiplier() {
        return switch (this) {
            case NORMAL -> 1.0;
            case HIGH_SPEED -> AConfig.HighSpeedAccelMultiplier;
            case MAGLEV -> AConfig.MaglevAccelMultiplier;
        };
    }
    public double speedMultiplier() {
        // same as above but with speed
    }
}

// USE
TrainType type = TrainTypeStorage.get(train);

accel *= type.accelerationMultiplier();
speed *= type.speedMultiplier();
```   

### Other Additions  
1. [x] Automated Driving Unit