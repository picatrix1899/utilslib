package cmn.utilslib.interfaces;

import java.util.Iterator;

public interface MemoryIterator<T> extends Iterator<T>
{
	public T current();
	
	public int index();
}
