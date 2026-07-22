package coppergrid.accelerate.datagen;

import com.simibubi.create.AllItems;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.inventoryTrigger;

public class GenRecipes {
    private static InventoryChangeTrigger.TriggerInstance unlockedByItem(ItemLike item) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
    }

    private static InventoryChangeTrigger.TriggerInstance unlockedByItemTag(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tag).build());
    }

    public static void generateRecipes(RegistrateRecipeProvider recipeProvider) {
        
    }

    public static void register() {
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.RECIPE, GenRecipes::generateRecipes);
    }
}
