package mods.thecomputerizer.time.client.shader.uniform;

import mods.thecomputerizer.time.client.shader.ShaderManager;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Function;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@SideOnly(CLIENT)
public class UniformFloat extends Uniform<Float> {

    private final Function<Float,Float> valFunc;

    public UniformFloat(String name, Function<Float,Float> valFunc) {
        super(name);
        this.valFunc = valFunc;
    }

    @Override public void upload(float partialTicks, int programID) {
        ShaderManager.getInstance().uploadFloat(programID,getName(),this.valFunc.apply(partialTicks));
    }
}