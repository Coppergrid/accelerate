package coppergrid.accelerate.datagen.recipe.processing;

import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import coppergrid.accelerate.datagen.recipe.ARecipeProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public abstract class AProcessingRecipeGen extends ARecipeProvider {

    protected static final List<AProcessingRecipeGen> GENERATORS = new ArrayList<>();

    public static DataProvider registerAll(PackOutput output) {
        GENERATORS.add(new AMixingRecipeGen(output));

        return new DataProvider() {

            @Override
            public @NotNull String getName() {
                return "Accelerate's Processing Recipes";
            }

            @Override
            public @NotNull CompletableFuture<?> run(@NotNull CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        };
    }

    public AProcessingRecipeGen(PackOutput generator) {
        super(generator);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(ResourceLocation name, UnaryOperator<ProcessingRecipeBuilder<T>> transform) {

        ProcessingRecipeSerializer<T> serializer = getSerializer();

        return register(c ->
                transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name))
                        .build(c));
    }

    protected abstract IRecipeTypeInfo getRecipeType();

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }
}