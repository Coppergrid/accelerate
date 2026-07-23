package coppergrid.accelerate.datagen;


import coppergrid.accelerate.datagen.recipe.processing.AProcessingRecipeGen;
import net.minecraft.data.DataGenerator;

public class DataGen {
    public static void register(DataGenerator.PackGenerator gen) {
        GenLang.register();
        GenRecipes.register();
        GenTags.register();
        gen.addProvider(AProcessingRecipeGen::registerAll);
    }
}