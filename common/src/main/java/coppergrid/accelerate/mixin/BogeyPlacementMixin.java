package coppergrid.accelerate.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.trains.station.StationBlockEntity;
import coppergrid.accelerate.registry.ABlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = StationBlockEntity.class, remap = false)
public class BogeyPlacementMixin {

    @ModifyExpressionValue(method = "trackClicked", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/trains/track/ITrackBlock;getBogeyAnchor(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/block/state/BlockState;"))
    private BlockState accelerate$modifyBogeyAnchor(BlockState original, @Local(name = "handItem") ItemStack handItem) {
        if (handItem.is(ABlocks.HIGH_SPEED_RAILWAY_CASING.asItem())) {
            return ABlocks.SMALL_HIGH_SPEED_BOGEY.getDefaultState()
                    .setValue(BlockStateProperties.HORIZONTAL_AXIS, original.getValue(BlockStateProperties.HORIZONTAL_AXIS));
        }
        return original;
    }
}
