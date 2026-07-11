package onelink.accelerate.content.components;

import com.simibubi.create.api.behaviour.interaction.ConductorBlockInteractionBehavior;
import net.minecraft.world.level.block.state.BlockState;

public class AutomatedDrivingModule extends ConductorBlockInteractionBehavior {
    @Override
    public boolean isValidConductor(BlockState state) {
        return true;
    }
}
