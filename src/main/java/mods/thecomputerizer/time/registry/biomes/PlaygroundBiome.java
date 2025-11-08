package mods.thecomputerizer.time.registry.biomes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraft.world.biome.Biome.TempCategory.COLD;

public class PlaygroundBiome extends Biome {

    public PlaygroundBiome(String name) {
        super(new BiomeProperties(name).setRainDisabled().setWaterColor(2621537));
    }

    @Override public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator() {
            @Override public void decorate(World world, Random rand, Biome biome, BlockPos pos) {}
            
            @Override protected void genDecorations(Biome biome, World world, Random rand) {}
            
            @Override protected void generateOres(World world, Random rand) {}
            
            @Override protected void genStandardOre1(World world, Random rand, int blockCount, WorldGenerator generator,
                    int minHeight, int maxHeight) {}
            
            @Override protected void genStandardOre2(World world, Random rand, int blockCount, WorldGenerator generator,
                    int centerHeight, int spread) {}
        };
    }
    
    @Override public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return new WorldGenAbstractTree(false) {
            @Override public boolean generate(World world, Random rand, BlockPos pos) {
                return true;
            }
            
            @Override protected void setDirtAt(World world, BlockPos pos) {}
        };
    }
    
    @Override public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return new WorldGenerator() {
            @Override public boolean generate(World world, Random rand, BlockPos pos) {
                return true;
            }
        };
    }
    
    @Override public int getSkyColorByTemp(float currentTemperature) {
        return 0;
    }
    
    @Override public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) {
        return new ArrayList<>();
    }
    
    @Override public void decorate(World world, Random rnd, BlockPos pos) {}
    
    @Override public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int x, int z, double noise) {}
    
    @Override public Class<? extends PlaygroundBiome> getBiomeClass() {
        return this.getClass();
    }
    
    @Override public TempCategory getTempCategory() {
        return COLD;
    }
    
    @Override public void addFlower(IBlockState state, int weight) {}
    
    @Override public void plantFlower(World world, Random rand, BlockPos pos) {}
    
    @Override public void addDefaultFlowers() {}
}