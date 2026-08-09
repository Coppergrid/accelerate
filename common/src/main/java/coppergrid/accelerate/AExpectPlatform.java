package coppergrid.accelerate;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import coppergrid.accelerate.content.bogey.HighSpeedBogeyBlock;
import coppergrid.accelerate.content.bogey.MaglevBogeyBlock;
import coppergrid.accelerate.content.track.HighSpeedTrackBlock;
import coppergrid.accelerate.content.track.MaglevTrackBlock;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class AExpectPlatform {
    /**
     * an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * Expect: net.examplemod.ExampleExpectPlatform#platformName()
     * Actual Fabric: net.examplemod.fabric.ExampleExpectPlatformImpl#platformName()
     * Actual Forge: net.examplemod.forge.ExampleExpectPlatformImpl#platformName()
     * <p>
     * <a href="https://plugins.jetbrains.com/plugin/16210-architectury">You should also get the IntelliJ plugin to help with @ExpectPlatform.</a>
     */

    @ExpectPlatform
    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedTrackBlock, P>> highSpeedTrackDatagen() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevTrackBlock, P>> maglevTrackDatagen() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <P> NonNullUnaryOperator<BlockBuilder<HighSpeedBogeyBlock, P>> highSpeedBogeyDatagen() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <P> NonNullUnaryOperator<BlockBuilder<MaglevBogeyBlock, P>> maglevBogeyDatagen() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String platformName() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
