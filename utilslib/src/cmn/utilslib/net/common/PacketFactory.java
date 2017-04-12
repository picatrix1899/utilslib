package cmn.utilslib.net.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.utilslib.dmap.DMapping2;
import cmn.utilslib.essentials.Auto;

public class PacketFactory
{
	
	private DMapping2<Long, Class<? extends IngoingPacket>> in_Templates = Auto.DMapping2();
	private DMapping2<Long, Class<? extends OutgoingPacket>> out_Templates = Auto.DMapping2();
	
	private boolean lock = false;
	
	public void registerIngoingPacketTemplate(long id, Class<? extends IngoingPacket> clazz)
	{
		if(!isLocked())
		{
			this.in_Templates.add(id, clazz);
		}
	}
	
	public void registerOutgoingPacketTemplate(long id, Class<? extends OutgoingPacket> clazz)
	{
		if(!isLocked())
		{
			this.out_Templates.add(id,clazz);
		}

	}
	
	
	public void lock()
	{
		this.lock = true;
	}
	
	public boolean isLocked()
	{
		return this.lock;
	}
	
	public IngoingPacket resolveIngoingPacket(InputStream stream) throws Exception
	{
		DataInputStream dis = new DataInputStream(stream);
		
		long id = dis.readLong();
		
		if(this.in_Templates.containsA(id))
		{
			IngoingPacket p = this.in_Templates.getFirstBByA(id).getConstructor().newInstance();
			
			p.read(stream);
			
			return p;
		}
		
		return null;
	}
	
	public boolean resolveOutgoingPacket(OutgoingPacket packet, OutputStream stream) throws Exception
	{
		DataOutputStream dos = new DataOutputStream(stream);
		
		if(this.out_Templates.containsB(packet.getClass()))
		{
			
			dos.writeLong(this.out_Templates.getFirstAByB(packet.getClass()));
			
			packet.write(stream);
			
			return true;
			
		}
		
		return false;
	}
}
