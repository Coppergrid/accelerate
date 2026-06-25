package onelink.accelerate.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AConfig {
    public static class Common {
        public final ForgeConfigSpec.DoubleValue HighSpeedTrackMultiplier;
        public final ForgeConfigSpec.DoubleValue MaglevTrackMultiplier;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Track Speed Multiplier");
            HighSpeedTrackMultiplier = builder.comment("Speed Multiplier for High Speed Tracks")
                    .defineInRange("High Speed Multiplier", 1.5, 0.1, 10);
            MaglevTrackMultiplier = builder.comment("Speed Multiplier for Maglev Tracks")
                    .defineInRange("Maglev Multiplier", 2.5, 0.1, 10);
            builder.pop();
        }

    }

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

}