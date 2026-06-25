package onelink.accelerate.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AConfig {
    public static class Server {
        public final ForgeConfigSpec.DoubleValue HighSpeedAccelMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevAccelMultiplier;

        public final ForgeConfigSpec.DoubleValue HighSpeedSpeedMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevSpeedMultiplier;

        Server(ForgeConfigSpec.Builder builder) {
            builder.push("Train Stats");
            builder.push("Acceleration");
            HighSpeedAccelMultiplier = builder.comment("Acceleration Multiplier for High Speed Tracks and Trains")
                    .defineInRange("highSpeedAccelMultiplier", 1.5, 0.1, 10);
            MaglevAccelMultiplier = builder.comment("Acceleration Multiplier for Maglev Tracks and Trains")
                    .defineInRange("maglevAccelMultiplier", 2.5, 0.1, 10);
            builder.pop();
            builder.push("Speed");
            HighSpeedSpeedMultiplier = builder.comment("Speed Multiplier for High Speed Tracks and Trains")
                    .defineInRange("highSpeedSpeedMultiplier", 2, 0.1, 10);
            MaglevSpeedMultiplier = builder.comment("Speed Multiplier for Maglev Tracks and Trains")
                    .defineInRange("maglevSpeedMultiplier", 3, 0.1, 10);
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