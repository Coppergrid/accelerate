package coppergrid.accelerate.datagen.recipe.processing;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ASplashingRecipeGen extends AProcessingRecipeGen {
    public ASplashingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getName() {
        return "Accelerate's Splashing Recipes";
    }

    GeneratedRecipe

            RAW_COBALT_FROM_SPLASHING = create(Accelerate.asResource("raw_cobalt_from_splashing"), builder -> builder
                    .require(Items.RAW_COPPER)
                    .output(0.1f, AItems.RAW_COBALT)
                    .output(AllItems.COPPER_NUGGET, 5)
                    .output(0.5f, AllItems.COPPER_NUGGET, 2));

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.SPLASHING;
    }
}
