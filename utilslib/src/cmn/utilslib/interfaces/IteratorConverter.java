package cmn.utilslib.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public interface IteratorConverter<R,I>
{
	
	public abstract R convert(I i);
	
	public default List<R> toList(Iterator<I> i)
	{
		ArrayList<R> out = Auto.ArrayList();
		
		R value = null;
		
		while(i.hasNext())
		{
			value = convert(i.next());
			
			if(value != null) out.add(value);
		}
		
		return out;
	}
}
