package coppergrid.accelerate.datagen;


import net.minecraft.data.DataGenerator;

public class DataGen {
    public static void register(DataGenerator.PackGenerator gen) {
        GenLang.register();
        GenRecipes.register(gen);
        GenTags.register();
    }
}