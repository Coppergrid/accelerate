package onelink.accelerate.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AConfig {
    public static class Server {
        public final ForgeConfigSpec.DoubleValue HighSpeedAccelMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevAccelMultiplier;

        public final ForgeConfigSpec.DoubleValue HighSpeedSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevSpeedMultiplier;


        public final ForgeConfigSpec.BooleanValue HighSpeedRealisticRadius;
        public final ForgeConfigSpec.BooleanValue MaglevRealisticRadius;

        Server(ForgeConfigSpec.Builder builder) {
            builder.push("Trains");
            builder.push("TrainStats");
            builder.push("Acceleration");
            HighSpeedAccelMultiplier = builder.comment("Acceleration Multiplier for High Speed Trains")
                    .defineInRange("highSpeedAccelMultiplier", 1.5, 0.1, Double.MAX_VALUE);
            MaglevAccelMultiplier = builder.comment("Acceleration Multiplier for Maglev Trains")
                    .defineInRange("maglevAccelMultiplier", 2.5, 0.1, Double.MAX_VALUE);
            builder.pop();
            builder.push("Speed");
            HighSpeedSpeedMultiplier = builder.comment("Speed Multiplier for High Speed Trains")
                    .defineInRange("highSpeedSpeedMultiplier", 2, 0.1, Double.MAX_VALUE);
            MaglevSpeedMultiplier = builder.comment("Speed Multiplier for Maglev Trains")
                    .defineInRange("maglevSpeedMultiplier", 3, 0.1, Double.MAX_VALUE);
            builder.pop();
            builder.pop();
            builder.pop();
            builder.push("Tracks");
            builder.push("CurveRadius");
            HighSpeedRealisticRadius = builder.comment("Force Realistic Radii for High Speed Tracks")
                    .define("highSpeedRealisticRadius",true);
            MaglevRealisticRadius = builder.comment("Force Realistic Radii for Maglev Tracks")
                    .define("maglevRealisticRadius", true);
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