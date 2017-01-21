package cmn.picatrix1899.utilslib.essentials;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrimitiveDataWatcher extends Thread
{
	private long probeInterval = 100l;
	private Method response;
	private Object responsee;
	private Field f;
	private Object watched;
	
	private Object old = null;
	
	public PrimitiveDataWatcher(long interval)
	{
		this.setDaemon(true);
		
		this.probeInterval = interval;

	}
	
	public PrimitiveDataWatcher setObjective(Object o, String field) throws NoSuchFieldException, SecurityException
	{
		this.watched = o;
		this.f = this.watched.getClass().getDeclaredField(field);
		this.f.setAccessible(true);
		
		return this;
	}
	
	public PrimitiveDataWatcher setResponse(Object o, String method) throws NoSuchMethodException, SecurityException
	{
		this.responsee = o;
		this.response = this.responsee.getClass().getDeclaredMethod(method);
		this.response.setAccessible(true);
		
		return this;
	}
	
	public void run()
	{
		

		try
		{
			this.old = this.f.get(this.watched);

			while(!isInterrupted())
			{

				if(!this.old.equals(this.f.get(this.watched)))
				{
					this.response.invoke(this.responsee);
					this.old = this.f.get(this.watched);
				}
				
				try
				{
					sleep(probeInterval);
				}
				catch(Exception e)
				{
					
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	public void end()
	{
		try
		{
			interrupt();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public Object getOld()
	{
		return this.old;
	}
}
