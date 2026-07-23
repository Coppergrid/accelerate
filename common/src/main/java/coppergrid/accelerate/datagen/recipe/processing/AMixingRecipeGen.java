package coppergrid.accelerate.datagen.recipe.processing;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

public class AMixingRecipeGen extends AProcessingRecipeGen {
    public AMixingRecipeGen(PackOutput output) {
        super(output);
    }

    GeneratedRecipe

            CHARGED_COBALT_INGOT = create(Accelerate.asResource("charged_cobalt_ingot_from_mixing"), builder -> builder
                    .require(AItems.COBALT_INGOT)
                    .require(Items.IRON_INGOT)
                    .output(AItems.CHARGED_COBALT_INGOT)
                    .requiresHeat(HeatCondition.HEATED)),

            MAGNETIZED_COBALT_INGOT = create(Accelerate.asResource("magnetized_cobalt_ingot_from_mixing"), builder -> builder
                    .require(AItems.CHARGED_COBALT_INGOT)
                    .require(Items.IRON_INGOT)
                    .require(Items.IRON_INGOT)
                    .require(Items.REDSTONE)
                    .require(Items.REDSTONE)
                    .require(Items.REDSTONE)
                    .output(AItems.MAGNETIZED_COBALT_INGOT)
                    .requiresHeat(HeatCondition.SUPERHEATED));

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
