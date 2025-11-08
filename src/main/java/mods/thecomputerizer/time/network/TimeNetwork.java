package mods.thecomputerizer.time.network;

import mods.thecomputerizer.time.network.TimePacket.Handler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

import static mods.thecomputerizer.time.core.TimeRef.LOGGER;
import static mods.thecomputerizer.time.core.TimeRef.MODID;
import static net.minecraftforge.fml.common.network.NetworkRegistry.INSTANCE;

public class TimeNetwork {
    
    static int messageID;
    static SimpleNetworkWrapper channel;
    
    private static SimpleNetworkWrapper getChannel() {
        if(Objects.isNull(channel)) channel = INSTANCE.newSimpleChannel(MODID);
        return channel;
    }
    
    public static void registerMessage(Class<? extends TimePacket> packetClass, Side receiverSide) {
        getChannel().registerMessage(new Handler(),packetClass,messageID++,receiverSide);
    }
    
    public static void sendToAll(TimePacket packet) {
        getChannel().sendToAll(packet);
    }
    
    public static void sendToAllAround(TimePacket packet, TargetPoint target) {
        getChannel().sendToAllAround(packet,target);
    }
    
    public static void sendToDimension(TimePacket packet, int dimension) {
        getChannel().sendToDimension(packet,dimension);
    }
    
    public static void sendToPlayer(TimePacket packet, EntityPlayer player) {
        if(player instanceof EntityPlayerMP) getChannel().sendTo(packet,(EntityPlayerMP)player);
        else LOGGER.error("Tried to send packet to player incorrectly! (packet={}|player-{})",packet,player);
    }
    
    public static void sendToServer(TimePacket packet) {
        getChannel().sendToServer(packet);
    }
    
    public static void sendToTracking(TimePacket packet, Entity entity) {
        getChannel().sendToAllTracking(packet,entity);
    }
    
    public static void sendToTracking(TimePacket packet, TargetPoint target) {
        getChannel().sendToAllTracking(packet,target);
    }
}