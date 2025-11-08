package mods.thecomputerizer.time.registry;

import mods.thecomputerizer.time.world.providers.PlaygroundProvider;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

import java.util.ArrayList;
import java.util.List;

public class DimensionRegistry {

    private static final List<DimensionType> ALL_DIMENSION_TYPES = new ArrayList<>();
    public static final DimensionType PLAYGROUND = make("playground",696969,PlaygroundProvider.class);

    @SuppressWarnings("SameParameterValue")
    private static DimensionType make(String name, int id, Class<? extends WorldProvider> provider) {
        DimensionType type = DimensionType.register(name,"_"+name.toLowerCase(),id,provider,false);
        ALL_DIMENSION_TYPES.add(type);
        return type;
    }

    public static void register() {
        for(DimensionType type : ALL_DIMENSION_TYPES) DimensionManager.registerDimension(type.getId(),type);
    }
}