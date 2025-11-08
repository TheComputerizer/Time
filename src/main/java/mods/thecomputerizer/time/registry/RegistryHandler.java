package mods.thecomputerizer.time.registry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static mods.thecomputerizer.time.core.TimeRef.LOGGER;
import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static net.minecraft.init.Blocks.BEDROCK;
import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@EventBusSubscriber(modid=MODID)
public final class RegistryHandler {

    public static final CreativeTabs SHADER_PLAYGROUND_TAB = new CreativeTabs(MODID) {
        @SideOnly(CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(BEDROCK);
        }
    };

    public static void onPreInit(FMLPreInitializationEvent ignored) {
        DimensionRegistry.register();
    }

    public static void onInit(FMLInitializationEvent ignored) {
        BiomeRegistry.initBiomeInfo();
    }

    public static void onPostInit(FMLPostInitializationEvent event) {
        if(event.getSide().isClient()) ParticleRegistry.postInit();
    }

    public static void onServerStarting(FMLServerStartingEvent ignored) {
        LOGGER.info("Registering commands");
    }

    @SubscribeEvent
    public static void registerBiomes(Register<Biome> event) {
        register(event,BiomeRegistry.getBiomes());
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        register(event,BlockRegistry.getBlocks());
        //GameRegistry.registerTileEntity();
    }

    @SubscribeEvent
    public static void registerEntities(Register<EntityEntry> event) {
        register(event,EntityRegistry.getEntityEntries());
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        register(event,ItemRegistry.getItems());
    }

    @SubscribeEvent
    public static void updateMappings(MissingMappings<Item> event) {}

    @SubscribeEvent
    public static void registerSoundEvents(Register<SoundEvent> event) {
        register(event,SoundRegistry.getSounds());
    }

    private static <E extends IForgeRegistryEntry<E>> void register(Register<E> event, E[] toRegister) {
        event.getRegistry().registerAll(toRegister);
    }
}