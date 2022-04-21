package io.ix0rai.bodaciousberries.registry;

import io.ix0rai.bodaciousberries.Bodaciousberries;
import io.ix0rai.bodaciousberries.block.BerryHarvesterBlock;
import io.ix0rai.bodaciousberries.block.JuicerBlock;
import io.ix0rai.bodaciousberries.block.entity.BerryHarvesterBlockEntity;
import io.ix0rai.bodaciousberries.block.entity.BerryHarvesterScreenHandler;
import io.ix0rai.bodaciousberries.block.entity.JuicerBlockEntity;
import io.ix0rai.bodaciousberries.block.entity.JuicerScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class BodaciousBlocks {
    public static final Identifier BERRY_HARVESTER = Bodaciousberries.id("berry_harvester");
    public static final BerryHarvesterBlock BERRY_HARVESTER_BLOCK = new BerryHarvesterBlock(QuiltBlockSettings.of(Material.METAL).strength(4.0f));
    public static final BlockEntityType<BerryHarvesterBlockEntity> BERRY_HARVESTER_ENTITY = FabricBlockEntityTypeBuilder.create(BerryHarvesterBlockEntity::new, BERRY_HARVESTER_BLOCK).build(null);
    public static final ScreenHandlerType<BerryHarvesterScreenHandler> BERRY_HARVESTER_SCREEN_HANDLER = new ScreenHandlerType<>(BerryHarvesterScreenHandler::new);

    public static final Identifier JUICER = Bodaciousberries.id("juicer");
    public static final JuicerBlock JUICER_BLOCK = new JuicerBlock(QuiltBlockSettings.of(Material.METAL).strength(4.0f));
    public static final BlockEntityType<JuicerBlockEntity> JUICER_ENTITY = FabricBlockEntityTypeBuilder.create(JuicerBlockEntity::new, JUICER_BLOCK).build(null);
    public static final ScreenHandlerType<JuicerScreenHandler> JUICER_SCREEN_HANDLER = new ScreenHandlerType<>(JuicerScreenHandler::new);

    public static void registerBlocks() {
        registerBlockEntity(BERRY_HARVESTER, BERRY_HARVESTER_BLOCK, BERRY_HARVESTER_ENTITY, BERRY_HARVESTER_SCREEN_HANDLER);
        registerBlockItem(BERRY_HARVESTER, BERRY_HARVESTER_BLOCK, ItemGroup.REDSTONE);

        registerBlockEntity(JUICER, JUICER_BLOCK, JUICER_ENTITY, JUICER_SCREEN_HANDLER);
        registerBlockItem(JUICER, JUICER_BLOCK, ItemGroup.BREWING);
    }

    private static void registerBlockEntity(Identifier id, Block block, BlockEntityType<?> entity, ScreenHandlerType<?> handler) {
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.SCREEN_HANDLER, id, handler);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Bodaciousberries.id(id.getPath() + "_entity"), entity);
    }

    private static void registerBlockItem(Identifier id, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, id, new BlockItem(block, new Settings().group(group)));
    }
}
