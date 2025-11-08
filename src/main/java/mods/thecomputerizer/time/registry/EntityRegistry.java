package mods.thecomputerizer.time.registry;

import mods.thecomputerizer.time.core.TimeRef;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder.BuiltEntityEntry;

import java.util.ArrayList;
import java.util.List;

public final class EntityRegistry {

    private static final List<EntityEntry> ALL_ENTRIES = new ArrayList<>();
    private static int entityIdCounter = 0;
    
    private static EntityEntry addEntry(EntityEntry entry) {
        if(entry instanceof BuiltEntityEntry) ((BuiltEntityEntry)entry).addedToRegistry();
        ALL_ENTRIES.add(entry);
        return entry;
    }
    
    @SuppressWarnings("unused")
    private static <E extends Entity> EntityEntry make(
            final String name, final Class<E> entityClass, final int eggColor1, final int eggColor2) {
        return addEntry(EntityEntryBuilder.create().entity(entityClass)
                .tracker(100,1,true).egg(eggColor1,eggColor2).name(name)
                .id(TimeRef.res(name),entityIdCounter++).build());
    }

    public static EntityEntry[] getEntityEntries() {
        return ALL_ENTRIES.toArray(new EntityEntry[0]);
    }
}