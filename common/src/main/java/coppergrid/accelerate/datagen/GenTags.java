package coppergrid.accelerate.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import coppergrid.accelerate.Accelerate;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;

public class GenTags {
    public static final TagKey<Item> COBALT_INGOTS = createItemTag("cobalt_ingots");
    public static final TagKey<Item> HIGH_SPEED_CONCRETE = createItemTag("high_speed_concrete");

    public static final TagKey<Block> ACCELERATE_TRACKS = createBlockTag("track_items");
    public static final TagKey<Block> CREATE_TRACKS = createBlockTag("create", "tracks");

    private static TagKey<Item> createItemTag(String path) {
        return createItemTag(Accelerate.MOD_ID, path);
    }

    private static TagKey<Item> createItemTag(String namespace, String path) {
        return TagKey.create(
                BuiltInRegistries.ITEM.key(),
                new ResourceLocation(namespace, path)
        );
    }

    private static TagKey<Block> createBlockTag(String path) {
        return createBlockTag(Accelerate.MOD_ID, path);
    }

    private static TagKey<Block> createBlockTag(String namespace, String path) {
        return TagKey.create(
                BuiltInRegistries.BLOCK.key(),
                new ResourceLocation(namespace, path)
        );
    }

    private static void generateBlockTags(RegistrateTagsProvider<Block> provider) {
        TagGen.CreateTagsProvider<Block> blockProvider = new TagGen.CreateTagsProvider<>(provider, block -> (net.minecraft.core.Holder.Reference<Block>) BuiltInRegistries.BLOCK.wrapAsHolder(block));

        // Merge your block tag with another mod's tag list
        blockProvider.tag(CREATE_TRACKS)
                .add(
                        ABlocks.HIGH_SPEED_TRACK_BLOCK.get(),
                        ABlocks.MAGLEV_TRACK_BLOCK.get()
                );

        blockProvider.tag(ACCELERATE_TRACKS)
                .add(
                        ABlocks.HIGH_SPEED_TRACK_BLOCK.get(),
                        ABlocks.MAGLEV_TRACK_BLOCK.get()
                );
    }

    private static void generateItemTags(RegistrateTagsProvider<Item> provider) {
        TagGen.CreateTagsProvider<Item> itemProvider = new TagGen.CreateTagsProvider<>(provider, item -> (net.minecraft.core.Holder.Reference<Item>) BuiltInRegistries.ITEM.wrapAsHolder(item));

        // Add two items from your mod
        itemProvider.tag(COBALT_INGOTS)
                .add(
                        AItems.COBALT_INGOT.get(),
                        AItems.CHARGED_COBALT_INGOT.get(),
                        AItems.MAGNETIZED_COBALT_INGOT.get()
                );

        itemProvider.tag(HIGH_SPEED_CONCRETE)
                .add(
                        Items.WHITE_CONCRETE,
                        Items.ORANGE_CONCRETE,
                        Items.MAGENTA_CONCRETE,
                        Items.LIGHT_BLUE_CONCRETE,
                        Items.YELLOW_CONCRETE,
                        Items.LIME_CONCRETE,
                        Items.PINK_CONCRETE,
                        Items.GRAY_CONCRETE,
                        Items.LIGHT_GRAY_CONCRETE,
                        Items.CYAN_CONCRETE,
                        Items.PURPLE_CONCRETE,
                        Items.BLUE_CONCRETE,
                        Items.BROWN_CONCRETE,
                        Items.GREEN_CONCRETE,
                        Items.RED_CONCRETE,
                        Items.BLACK_CONCRETE
                );
    }

    public static void register() {
        // Register block and item tag generators
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, GenTags::generateBlockTags);
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, GenTags::generateItemTags);
    }
}
