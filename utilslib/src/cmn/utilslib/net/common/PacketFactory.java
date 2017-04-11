package cmn.utilslib.net.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import cmn.utilslib.essentials.Auto;

public class PacketFactory
{
	
	private HashMap<Long, Class<? extends IngoingPacket>> inTemplates_ClassByID = Auto.HashMap();
	private HashMap<Class<? extends IngoingPacket>, Long> inTemplates_IDByClass = Auto.HashMap();
	private HashMap<Long, Class<? extends OutgoingPacket>> outTemplates_ClassByID = Auto.HashMap();
	private HashMap<Class<? extends OutgoingPacket>, Long> outTemplates_IDByClass = Auto.HashMap();
	
	
	public void registerIngoingPacketTemplate(long id, Class<? extends IngoingPacket> clazz)
	{
		this.inTemplates_ClassByID.put(id, clazz);
		this.inTemplates_IDByClass.put(clazz, id);
	}
	
	public void registerOutgoingPacketTemplate(long id, Class<? extends OutgoingPacket> clazz)
	{
		System.out.println(clazz);
		this.outTemplates_ClassByID.put(id, clazz);
		this.outTemplates_IDByClass.put(clazz, id);
	}
	
	
	
	public IngoingPacket resolveIngoingPacketImpl(InputStream stream) throws Exception
	{
		DataInputStream dis = new DataInputStream(stream);
		
		long id = dis.readLong();
		
		if(this.inTemplates_ClassByID.containsKey(id))
		{
			IngoingPacket p = this.inTemplates_ClassByID.get(id).getConstructor((Class<?>)null).newInstance((Object)null);
			
			p.read(stream);
			
			return p;
		}
		
		return null;
	}
	
	public boolean resolveOutgoingPacketImpl(OutgoingPacket packet, OutputStream stream) throws Exception
	{
		DataOutputStream dos = new DataOutputStream(stream);
		
		if(this.outTemplates_IDByClass.containsKey(packet.getClass()))
		{
			
			dos.writeLong(this.outTemplates_IDByClass.get(packet.getClass()));
			
			packet.write(stream);
			
			return true;
			
		}
		
		return false;
	}
}
