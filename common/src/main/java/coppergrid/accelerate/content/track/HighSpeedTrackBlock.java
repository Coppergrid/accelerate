package coppergrid.accelerate.content.track;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.content.trains.track.TrackShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.ATrackMaterials;

public class HighSpeedTrackBlock extends TrackBlock {
    public HighSpeedTrackBlock(Properties properties) {
        super(properties, ATrackMaterials.HIGH_SPEED);
    }

    @Override
    public TrackMaterial getMaterial() {
        return ATrackMaterials.HIGH_SPEED;
    }

    @Override
    public BlockState getBogeyAnchor(BlockGetter world, BlockPos pos, BlockState state) {
        return ABlocks.SMALL_HIGH_SPEED_BOGEY.getDefaultState()
                .setValue(BlockStateProperties.HORIZONTAL_AXIS, state.getValue(SHAPE) == TrackShape.XO ? Axis.X : Axis.Z);
    }
}