package coppergrid.accelerate.datagen;

import com.tterrag.registrate.providers.ProviderType;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.datagen.recipe.ASequencedAssemblyRecipeGen;
import coppergrid.accelerate.datagen.recipe.GenCraftingRecipes;
import coppergrid.accelerate.datagen.recipe.GenSmeltingRecipes;
import coppergrid.accelerate.datagen.recipe.processing.AProcessingRecipeGen;
import net.minecraft.data.DataGenerator;

public class GenRecipes {

    public static void register(DataGenerator.PackGenerator gen) {
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.RECIPE, GenSmeltingRecipes::generateRecipes);
        gen.addProvider(AProcessingRecipeGen::registerAll);
        gen.addProvider(ASequencedAssemblyRecipeGen::new);
        gen.addProvider(GenCraftingRecipes::new);
    }
}
