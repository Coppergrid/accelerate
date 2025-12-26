package onelink.accelerate;

import com.simibubi.create.content.trains.track.TrackMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import static com.simibubi.create.content.trains.track.TrackMaterialFactory.make;

public class ATrackMaterials {

    public static final TrackMaterial
            HIGH_SPEED = make(new ResourceLocation("accelerate", "high_speed"))
            .lang("High Speed")
            .block(() -> ABlocks.HIGH_SPEED_TRACK_BLOCK)
            .particle(new ResourceLocation("block/iron_block"))
            .sleeper(Blocks.STONE_SLAB)
            .standardModels()
            .build(),

        MAGLEV = make(new ResourceLocation("accelerate", "maglev"))
            .lang("Maglev")
            .block(() -> ABlocks.MAGLEV_TRACK_BLOCK)
            .particle(new ResourceLocation("block/cobalt"))
            .sleeper(Blocks.QUARTZ_SLAB)
            .standardModels()
            .build();

    public static void register() {}
}
