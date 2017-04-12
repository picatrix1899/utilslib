package cmn.utilslib.net.client;


import java.net.Socket;

import cmn.utilslib.net.common.IngoingPacket;
import cmn.utilslib.net.common.OutgoingPacket;
import cmn.utilslib.net.common.Packet;
import cmn.utilslib.net.common.PacketFactory;

public class ClientCore 
{

	private Socket socket;

	private ClientServerConnection connection;

	private PacketFactory factory;
	
	private String address;
	
	private int port;
	
	public ClientCore(String address, int port)
	{
		try
		{
			this.address = address;
			this.port = port;
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
		try
		{
			this.socket = new Socket(this.address, this.port);
			this.factory.lock();
		}
		catch(Exception e)
		{
			this.socket = null;
		}
		
		if(this.socket == null)
		{
			System.out.println("cannot Connect to Server!");
			return;
		}
		
		ClientServerConnection c = new ClientServerConnection(this, this.socket);
		
		startConnection(c);
	}
	
	public void startConnection(ClientServerConnection c)
	{
		this.connection = c;
		this.connection.start();
	}
	
	public PacketFactory getPacketFactory()
	{
		return this.factory;
	}
	
}
