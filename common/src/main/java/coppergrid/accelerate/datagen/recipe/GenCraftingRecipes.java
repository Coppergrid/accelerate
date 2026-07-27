package coppergrid.accelerate.datagen.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class GenCraftingRecipes extends ARecipeProvider {

    public GenCraftingRecipes(PackOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getName() {
        return "Accelerate's Crafting Recipes";
    }

        GeneratedRecipe AUTOMATED_DRIVER = create(AItems.AUTOMATED_DRIVER, RecipeCategory.TRANSPORTATION)
                .unlockedBy(AllItems.PRECISION_MECHANISM)
                .viaShaped(b -> b
                        .define('A', AllItems.ANDESITE_ALLOY)
                        .define('G', AllItems.GOLDEN_SHEET)
                        .define('P', AllItems.PRECISION_MECHANISM)
                        .define('Q', AllItems.POLISHED_ROSE_QUARTZ)
                        .pattern("AGA")
                        .pattern("QPQ")
                        .pattern("AGA")
                );


    GeneratedRecipe AUTOMATED_DRIVING_MODULE = create(ABlocks.AUTOMATED_DRIVING_MODULE, RecipeCategory.TRANSPORTATION)
            .unlockedBy(AItems.AUTOMATED_DRIVER)
            .viaShaped(b -> b
                    .define('C', AItems.CHARGED_COBALT_INGOT)
                    .define('D', AItems.AUTOMATED_DRIVER)
                    .define('S', AllItems.STURDY_SHEET)
                    .define('T', AllBlocks.RAILWAY_CASING)
                    .pattern("SCS")
                    .pattern("TDT")
                    .pattern("SCS")
            );

    GeneratedRecipe RAW_COBALT_BLOCK = create(ABlocks.RAW_COBALT_BLOCK, RecipeCategory.MISC)
            .withLocation(Accelerate.asResource("raw_cobalt_block_from_ore"))
            .unlockedBy(AItems.RAW_COBALT)
            .viaShaped(b -> b
                    .define('R', AItems.RAW_COBALT)
                    .pattern("RRR")
                    .pattern("RRR")
                    .pattern("RRR")
            );

    GeneratedRecipe RAW_COBALT = create(AItems.RAW_COBALT, RecipeCategory.MISC)
            .returns(9)
            .withLocation(Accelerate.asResource("raw_cobalt_from_block"))
            .unlockedBy(ABlocks.RAW_COBALT_BLOCK)
            .viaShapeless(b -> b
                    .requires(ABlocks.RAW_COBALT_BLOCK)
            );

    GeneratedRecipe COBALT_BLOCK = create(ABlocks.COBALT_BLOCK, RecipeCategory.BUILDING_BLOCKS)
            .withLocation(Accelerate.asResource("cobalt_block_from_ingot"))
            .unlockedBy(AItems.COBALT_INGOT)
            .viaShaped(b -> b
                    .define('C', AItems.COBALT_INGOT)
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")
            );

    GeneratedRecipe COBALT_INGOT = create(AItems.COBALT_INGOT, RecipeCategory.MISC)
            .returns(9)
            .withLocation(Accelerate.asResource("cobalt_ingot_from_block"))
            .unlockedBy(ABlocks.COBALT_BLOCK)
            .viaShapeless(b -> b
                    .requires(ABlocks.COBALT_BLOCK)
            );

    GeneratedRecipe HIGH_SPEED_RAILWAY_CASING = create(ABlocks.HIGH_SPEED_RAILWAY_CASING, RecipeCategory.TRANSPORTATION)
            .returns(2)
            .unlockedBy(AllBlocks.RAILWAY_CASING)
            .viaShaped(b -> b
                    .define('B', AllItems.BRASS_SHEET)
                    .define('C', AllItems.COPPER_SHEET)
                    .define('P', AllItems.PRECISION_MECHANISM)
                    .define('R', AllBlocks.RAILWAY_CASING)
                    .pattern("CCC")
                    .pattern("RPR")
                    .pattern("BBB")
            );

    GeneratedRecipe MAGLEV_RAILWAY_CASING = create(ABlocks.MAGLEV_RAILWAY_CASING.asItem(), RecipeCategory.TRANSPORTATION)
            .returns(2)
            .unlockedBy(ABlocks.HIGH_SPEED_RAILWAY_CASING)
            .viaShaped(b -> b
                    .define('C', AllItems.COPPER_SHEET)
                    .define('H', ABlocks.HIGH_SPEED_RAILWAY_CASING)
                    .define('M', AItems.MAGNETIZED_COBALT_INGOT)
                    .define('P', AllItems.PRECISION_MECHANISM)
                    .define('T', AllItems.ELECTRON_TUBE)
                    .pattern("TCT")
                    .pattern("HPH")
                    .pattern("MCM")
            );

    protected class GeneratedRecipeBuilder {

        private final ItemLike result;
        private final RecipeCategory category;

        private int amount = 1;

        private Consumer<RecipeBuilder> unlock = b -> {};

        private ResourceLocation recipeId;

        private GeneratedRecipeBuilder(ItemLike result, RecipeCategory category) {
            this.result = result;
            this.category = category;
        }

        public GeneratedRecipeBuilder returns(int amount) {
            this.amount = amount;
            return this;
        }

        public GeneratedRecipeBuilder withLocation(ResourceLocation id) {
            this.recipeId = id;
            return this;
        }

        public GeneratedRecipeBuilder unlockedBy(ItemLike item) {
            unlock = b ->
                    b.unlockedBy("has_item", RecipeProvider.has(item));
            return this;
        }

        public GeneratedRecipeBuilder unlockedBy(TagKey<Item> tag) {
            unlock = b ->
                    b.unlockedBy("has_item", RecipeProvider.has(tag));
            return this;
        }

        public GeneratedRecipe viaShaped(
                UnaryOperator<ShapedRecipeBuilder> transform) {

            return register(consumer -> {

                ShapedRecipeBuilder builder =
                        transform.apply(
                                ShapedRecipeBuilder.shaped(category, result, amount));

                unlock.accept(builder);

                if (recipeId == null)
                    builder.save(consumer);
                else
                    builder.save(consumer, recipeId);
            });
        }

        public GeneratedRecipe viaShapeless(
                UnaryOperator<ShapelessRecipeBuilder> transform) {

            return register(consumer -> {

                ShapelessRecipeBuilder builder =
                        transform.apply(
                                ShapelessRecipeBuilder.shapeless(category, result, amount));

                unlock.accept(builder);

                if (recipeId == null)
                    builder.save(consumer);
                else
                    builder.save(consumer, recipeId);
            });
        }
    }

    protected GeneratedRecipeBuilder create(ItemLike result, RecipeCategory category) {
        return new GeneratedRecipeBuilder(result, category);
    }
}
