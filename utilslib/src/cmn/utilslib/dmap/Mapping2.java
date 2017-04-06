package cmn.utilslib.dmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import cmn.utilslib.dmap.IMapping2Foundation.IMapping2;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.ListUtils;
import cmn.utilslib.essentials.MemoryIterable;
import cmn.utilslib.essentials.MemoryIterator;
import cmn.utilslib.validation.Validate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Mapping2<A,B> implements IMapping2<Mapping2<A,B>,A,B>, MemoryIterable<IDMap2Base<A,B>>
{

	private ArrayList<A> a = Auto.ArrayList();
	private ArrayList<B> b = Auto.ArrayList();

	private int size = 0;
	
	
	
	public List<A> a() { return this.a; }
	public List<B> b() { return this.b; }

	
	
	public IDMap2Base<A,B> get(int index)
	{
		Validate.isInRange(0, size() - 1, index);
		return get0(index);
	}

	public A getA(int index) { Validate.isInRange(0, size() - 1, index); return this.a.get(index); }
	public B getB(int index) { Validate.isInRange(0, size() - 1, index); return this.b.get(index); }

	
	
	public List<IDMap2Base<A,B>> get(int... indices)
	{
		Validate.isInRange(0, size() - 1, indices);
		
		return get0(indices);
	}
	
	public List<A> getA(int... indices)
	{
		Validate.isInRange(0, size() - 1, indices);
		
		return getA0(indices);
	}
	public List<B> getB(int... indices)
	{
		Validate.isInRange(0, size() - 1, indices);
		
		return getB0(indices);
	}
	
	
	
	public IDMap2Base<A,B> getFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap2Base<A,B> getFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? get0(index) : null;
	}
	
	
	
	public A getFirstAByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? getA0(index) : null;
	}
	public B getFirstBByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? getB0(index) : null;
	}

	
	
	public List<IDMap2Base<A,B>> getByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return get(indices);
	}
	public List<IDMap2Base<A,B>> getByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return get(indices);
	}
	

	
	public List<A> getAByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return getA(indices);
	}
	public List<B> getBByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return getB(indices);
	}
	
	
	
	public int firstIndexOf(A a, B b) { return firstIndexOf(Auto.DMap2(a, b)); }	
	public int firstIndexOf(IDMap2Base<A,B> entry)
	{
		MemoryIterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return i.index();
		
		return -1;
	}

	public int firstIndexOfA(A a) { return this.a.indexOf(a); }
	public int firstIndexOfB(B b) { return this.a.indexOf(a); }
	
	
	
	public boolean contains(A a, B b) { return contains(Auto.DMap2(a,b)); }
	public boolean contains(IDMap2Base<A,B> entry)
	{
		Iterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return true;	
		
		return false;
	}
	
	public boolean containsA(A a) { return this.a.contains(a); }
	public boolean containsB(B b) { return this.b.contains(b); }
	
	
	
	public int[] indicesOf(A a, B b) { return indicesOf(Auto.DMap2(a, b)); }
	public int[] indicesOf(IDMap2Base<A,B> entry)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) out.add(i.index());
		
		return ListUtils.toIntArray(out);
	}

	public int[] indicesOfA(A a)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<A> i = iteratorA();
		
		while(i.hasNext()) if(i.next().equals(a)) out.add(i.index());
		
		return ListUtils.toIntArray(out);
	}
	public int[] indicesOfB(B b)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<B> i = iteratorB();
		
		while(i.hasNext()) if(i.next().equals(b)) out.add(i.index());
		
		return ListUtils.toIntArray(out);
	}
	
	

	public int occurrencesOf(A a, B b) { return occurrencesOf(Auto.DMap2(a, b)); }
	public int occurrencesOf(IDMap2Base<A,B> entry)
	{
		int out = 0;
		
		Iterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) out++;
		
		return out;
	}

	public int occurrencesOfA(A a)
	{
		int out = 0;
		
		Iterator<A> i = iteratorA();
		
		while(i.hasNext()) if(i.next().equals(a)) out++;
		
		return out;
	}
	public int occurrencesOfB(B b)
	{
		int out = 0;
		
		Iterator<B> i = iteratorB();
		
		while(i.hasNext()) if(i.next().equals(b)) out++;
		
		return out;
	}


	
	public int size() { return this.size; }

	
	
	public MemoryIterator<IDMap2Base<A,B>> iterator()
	{
		return new MemoryIterator<IDMap2Base<A,B>>()
		{
			private int index = 0;
			private IDMap2Base<A,B> c = null;
			

			
			public boolean hasNext() { return this.index < size(); }
		
			public IDMap2Base<A,B> next() { return hasNext() ? this.c = get0(this.index++) : null; }

			public IDMap2Base<A,B> current() { return this.c; }

			public int index() { return this.index; }
		};
	}

	public MemoryIterator<A> iteratorA()
	{
		return new MemoryIterator<A>()
		{
			private int index = 0;
			private A c = null;
			

			
			public boolean hasNext() { return this.index < size(); }

			public A next() { return hasNext() ? this.c = getA0(this.index++) : null; }

			public A current() { return this.c; }

			public int index() { return this.index; }
		};
	}
	public MemoryIterator<B> iteratorB()
	{
		return new MemoryIterator<B>()
		{
			private int index = 0;
			private B c = null;
			
			

			public boolean hasNext() { return this.index < size(); }

			public B next() { return hasNext() ? this.c = getB0(this.index++) : null; }

			public B current() { return this.c; }

			public int index() { return this.index; }
		};
	}

	
	public Mapping2<A,B> set(int index, A a, B b)
	{
		Validate.isInRange(0, size(), index);
		
		if(index < size())
		{
			setA0(index, a);
			setB0(index, b);
		}
		else
		{
			add(a, b);
		}
		

		
		return this;
	}

	public Mapping2<A,B> set(int index, IDMap2Base<A,B> entry) { return set(index, entry.getA(), entry.getB()); }


	public Mapping2<A,B> setA(int index, A a)
	{
		Validate.isInRange(0, size() -1, index);
		
		setA0(index, a);
		
		return this;
	}

	public Mapping2<A,B> setB(int index, B b)
	{
		Validate.isInRange(0, size() - 1, index);
		setB0(index, b);
		
		return this;
	}


	public Mapping2<A,B> add(IDMap2Base<A,B> entry)
	{
		return add(entry.getA(), entry.getB());
	}

	
	public Mapping2<A,B> add(A a, B b)
	{
		this.a.add(a);
		this.b.add(b);
		
		this.size++;
		
		return this;
	}

	
	@Override
	public Mapping2<A,B> remove(int index)
	{
		Validate.isInRange(0, size() - 1, index);

		this.a.remove(index);
		this.b.remove(index);
		
		this.size--;
		
		return this;
	}

	@Override
	public Mapping2<A,B> remove(IDMap2Base<A,B> entry)
	{
		int index = -1;
		
		while(contains(entry))
		{
			index = firstIndexOf(entry);
			
			remove(index);
		}
			
		return this;
	}
	
	public Mapping2<A,B> removeFirst(IDMap2Base<A,B> entry)
	{
		int index = firstIndexOf(entry);
		if(index != -1)
		{
			remove(index);
		}
		
		return this;
	}

	@Override
	public Mapping2<A,B> removeByA(A a)
	{
		int index = firstIndexOf()
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
	public boolean equals(Mapping2<A,B> subject)
	{
		throw new NotImplementedException();
	}
	
	
	
	private IDMap2Base<A,B> get0(int index) { return Auto.DMap2(getA0(index), getB0(index)); }
	
	private A getA0(int index) { return this.a.get(index); } 
	private B getB0(int index) { return this.b.get(index); } 
	
	
	
	private List<IDMap2Base<A,B>> get0(int... indices)
	{
		ArrayList<IDMap2Base<A,B>> out = Auto.ArrayList();
		
		for(int i : indices)
		{
			out.add(get0(i));
		}
		
		return out;
	}
	
	private List<A> getA0(int... indices)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int i : indices)
		{
			out.add(getA0(i));
		}
		
		return out;
	}
	private List<B> getB0(int... indices)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int i : indices)
		{
			out.add(getB0(i));
		}
		
		return out;
	}
	
	
	
	private void setA0(int index, A a) { this.a.set(index, a); }
	private void setB0(int index, B b) { this.b.set(index, b); }

}

