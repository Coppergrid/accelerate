package coppergrid.accelerate.datagen.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
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

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, ABlocks.RAW_COBALT_BLOCK.asItem())
                .unlockedBy("has_item", RecipeProvider.has(AItems.RAW_COBALT))
                .define('R', AItems.RAW_COBALT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .save(recipeProvider, Accelerate.asResource("raw_cobalt_block_from_ore"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, AItems.RAW_COBALT.asItem(), 9)
                .unlockedBy("has_item", RecipeProvider.has(ABlocks.RAW_COBALT_BLOCK.asItem()))
                .requires(ABlocks.RAW_COBALT_BLOCK.asItem())
                .save(recipeProvider, Accelerate.asResource("raw_cobalt_from_block"));

        ShapedRecipeBuilder
                .shaped(RecipeCategory.BUILDING_BLOCKS, ABlocks.COBALT_BLOCK.asItem())
                .unlockedBy("has_item", RecipeProvider.has(AItems.COBALT_INGOT))
                .define('C', AItems.COBALT_INGOT)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .save(recipeProvider, Accelerate.asResource("cobalt_block_from_ingot"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, AItems.COBALT_INGOT.asItem(), 9)
                .unlockedBy("has_item", RecipeProvider.has(ABlocks.COBALT_BLOCK.asItem()))
                .requires(ABlocks.COBALT_BLOCK.asItem())
                .save(recipeProvider, Accelerate.asResource("cobalt_ingot_from_block"));
    }
}
