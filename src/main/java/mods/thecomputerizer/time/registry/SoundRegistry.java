package mods.thecomputerizer.time.registry;

import mods.thecomputerizer.time.core.TimeRef;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public final class SoundRegistry {

    private static final List<SoundEvent> ALL_SOUNDS = new ArrayList<>();
    @SuppressWarnings("unused")
    public static final SoundEvent BELL = makeSoundEvent("bell");
    @SuppressWarnings("unused")
    public static final SoundEvent REVERSE_BELL = makeSoundEvent("reversebell");

    private static SoundEvent makeSoundEvent(final String name) {
        ResourceLocation id = TimeRef.res(name);
        SoundEvent sound = new SoundEvent(id).setRegistryName(name);
        ALL_SOUNDS.add(sound);
        return sound;
    }

    public static SoundEvent[] getSounds() {
        return ALL_SOUNDS.toArray(new SoundEvent[0]);
    }
}