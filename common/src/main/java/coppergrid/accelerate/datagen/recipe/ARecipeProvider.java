package coppergrid.accelerate.datagen.recipe;

import coppergrid.accelerate.Accelerate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ARecipeProvider extends RecipeProvider {

    protected final List<GeneratedRecipe> all = new ArrayList<>();

    public ARecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    public void buildRecipes(@NotNull Consumer<FinishedRecipe> finishedRecipeConsumer) {
        all.forEach(c -> c.register(finishedRecipeConsumer));
        Accelerate.LOGGER.info(getName() + " registered " + all.size() + " recipe" + (all.size() == 1 ? "" : "s"));
    }

    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(Consumer<FinishedRecipe> consumer);
    }
}
