package cmn.utilslib.essentials;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class WeakList<T> extends AbstractList<T>
{

	private ArrayList<WeakReference<T>> items = Auto.ArrayList();
	
	public WeakList() { }
	
	public WeakList(Collection<T> c)
	{
		addAll(c);
	}
	
	@Override
	public T get(int index)
	{
		return this.items.get(index).get();
	}

	@Override
	public void add(int index, T element)
	{
		this.items.add(index, new WeakReference<T>(element));
	}
	
	@Override
	public int size()
	{
		removeReleased();
		return this.items.size();
	}

	private void removeReleased()
	{
		for (Iterator<WeakReference<T>> it = this.items.iterator(); it.hasNext(); )
		{
			WeakReference<T> ref = it.next();
			if (ref.get() == null) this.items.remove(ref);
		}
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new WeakListIterator();
	}
	
	
	
	private class WeakListIterator implements Iterator<T>
	{

		private int snapshotSize = 0;
		private int index = 0;
		
		public WeakListIterator()
		{
			this.snapshotSize = size();
		}
		
		@Override
		public boolean hasNext()
		{
			return index < snapshotSize;
		}

		@Override
		public T next()
		{
			return get(index++);
		}
		
	}
}
