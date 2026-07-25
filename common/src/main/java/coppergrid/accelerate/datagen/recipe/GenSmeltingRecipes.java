package coppergrid.accelerate.datagen.recipe;

import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class GenSmeltingRecipes extends ARecipeProvider {

    public GenSmeltingRecipes(PackOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getName() {
        return "Accelerate's Smelting Recipes";
    }

    ARecipeProvider.GeneratedRecipe COBALT_SMELTING = register(consumer ->
            SimpleCookingRecipeBuilder.smelting(
                            Ingredient.of(AItems.RAW_COBALT.get()),
                            RecipeCategory.MISC,
                            AItems.COBALT_INGOT,
                            0.7f,
                            200
                    )
                    .unlockedBy("has_item", RecipeProvider.has(AItems.RAW_COBALT))
                    .save(consumer, Accelerate.asResource("cobalt_ingot_from_smelting")
            ));

    ARecipeProvider.GeneratedRecipe COBALT_BLASTING = register(consumer ->
            SimpleCookingRecipeBuilder.blasting(
                            Ingredient.of(AItems.RAW_COBALT.get()),
                            RecipeCategory.MISC,
                            AItems.COBALT_INGOT,
                            0.7f,
                            100
                    )
                    .unlockedBy("has_item", RecipeProvider.has(AItems.RAW_COBALT))
                    .save(consumer, Accelerate.asResource("cobalt_ingot_from_blasting")
                    ));
}
