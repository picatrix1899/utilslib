package cmn.utilslib.net.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.SimpleThread;
import cmn.utilslib.net.common.IngoingPacket;
import cmn.utilslib.net.common.OutgoingPacket;
import cmn.utilslib.net.common.Packet;
import cmn.utilslib.net.common.PacketFactory;

public class ServerCore 
{

	private ServerSocket socket;
	
	private volatile boolean isRunning;
	
	private ArrayList<ServerClientConnection> connections = Auto.ArrayList();

	private PacketFactory factory;
	
	
	public ServerCore(String address, int port, int maxConnections)
	{
		try
		{
			this.socket = new ServerSocket(port, maxConnections, InetAddress.getByName(address));
			this.factory = new PacketFactory();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addPacket(long id, Class<? extends Packet> p)
	{
		if(OutgoingPacket.class.isAssignableFrom(p))
			this.factory.registerOutgoingPacketTemplate(id, p.asSubclass(OutgoingPacket.class));
		
		if(IngoingPacket.class.isAssignableFrom(p))
			this.factory.registerIngoingPacketTemplate(id, p.asSubclass(IngoingPacket.class));
	}
	
	public void start()
	{
		if(!isRunning)
		{
			this.factory.lock();
			this.isRunning = true;
			new SimpleThread(() -> run()).start();			
		}
	}
	
	public void broadcastPacket(OutgoingPacket p)
	{
		for(ServerClientConnection c : this.connections)
		{
			c.sendPacket(p);
		}
	}
	
	public void stop()
	{
		this.isRunning = false;
	}
	
	public void run()
	{
		try
		{
			while(isRunning && ! socket.isClosed())
				retriveConnection();
			
			socket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void retriveConnection() throws Exception
	{
		Socket s = socket.accept();
		
		s.setKeepAlive(true);
		
		ServerClientConnection connection = new ServerClientConnection(this, s);
		
		joinConnection(connection);
	}
	
	public PacketFactory getPacketFactory()
	{
		return this.factory;
	}
	
	public synchronized void joinConnection(ServerClientConnection c)
	{
		this.connections.add(c);
	}
	
	public synchronized void quitConnection(ServerClientConnection c)
	{
		this.connections.remove(c);
	}
	
}
