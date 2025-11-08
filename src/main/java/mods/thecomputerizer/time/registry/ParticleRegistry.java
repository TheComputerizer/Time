package mods.thecomputerizer.time.registry;

import mods.thecomputerizer.time.client.particle.ParticleAscii.Factory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static mods.thecomputerizer.time.core.TimeRef.LOGGER;
import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static net.minecraftforge.fml.relauncher.Side.CLIENT;

@EventBusSubscriber(modid=MODID, value=CLIENT)
public final class ParticleRegistry {

    public static final ResourceLocation PARTICLE_TEXTURES = new ResourceLocation("textures/particle/particles.png");
    private static final Class<?>[] PARTICLE_INIT_CLASSES = {String.class,int.class,boolean.class};
    public static final EnumParticleTypes RANDOM_ASCII = registerParticle("RANDOM_ASCII",true);
    private static TextureAtlasSprite FONT_ATLAS = null;
    
    private static String camelName(String snakeName) {
        if(Objects.isNull(snakeName) || snakeName.isEmpty()) return "";
        String[] split = snakeName.split("_");
        if(split.length==0) return "";
        StringBuilder builder = new StringBuilder(split[0]);
        for(int i=1;i<split.length;i++) { //don't worry about edge cases yet and assume the first char is alphabetic
            String word = split[i];
            if(word.isEmpty()) continue;
            builder.append(word.substring(0,1).toUpperCase()).append(word.substring(1));
        }
        return builder.toString();
    }

    @SuppressWarnings("SameParameterValue")
    private static EnumParticleTypes registerParticle(String name, boolean ignoreRange) {
        String camelName = camelName(name);
        int id = EnumParticleTypes.values().length;
        LOGGER.info("Registering particle with name {}",camelName);
        EnumParticleTypes ret = EnumHelper.addEnum(EnumParticleTypes.class,name,PARTICLE_INIT_CLASSES,camelName,id,ignoreRange);
        if(Objects.isNull(ret)) {
            LOGGER.error("Failed to register particle {}!", camelName);
            return null;
        }
        //TODO Make the AccessTransformer functional
        //EnumParticleTypes.PARTICLES.put(ret.getParticleID(),ret);
        //EnumParticleTypes.BY_NAME.put(ret.getParticleName(),ret);
        return ret;
    }

    @SubscribeEvent @SideOnly(CLIENT)
    public static void stitchEvent(TextureStitchEvent.Pre ev) {
        //String texPath = Minecraft.getMinecraft().fontRenderer.locationFontTexture.getPath();
        //texPath = texPath.substring(0,texPath.lastIndexOf(".")).replace("textures/","");
        //FONT_ATLAS = ev.getMap().registerSprite(new ResourceLocation(texPath));
    }

    @SideOnly(CLIENT)
    public static void postInit() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(RANDOM_ASCII.getParticleID(),new Factory());
    }

    @SideOnly(CLIENT)
    public static TextureAtlasSprite getFontAtlas() {
        return FONT_ATLAS;
    }
}