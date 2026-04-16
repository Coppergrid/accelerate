package onelink.accelerate.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import onelink.accelerate.ABlocks;
import onelink.accelerate.AItems;
import onelink.accelerate.Accelerate;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;

public class GenTrackTags {
    public static final TagKey<Item> COBALT_INGOTS = createItemTag("cobalt_ingots");
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

    private static void genBlockTags(RegistrateTagsProvider<Block> provider) {
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

    private static void genItemTags(RegistrateTagsProvider<Item> provider) {
        TagGen.CreateTagsProvider<Item> itemProvider = new TagGen.CreateTagsProvider<>(provider, item -> (net.minecraft.core.Holder.Reference<Item>) BuiltInRegistries.ITEM.wrapAsHolder(item));

        // Add two items from your mod
        itemProvider.tag(COBALT_INGOTS)
                .add(
                        AItems.COBALT_INGOT.get(),
                        AItems.CHARGED_COBALT_INGOT.get(),
                        AItems.MAGNETIZED_COBALT_INGOT.get()
                );
    }

    public static void register() {
        // Register block and item tag generators
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, GenTrackTags::genBlockTags);
        Accelerate.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, GenTrackTags::genItemTags);
    }
}
