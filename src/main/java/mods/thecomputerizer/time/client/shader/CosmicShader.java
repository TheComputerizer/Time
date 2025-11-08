package mods.thecomputerizer.time.client.shader;

import mods.thecomputerizer.time.core.TimeRef;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@SideOnly(CLIENT)
public class CosmicShader extends Shader {

    public CosmicShader() {
        super(TimeRef.res("shaders/cosmic/cosmic.fsh"),TimeRef.res("shaders/cosmic/cosmic.vsh"));
    }

    @Override public boolean canRender(@Nullable WorldClient world) {
        return Objects.nonNull(world) && world.provider.getDimension()==222;
    }
}