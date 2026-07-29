package coppergrid.accelerate.datagen;

import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackShape;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;

import coppergrid.accelerate.Accelerate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile; // FABRIC ONLY

public class CustomTrackBlockStateGenerator extends SpecialBlockStateGen {
    private final String path;

    // Constructor to set the specific model folder (e.g., "high_speed" or "maglev")
    public CustomTrackBlockStateGenerator(String path) {
        this.path = path;
    }

    @Override
    protected int getXRotation(BlockState state) {
        return 0;
    }

    @Override
    protected int getYRotation(BlockState state) {
        return state.getValue(TrackBlock.SHAPE)
                .getModelRotation();
    }

    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov,
                                                BlockState state) {
        TrackShape value = state.getValue(TrackBlock.SHAPE);
        if (value == TrackShape.NONE)
            return prov.models()
                    .getExistingFile(prov.mcLoc("block/air"));
        return prov.models()
                .getExistingFile(Accelerate.asResource("block/track/" + path + "/" + value.getModel()));
    }

}
