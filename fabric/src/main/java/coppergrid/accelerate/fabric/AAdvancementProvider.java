package coppergrid.accelerate.fabric;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.advancements.Advancement;

import java.util.function.Consumer;

import coppergrid.accelerate.datagen.advancement.AdvancementGen;

public class AAdvancementProvider extends FabricAdvancementProvider {

    protected AAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        AdvancementGen.generate(consumer);
    }
}