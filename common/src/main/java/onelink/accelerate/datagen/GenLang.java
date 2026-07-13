package onelink.accelerate.datagen;

import com.google.gson.JsonElement;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.createmod.ponder.foundation.PonderIndex;
import onelink.accelerate.Accelerate;

import java.util.Map;

public class GenLang {
    public static void generateLanguage(RegistrateLangProvider provider) {
        PonderIndex.getLangAccess().provideLang(Accelerate.MOD_ID, provider::add);

        // defaults
        JsonElement elem = FilesHelper.loadJsonResource("assets/accelerate/lang/en_defaults.json");

        if (elem == null) {
            throw new RuntimeException("Couldn't find lang/en_defaults.json");
        }

        for (Map.Entry<String, JsonElement> entry : elem.getAsJsonObject().entrySet()) {
            provider.add(entry.getKey(), entry.getValue().getAsString());
        }
    }

    public static void register() {
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.LANG, GenLang::generateLanguage);
    }
}
