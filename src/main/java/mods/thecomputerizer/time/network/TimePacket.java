package mods.thecomputerizer.time.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class TimePacket implements IMessage {
    
    public TimePacket() {}
    
    protected abstract void decode(ByteBuf buf);
    protected abstract void encode(ByteBuf buf);
    
    @Override public final void fromBytes(ByteBuf buf) {
        decode(buf);
    }
    
    @Override public final void toBytes(ByteBuf buf) {
        encode(buf);
    }
    
    public static class Handler implements IMessageHandler<TimePacket,IMessage> {
        
        @Override public IMessage onMessage(TimePacket packet, MessageContext ctx) {
            return null;
        }
    }
}