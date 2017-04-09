package cmn.utilslib.dmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.ListUtils;
import cmn.utilslib.interfaces.IteratorConverter;
import cmn.utilslib.interfaces.MemoryIterator;
import cmn.utilslib.validation.Validate;

public class DMapping3<A,B,C> implements IDMapping3<A,B,C>
{

	private ArrayList<LinkedDMap3<A,B,C>> content = Auto.ArrayList();
	
	
	
	private final IteratorConverter<A,IDMap3Base<A,B,C>> converter_ToA = i -> i.getA();
	private final IteratorConverter<B,IDMap3Base<A,B,C>> converter_ToB = i -> i.getB();
	private final IteratorConverter<C,IDMap3Base<A,B,C>> converter_ToC = i -> i.getC();
	
	private final IteratorConverter<LinkedValue<A,IDMap3Base<A,B,C>>,IDMap3Base<A,B,C>> converter_ToLinkedA = i -> ((LinkedDMap3<A,B,C>) i).getLinkedA();
	private final IteratorConverter<LinkedValue<B,IDMap3Base<A,B,C>>,IDMap3Base<A,B,C>> converter_ToLinkedB = i -> ((LinkedDMap3<A,B,C>) i).getLinkedB();
	private final IteratorConverter<LinkedValue<C,IDMap3Base<A,B,C>>,IDMap3Base<A,B,C>> converter_ToLinkedC = i -> ((LinkedDMap3<A,B,C>) i).getLinkedC();
	
	
	public List<A> a() { return converter_ToA.toList(iterator()); }
	public List<B> b() { return converter_ToB.toList(iterator()); }
	public List<C> c() { return converter_ToC.toList(iterator()); }
	
	
	public List<LinkedValue<A,IDMap3Base<A,B,C>>> linkedA() { return converter_ToLinkedA.toList(iterator()); }
	public List<LinkedValue<B,IDMap3Base<A,B,C>>> linkedB() { return converter_ToLinkedB.toList(iterator()); }
	public List<LinkedValue<C,IDMap3Base<A,B,C>>> linkedC() { return converter_ToLinkedC.toList(iterator()); }
	
	
	
	public List<IDMap3Base<A,B,C>> list() { return Auto.ArrayList(this.content); }
	
	
	
	public IDMap3Base<A,B,C> get(int index)
	{
		Validate.isInRange(0, size() - 1, index);
		return get0(index);
	}
	public A getA(int index) { Validate.isInRange(0, size() - 1, index); return getA0(index); }
	public B getB(int index) { Validate.isInRange(0, size() - 1, index); return getB0(index); }
	public C getC(int index) { Validate.isInRange(0, size() - 1, index); return getC0(index); }

	
	
	public List<IDMap3Base<A,B,C>> get(int... indices)
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
	public List<C> getC(int... indices)
	{
		Validate.isInRange(0, size() - 1, indices);
		
		return getC0(indices);
	}
	
	
	
	public IDMap3Base<A,B,C> getFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap3Base<A,B,C> getFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap3Base<A,B,C> getFirstByC(C c)
	{
		int index = firstIndexOfC(c);
		
		return index != -1 ? get0(index) : null;
	}
	
	
	
