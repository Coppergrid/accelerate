package onelink.accelerate.datagen.advancement;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import onelink.accelerate.ABlocks;
import onelink.accelerate.AItems;
import net.minecraft.advancements.FrameType;

import java.util.function.Consumer;

public class AdvancementGen {
    public static void generate(Consumer<Advancement> consumer) {

        // HIGH SPEED TRACK
        Advancement high_speed_track = Advancement.Builder.advancement()
//                .parent(new ResourceLocation("create", "track_0")) // I will add this back once it stops breaking everything and I figure out how to do it
                .display(
                        ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem(),
                        Component.translatable("advancement.accelerate.high_speed_track.title"),
                        Component.translatable("advancement.accelerate.high_speed_track.description"),
                        new ResourceLocation("accelerate", "textures/block/cobalt_block.png"),
                        FrameType.GOAL,
                        true, true, false
                )
                .addCriterion("has_high_speed_track",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ABlocks.HIGH_SPEED_TRACK_BLOCK.asItem())
                )
                .build(new ResourceLocation("accelerate", "high_speed_track"));

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
                .build(new ResourceLocation("accelerate","cobalt_ingot"));

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
                .build(new ResourceLocation("accelerate","magnetized_cobalt_ingot"));

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
                .build(new ResourceLocation("accelerate","maglev_track"));

        // REGISTER
        consumer.accept(high_speed_track);
        consumer.accept(cobalt_ingot);
        consumer.accept(magnetized_cobalt_ingot);
        consumer.accept(maglev_track);
    }
}

