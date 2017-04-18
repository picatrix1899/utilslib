package cmn.utilslib.essentials;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ObservedList<T> implements List<T>
{

	private List<T> list;
	
	private List<Listener> listeners = Auto.ArrayList();
	
	
	public ObservedList(List<T> list)
	{
		this.list = list;
	}
	
	public void addListener(Listener l)
	{
		this.listeners.add(l);
	}
	
	private void changed()
	{
		for(Listener l : this.listeners)
		{
			l.trigger();
		}
	}
	
	
	@Override
	public boolean add(T e)
	{
		changed();
		return this.list.add(e);
	}

	@Override
	public void add(int index, T element)
	{
		changed();
		this.list.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		changed();
		return this.list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		changed();
		return this.list.addAll(index, c);
	}

	@Override
	public void clear()
	{
		changed();
		this.list.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return this.list.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.list.containsAll(c);
	}

	@Override
	public T get(int index)
	{
		return this.list.get(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return this.list.indexOf(o);
	}

	@Override
	public boolean isEmpty()
	{
		return this.list.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.list.iterator();
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return this.list.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return this.list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return this.list.listIterator(index);
	}

	@Override
	public boolean remove(Object o)
	{
		return this.list.remove(o);
	}

	@Override
	public T remove(int index)
	{
		return this.list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return this.list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return this.list.retainAll(c);
	}

	@Override
	public T set(int index, T element)
	{
		return this.list.set(index, element);
	}

	@Override
	public int size()
	{
		return this.list.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return this.list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray()
	{
		return this.list.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a)
	{
		return this.list.toArray(a);
	}

}
