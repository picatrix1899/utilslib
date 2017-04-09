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

public class DMapping2<A,B> implements IDMapping2<A,B>
{

	private ArrayList<LinkedDMap2<A,B>> content = Auto.ArrayList();
	
	
	
	private final IteratorConverter<A,IDMap2Base<A,B>> converter_ToA = i -> i.getA();
	private final IteratorConverter<B,IDMap2Base<A,B>> converter_ToB = i -> i.getB();
	
	private final IteratorConverter<LinkedValue<A,IDMap2Base<A,B>>,IDMap2Base<A,B>> converter_ToLinkedA = i -> ((LinkedDMap2<A,B>) i).getLinkedA();
	private final IteratorConverter<LinkedValue<B,IDMap2Base<A,B>>,IDMap2Base<A,B>> converter_ToLinkedB = i -> ((LinkedDMap2<A,B>) i).getLinkedB();
	
	
	
	public List<A> a() { return converter_ToA.toList(iterator()); }
	public List<B> b() { return converter_ToB.toList(iterator()); }

	
	
	public List<LinkedValue<A,IDMap2Base<A,B>>> linkedA() { return converter_ToLinkedA.toList(iterator()); }
	public List<LinkedValue<B,IDMap2Base<A,B>>> linkedB() { return converter_ToLinkedB.toList(iterator()); }
	
	
	
	public List<IDMap2Base<A,B>> list() { return Auto.ArrayList(this.content); }
	
	
	
	public IDMap2Base<A,B> get(int index)
	{
		Validate.isInRange(0, size() - 1, index);
		return get0(index);
	}
	public A getA(int index) { Validate.isInRange(0, size() - 1, index); return getA0(index); }
	public B getB(int index) { Validate.isInRange(0, size() - 1, index); return getB0(index); }

	
	
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
		
		return getA0(indices);
	}
	public List<B> getBByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return getB0(indices);
	}
	
	
	
	public int firstIndexOf(A a, B b) { return firstIndexOf(Auto.DMap2(a, b)); }	
	public int firstIndexOf(IDMap2Base<A,B> entry)
	{
		MemoryIterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return i.index();
		
		return -1;
	}
	public int firstIndexOfA(A a) { return this.a().indexOf(a); }
	public int firstIndexOfB(B b) { return this.b().indexOf(b); }
	
	
	
	public boolean contains(A a, B b) { return contains(Auto.DMap2(a,b)); }
	public boolean contains(IDMap2Base<A,B> entry)
	{
		Iterator<IDMap2Base<A,B>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return true;	
		
		return false;
	}
	public boolean containsA(A a) { return converter_ToA.toList(iterator()).contains(a); }
	public boolean containsB(B b) { return converter_ToB.toList(iterator()).contains(b); }
	
	
	
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


	
	public int size() { return this.content.size(); }

	
	
	public MemoryIterator<IDMap2Base<A,B>> iterator()
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

	
	
	public MemoryIterator<LinkedValue<A, IDMap2Base<A,B>>> iteratorLinkedA()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedA());
	}
	public MemoryIterator<LinkedValue<B, IDMap2Base<A,B>>> iteratorLinkedB()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedB());
	}
	
	
	
	public DMapping2<A,B> set(int index, A a, B b)
	{
		Validate.isInRange(0, size(), index);
		
		if(index < size())
		{
			setA0(index, a);
			setB0(index, b);
		}
		else
		{
			this.content.add(Auto.LinkedDMap2(a, b));
		}
		
		return this;
	}
	public DMapping2<A,B> set(int index, IDMap2Base<A,B> entry) { return set(index, entry.getA(), entry.getB()); }
	public DMapping2<A,B> setA(int index, A a)
	{
		Validate.isInRange(0, size() -1, index);
		setA0(index, a);
		
		return this;
	}
	public DMapping2<A,B> setB(int index, B b)
	{
		Validate.isInRange(0, size() - 1, index);
		setB0(index, b);
		
		return this;
	}


	
	public DMapping2<A,B> add(A a, B b)
	{
		this.content.add(Auto.LinkedDMap2(a,b));
		
		return this;
	}
	public DMapping2<A,B> add(IDMap2Base<A,B> entry)
	{
		return add(entry.getA(), entry.getB());
	}

	
	
	public DMapping2<A,B> remove(int index)
	{
		Validate.isInRange(0, size() - 1, index);

		remove0(index);
		
		return this;
	}
	
	public DMapping2<A,B> remove(A a, B b) { return remove(Auto.DMap2(a, b)); }
	public DMapping2<A,B> remove(IDMap2Base<A,B> entry)
	{
		int index = -1;
		
		while(contains(entry))
		{
			index = firstIndexOf(entry);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping2<A,B> removeByA(A a)
	{
		int index = -1;
		
		while(containsA(a))
		{
			index = firstIndexOfA(a);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping2<A,B> removeByB(B b)
	{
		int index = -1;
		
		while(containsB(b))
		{
			index = firstIndexOfB(b);
			
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping2<A,B> removeFirst(A a, B b) { return removeFirst(Auto.DMap2(a, b)); }
	public DMapping2<A,B> removeFirst(IDMap2Base<A,B> entry)
	{
		int index = firstIndexOf(entry);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping2<A,B> removeFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping2<A,B> removeFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping2<A,B> sortByLinkedA(Comparator<? super LinkedValue<A,IDMap2Base<A,B>>> comp)
	{
		List<LinkedValue<A, IDMap2Base<A,B>>> e = linkedA();
		
		e.sort(comp);

		Iterator<LinkedValue<A, IDMap2Base<A,B>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping2<A,B> sortByLinkedB(Comparator<? super LinkedValue<B,IDMap2Base<A,B>>> comp)
	{
		List<LinkedValue<B, IDMap2Base<A,B>>> e = linkedB();
		
		e.sort(comp);
		
		Iterator<LinkedValue<B, IDMap2Base<A,B>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	
	
	
	public DMapping2<A,B> sortByA(Comparator<? super A> comp)
	{
		return sortByLinkedA((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping2<A,B> sortByB(Comparator<? super B> comp)
	{
		return sortByLinkedB((a,b) -> comp.compare(a.value(), b.value()));
	}

	
	
	public DMapping2<A,B> clear()
	{
		this.content.clear();
		
		return this;
	}

	
	
	private IDMap2Base<A,B> get0(int index) { return this.content.get(index); }
	private A getA0(int index) { return this.content.get(index).getA(); } 
	private B getB0(int index) { return this.content.get(index).getB(); } 
	
	
	
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
	
	
	
	private void setA0(int index, A a) { this.content.get(index).setA(a); }
	private void setB0(int index, B b) { this.content.get(index).setB(b); }
	
	
	
	private void remove0(int index)
	{
		this.content.remove(index);
	}

}

