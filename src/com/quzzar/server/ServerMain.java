package com.quzzar.server;

public class ServerMain {

	private static ServerProgram server;
	
	public static void main(String[] args) {
		
		server = new ServerProgram();
		
		try {
			server.start();
		} catch (Exception e) {
			System.out.println("Failed to connect!");
			e.printStackTrace();
		}
		
	}
	
}
