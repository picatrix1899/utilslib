package cmn.utilslib.dmap.dmappings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmappings.api.IDMapping4;
import cmn.utilslib.dmap.dmaps.LinkedDMap4;
import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.ListUtils;
import cmn.utilslib.interfaces.IteratorConverter;
import cmn.utilslib.interfaces.MemoryIterator;
import cmn.utilslib.validation.Validate;

public class DMapping4<A,B,C,D> implements IDMapping4<A,B,C,D>
{

	private ArrayList<LinkedDMap4<A,B,C,D>> content = Auto.ArrayList();
	
	
	
	private final IteratorConverter<A,IDMap4Base<A,B,C,D>> converter_ToA = i -> i.getA();
	private final IteratorConverter<B,IDMap4Base<A,B,C,D>> converter_ToB = i -> i.getB();
	private final IteratorConverter<C,IDMap4Base<A,B,C,D>> converter_ToC = i -> i.getC();
	private final IteratorConverter<D,IDMap4Base<A,B,C,D>> converter_ToD = i -> i.getD();
	
	private final IteratorConverter<LinkedValue<A,IDMap4Base<A,B,C,D>>,IDMap4Base<A,B,C,D>> converter_ToLinkedA = i -> ((LinkedDMap4<A,B,C,D>) i).getLinkedA();
	private final IteratorConverter<LinkedValue<B,IDMap4Base<A,B,C,D>>,IDMap4Base<A,B,C,D>> converter_ToLinkedB = i -> ((LinkedDMap4<A,B,C,D>) i).getLinkedB();
	private final IteratorConverter<LinkedValue<C,IDMap4Base<A,B,C,D>>,IDMap4Base<A,B,C,D>> converter_ToLinkedC = i -> ((LinkedDMap4<A,B,C,D>) i).getLinkedC();
	private final IteratorConverter<LinkedValue<D,IDMap4Base<A,B,C,D>>,IDMap4Base<A,B,C,D>> converter_ToLinkedD = i -> ((LinkedDMap4<A,B,C,D>) i).getLinkedD();
	
	
	
	public List<A> a() { return converter_ToA.toList(iterator()); }
	public List<B> b() { return converter_ToB.toList(iterator()); }
	public List<C> c() { return converter_ToC.toList(iterator()); }
	public List<D> d() { return converter_ToD.toList(iterator()); }
	
	
	
	public List<LinkedValue<A,IDMap4Base<A,B,C,D>>> linkedA() { return converter_ToLinkedA.toList(iterator()); }
	public List<LinkedValue<B,IDMap4Base<A,B,C,D>>> linkedB() { return converter_ToLinkedB.toList(iterator()); }
	public List<LinkedValue<C,IDMap4Base<A,B,C,D>>> linkedC() { return converter_ToLinkedC.toList(iterator()); }
	public List<LinkedValue<D,IDMap4Base<A,B,C,D>>> linkedD() { return converter_ToLinkedD.toList(iterator()); }
	
	
	
	public List<IDMap4Base<A,B,C,D>> list() { return Auto.ArrayList(this.content); }
	
	
	
	public IDMap4Base<A,B,C,D> get(int index)
	{
		Validate.isInRange(0, size() - 1, index);
		return get0(index);
	}
	public A getA(int index) { Validate.isInRange(0, size() - 1, index); return getA0(index); }
	public B getB(int index) { Validate.isInRange(0, size() - 1, index); return getB0(index); }
	public C getC(int index) { Validate.isInRange(0, size() - 1, index); return getC0(index); }
	public D getD(int index) { Validate.isInRange(0, size() - 1, index); return getD0(index); }

	
	
	public List<IDMap4Base<A,B,C,D>> get(int... indices)
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
	public List<D> getD(int... indices)
	{
		Validate.isInRange(0, size() - 1, indices);
		
		return getD0(indices);
	}
	
	
	
