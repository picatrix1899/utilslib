package cmn.picatrix1899.utilslib.events;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventHandle
{
	private ArrayList<IEventListener> listener = new ArrayList<IEventListener>();
	
	public void add(IEventListener listener)
	{
		this.listener.add(listener);
	}
	
	public void raise(Event e)
	{
		for(IEventListener l : listener)
		{
			Method[] methods = l.getClass().getDeclaredMethods();
			
			for(Method m : methods)
			{
				if(m.getDeclaredAnnotation(EventHandler.class) == null)
				{
					continue;
				}
				
				if(m.getParameterCount() > 1)
				{
					continue;
				}
				
				if(m.getParameterTypes()[0] == e.getClass())
				{
					try
					{
						m.invoke(e);
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
					
				}
			}
		}
	}
}
