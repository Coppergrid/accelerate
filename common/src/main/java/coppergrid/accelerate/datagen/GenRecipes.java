package coppergrid.accelerate.datagen;

import coppergrid.accelerate.datagen.recipe.ASequencedAssemblyRecipeGen;
import coppergrid.accelerate.datagen.recipe.GenCraftingRecipes;
import coppergrid.accelerate.datagen.recipe.GenSmeltingRecipes;
import coppergrid.accelerate.datagen.recipe.processing.AProcessingRecipeGen;
import net.minecraft.data.DataGenerator;

public class GenRecipes {

    public static void register(DataGenerator.PackGenerator gen) {
        gen.addProvider(AProcessingRecipeGen::registerAll);
        gen.addProvider(ASequencedAssemblyRecipeGen::new);
        gen.addProvider(GenCraftingRecipes::new);
        gen.addProvider(GenSmeltingRecipes::new);
    }
}
