package coppergrid.accelerate.registry;

import com.simibubi.create.content.trains.track.TrackMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import coppergrid.accelerate.Accelerate;

import static com.simibubi.create.content.trains.track.TrackMaterialFactory.make;

public class ATrackMaterials {

    public static final TrackMaterial
            HIGH_SPEED = make(Accelerate.asResource("high_speed"))
            .lang("High Speed")
            .block(() -> ABlocks.HIGH_SPEED_TRACK_BLOCK)
            .particle(new ResourceLocation("minecraft","block/iron_block"))
            .sleeper(Blocks.STONE_SLAB)
            .standardModels()
            .build(),

        MAGLEV = make(Accelerate.asResource("maglev"))
            .lang("Maglev")
            .block(() -> ABlocks.MAGLEV_TRACK_BLOCK)
            .particle(Accelerate.asResource("block/cobalt"))
            .sleeper(Blocks.QUARTZ_SLAB)
            .standardModels()
            .build();

    public static void register() {}
}
