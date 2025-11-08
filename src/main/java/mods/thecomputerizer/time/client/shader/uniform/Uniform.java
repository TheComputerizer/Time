package mods.thecomputerizer.time.client.shader.uniform;

import lombok.Getter;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@SideOnly(CLIENT)
@SuppressWarnings("unused")
public abstract class Uniform<U> {

    @Getter private final String name;
    private int uniformID;

    protected Uniform(String name) {
        this.name = name;
    }

    public int getID() {
        return this.uniformID;
    }
    
    public void setID(int id) {
        this.uniformID = id;
    }

    public abstract void upload(float partialTicks, int programID);
}