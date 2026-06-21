package onelink.accelerate.config;

public class SpeedConfig {

    public double high_speedMultiplier;

    public double maglevMultiplier;

    public static SpeedConfig getDefault() {
        SpeedConfig config = new SpeedConfig();

        config.high_speedMultiplier = 1.5;
        config.maglevMultiplier = 2.5;

        return config;
    }
}
