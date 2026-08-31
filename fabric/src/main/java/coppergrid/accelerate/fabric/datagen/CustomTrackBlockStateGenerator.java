package coppergrid.accelerate.fabric.datagen;

import com.simibubi.create.Create;
import com.simibubi.create.content.trains.track.TrackBlock;
import com.simibubi.create.content.trains.track.TrackShape;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;

import coppergrid.accelerate.Accelerate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile; // FABRIC ONLY
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockModelBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> textureMap = getTextureMap(value);

        BlockModelBuilder builder = prov.models()
                .withExistingParent(
                        "block/track/" + path + "/" + value.getModel(),
                        Create.asResource("block/track/" + value.getModel())
                )
                .texture(
                        "particle",
                        Accelerate.asResource("block/raw_cobalt_block")
                );

        for (Map.Entry<String, String> entry : textureMap.entrySet()) {
            builder.texture(entry.getKey(), Accelerate.asResource("block/" + entry.getValue()));
        }
        generateTrackSegments(prov);

        return builder;
    }

    private @NotNull Map<String, String> getTextureMap(TrackShape value) {
        Map<String, String> textureMap = new HashMap<>();

        switch (value) {
            case TE, TN, TS, TW -> {
                textureMap.put("1", path + "_track");
                textureMap.put("2", path + "_track_mip");
                textureMap.put("3", path + "_track");
            }

            case AE, AW, AN, AS -> {
                textureMap.put("0", path + "_track");
                textureMap.put("1", path + "_track_mip");
            }

            case CR_O, XO, ZO -> {
                textureMap.put("1", path + "_track");
                textureMap.put("2", path + "_track_mip");
                textureMap.put("3", path + "_track_crossing");
            }

            default -> {
                textureMap.put("0", path + "_track");
                textureMap.put("1", path + "_track_mip");
                textureMap.put("2", path + "_track_crossing");
            }
        }
        return textureMap;
    }

    private void generateTrackSegments(RegistrateBlockstateProvider prov) {
        String prefix = "block/track/" + path + "/";

        for (String part : new String[]{"segment_left", "segment_right"}) {
            prov.models()
                    .withExistingParent(prefix + part, Create.asResource("block/track/" + part))
                    .texture("0", Accelerate.asResource("block/" + path + "_track"))
                    .texture("1", Accelerate.asResource("block/" + path + "_track_mip"))
                    .texture("particle", Accelerate.asResource("block/raw_cobalt_block"));
        }

        for (String part : new String[]{"tie"}) {
            prov.models()
                    .withExistingParent(prefix + part, Create.asResource("block/track/" + part))
                    .renderType(new ResourceLocation("minecraft", "cutout_mipped"))
                    .texture("0", Accelerate.asResource("block/" + path + "_track"))
                    .texture("1", Accelerate.asResource("block/" + path + "_track_mip"))
                    .texture("particle", Accelerate.asResource("block/raw_cobalt_block"));
        }
    }

}
