## Train Type Detection
1. ✅ High-speed tracks
2. ✅ High-speed bogeys
3. ✅ Train assembly detection and validation
4. → High-speed gameplay (speed, acceleration, restrictions)
5. Polish and test High-Speed thoroughly
6. Implement Maglev using the same assembly pipeline
7. Add Maglev-specific mechanics and polish

### Step 4
1. ✅ TrackHelper.getCurrentTrackMaterial(Train)
2. ✅ TrackHelper.getTrackSpeedMultiplier(Train)
3. ✅ Test detection/logging 
4. ✅ Modify TrainStatsMixin 
5. ✅ Add mixed-track handling 
6. → Add caching only if needed

#### Step 6
1. Create the cache
2. Link the cache to the train
3. Make a storage helper
4. Update the cache
5. Use the cache
6. Test implementation
7. (if needed) Cache computed values, not just TrackMaterial

## Dev Changes
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