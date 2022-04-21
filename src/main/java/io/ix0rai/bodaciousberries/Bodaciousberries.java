package io.ix0rai.bodaciousberries;

import io.ix0rai.bodaciousberries.compat.Compat;
import io.ix0rai.bodaciousberries.registry.Berries;
import io.ix0rai.bodaciousberries.registry.BodaciousBlocks;
import io.ix0rai.bodaciousberries.registry.Bushes;
import io.ix0rai.bodaciousberries.registry.Juices;
import io.ix0rai.bodaciousberries.registry.Sounds;
import io.ix0rai.bodaciousberries.worldgen.BerryBushPatchGen;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.apache.logging.log4j.Logger;

public class Bodaciousberries implements ModInitializer {
    public static final String MOD_ID = "bodaciousberries";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static Identifier id(String path) {
        return new Identifier(idString(path));
    }

    public static String idString(String path) {
        return MOD_ID + ":" + path;
    }

    @Override
    public void onInitialize(ModContainer mod) {
        Bushes.registerBushes();
        Berries.registerBerries();
        BodaciousBlocks.registerBlocks();
        Juices.registerJuice();
        Sounds.registerSounds();
        BerryBushPatchGen.register();
        Compat.registerCompat();
    }
}
