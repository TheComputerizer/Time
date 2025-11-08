package mods.thecomputerizer.time;

import mods.thecomputerizer.time.registry.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import static mods.thecomputerizer.time.core.TimeRef.DEPENDENCIES;
import static mods.thecomputerizer.time.core.TimeRef.LOGGER;
import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static mods.thecomputerizer.time.core.TimeRef.NAME;
import static mods.thecomputerizer.time.core.TimeRef.VERSION;

@Mod(modid=MODID, name=NAME, version=VERSION, dependencies=DEPENDENCIES)
public class TimeMod {

    public TimeMod() {
        LOGGER.info("Starting mod construction");
        LOGGER.info("Completed mod construction");
    }

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting pre-init");
        RegistryHandler.onPreInit(event);
        LOGGER.info("Completed pre-init");
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        LOGGER.info("Starting init");
        RegistryHandler.onInit(event);
        LOGGER.info("Completed init");
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting post-init");
        RegistryHandler.onPostInit(event);
        LOGGER.info("Completed post-init");
    }

    @EventHandler
    public void start(FMLServerStartingEvent event) {
        LOGGER.info("Running server starting stuff");
        RegistryHandler.onServerStarting(event);
        LOGGER.info("Completed server starting stuff");
    }
}