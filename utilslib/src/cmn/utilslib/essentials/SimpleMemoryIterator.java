package cmn.utilslib.essentials;

import java.util.function.Function;

import cmn.utilslib.interfaces.MemoryIterator;

public class SimpleMemoryIterator<T> implements MemoryIterator<T>
{
	private int index = 0;
	private T c = null;
	
	private Function<Void,Integer> f_size;
	private Function<Integer,T> f_get;
	
	public SimpleMemoryIterator(Function<Void,Integer> f_size, Function<Integer,T> f_get)
	{
		this.f_size = f_size;
		this.f_get = f_get;
	}
	
	public boolean hasNext()
	{
		int i = this.f_size.apply(null);
		
		return i > 0 && this.index < i;
	}

	public T next() { return hasNext() ? this.c = this.f_get.apply(this.index++) : null; }

	public T current() { return this.c; }

	public int index() { return this.index - 1; }

}
