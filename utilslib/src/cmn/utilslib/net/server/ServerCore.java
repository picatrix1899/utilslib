package cmn.utilslib.net.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.net.common.IngoingPacket;
import cmn.utilslib.net.common.OutgoingPacket;
import cmn.utilslib.net.common.Packet;
import cmn.utilslib.net.common.PacketFactory;

public class ServerCore implements Runnable
{

	private ServerSocket socket;
	
	private volatile boolean isRunning;
	
	private ArrayList<ServerClientConnection> connections = Auto.ArrayList();
	
	private Thread th;
	
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
			this.isRunning = true;
			this.th = new Thread(this);
			this.th.setDaemon(false);
			this.th.start();			
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
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void retriveLoop() throws Exception { while(isRunning) retriveConnection(); }
	
	public void retriveConnection() throws Exception
	{
		Socket s = socket.accept();
		
		s.setKeepAlive(true);
		
	}
	
}
