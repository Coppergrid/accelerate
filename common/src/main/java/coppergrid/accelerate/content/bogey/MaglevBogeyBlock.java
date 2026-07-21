package coppergrid.accelerate.content.bogey;

import com.simibubi.create.api.schematic.requirement.SpecialBlockItemRequirement;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import coppergrid.accelerate.registry.ABlockEntityTypes;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.ABogeyStyles;
import coppergrid.accelerate.registry.ATrackMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Properties;

public class MaglevBogeyBlock extends AbstractBogeyBlock<MaglevBogeyBlockEntity>
        implements IBE<MaglevBogeyBlockEntity>, ProperWaterloggedBlock, SpecialBlockItemRequirement {
    public MaglevBogeyBlock(Properties props, BogeySizes.BogeySize size) {
        super(props, size);
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    public TrackMaterial.TrackType getTrackType(BogeyStyle style) {
        return ATrackMaterials.MAGLEV.trackType;
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
        return ABogeyStyles.MAGLEV;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return ABlocks.MAGLEV_RAILWAY_CASING.asStack();
    }

    @Override
    public Class<MaglevBogeyBlockEntity> getBlockEntityClass() {
        return MaglevBogeyBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MaglevBogeyBlockEntity> getBlockEntityType() {
        return ABlockEntityTypes.MAGLEV_BOGEY.get();
    }
}