	public IDMap4Base<A,B,C,D> getFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap4Base<A,B,C,D> getFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap4Base<A,B,C,D> getFirstByC(C c)
	{
		int index = firstIndexOfC(c);
		
		return index != -1 ? get0(index) : null;
	}
	public IDMap4Base<A,B,C,D> getFirstByD(D d)
	{
		int index = firstIndexOfD(d);
		
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
	public A getFirstAByD(D d)
	{
		int index = firstIndexOfD(d);
		
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
	public B getFirstBByD(D d)
	{
		int index = firstIndexOfD(d);
		
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
	public C getFirstCByD(D d)
	{
		int index = firstIndexOfD(d);
		
		return index != -1 ? getC0(index) : null;
	}
	public D getFirstDByA(A a)
	{
		int index = firstIndexOfA(a);
		
		return index != -1 ? getD0(index) : null;
	}
	public D getFirstDByB(B b)
	{
		int index = firstIndexOfB(b);
		
		return index != -1 ? getD0(index) : null;
	}
	public D getFirstDByC(C c)
	{
		int index = firstIndexOfC(c);
		
		return index != -1 ? getD0(index) : null;
	}


	
	
	public List<IDMap4Base<A,B,C,D>> getByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return get(indices);
	}
	public List<IDMap4Base<A,B,C,D>> getByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return get(indices);
	}
	public List<IDMap4Base<A,B,C,D>> getByC(C c)
	{
		int[] indices = indicesOfC(c);
		
		return get(indices);
	}
	public List<IDMap4Base<A,B,C,D>> getByD(D d)
	{
		int[] indices = indicesOfD(d);
		
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
	public List<A> getAByD(D d)
	{
		int[] indices = indicesOfD(d);
		
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
	public List<B> getBByD(D d)
	{
		int[] indices = indicesOfD(d);
		
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
	public List<C> getCByD(D d)
	{
		int[] indices = indicesOfD(d);
		
		return getC0(indices);
	}
	public List<D> getDByA(A a)
	{
		int[] indices = indicesOfA(a);
		
		return getD0(indices);
	}
	public List<D> getDByB(B b)
	{
		int[] indices = indicesOfB(b);
		
		return getD0(indices);
	}
	public List<D> getDByC(C c)
	{
		int[] indices = indicesOfC(c);
	
		return getD0(indices);
	}
	
	
	
	public int firstIndexOf(A a, B b, C c, D d) { return firstIndexOf(Auto.DMap4(a, b, c, d)); }	
	public int firstIndexOf(IDMap4Base<A,B,C,D> entry)
	{
		MemoryIterator<IDMap4Base<A,B,C,D>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return i.index();
		
		return -1;
	}
	public int firstIndexOfA(A a) { return this.a().indexOf(a); }
	public int firstIndexOfB(B b) { return this.b().indexOf(b); }
	public int firstIndexOfC(C c) { return this.c().indexOf(c); }
	public int firstIndexOfD(D d) { return this.d().indexOf(d); }
	
	
	
	public boolean contains(A a, B b, C c, D d) { return contains(Auto.DMap4(a, b, c, d)); }
	public boolean contains(IDMap4Base<A,B,C,D> entry)
	{
		Iterator<IDMap4Base<A,B,C,D>> i = iterator();
		
		while(i.hasNext()) if(i.next().equals(entry)) return true;	
		
		return false;
	}
	public boolean containsA(A a) { return converter_ToA.toList(iterator()).contains(a); }
	public boolean containsB(B b) { return converter_ToB.toList(iterator()).contains(b); }
	public boolean containsC(C c) { return converter_ToC.toList(iterator()).contains(c); }
	public boolean containsD(D d) { return converter_ToD.toList(iterator()).contains(d); }
	
	
	
	public int[] indicesOf(A a, B b, C c, D d) { return indicesOf(Auto.DMap4(a, b, c, d)); }
	public int[] indicesOf(IDMap4Base<A,B,C,D> entry)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<IDMap4Base<A,B,C,D>> i = iterator();
		
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
	public int[] indicesOfD(D d)
	{
		ArrayList<Integer> out = Auto.ArrayList();
		
		MemoryIterator<D> i = iteratorD();
		
		while(i.hasNext()) if(i.next().equals(d)) out.add(i.index());

		return ListUtils.toIntArray(out);
	}
	
	

	public int occurrencesOf(A a, B b, C c, D d) { return occurrencesOf(Auto.DMap4(a, b, c, d)); }
	public int occurrencesOf(IDMap4Base<A,B,C,D> entry)
	{
		int out = 0;
		
		Iterator<IDMap4Base<A,B,C,D>> i = iterator();
		
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
	public int occurrencesOfD(D d)
	{
		int out = 0;
		
		Iterator<D> i = iteratorD();
		
		while(i.hasNext()) if(i.next().equals(d)) out++;
		
		return out;
	}

	
	public int size() { return this.content.size(); }

	
	
	public MemoryIterator<IDMap4Base<A,B,C,D>> iterator()
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
	public MemoryIterator<D> iteratorD()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getD());
	}

	
	
	public MemoryIterator<LinkedValue<A, IDMap4Base<A,B,C,D>>> iteratorLinkedA()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedA());
	}
	public MemoryIterator<LinkedValue<B, IDMap4Base<A,B,C,D>>> iteratorLinkedB()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedB());
	}
	public MemoryIterator<LinkedValue<C, IDMap4Base<A,B,C,D>>> iteratorLinkedC()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedC());
	}
	public MemoryIterator<LinkedValue<D, IDMap4Base<A,B,C,D>>> iteratorLinkedD()
	{
		return Auto.SimpleMemoryIterator(v -> size(), i -> this.content.get(i).getLinkedD());
	}
	
	
	
	public DMapping4<A,B,C,D> set(int index, A a, B b, C c, D d)
	{
		Validate.isInRange(0, size(), index);
		
		if(index < size())
		{
			setA0(index, a);
			setB0(index, b);
		}
		else
		{
			this.content.add(Auto.LinkedDMap4(a, b, c, d));
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> set(int index, IDMap4Base<A,B,C,D> entry) { return set(index, entry.getA(), entry.getB(), entry.getC(), entry.getD()); }
	public DMapping4<A,B,C,D> setA(int index, A a)
	{
		Validate.isInRange(0, size() -1, index);
		setA0(index, a);
		
		return this;
	}
	public DMapping4<A,B,C,D> setB(int index, B b)
	{
		Validate.isInRange(0, size() - 1, index);
		setB0(index, b);
		
		return this;
	}
	public DMapping4<A,B,C,D> setC(int index, C c)
	{
		Validate.isInRange(0, size() - 1, index);
		setC0(index, c);
		
		return this;
	}
	public DMapping4<A,B,C,D> setD(int index, D d)
	{
		Validate.isInRange(0, size() - 1, index);
		setD0(index, d);
		
		return this;
	}


	
	public DMapping4<A,B,C,D> add(A a, B b, C c, D d)
	{
		this.content.add(Auto.LinkedDMap4(a, b, c, d));
		
		return this;
	}
	public DMapping4<A,B,C,D> add(IDMap4Base<A,B,C,D> entry)
	{
		return add(entry.getA(), entry.getB(), entry.getC(), entry.getD());
	}

	
	
	public DMapping4<A,B,C,D> remove(int index)
	{
		Validate.isInRange(0, size() - 1, index);

		remove0(index);
		
		return this;
	}
	
	public DMapping4<A,B,C,D> remove(A a, B b, C c, D d) { return remove(Auto.DMap4(a, b, c, d)); }
	public DMapping4<A,B,C,D> remove(IDMap4Base<A,B,C,D> entry)
	{
		int index = -1;
		
		while(contains(entry))
		{
			index = firstIndexOf(entry);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeByA(A a)
	{
		int index = -1;
		
		while(containsA(a))
		{
			index = firstIndexOfA(a);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeByB(B b)
	{
		int index = -1;
		
		while(containsB(b))
		{
			index = firstIndexOfB(b);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeByC(C c)
	{
		int index = -1;
		
		while(containsC(c))
		{
			index = firstIndexOfC(c);
			
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeByD(D d)
	{
		int index = -1;
		
		while(containsD(d))
		{
			index = firstIndexOfD(d);
			
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping4<A,B,C,D> removeFirst(A a, B b, C c, D d) { return removeFirst(Auto.DMap4(a, b, c, d)); }
	public DMapping4<A,B,C,D> removeFirst(IDMap4Base<A,B,C,D> entry)
	{
		int index = firstIndexOf(entry);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeFirstByA(A a)
	{
		int index = firstIndexOfA(a);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeFirstByB(B b)
	{
		int index = firstIndexOfB(b);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeFirstByC(C c)
	{
		int index = firstIndexOfC(c);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> removeFirstByD(D d)
	{
		int index = firstIndexOfD(d);
		if(index != -1)
		{
			remove0(index);
		}
		
		return this;
	}
	
	
	
	public DMapping4<A,B,C,D> sortByLinkedA(Comparator<? super LinkedValue<A,IDMap4Base<A,B,C,D>>> comp)
	{
		List<LinkedValue<A, IDMap4Base<A,B,C,D>>> e = linkedA();
		
		e.sort(comp);

		Iterator<LinkedValue<A, IDMap4Base<A,B,C,D>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> sortByLinkedB(Comparator<? super LinkedValue<B,IDMap4Base<A,B,C,D>>> comp)
	{
		List<LinkedValue<B, IDMap4Base<A,B,C,D>>> e = linkedB();
		
		e.sort(comp);
		
		Iterator<LinkedValue<B, IDMap4Base<A,B,C,D>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> sortByLinkedC(Comparator<? super LinkedValue<C,IDMap4Base<A,B,C,D>>> comp)
	{
		List<LinkedValue<C, IDMap4Base<A,B,C,D>>> e = linkedC();
		
		e.sort(comp);
		
		Iterator<LinkedValue<C, IDMap4Base<A,B,C,D>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	public DMapping4<A,B,C,D> sortByLinkedD(Comparator<? super LinkedValue<D,IDMap4Base<A,B,C,D>>> comp)
	{
		List<LinkedValue<D, IDMap4Base<A,B,C,D>>> e = linkedD();
		
		e.sort(comp);
		
		Iterator<LinkedValue<D, IDMap4Base<A,B,C,D>>> i = e.iterator();
		
		clear();
		
		while(i.hasNext())
		{
			add(i.next().parent());
		}
		
		return this;
	}
	
	
	
	public DMapping4<A,B,C,D> sortByA(Comparator<? super A> comp)
	{
		return sortByLinkedA((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping4<A,B,C,D> sortByB(Comparator<? super B> comp)
	{
		return sortByLinkedB((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping4<A,B,C,D> sortByC(Comparator<? super C> comp)
	{
		return sortByLinkedC((a,b) -> comp.compare(a.value(), b.value()));
	}
	public DMapping4<A,B,C,D> sortByD(Comparator<? super D> comp)
	{
		return sortByLinkedD((a,b) -> comp.compare(a.value(), b.value()));
	}

	
	
	public DMapping4<A,B,C,D> clear()
	{
		this.content.clear();
		
		return this;
	}

	
	
	private IDMap4Base<A,B,C,D> get0(int index) { return this.content.get(index); }
	private A getA0(int index) { return this.content.get(index).getA(); } 
	private B getB0(int index) { return this.content.get(index).getB(); } 
	private C getC0(int index) { return this.content.get(index).getC(); }
	private D getD0(int index) { return this.content.get(index).getD(); } 
	
	
	
	private List<IDMap4Base<A,B,C,D>> get0(int... indices)
	{
		ArrayList<IDMap4Base<A,B,C,D>> out = Auto.ArrayList();
		
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
	private List<D> getD0(int... indices)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int i : indices)
		{
			out.add(getD0(i));
		}
		
		return out;
	}
	
	
	
	private void setA0(int index, A a) { this.content.get(index).setA(a); }
	private void setB0(int index, B b) { this.content.get(index).setB(b); }
	private void setC0(int index, C c) { this.content.get(index).setC(c); }
	private void setD0(int index, D d) { this.content.get(index).setD(d); }
	
	
	
	private void remove0(int index)
	{
		this.content.remove(index);
	}

}

