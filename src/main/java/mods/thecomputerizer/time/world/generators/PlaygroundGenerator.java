package mods.thecomputerizer.time.world.generators;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

import static net.minecraft.init.Blocks.BEDROCK;
import static net.minecraft.init.Blocks.STONE;

public class PlaygroundGenerator implements IChunkGenerator {
    
    private static final int HEIGHT = 64;
    private static final IBlockState FILLER_STATE = STONE.getDefaultState();
    private static final IBlockState BOTTOM_STATE = BEDROCK.getDefaultState();
    private final World world;
    private final Random rand;

    public PlaygroundGenerator(World world) {
        this.world = world;
        this.rand = new Random();
    }

    @Override public Chunk generateChunk(int x, int z) {
        this.rand.setSeed(this.world.getSeed()+(long)x*341873128712L+(long)z*132897987541L);
        ChunkPrimer primer = new ChunkPrimer();
        for(int cx=0;cx<16;cx++) {
            for(int cy=0;cy<=HEIGHT;cy++) {
                IBlockState state = cy==0 ? BOTTOM_STATE : FILLER_STATE;
                for(int cz=0;cz<16;cz++) primer.setBlockState(cx,cy,cz,state);
            }
        }
        return new Chunk(this.world, primer,x,z);
    }

    @Override public void populate(int x, int z) {}

    @Override public boolean generateStructures(Chunk chunk, int x, int z) {
        return false;
    }

    @Override public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType type, BlockPos pos) {
        Biome biome = this.world.getBiome(pos);
        return biome.getSpawnableList(type);
    }

    @Override public @Nullable BlockPos getNearestStructurePos(World world, String name, BlockPos pos,
            boolean findUnexplored) {
        return null;
    }

    @Override public void recreateStructures(Chunk chunk, int x, int z) {}

    @Override public boolean isInsideStructure(World world, String name, BlockPos pos) {
        return false;
    }
}