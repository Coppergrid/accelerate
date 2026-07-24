package coppergrid.accelerate.datagen.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.inventoryTrigger;

public class GenSmeltingRecipes {
    private static InventoryChangeTrigger.TriggerInstance unlockedByItem(ItemLike item) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
    }

    private static InventoryChangeTrigger.TriggerInstance unlockedByItemTag(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tag).build());
    }

    public static void generateRecipes(RegistrateRecipeProvider recipeProvider) {

        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(AItems.RAW_COBALT.get()),
                        RecipeCategory.MISC,
                        AItems.COBALT_INGOT,
                        0.7f,
                        200
                )
                .unlockedBy("has_item", RecipeProvider.has(AItems.RAW_COBALT))
                .save(recipeProvider, Accelerate.asResource("cobalt_ingot_from_smelting"));

        SimpleCookingRecipeBuilder.blasting(
                Ingredient.of(AItems.RAW_COBALT.get()),
                        RecipeCategory.MISC,
                        AItems.COBALT_INGOT,
                        0.7f,
                        100
                )
                .unlockedBy("has_item", RecipeProvider.has(AItems.RAW_COBALT))
                .save(recipeProvider, Accelerate.asResource("cobalt_ingot_from_blasting"));
    }
}
