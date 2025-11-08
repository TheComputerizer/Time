package mods.thecomputerizer.time.registry.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IRarity;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.item.EnumRarity.EPIC;

@SuppressWarnings("unused")
public class EpicItem extends Item {

    @Override public @NotNull IRarity getForgeRarity(@NotNull ItemStack stack) {
        return EPIC;
    }
}