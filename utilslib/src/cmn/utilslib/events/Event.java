package cmn.utilslib.events;

import java.util.HashMap;

import cmn.utilslib.essentials.Auto;

public class Event<A extends EventArgs>
{
	
	HashMap<Integer,EventHandler<A>> handlers = Auto.HashMap();
	
	static <B extends EventArgs> EventHandler<B> getDefault()
	{
		return (argsorg, argsref) -> {};
	}
	
	
	@SuppressWarnings("unchecked")
	public void raise(A args)
	{
		A ref = (A) args.cloneArgs();
		
		for(EventHandler<A> handler : handlers.values())
		{
			handler.raise(args, ref);
		}
	}
}
