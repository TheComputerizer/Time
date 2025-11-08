package mods.thecomputerizer.time.registry;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static mods.thecomputerizer.time.core.TimeRef.MODID;

public final class BlockRegistry {

    private static final List<Block> ALL_BLOCKS = new ArrayList<>();

    @SuppressWarnings("unused")
    private static Block make(final String name, final Supplier<Block> constructor,
            final Consumer<Block> config) {
        final Block block = constructor.get();
        config.accept(block);
        block.setRegistryName(MODID, name);
        block.setTranslationKey(MODID+"."+name);
        ALL_BLOCKS.add(block);
        return block;
    }

    public static Block[] getBlocks() {
        return ALL_BLOCKS.toArray(new Block[0]);
    }
}