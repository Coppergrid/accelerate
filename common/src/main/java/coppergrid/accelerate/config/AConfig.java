package coppergrid.accelerate.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AConfig {
    public static class Server {
        public final ForgeConfigSpec.BooleanValue DevMode;

        public final ForgeConfigSpec.DoubleValue HighSpeedTrainAccelMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevTrainAccelMultiplier;

        public final ForgeConfigSpec.DoubleValue HighSpeedTrainSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevTrainSpeedMultiplier;

        public final ForgeConfigSpec.DoubleValue HighSpeedTrackSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevTrackSpeedMultiplier;

        public final ForgeConfigSpec.BooleanValue HighSpeedRealisticRadius;
        public final ForgeConfigSpec.BooleanValue MaglevRealisticRadius;
        public final ForgeConfigSpec.DoubleValue HighSpeedRadiusMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevRadiusMultiplier;

        Server(ForgeConfigSpec.Builder builder) {
            builder.push("Trains");
            builder.push("TrainStats");
            DevMode = builder.comment("For testing purposes only. Applies high speed train parameters to ALL TRAINS. Use with caution. (Requires world restart)")
                    .define("devMode", false);
            builder.push("Acceleration");
            HighSpeedTrainAccelMultiplier = builder.comment("Acceleration Multiplier for High Speed Trains")
                    .defineInRange("highSpeedTrainAccelMultiplier", 1.5, 0.1, Double.MAX_VALUE);
            MaglevTrainAccelMultiplier = builder.comment("Acceleration Multiplier for Maglev Trains")
                    .defineInRange("maglevTrainAccelMultiplier", 2.5, 0.1, Double.MAX_VALUE);
            builder.pop();
            builder.push("Speed");
            HighSpeedTrainSpeedMultiplier = builder.comment("Speed Multiplier for High Speed Trains")
                    .defineInRange("highSpeedTrainSpeedMultiplier", 2, 0.1, Double.MAX_VALUE);
            MaglevTrainSpeedMultiplier = builder.comment("Speed Multiplier for Maglev Trains")
                    .defineInRange("maglevTrainSpeedMultiplier", 3, 0.1, Double.MAX_VALUE);
            builder.pop();
            builder.pop();
            builder.pop();
            builder.push("Tracks");
            builder.push("TrackStats");
            builder.push("CurveRadius");
            HighSpeedRealisticRadius = builder.comment("Force Realistic Radii for High Speed Tracks")
                    .define("highSpeedRealisticRadius",true);
            HighSpeedRadiusMultiplier = builder.comment("Radius Multiplier for High Speed Tracks")
                    .defineInRange("highSpeedRadiusMultiplier", 8, 1, 36.0);
            MaglevRealisticRadius = builder.comment("Force Realistic Radii for Maglev Tracks")
                    .define("maglevRealisticRadius", true);
            MaglevRadiusMultiplier = builder.comment("Radius Multiplier for Maglev Tracks")
                    .defineInRange("maglevRadiusMultiplier", 18, 1, 36.0);
            builder.pop();
            builder.push("Speed");
            HighSpeedTrackSpeedMultiplier = builder.comment("Speed Multiplier for High Speed Tracks")
                    .defineInRange("highSpeedTrackSpeedMultiplier", 2, 0.1, Double.MAX_VALUE);
            MaglevTrackSpeedMultiplier = builder.comment("Speed Multiplier for Maglev Tracks")
                    .defineInRange("maglevTrackSpeedMultiplier", 3, 0.1, Double.MAX_VALUE);
            builder.pop();
            builder.pop();
            builder.pop();
        }

    }

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        SERVER = new Server(builder);
        SERVER_SPEC = builder.build();
    }

    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

}