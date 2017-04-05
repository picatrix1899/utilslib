package cmn.utilslib.dmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cmn.utilslib.dmap.IMapping2Foundation.IMapping2;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Mapping2<A,B> implements IMapping2<Mapping2<A,B>,A,B>
{

	private ArrayList<A> a = Auto.ArrayList();
	private ArrayList<B> b = Auto.ArrayList();

	private int size = 0;
	
	

	@Override
	public List<A> a() { return this.a; }
	@Override
	public List<B> b() { return this.b; }

	
	
	private A getA0(int index) { return this.a.get(index); } 
	private B getB0(int index) { return this.b.get(index); } 
	
	
	@Override
	public IPair2Base<A,B> get(int index)
	{
		if(index < size()) return Auto.Pair2(getA(index), getB(index));
		
		return null;
	}
	@Override
	public A getA(int index) { return this.a.get(index); }
	@Override
	public B getB(int index) { return this.b.get(index); }

	@Override
	public IPair2Base<A,B> getFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		if(index != -1)
		{
			return get(index);
		}
		
		return null;
	}

	@Override
	public IPair2Base<A,B> getFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		if(index != -1)
		{
			return get(index);
		}
		
		return null;
	}

	@Override
	public A getFirstAByB(B b)
	{
		int index = firstIndexOfB(b);
		if(index != -1)
		{
			return getA(index);
		}
		
		return null;
	}

	@Override
	public B getFirstBByA(A a)
	{
		int index = firstIndexOfA(a);
		if(index != -1)
		{
			return getB(index);
		}
		
		return null;
	}

	@Override
	public List<A> getAByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indices)
		{
			out.add(getA(index));
		}

		return out;
			
	}

	@Override
	public List<B> getBByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indices)
		{
			out.add(getB(index));
		}

		return out;
	}
	
	
	
	
	@Override
	public Mapping2<A,B> clone()
	{
		throw new NotImplementedException();
	}
	
	@Override
	public boolean equals(Object o)
	{
		throw new NotImplementedException();
	}

	
	@Override
	public int firstIndexOf(A a, B b)
	{
		for(int i = 0; i < size(); i++)
		{
			if(Check.isTrue(getA0(i).equals(a), getB0(i).equals(b)))
			{
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public int[] indicesOf(A a, B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public int occurrencesOf(A a, B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public boolean contains(A a, B b)
	{
		throw new NotImplementedException();
	}
	
	
	
	
	

	
	




	@Override
	public int firstIndexOf(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public int firstIndexOfA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public int firstIndexOfB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public int[] indicesOf(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public int[] indicesOfA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public int[] indicesOfB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public int occurrencesOf(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public int occurrencesOfA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public int occurrencesOfB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public boolean containsA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public boolean containsB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public boolean contains(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> set(int index, IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> setA(int index, A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> setB(int index, B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> add(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> remove(int index)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> remove(IPair2Base<A,B> entry)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> removeByA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> removeByB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> removeFirstByA(A a)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> removeFirstByB(B b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> sortByA(Comparator<? super A> comp)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> sortByB(Comparator<? super B> comp)
	{
		throw new NotImplementedException();
	}

	@Override
	public Mapping2<A,B> clear()
	{
		throw new NotImplementedException();
	}

	@Override
	public boolean equals(Mapping2<A,B> subject)
	{
		throw new NotImplementedException();
	}
	@Override
	public int size()
	{
		return this.size;
	}
	
	
	
	
}
