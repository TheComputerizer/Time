package mods.thecomputerizer.time.client.shader.uniform;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.nio.FloatBuffer;
import java.util.function.Function;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@SideOnly(CLIENT)
@SuppressWarnings("unused")
public class UniformMatrix extends Uniform<Float> {

    private final Function<Float,FloatBuffer> bufferFunc;
    
    public UniformMatrix(String name, Function<Float,FloatBuffer> bufferFunc) {
        super(name);
        this.bufferFunc = bufferFunc;
    }

    @Override public void upload(float partialTicks, int programID) {
        setID(OpenGlHelper.glGetUniformLocation(programID,getName()));
        OpenGlHelper.glUniformMatrix2(getID(),false,this.bufferFunc.apply(partialTicks));
    }
}