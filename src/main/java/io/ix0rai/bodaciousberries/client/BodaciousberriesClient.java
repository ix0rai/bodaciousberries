package io.ix0rai.bodaciousberries.client;

import io.ix0rai.bodaciousberries.block.entity.BerryHarvesterScreen;
import io.ix0rai.bodaciousberries.block.entity.JuicerScreen;
import io.ix0rai.bodaciousberries.particle.Particles;
import io.ix0rai.bodaciousberries.registry.Berries;
import io.ix0rai.bodaciousberries.registry.BodaciousBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

@Environment(EnvType.CLIENT)
public class BodaciousberriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        HandledScreens.register(BodaciousBlocks.BERRY_HARVESTER_SCREEN_HANDLER, BerryHarvesterScreen::new);
        HandledScreens.register(BodaciousBlocks.JUICER_SCREEN_HANDLER, JuicerScreen::new);

        for (var entry : Berries.BERRY_BUSHES.entrySet()) {
            //ensure bush is rendered with a cutout
            BlockRenderLayerMap.put(RenderLayer.getCutout(), entry.getKey().getBaseState().getBlock());
        }

        Particles.registerParticles();
    }
}
