package mods.thecomputerizer.time.registry;

import mods.thecomputerizer.time.registry.biomes.PlaygroundBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;

import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static net.minecraftforge.common.BiomeDictionary.Type.VOID;
import static net.minecraftforge.common.BiomeManager.BiomeType.COOL;

public class BiomeRegistry {

    private static final Map<Biome,Consumer<Biome>> ALL_BIOMES = new HashMap<>();
    public static final PlaygroundBiome PLAYGROUND = make("playground_biome",PlaygroundBiome::new,biome -> {
        BiomeManager.addBiome(COOL,new BiomeEntry(biome,1));
        BiomeDictionary.addTypes(biome,VOID);
    });

    @SuppressWarnings("SameParameterValue")
    private static <B extends Biome> B make(final String name,
            final Function<String,B> constructor, final Consumer<Biome> onDictionaryInit) {
        final B biome = constructor.apply(name);
        biome.setRegistryName(MODID,name);
        ALL_BIOMES.put(biome,onDictionaryInit);
        return biome;
    }

    public static Biome[] getBiomes() {
        return ALL_BIOMES.keySet().toArray(new Biome[0]);
    }

    public static void initBiomeInfo() {
        for(Entry<Biome,Consumer<Biome>> entry : ALL_BIOMES.entrySet())
            entry.getValue().accept(entry.getKey());
    }
}