	public A getFirstAByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? getA0(index) : null;
	}
	public A getFirstAByC(C c)
	{
		int index = firstIndexOfC(c);
		
		return index != -1 ? getA0(index) : null;
	}
	public B getFirstBByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? getB0(index) : null;
	}
	public B getFirstBByC(C c)
	{
		int index = firstIndexOfC(c);
		
		return index != -1 ? getB0(index) : null;
	}
	public C getFirstCByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? getC0(index) : null;
	}
	public C getFirstCByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? getC0(index) : null;
	}

	
	
	public List<IDMap3Base<A,B,C>> getByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return get(indices);
	}
	public List<IDMap3Base<A,B,C>> getByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return get(indices);
	}
	public List<IDMap3Base<A,B,C>> getByC(C c)
	{
		int[] indices = indicesOfC(c);
		
		return get(indices);
	}
	

	
	public List<A> getAByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return getA0(indices);
	}
	public List<A> getAByC(C c)
	{
		int[] indices = indicesOfC(c);
		
		return getA0(indices);
	}
	public List<B> getBByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return getB0(indices);
	}
	public List<B> getBByC(C c)
	{
		int[] indices = indicesOfC(c);
		
		return getB0(indices);
	}
	public List<C> getCByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return getC0(indices);
	}
	public List<C> getCByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return getC0(indices);
	}
	
	
	
	public int firstIndexOf(A a, B b, C c) { return firstIndexOf(Auto.DMap3(a, b, c)); }	
	public int firstIndexOf(IDMap3Base<A,B,C> entry)
	{
		MemoryIterator<IDMap3Base<A,B,C>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return i.index();
		
		return -1;
	}
	public int firstIndexOfA(A a) { return this.a().indexOf(a); }
	public int firstIndexOfB(B b) { return this.b().indexOf(b); }
	public int firstIndexOfC(C c) { return this.c().indexOf(c); }
	
	
	
	public boolean contains(A a, B b, C c) { return contains(Auto.DMap3(a,b,c)); }
	public boolean contains(IDMap3Base<A,B,C> entry)
	{
		Iterator<IDMap3Base<A,B,C>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return true;	
		
		return false;
	}
	public boolean containsA(A a) { return converter_ToA.toList(iterator()).contains(a); }
	public boolean containsB(B b) { return converter_ToB.toList(iterator()).contains(b); }
	public boolean containsC(C c) { return converter_ToC.toList(iterator()).contains(c); }
	
	
	
	public int[] indicesOf(A a, B b, C c) { return indicesOf(Auto.DMap3(a, b, c)); }
	public int[] indicesOf(IDMap3Base<A,B,C> entry)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<IDMap3Base<A,B,C>> i = iterator();
		
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
	public int[] indicesOfC(C c)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<C> i = iteratorC();
		
		while(i.hasNext()) if(i.next().equals(c)) out.add(i.index());

		return ListUtils.toIntArray(out);
	}
	
	

	public int occurrencesOf(A a, B b, C c) { return occurrencesOf(Auto.DMap3(a, b, c)); }
	public int occurrencesOf(IDMap3Base<A,B,C> entry)
	{
		int out = 0;
		
		Iterator<IDMap3Base<A,B,C>> i = iterator();
		
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
	public int occurrencesOfC(C c)
	{
		int out = 0;
		
		Iterator<C> i = iteratorC();
		
		while(i.hasNext()) if(i.next().equals(c)) out++;
		
		return out;
	}


	
	public int size() { return this.content.size(); }

	
	
	public MemoryIterator<IDMap3Base<A,B,C>> iterator()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i));
	}
	public MemoryIterator<A> iteratorA()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getA());
	}
	public MemoryIterator<B> iteratorB()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getB());
	}
	public MemoryIterator<C> iteratorC()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getC());
	}

	
	
	public MemoryIterator<LinkedValue<A, IDMap3Base<A,B,C>>> iteratorLinkedA()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedA());
	}
	public MemoryIterator<LinkedValue<B, IDMap3Base<A,B,C>>> iteratorLinkedB()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedB());
	}
	public MemoryIterator<LinkedValue<C, IDMap3Base<A,B,C>>> iteratorLinkedC()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedC());
	}
	
	
	
	public DMapping3<A,B,C> set(int index, A a, B b, C c)
	{
		Validate.isInRange(0, size(), index);
		
		if(index < size())
		{
			setA0(index, a);
			setB0(index, b);
		}
		else
		{
			this.content.add(Auto.LinkedDMap3(a, b, c));
		}
		
		return this;
	}
	public DMapping3<A,B,C> set(int index, IDMap3Base<A,B,C> entry) { return set(index, entry.getA(), entry.getB(), entry.getC()); }
	public DMapping3<A,B,C> setA(int index, A a)
	{
		Validate.isInRange(0, size() -1, index);
		setA0(index, a);
		
		return this;
	}
	public DMapping3<A,B,C> setB(int index, B b)
	{
		Validate.isInRange(0, size() - 1, index);
		setB0(index, b);
		
		return this;
	}
	public DMapping3<A,B,C> setC(int index, C c)
	{
		Validate.isInRange(0, size() - 1, index);
		setC0(index, c);
		
		return this;
	}


	
	public DMapping3<A,B,C> add(A a, B b, C c)
	{
		this.content.add(Auto.LinkedDMap3(a, b, c));
		
		return this;
	}
	public DMapping3<A,B,C> add(IDMap3Base<A,B,C> entry)
	{
		return add(entry.getA(), entry.getB(), entry.getC());
	}

	
	
	public DMapping3<A,B,C> remove(int index)
	{
		Validate.isInRange(0, size() - 1, index);

		remove0(index);
		
		return this;
	}
	
	public DMapping3<A,B,C> remove(A a, B b, C c) { return remove(Auto.DMap3(a, b, c)); }
	public DMapping3<A,B,C> remove(IDMap3Base<A,B,C> entry)
	{
		int index = -1;
		
		while(contains(entry))
		{
			index = firstIndexOf(entry);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeByA(A a)
	{
		int index = -1;
		
		while(containsA(a))
		{
			index = firstIndexOfA(a);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeByB(B b)
	{
		int index = -1;
		
		while(containsB(b))
		{
			index = firstIndexOfB(b);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeByC(C c)
	{
		int index = -1;
		
		while(containsC(c))
		{
			index = firstIndexOfC(c);
			
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping3<A,B,C> removeFirst(A a, B b, C c) { return removeFirst(Auto.DMap3(a, b, c)); }
	public DMapping3<A,B,C> removeFirst(IDMap3Base<A,B,C> entry)
	{
		int index = firstIndexOf(entry);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping3<A,B,C> removeFirstByC(C c)
	{
		int index = firstIndexOfC(c);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping3<A,B,C> sortByLinkedA(Comparator<? super LinkedValue<A,IDMap3Base<A,B,C>>> comp)
	{
		List<LinkedValue<A, IDMap3Base<A,B,C>>> e = linkedA();
		
		e.sort(comp);

		Iterator<LinkedValue<A, IDMap3Base<A,B,C>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping3<A,B,C> sortByLinkedB(Comparator<? super LinkedValue<B,IDMap3Base<A,B,C>>> comp)
	{
		List<LinkedValue<B, IDMap3Base<A,B,C>>> e = linkedB();
		
		e.sort(comp);
		
		Iterator<LinkedValue<B, IDMap3Base<A,B,C>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping3<A,B,C> sortByLinkedC(Comparator<? super LinkedValue<C,IDMap3Base<A,B,C>>> comp)
	{
		List<LinkedValue<C, IDMap3Base<A,B,C>>> e = linkedC();
		
		e.sort(comp);
		
		Iterator<LinkedValue<C, IDMap3Base<A,B,C>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	
	
	
	public DMapping3<A,B,C> sortByA(Comparator<? super A> comp)
	{
		return sortByLinkedA((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping3<A,B,C> sortByB(Comparator<? super B> comp)
	{
		return sortByLinkedB((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping3<A,B,C> sortByC(Comparator<? super C> comp)
	{
		return sortByLinkedC((a,b) -> comp.compare(a.value(), b.value()));
	}

	
	
	public DMapping3<A,B,C> clear()
	{
		this.content.clear();
		
		return this;
	}

	
	
	private IDMap3Base<A,B,C> get0(int index) { return this.content.get(index); }
	private A getA0(int index) { return this.content.get(index).getA(); } 
	private B getB0(int index) { return this.content.get(index).getB(); } 
	private C getC0(int index) { return this.content.get(index).getC(); } 
	
	
	
	private List<IDMap3Base<A,B,C>> get0(int... indices)
	{
		ArrayList<IDMap3Base<A,B,C>> out = Auto.ArrayList();
		
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
	private List<C> getC0(int... indices)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int i : indices)
		{
			out.add(getC0(i));
		}
		
		return out;
	}
	
	
	
	private void setA0(int index, A a) { this.content.get(index).setA(a); }
	private void setB0(int index, B b) { this.content.get(index).setB(b); }
	private void setC0(int index, C c) { this.content.get(index).setC(c); }
	
	
	
	private void remove0(int index)
	{
		this.content.remove(index);
	}

}

