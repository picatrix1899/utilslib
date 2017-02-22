
package cmn.utilslib.dmap;



import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.ListUtils;
import cmn.utilslib.essentials.PrimeUtils;



/**
 * 

 * @author picatrix1899
 *
 */
public class DMapping3<A,B,C>
{

	public static final short DIMENSIONS = 3;
	
	protected ArrayList<A> a = new ArrayList<A>();
	protected ArrayList<B> b = new ArrayList<B>();
	protected ArrayList<C> c = new ArrayList<C>();
	
	protected int size = 0;	
	
	
	
	public DMapping3<A,B,C> set(int index, DMap3<A,B,C> entry) { return set(index, entry.getA(), entry.getB(), entry.getC()); }
	
	public DMapping3<A,B,C> set(int index, A a, B b,C c) 
	{

		
		if(index == getSize())
		{
			add(a, b, c);
		}
		else
		{
			this.a.set(index, a);
			this.b.set(index, b);
			this.c.set(index, c);			
		}
		
		return this;
	}
	
	
	public DMapping3<A,B,C> setA(int index, A a) { validate0(index); this.a.set(index, a); return this; }
	
	public DMapping3<A,B,C> setB(int index, B b) { validate0(index); this.b.set(index, b); return this; }
	
	public DMapping3<A,B,C> setC(int index, C c) {validate0(index); this.c.set(index, c); return this; }
		
	
	
	public DMap3<A,B,C> get(int index) { validate0(index); return new DMap3<A,B,C>(getA(index), getB(index), getC(index)); }
	
	
	public A getA(int index) { validate0(index); return this.a.get(index); }
	
	public B getB(int index) { validate0(index); return this.b.get(index); }
	
	public C getC(int index) { validate0(index); return this.c.get(index); }
	
	
	
	public DMap3<A,B,C> getbyA(A a) { return (!containsA(a)) ? null : get(indexOfA(a)); }
	
	public DMap3<A,B,C> getbyB(B b) { return (!containsB(b)) ? null : get(indexOfB(b)); }
	
	public DMap3<A,B,C> getbyC(C c) { return (!containsC(c)) ? null : get(indexOfC(c)); }
	
	
	public DMap3<A,B,C> getbyAB(A a, B b) { return ((!containsA(a)) || (!containsB(b) || (!containsAB(a, b)))) ? null : get0(indexOfAB(a, b)); }
	
	public DMap3<A,B,C> getbyAC(A a, C c) { return ((!containsA(a)) || (!containsC(c) || (!containsAC(a, c)))) ? null : get0(indexOfAC(a, c)); }
	
	public DMap3<A,B,C> getbyBC(B b, C c) { return ((!containsB(b)) || (!containsC(c) || (!containsBC(b, c)))) ? null :  get0(indexOfBC(b, c)); }
	
	
	
	public A getAbyB(B b) { return (!containsB(b)) ? null : getA0(indexOfB(b)); }
	
	public A getAbyC(C c) { return (!containsC(c)) ? null : getA0(indexOfC(c)); }
	
	public B getBbyA(A a) { return (!containsA(a)) ? null : getB0(indexOfA(a)); }
	
	public B getBbyC(C c) { return (!containsC(c)) ? null : getB0(indexOfC(c)); }
	
	public C getCbyA(A a) { return (!containsA(a)) ? null : getC0(indexOfA(a)); }
	
	public C getCbyB(B b) { return (!containsB(b)) ? null : getC0(indexOfB(b)); }
	
	
	
	public A getAbyBC(B b, C c) { return ((!containsB(b)) || (!containsC(c) || (!containsBC(b, c)))) ? null : getA0(indexOfBC(b, c)); }
	
	public B getBbyAC(A a, C c) { return ((!containsA(a)) || (!containsC(c) || (!containsAC(a, c)))) ? null : getB0(indexOfAC(a, c)); }
	
	public C getCbyAB(A a, B b) { return ((!containsA(a)) || (!containsB(b) || (!containsAB(a, b)))) ? null : getC0(indexOfAB(a, b)); }
	
	
	
	public ArrayList<A> getAListByB(B b)
	{
		ArrayList<A> out = new ArrayList<A>();
		
		for(int index : indicesOfB(b))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<A> getAListByC(C c)
	{
		ArrayList<A> out = new ArrayList<A>();
		
		for(int index : indicesOfC(c))
			out.add(getA0(index));
		
		return out;
	}
	
	
	
	public ArrayList<B> getBListByA(A a)
	{
		ArrayList<B> out = new ArrayList<B>();
		
		for(int index : indicesOfA(a))
			out.add(getB0(index));
	
		return out;
	}
	
	public ArrayList<B> getBListByC(C c)
	{
		ArrayList<B> out = new ArrayList<B>();
		
		for(int index : indicesOfC(c))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByA(A a)
	{
		ArrayList<C> out = new ArrayList<C>();
		
		for(int index : indicesOfA(a))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByB(B b)
	{
		ArrayList<C> out = new ArrayList<C>();
		
		for(int index : indicesOfB(b))
			out.add(getC0(index));
		
		return out;
	}
	
	
	
	public ArrayList<DMap3<A,B,C>> getListByA(A a)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfA(a))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<DMap3<A,B,C>> getListByB(B b)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfB(b))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<DMap3<A,B,C>> getListByC(C c)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfC(c))
			out.add(get0(index));
		
