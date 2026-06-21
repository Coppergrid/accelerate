package onelink.accelerate.config;

import com.google.gson.*;
import onelink.accelerate.Accelerate;

import java.io.*;

public class AConfig {
    private static AConfig instance;

    public static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

    private static final File file = new File("config", Accelerate.MOD_ID + "-config.json");

    public SpeedConfig speed;

    public static AConfig getInstance() {
        System.out.println("getInstance config call made successfully");
        if (instance == null) {
            System.out.println("Accelerate config instance null - reloading");
            return reload();
        }
        System.out.println("Accelerate config -- Returning instance...");
        return instance;
    }

    public void write() throws IOException {
        if (!file.exists())
            file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(this, writer);
        }
    }

    public static AConfig reload() {
        AConfig config;
        System.out.println("[Accelerate] Config path: " + file.getAbsolutePath());
        System.out.println("[Accelerate] Exists: " + file.exists());

        try (FileReader reader = new FileReader(file)) {
            config = gson.fromJson(reader, AConfig.class);

            if (config == null) {
                config = new AConfig();
            }
        } catch (IOException e) {
            config = new AConfig();
        }

        // generate initial config
        if (config.speed == null) {
            config.speed = SpeedConfig.getDefault();
        }

        // additional configs for the future

        instance = config;
        return config;
    }
}
