package onelink.highspeed;

import com.simibubi.create.content.trains.track.TrackMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import static com.simibubi.create.content.trains.track.TrackMaterialFactory.make;

public class HSTrackMaterials {

    public static final TrackMaterial
        HIGHSPEED = make(new ResourceLocation("highspeed", "highspeed"))
            .lang("Highspeed")
            .block(() -> HSBlocks.HIGH_SPEED_TRACK_BLOCK)
            .particle(new ResourceLocation("block/iron_block"))
            .sleeper(Blocks.STONE_SLAB)
            .rails(Items.IRON_NUGGET)
            .standardModels()
            .build(),

        MAGLEV = make(new ResourceLocation("highspeed", "maglev"))
            .lang("Maglev")
            .block(() -> HSBlocks.MAGLEV_TRACK_BLOCK)
            .particle(new ResourceLocation("block/diamond_block"))
            .sleeper(Blocks.QUARTZ_SLAB)
            .rails(Items.QUARTZ)
            .standardModels()
            .build();

    public static void register() {}
}
