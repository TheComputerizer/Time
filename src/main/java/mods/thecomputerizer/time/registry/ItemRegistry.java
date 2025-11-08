package mods.thecomputerizer.time.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static mods.thecomputerizer.time.registry.RegistryHandler.SHADER_PLAYGROUND_TAB;

public final class ItemRegistry {

    private static final List<Item> ALL_ITEMS = new ArrayList<>();
    
    @SuppressWarnings("unused")
    private static <I extends Item> I make(final String name, final Supplier<I> constructor) {
        return make(name,constructor,null);
    }

    @SuppressWarnings("SameParameterValue")
    private static <I extends Item> I make(final String name, final Supplier<I> constructor,
            final @Nullable Consumer<I> config) {
        final I item = constructor.get();
        item.setCreativeTab(SHADER_PLAYGROUND_TAB);
        item.setMaxStackSize(1);
        item.setTranslationKey(MODID+"."+name);
        item.setRegistryName(MODID,name);
        if(Objects.nonNull(config)) config.accept(item);
        ALL_ITEMS.add(item);
        return item;
    }

    @SuppressWarnings("unused")
    private static ItemBlock makeEpicBlock(final Block constructor) {
        return makeEpicBlock(constructor,null);
    }
    
    @SuppressWarnings("SameParameterValue")
    private static ItemBlock makeEpicBlock(final Block constructor,
            final @Nullable Consumer<ItemBlock> config) {
        final ItemBlock item = new ItemBlock(constructor);
        item.setCreativeTab(SHADER_PLAYGROUND_TAB);
        item.setMaxStackSize(1);
        item.setRegistryName(Objects.requireNonNull(constructor.getRegistryName()));
        item.setTranslationKey(constructor.getTranslationKey());
        if(Objects.nonNull(config)) config.accept(item);
        ALL_ITEMS.add(item);
        return item;
    }

    public static Item[] getItems() {
        return ALL_ITEMS.toArray(new Item[0]);
    }
}