package coppergrid.accelerate.registry;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import coppergrid.accelerate.Accelerate;

public class ASpriteShifts {

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, Accelerate.asResource("block/" + blockTextureName),
                Accelerate.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    public static final CTSpriteShiftEntry
            HIGH_SPEED_RAILWAY_CASING = omni("high_speed_railway_casing"),
            HIGH_SPEED_RAILWAY_CASING_SIDE = omni("high_speed_railway_casing_side"),
            MAGLEV_RAILWAY_CASING = omni("maglev_railway_casing"),
            MAGLEV_RAILWAY_CASING_SIDE = omni("maglev_railway_casing_side");
}
