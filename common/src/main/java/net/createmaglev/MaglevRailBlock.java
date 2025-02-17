package net.createmaglev;

import com.simibubi.create.content.trains.track.TrackBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class MaglevRailBlock extends TrackBlock {
    public MaglevRailBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(2.0f));
    }
}