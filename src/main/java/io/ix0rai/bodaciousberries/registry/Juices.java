package io.ix0rai.bodaciousberries.registry;

import io.ix0rai.bodaciousberries.Bodaciousberries;
import io.ix0rai.bodaciousberries.block.entity.JuicerRecipes;
import io.ix0rai.bodaciousberries.registry.items.ChorusBerryJuice;
import io.ix0rai.bodaciousberries.registry.items.Juice;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.List;

import static net.minecraft.world.biome.BiomeKeys.*;

public class Juices {
    public static final Item RECEPTACLE = Items.GLASS_BOTTLE;
    private static final Item.Settings JUICE_SETTINGS = new Item.Settings().recipeRemainder(RECEPTACLE).group(ItemGroup.FOOD).maxCount(16);

    public static void registerJuice() {
        register("saskatoon_berry_juice", new Juice(Berries.SASKATOON_BERRIES));
        register("strawberry_juice", new Juice(Berries.STRAWBERRY));
        register("raspberry_juice", new Juice(Berries.RASPBERRIES));
        register("blackberry_juice", new Juice(Berries.BLACKBERRIES));
        register("rainberry_juice", new Juice(Berries.RAINBERRY));
        register("lingonberry_juice", new Juice(Berries.LINGONBERRIES));
        register("grape_juice", new Juice(Berries.GRAPES));
        register("goji_berry_juice", new Juice(Berries.GOJI_BERRIES));
        register("gooseberry_juice", new Juice(Berries.GOOSEBERRIES));

        createChorusBerryJuice(List.of(
                PLAINS, SNOWY_SLOPES, SWAMP,
                DESERT, TAIGA, BIRCH_FOREST,
                OCEAN, MUSHROOM_FIELDS, SUNFLOWER_PLAINS,
                FOREST, FLOWER_FOREST, DARK_FOREST,
                SAVANNA, BADLANDS, MEADOW,
                LUSH_CAVES, DRIPSTONE_CAVES, JUNGLE
        ));
    }

    private static void register(String name, Juice juice) {
        JuicerRecipes.addRecipe(juice.getBerry(), juice);
        Registry.register(Registry.ITEM, Bodaciousberries.getIdentifier(name), juice);
    }

    public static Item.Settings settings(int hunger, float saturation) {
        return JUICE_SETTINGS.food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build());
    }

    private static void createChorusBerryJuice(List<RegistryKey<Biome>> biomes) {
        register("chorus_berry_juice", new ChorusBerryJuice(Berries.CHORUS_BERRIES, null));

        for (RegistryKey<Biome> key : biomes) {
            ChorusBerryJuice juice = chorusBerryJuice(key);
            String name = "chorus_berry_juice_" + key.getValue().getPath();
            Registry.register(Registry.ITEM, Bodaciousberries.getIdentifier(name), juice);
        }
    }

    private static ChorusBerryJuice chorusBerryJuice(RegistryKey<Biome> biome) {
        return new ChorusBerryJuice(Berries.CHORUS_BERRIES, biome.getValue());
    }
}