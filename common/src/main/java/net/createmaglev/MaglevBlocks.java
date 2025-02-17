package net.createmaglev;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.*;
import com.simibubi.create.content.trains.track.TrackBlock;

public class MaglevBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateMaglev.MOD_ID);

	public static final BlockEntry<TrackBlock> MAGLEV_RAIL_BLOCK = REGISTRATE.block("maglev_rail", properties -> new TrackBlock(Block.Properties.of(Material.METAL).strength(2.0f))).register();

	public static void init() {
		// load the class and register everything
		CreateMaglev.LOGGER.info("Registering blocks for " + CreateMaglev.NAME);
		MAGLEV_RAIL_BLOCK.get();
	}
}