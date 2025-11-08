package mods.thecomputerizer.time.core;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeRef {

    public static final boolean CLIENT = FMLLaunchHandler.side().isClient();
    public static final String DEPENDENCIES = "";
    public static final String MODID = "${mod_id}";
    public static final String NAME = "${name}";
    public static final Logger LOGGER = LogManager.getLogger("${name} Mod");
    public static final String VERSION = "${version}";

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MODID,path);
    }
}
