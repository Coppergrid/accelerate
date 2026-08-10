package coppergrid.accelerate.datagen.advancement;

import com.simibubi.create.AllBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.network.chat.Component;
import coppergrid.accelerate.Accelerate;
import coppergrid.accelerate.registry.ABlocks;
import coppergrid.accelerate.registry.AItems;
import net.minecraft.advancements.FrameType;

import java.util.function.Consumer;

public class AdvancementGen {
    public static void generate(Consumer<Advancement> consumer) {

        // ROOT (Tab name)
        Advancement root = Advancement.Builder.advancement()
                .display(
                        AllBlocks.TRACK.asItem(),
                        Component.translatable("advancement.accelerate.root.title"),
                        Component.translatable("advancement.accelerate.root.description"),
                        Accelerate.asResource("textures/block/cobalt_block.png"),
                        FrameType.TASK,
                        false, false, true
                )
                .addCriterion("has_track",
                        InventoryChangeTrigger.TriggerInstance.hasItems(AllBlocks.TRACK.asItem())
                )
                .build(Accelerate.asResource("root"));

        // HIGH SPEED TRACK
        Advancement high_speed_track = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem(),
                        Component.translatable("advancement.accelerate.high_speed_track.title"),
                        Component.translatable("advancement.accelerate.high_speed_track.description"),
                        null,
                        FrameType.GOAL,
                        true, true, false
                )
                .addCriterion("has_high_speed_track",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem())
                )
                .build(Accelerate.asResource("high_speed_track"));

        // COBALT
        Advancement cobalt_ingot = Advancement.Builder.advancement()
                .parent(high_speed_track)
                .display(
                        AItems.COBALT_INGOT,
                        Component.translatable("advancement.accelerate.cobalt_ingot.title"),
                        Component.translatable("advancement.accelerate.cobalt_ingot.description"),
                        null,
                        FrameType.TASK,
                        true, true, false
                )
                .addCriterion("has_cobalt_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(AItems.COBALT_INGOT)
                )
                .build(Accelerate.asResource("cobalt_ingot"));

        // MAGNETS
        Advancement magnetized_cobalt_ingot = Advancement.Builder.advancement()
                .parent(cobalt_ingot)
                .display(
                        AItems.MAGNETIZED_COBALT_INGOT,
                        Component.translatable("advancement.accelerate.magnetized_cobalt_ingot.title"),
                        Component.translatable("advancement.accelerate.magnetized_cobalt_ingot.description"),
                        null,
                        FrameType.TASK,
                        true, true, false
                )
                .addCriterion("has_magnetized_cobalt_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(AItems.MAGNETIZED_COBALT_INGOT)
                )
                .build(Accelerate.asResource("magnetized_cobalt_ingot"));

        Advancement maglev_track = Advancement.Builder.advancement()
                .parent(magnetized_cobalt_ingot)
                .display(
                        ABlocks.MAGLEV_TRACK_BLOCK.asItem(),
                        Component.translatable("advancement.accelerate.maglev_track.title"),
                        Component.translatable("advancement.accelerate.maglev_track.description"),
                        null,
                        FrameType.CHALLENGE,
                        true, true, false
                )
                .addCriterion("has_maglev_track",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ABlocks.MAGLEV_TRACK_BLOCK.asItem())
                )
                .build(Accelerate.asResource("maglev_track"));

        // REGISTER
        consumer.accept(root);
        consumer.accept(high_speed_track);
        consumer.accept(cobalt_ingot);
        consumer.accept(magnetized_cobalt_ingot);
        consumer.accept(maglev_track);
    }
}

