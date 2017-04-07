package cmn.utilslib.essentials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class IteratorConverter<R,I>
{
	
	public R convert(I i)
	{
		return null;
	}
	
	public List<R> toList(Iterator<I> i)
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
