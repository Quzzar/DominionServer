package com.quzzar.server;

import com.esotericsoftware.kryonet.Server;
import com.quzzar.server.listeners.ServerListener;
import com.quzzar.server.packets.PacketMessage;
import com.quzzar.server.packets.WorldUpdatePacket;

public class ServerProgram {

    // Server object
    private static Server server;

    // Ports to listen on
    private static int udpPort = 27960;
    private static int tcpPort = 27960;

    public void start() throws Exception{
    	
        System.out.println("Connecting to server...");
        // Create server
        server = new Server();

        // Register a packet class
        server.getKryo().register(PacketMessage.class);
        server.getKryo().register(WorldUpdatePacket.class);

        // Bind it to a port
        server.bind(udpPort,tcpPort);

        // Start the server
        server.start();

        // All server listener
        server.addListener(new ServerListener());

        System.out.println("Connected!");
        
    }

}