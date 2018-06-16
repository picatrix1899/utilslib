package cmn.utilslib.events;

import java.util.HashMap;

import cmn.utilslib.essentials.Auto;

public class Event<A extends EventArgs>
{
	
	private HashMap<Integer,EventHandler<A>> handlers = Auto.HashMap();
	
	private int index = 0;
	
	static <B extends EventArgs> EventHandler<B> getDefault()
	{
		return (argsorg, argsref) -> {};
	}
	
	public int addHandler(EventHandler<A> handler)
	{
		int index = this.index;
		
		handlers.put(index, handler);
		
		this.index++;
		
		return index;
	}
	
	public void removeHandler(int index)
	{
		this.handlers.remove(index);
	}
	
	public void clearHandlers()
	{
		this.handlers.clear();
	}
	
	@SuppressWarnings("unchecked")
	public void raise(A args)
	{
		for(EventHandler<A> handler : handlers.values())
		{
			A src = (A) args.cloneArgs();
			
			handler.raise(src, args);
		}
	}
}
