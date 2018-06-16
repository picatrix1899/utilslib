package cmn.utilslib.essentials;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cmn.utilslib.events.EmptyArgs;
import cmn.utilslib.events.Event;

public class ObservedList<T> implements List<T>
{

	private List<T> list;
	
	public Event<EmptyArgs> ChangedEvent = new Event<EmptyArgs>();
	
	
	public ObservedList(List<T> list)
	{
		this.list = list;
	}
	
	public ObservedList()
	{
		this.list = Auto.ArrayList();
	}
	
	@SafeVarargs
	public ObservedList(T... array)
	{
		this.list = Auto.ArrayList(array);
	}
	
	private void changed()
	{
		ChangedEvent.raise(EmptyArgs.getInstance());
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
		changed();
		return this.list.remove(o);
	}

	@Override
	public T remove(int index)
	{
		changed();
		return this.list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		changed();
		return this.list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		changed();
		return this.list.retainAll(c);
	}

	@Override
	public T set(int index, T element)
	{
		changed();
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
