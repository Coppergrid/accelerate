package coppergrid.accelerate.datagen.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.datagen.GenTags;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ASequencedAssemblyRecipeGen extends ARecipeProvider {
    public ASequencedAssemblyRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getName() {
        return "Accelerate's Sequenced Assembly Recipes";
    }

    protected GeneratedRecipe create(
            ResourceLocation resourceLocation,
            Function<SequencedAssemblyRecipeBuilder, SequencedAssemblyRecipeBuilder> transform) {

        GeneratedRecipe recipe = consumer ->
                transform.apply(new SequencedAssemblyRecipeBuilder(resourceLocation))
                        .build(consumer);

        return register(recipe);
    }

    GeneratedRecipe

            HIGH_SPEED_TRACK_ASSEMBLY = create(Accelerate.asResource("high_speed_track_assembly"), builder -> builder
                .require(AllBlocks.TRACK.asItem())
                .transitionTo(AItems.INCOMPLETE_HIGH_SPEED_TRACK)
                .loops(3)
                .addOutput(ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem(), 1)
                .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(GenTags.HIGH_SPEED_CONCRETE))
                .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(Items.IRON_INGOT))
                .addStep(PressingRecipe::new, recipeBuilder -> recipeBuilder)),

            MAGLEV_TRACK_ASSEMBLY = create(Accelerate.asResource("maglev_track_assembly"), builder -> builder
                    .require(ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem())
                    .transitionTo(AItems.INCOMPLETE_MAGLEV_TRACK)
                    .loops(2)
                    .addOutput(ABlocks.MAGLEV_TRACK_BLOCK.asItem(), 1)
                    .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(Items.IRON_BLOCK))
                    .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(AItems.MAGNETIZED_COBALT_INGOT))
                    .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(AItems.MAGNETIZED_COBALT_INGOT))
                    .addStep(DeployerApplicationRecipe::new, recipeBuilder -> recipeBuilder.require(Items.IRON_BLOCK))
                    .addStep(PressingRecipe::new, recipeBuilder -> recipeBuilder));


}
