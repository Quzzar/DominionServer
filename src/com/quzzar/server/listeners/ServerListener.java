package com.quzzar.server.listeners;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.quzzar.server.packets.PacketMessage;
import com.quzzar.server.packets.WorldUpdatePacket;

import java.util.Date;

public class ServerListener extends Listener {

    @Override
    public void connected(Connection c) {
        super.connected(c);
        System.out.println("Received a connection from "+ c.getRemoteAddressTCP().getHostString()+"!");

        // Create a message packet
        PacketMessage packetMessage = new PacketMessage();
        packetMessage.setMessage("Hello friend! The time is: "+new Date().toString());
        
        WorldUpdatePacket worldUpdatePacket = new WorldUpdatePacket();
        worldUpdatePacket.worldHeight = 5000;
        worldUpdatePacket.worldWidth = 6000;

        // Send message
        c.sendTCP(packetMessage);
        c.sendTCP(worldUpdatePacket);
        /*
        Could also use
        c.sendUDP(packetMessage)
        to send over UDP
         */
    }

    @Override
    public void disconnected(Connection c) {
        super.disconnected(c);
        System.out.println("A client disconnected!");
    }

    @Override
    public void received(Connection c, Object packet) {
        super.received(c, packet);
        System.out.println("Received a packet?!? "+packet.toString());
        // Do nothing, we don't expect to receive any packets.
    }

    @Override
    public void idle(Connection c) {
        super.idle(c);
        // Do nothing.
    }
}
