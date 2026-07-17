package onelink.accelerate.content.bogey;


import com.google.common.collect.ImmutableSet;
import com.simibubi.create.api.schematic.requirement.SpecialBlockItemRequirement;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.content.trains.entity.TravellingPoint;
import com.simibubi.create.content.trains.graph.TrackEdge;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import onelink.accelerate.registry.ABlockEntityTypes;
import onelink.accelerate.registry.ABlocks;
import onelink.accelerate.registry.ABogeyStyles;
import onelink.accelerate.registry.ATrackMaterials;

import java.util.Set;

public class HighSpeedBogeyBlock extends AbstractBogeyBlock<HighSpeedBogeyBlockEntity>
        implements IBE<HighSpeedBogeyBlockEntity>, ProperWaterloggedBlock, SpecialBlockItemRequirement {

    public HighSpeedBogeyBlock(Properties props, BogeySizes.BogeySize size) {
        super(props, size);
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    public TrackMaterial.TrackType getTrackType(BogeyStyle style) {
        return ATrackMaterials.HIGH_SPEED.trackType;
    }

    @Override
    public double getWheelPointSpacing() {
        return 2;
    }

    @Override
    public double getWheelRadius() {
        return (size == BogeySizes.LARGE ? 12.5 : 6.5) / 16d;
    }

    @Override
    public Vec3 getConnectorAnchorOffset() {
        return new Vec3(0, 7 / 32f, 1);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        return ABogeyStyles.HIGH_SPEED;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return ABlocks.HIGH_SPEED_RAILWAY_CASING.asStack();
    }

    @Override
    public Class<HighSpeedBogeyBlockEntity> getBlockEntityClass() {
        return HighSpeedBogeyBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends HighSpeedBogeyBlockEntity> getBlockEntityType() {
        return ABlockEntityTypes.HIGH_SPEED_BOGEY.get();
    }

    @Override
    public Set<TrackMaterial.TrackType> getValidPathfindingTypes(BogeyStyle style) {
        return ImmutableSet.of(
                TrackMaterial.TrackType.STANDARD,
                ATrackMaterials.HIGH_SPEED.trackType
        );
    }

    @Override
    public boolean isOnIncompatibleTrack(Carriage carriage, boolean leading) {
        TravellingPoint point = leading ? carriage.getLeadingPoint() : carriage.getTrailingPoint();
        CarriageBogey bogey = leading ? carriage.leadingBogey() : carriage.trailingBogey();
        TrackEdge currentEdge = point.edge;
        if (currentEdge == null)
            return false;
        TrackMaterial.TrackType currentType = currentEdge.getTrackMaterial().trackType;
        return !getValidPathfindingTypes(bogey.getStyle()).contains(currentType);
    }

}

