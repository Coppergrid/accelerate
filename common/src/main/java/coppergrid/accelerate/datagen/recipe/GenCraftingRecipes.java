package coppergrid.accelerate.datagen.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.inventoryTrigger;

public class GenCraftingRecipes {
    private static InventoryChangeTrigger.TriggerInstance unlockedByItem(ItemLike item) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
    }

    private static InventoryChangeTrigger.TriggerInstance unlockedByItemTag(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tag).build());
    }

    public static void generateRecipes(RegistrateRecipeProvider recipeProvider) {
        ShapedRecipeBuilder
                .shaped(RecipeCategory.TRANSPORTATION, AItems.AUTOMATED_DRIVER)
                .unlockedBy("has_item", unlockedByItem(AllItems.PRECISION_MECHANISM))
                .define('A', AllItems.ANDESITE_ALLOY)
                .define('G', AllItems.GOLDEN_SHEET)
                .define('P', AllItems.PRECISION_MECHANISM)
                .define('Q', AllItems.POLISHED_ROSE_QUARTZ)
                .pattern("AGA")
                .pattern("QPQ")
                .pattern("AGA")
                .save(recipeProvider);

        ShapedRecipeBuilder
                .shaped(RecipeCategory.TRANSPORTATION, ABlocks.AUTOMATED_DRIVING_MODULE.asItem())
                .unlockedBy("has_item", unlockedByItem(AItems.AUTOMATED_DRIVER))
                .define('C', AItems.CHARGED_COBALT_INGOT)
                .define('D', AItems.AUTOMATED_DRIVER)
                .define('S', AllItems.STURDY_SHEET)
                .define('T', AllBlocks.RAILWAY_CASING.asItem())
                .pattern("SCS")
                .pattern("TDT")
                .pattern("SCS")
                .save(recipeProvider);
    }
}
