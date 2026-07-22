package coppergrid.accelerate.datagen;

import com.tterrag.registrate.providers.ProviderType;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.datagen.recipe.GenCraftingRecipes;

public class GenRecipes {

    public static void register() {
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.RECIPE, GenCraftingRecipes::generateRecipes);
    }
}
