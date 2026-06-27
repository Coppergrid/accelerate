package onelink.accelerate.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.content.trains.track.TrackPlacement;
import onelink.accelerate.registry.ATrackMaterials;
import onelink.accelerate.config.AConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(value = TrackPlacement.class, remap = false)
public class TrackRadiusMixin {

    @ModifyExpressionValue(method = "tryConnect", at = { @At(value = "CONSTANT", args = "doubleValue=7.0"), @At(value = "CONSTANT", args = "doubleValue=3.25") })
    private static double accelerate$modifyTurnRadius(double original, Level level, Player player, BlockPos pos2, BlockState state2, ItemStack stack, boolean girder, boolean maximiseTurn) {
        if (TrackMaterial.fromItem(stack.getItem()) == ATrackMaterials.HIGH_SPEED) {
            if (AConfig.SERVER.HighSpeedRealisticRadius.get()) {
                return original * AConfig.SERVER.HighSpeedRadiusMultiplier.get();
            }
            else {
                return original;
            }
        }
        else if (TrackMaterial.fromItem(stack.getItem()) == ATrackMaterials.MAGLEV) {
            if (AConfig.SERVER.MaglevRealisticRadius.get()) {
                return original * AConfig.SERVER.MaglevRadiusMultiplier.get();
            }
            else {
                return original;
            }
        }
        else {
            return original;
        }
    }
}