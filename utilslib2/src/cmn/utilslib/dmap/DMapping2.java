
package cmn.utilslib.dmap;



import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.ListUtils;



/**
 * 
 * @author picatrix1899
 *
 */
public class DMapping2<A,B>
{
	
	public static final short DIMENSIONS = 2;
	
	
	
	protected ArrayList<A> a = new ArrayList<A>();
	protected ArrayList<B> b = new ArrayList<B>();
	
	protected int size = 0;
	
	
	
	public DMapping2<A,B> set(int index, DMap2<A,B> entry)  { return set(index, entry.getA(), entry.getB()); }
	
	public DMapping2<A,B> set(int index, A a, B b) 
	{
		
		if(index == getSize())
		{
			add(a, b);
		}
		else
		{
			this.a.set(index, a);
			this.b.set(index, b);			
		}
		
		return this;
	}
	
	
	public DMapping2<A,B> setA(int index, A a)
	{
		
		this.a.set(index, a); return this;
	}
	
	public DMapping2<A,B> setB(int index, B b)
	{
		
		this.b.set(index, b); return this;
	}	
	
	
	
	public DMap2<A,B> get(int index)
	{
		
		return new DMap2<A,B>(getA(index), getB(index));
	}	
	
	
	public A getA(int index)
	{
		
		return this.a.get(index);
	}
	
	public B getB(int index)
	{ 
		
		return this.b.get(index);
	}
	
	
	
	public DMap2<A,B> getbyA(A a) { return (!containsA(a)) ? null : get(indexOfA(a)); }
	
	public DMap2<A,B> getbyB(B b) { return (!containsB(b)) ? null : get(indexOfB(b)); }
	
	
	
	public B getBbyA(A a) { return (!containsA(a)) ? null : getB(indexOfA(a)); }
	
	public A getAbyB(B b) { return (!containsB(b)) ? null : getA(indexOfB(b)); }
	
	
	
	public List<A> a() { return this.a; }
	
	public List<B> b() { return this.b; }
	
	
	
	public int getSize() { return this.size; }	
	
	
	
	public DMapping2<A,B> add(DMap2<A,B> entry) { return add(entry.getA(), entry.getB()); }
	
	public DMapping2<A,B> add(A a, B b)
	{
		this.a.add(a);
		this.b.add(b);
		
		this.size++;
		
		return this;
		
	}

	
	
	public DMapping2<A,B> remove(int index)
	{
		
		this.a.remove(index);
		this.b.remove(index);
		
		this.size--;
		
		return this;
	}
	

	
	public int indexOf(DMap2<A,B> m) { return indexOf(m.getA(), m.getB()); }
	
	public int indexOf(A a, B b)
	{
		if(!(containsA(a) && containsB(b))) return -1;
		
		for(int i : indicesOfA(a))
		{
			if(getB(i).equals(b) || getB(i) == b) return i;			
		}

		return -1;
	}	
	
	
	public int indexOfA(A a) { return this.a.indexOf(a); }
	
	public int indexOfB(B b) { return this.b.indexOf(b); }
	
	
	
	public int[] indicesOfA(A a) { return ListUtils.<A>indicesOf(this.a, a); }
	
	public int[] indicesOfB(B b) { return ListUtils.<B>indicesOf(this.b, b); }
	
	
	
	public boolean contains(A a, B b) { return indexOf(a,b) == -1 ? false : true; }
	
	public boolean contains(DMap2<A,B> entry) { return contains(entry.getA(),entry.getB()); }	
	
	
	public boolean containsA(A a) { return this.a.contains(a); }
	
	public boolean containsB(B b) { return this.b.contains(b); }
	
}
