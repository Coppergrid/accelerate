package coppergrid.accelerate.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import coppergrid.accelerate.AExpectPlatform;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlockEntity;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlockEntity;

public class ABlockEntityTypes {

    public static final BlockEntityEntry<HighSpeedBogeyBlockEntity> HIGH_SPEED_BOGEY =
            AExpectPlatform.registerHighSpeedBogeyBlockEntity();

    public static final BlockEntityEntry<MaglevBogeyBlockEntity> MAGLEV_BOGEY =
            AExpectPlatform.registerMaglevBogeyBlockEntity();

    public static void init() {}
}