		return out;
	}
	
	
	
	public ArrayList<A> getAListByBC(B b, C c)
	{
		ArrayList<A> out = new ArrayList<A>();
		
		for(int index : indicesOfBC(b, c))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByAC(A a, C c)
	{
		ArrayList<B> out = new ArrayList<B>();
		
		for(int index : indicesOfAC(a, c))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByAB(A a, B b)
	{
		ArrayList<C> out = new ArrayList<C>();
		
		for(int index : indicesOfAB(a, b))
			out.add(getC0(index));
		
		return out;
	}
	
	
	
	public ArrayList<DMap3<A,B,C>> getListByAB(A a, B b)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfAB(a, b))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<DMap3<A,B,C>> getListByAC(A a, C c)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfAC(a, c))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<DMap3<A,B,C>> getListByBC(B b, C c)
	{
		ArrayList<DMap3<A,B,C>> out = new ArrayList<DMap3<A,B,C>>();
		
		for(int index : indicesOfBC(b, c))
			out.add(get0(index));
		
		return out;
	}
	
	
	
	public List<A> a() { return this.a; }
	
	public List<B> b() { return this.b; }
	
	public List<C> c() { return this.c; }
	
	
	
	public int getSize() { return this.size; }
	
	
	
	public DMapping3<A,B,C> add(DMap3<A,B,C> entry) { return add(entry.getA(), entry.getB(), entry.getC()); }
	
	public DMapping3<A,B,C> add(A a, B b,C c)
	{
		this.a.add(a);
		this.b.add(b);
		this.c.add(c);
		this.size++;
		
		return this;
	}
	
	

	public DMapping3<A,B,C> remove(int index)
	{
		validate0(index);
		
		this.a.remove(index);
		this.b.remove(index);
		this.c.remove(index);
		this.size--;
		
		return this;
	}
	
	
	
	public int indexOfA(A a) { return this.a.indexOf(a); }
	
	public int indexOfB(B b) { return this.b.indexOf(b); }
	
	public int indexOfC(C c) { return this.c.indexOf(c); }
	
	
	
	public int[] indicesOfA(A a) { return ListUtils.<A>indicesOf(this.a, a); }
	
	public int[] indicesOfB(B b) { return ListUtils.<B>indicesOf(this.b, b); }
	
	public int[] indicesOfC(C c) { return ListUtils.<C>indicesOf(this.c, c); }
	
	
	
	public int[] indicesOfAB(A a, B b)
	{
		if(!containsA(a) || !containsB(b)) return null;
		if(indicesOfA(a) == null) return null;		
	
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int x : indicesOfA(a))
			if(getB0(x).equals(b) || getB0(x) == b) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfAC(A a, C c)
	{
		if(!containsA(a) || !containsC(c)) return null;
		if(indicesOfA(a) == null) return null;		
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int x : indicesOfA(a))
			if(getC0(x).equals(c) || getC0(x) == c) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}	
	
	public int[] indicesOfBC(B b, C c)
	{
		if(!containsB(b) || !containsC(c)) return null;
		if(indicesOfB(b) == null) return null;		
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int x : indicesOfB(b))
			if(getC0(x).equals(c) || getC0(x) == c) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	
	
	public int indexOfAB(A a, B b) { return indicesOfAB(a, b) == null ? -1 : indicesOfAB(a, b)[0]; }
	
	public int indexOfAC(A a, C c) { return indicesOfAC(a, c) == null ? -1 : indicesOfAC(a, c)[0]; }
	
	public int indexOfBC(B b, C c) { return indicesOfBC(b, c) == null ? -1 : indicesOfBC(b, c)[0]; }
	
	

	public int indexOf(DMap3<A,B,C> m) { return indexOf(m.getA(), m.getB(), m.getC()); }
	
	public int indexOf(A a, B b, C c)
	{
		if(!containsA(a) || !containsB(b) || !containsC(c)) return -1;
		
		for(int i : indicesOfAB(a,b))
			if(getC0(i).equals(c) || getC0(i) == c) return i;
		
		return -1;
	}
	
	
	
	public boolean containsA(A a) { return this.a.contains(a); }
	
	public boolean containsB(B b) { return this.b.contains(b); }
	
	public boolean containsC(C c) { return this.c.contains(c); }
	
	
	
	public boolean contains(A a,B b,C c) { return indexOf(a, b, c) == -1 ? false : true; }
	
	public boolean contains(DMap3<A,B,C> m) { return contains(m.getA(), m.getB(), m.getC()); }
	
	
	
	public boolean containsAB(A a , B b) { return indexOfAB(a, b) != -1; }
	
	public boolean containsAC(A a , C c) { return indexOfAC(a, c) != -1; }
	
	public boolean containsBC(B b , C c) { return indexOfBC(b, c) != -1; }
	
	

	protected void validate0(int i)
	{

	}	
	
	
	
	private DMap3<A,B,C> get0(int index) { return index == -1 ? null : get(index); }
	
	
	
	private A getA0(int index) { return index == -1 ? null : getA(index); }
	
	private B getB0(int index) { return index == -1 ? null : getB(index); }
	
	private C getC0(int index) { return index == -1 ? null : getC(index); }

}
