package cmn.utilslib.essentials;

import java.util.Iterator;
import java.util.function.Function;

public class ReusableIterator<T> implements Iterator<T>
{

	private Function<Integer,T> _get;
	private Function<Void,Integer> _size;
	
	private int index = 0;
	
	public ReusableIterator(Function<Integer,T> g, Function<Void,Integer> s)
	{
		_get = g;
		_size = s;
	}
	
	public void set(Function<Integer,T> g, Function<Void,Integer> s)
	{
		_get = g;
		_size = s;
		index = 0;
	}
	
	@Override
	public boolean hasNext()
	{
		return this.index + 1 < _size.apply(null);
	}

	@Override
	public T next()
	{
		return _get.apply(this.index++);
	}

}
