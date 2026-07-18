package coppergrid.accelerate.content.bogey;

import com.simibubi.create.content.trains.bogey.AbstractBogeyBlockEntity;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import coppergrid.accelerate.registry.ABogeyStyles;

public class HighSpeedBogeyBlockEntity extends AbstractBogeyBlockEntity {

    public HighSpeedBogeyBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        return ABogeyStyles.HIGH_SPEED;
    }
}
