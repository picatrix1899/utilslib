
package cmn.utilslib.dmap;



import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.dmap.IDMapping4Foundation.IDMapping4;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;
import cmn.utilslib.essentials.ListUtils;
import cmn.utilslib.essentials.PrimeUtils;



/**
 * 

 * @author picatrix1899
 *
 */
public class DMapping4<A,B,C,D> implements IDMapping4<DMapping4<A,B,C,D>,A,B,C,D>
{

	private ArrayList<A> a = Auto.ArrayList();
	private ArrayList<B> b = Auto.ArrayList();
	private ArrayList<C> c = Auto.ArrayList();
	private ArrayList<D> d = Auto.ArrayList();
	
	private int size = 0;
	
	
	
	public DMapping4<A,B,C,D> set(int index, IPair4Base<A,B,C,D> entry) { return set(index, entry.getA(), entry.getB(), entry.getC(), entry.getD()); }
	
	public DMapping4<A,B,C,D> set(int index, A a, B b,C c, D d) 
	{

		
		if(index == size())
		{
			add(a, b, c, d);
		}
		else
		{
			this.a.set(index, a);
			this.b.set(index, b);
			this.c.set(index, c);
			this.d.set(index, d);
		}

		
		return this;
	}
	
	
	
	public DMapping4<A,B,C,D> setA(int index, A a) { validate0(index); this.a.set(index, a); return this; }
	
	public DMapping4<A,B,C,D> setB(int index, B b) { validate0(index); this.b.set(index, b); return this; }
	
	public DMapping4<A,B,C,D> setC(int index, C c) { validate0(index); this.c.set(index, c); return this; }
	
	public DMapping4<A,B,C,D> setD(int index, D d) { validate0(index); this.d.set(index, d); return this; }	
	
	
	
	public Pair4<A,B,C,D> get(int index) { validate0(index); return Auto.Pair4(getA(index), getB(index), getC(index), getD(index)); }
	
	
	
	public A getA(int index) { validate0(index); return this.a.get(index); }
	
	public B getB(int index) { validate0(index); return this.b.get(index); }
	
	public C getC(int index) { validate0(index); return this.c.get(index); }
	
	public D getD(int index) { validate0(index); return this.d.get(index); }
	
		
	
	public Pair4<A,B,C,D> getbyA(A a) { return (!containsA(a)) ? null : get(indexOfA(a)); }
	
	public Pair4<A,B,C,D> getbyB(B b) { return (!containsB(b)) ? null : get(indexOfB(b)); }
	
	public Pair4<A,B,C,D> getbyC(C c) { return (!containsC(c)) ? null : get(indexOfC(c)); }
	
	public Pair4<A,B,C,D> getbyD(D d) { return (!containsD(d)) ? null : get(indexOfD(d)); }
	
	
	
	public Pair4<A,B,C,D> getbyAB(A a, B b) { return !containsAB(a, b) ? null : get0(indexOfAB(a, b)); }
	
	public Pair4<A,B,C,D> getbyAC(A a, C c) { return !containsAC(a, c) ? null : get0(indexOfAC(a, c)); }
	
	public Pair4<A,B,C,D> getbyAD(A a, D d) { return !containsAD(a, d) ? null : get0(indexOfAD(a, d)); }
	
	public Pair4<A,B,C,D> getbyBC(B b, C c) { return !containsBC(b, c) ? null :  get0(indexOfBC(b, c)); }
	
	public Pair4<A,B,C,D> getbyBD(B b, D d) { return !containsBD(b, d) ? null :  get0(indexOfBD(b, d)); }
	
	public Pair4<A,B,C,D> getbyCD(C c, D d) { return !containsCD(c, d) ? null :  get0(indexOfCD(c, d)); }
	
	
	
	public Pair4<A,B,C,D> getbyABC(A a, B b, C c) { return !containsABC(a, b, c) ? null :  get0(indexOfABC(a, b, c)); }
	
	public Pair4<A,B,C,D> getbyABD(A a, B b, D d) { return !containsABD(a, b, d) ? null :  get0(indexOfABD(a, b, d)); }
	
	public Pair4<A,B,C,D> getbyACD(A a, C c, D d) { return !containsACD(a, c, d) ? null :  get0(indexOfACD(a, c, d)); }
	
	public Pair4<A,B,C,D> getbyBCD(B b, C c, D d) { return !containsBCD(b, c, d) ? null :  get0(indexOfBCD(b, c, d)); }
	
	
	
	public A getAbyB(B b) { return !containsB(b) ? null : getA0(indexOfB(b)); }
	
	public A getAbyC(C c) { return !containsC(c) ? null : getA0(indexOfC(c)); }
	
	public A getAbyD(D d) { return !containsD(d) ? null : getA0(indexOfD(d)); }
	
	public B getBbyA(A a) { return !containsA(a) ? null : getB0(indexOfA(a)); }
	
	public B getBbyC(C c) { return !containsC(c) ? null : getB0(indexOfC(c)); }
	
	public B getBbyD(D d) { return !containsD(d) ? null : getB0(indexOfD(d)); }
	
	public C getCbyA(A a) { return !containsA(a) ? null : getC0(indexOfA(a)); }
	
	public C getCbyB(B b) { return !containsB(b) ? null : getC0(indexOfB(b)); }
	
	public C getCbyD(D d) { return !containsD(d) ? null : getC0(indexOfD(d)); }
	
	public D getDbyA(A a) { return !containsA(a) ? null : getD0(indexOfA(a)); }
	
	public D getDbyB(B b) { return !containsB(b) ? null : getD0(indexOfB(b)); }
	
	public D getDbyC(C c) { return !containsC(c) ? null : getD0(indexOfC(c)); }
	
	
	
	public A getAbyBC(B b, C c) { return !containsBC(b, c) ? null : getA0(indexOfBC(b, c)); }
	
	public A getAbyBD(B b, D d) { return !containsBD(b, d) ? null : getA0(indexOfBD(b, d)); }
	
	public B getBbyAC(A a, C c) { return !containsAC(a, c) ? null : getB0(indexOfAC(a, c)); }
	
	public B getBbyAD(A a, D d) { return !containsAD(a, d) ? null : getB0(indexOfAD(a, d)); }
	
	public C getCbyAB(A a, B b) { return !containsAB(a, b) ? null : getC0(indexOfAB(a, b)); }
	
	public C getCbyAD(A a, D d) { return !containsAD(a, d) ? null : getC0(indexOfAD(a, d)); }
	
	public D getDbyAB(A a, B b) { return !containsAB(a, b) ? null : getD0(indexOfAB(a, b)); }
	
	public D getDbyAC(A a, C c) { return !containsAC(a, c) ? null : getD0(indexOfAC(a, c)); }
	
	
	
	public A getAbyBCD(B b, C c, D d) { return !containsBCD(b, c, d) ? null : getA0(indexOfBCD(b, c, d)); }
	
	public B getBbyACD(A a, C c, D d) { return !containsACD(a, c, d) ? null : getB0(indexOfACD(a, c, d)); }
	
	public C getCbyABD(A a, B b, D d) { return !containsABD(a, b, d) ? null : getC0(indexOfABD(a, b, d)); }
	
	public D getDbyABC(A a, B b, C c) { return !containsABC(a, b, c) ? null : getD0(indexOfABC(a, b, c)); }
	
	
	
	public ArrayList<A> getAListByB(B b)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfB(b))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<A> getAListByC(C c)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfC(c))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<A> getAListByD(D d)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfD(d))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByA(A a)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfA(a))
			out.add(getB0(index));
	
		return out;
	}
	
	public ArrayList<B> getBListByC(C c)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfC(c))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByD(D d)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfD(d))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByA(A a)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfA(a))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByB(B b)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfB(b))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByD(D d)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfD(d))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<D> getDListByA(A a)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int index : indicesOfA(a))
			out.add(getD0(index));
		
		return out;
	}
	
	public ArrayList<D> getDListByB(B b)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int index : indicesOfB(b))
			out.add(getD0(index));
		
		return out;
	}
	
	public ArrayList<D> getDListByC(C c)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int index : indicesOfC(c))
			out.add(getD0(index));
		
		return out;
	}
	
	
	
	public ArrayList<Pair4<A,B,C,D>> getListByA(A a)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfA(a))
			out.add(get0(index));
	
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByB(B b)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfB(b))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByC(C c)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfC(c))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByD(D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfD(d))
			out.add(get0(index));
		
		return out;
	}
	
	
	
	public ArrayList<A> getAListByBC(B b, C c)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfBC(b, c))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<A> getAListByBD(B b, D d)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfBD(b, d))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByAC(A a, C c)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfAC(a, c))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByAD(A a, D d)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfAD(a, d))
			out.add(getB0(index));
		
		return out;
	}		
	
	public ArrayList<C> getCListByAB(A a, B b)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfAB(a, b))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByAD(A a, D d)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfAD(a, d))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<D> getDListByAB(A a, B b)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int index : indicesOfAB(a, b))
			out.add(getD0(index));
		
		return out;
	}

	
	
	public ArrayList<Pair4<A,B,C,D>> getListByAB(A a, B b)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfAB(a, b))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByAC(A a, C c)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfAC(a, c))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByAD(A a, D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfAD(a, d))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByBC(B b, C c)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfBC(b, c))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByBD(B b, D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfBD(b, d))
			out.add(get0(index));
		
		return out;
	}
	
	
	
	public ArrayList<A> getAListByBCD(B b, C c, D d)
	{
		ArrayList<A> out = Auto.ArrayList();
		
		for(int index : indicesOfBCD(b, c, d))
			out.add(getA0(index));
		
		return out;
	}
	
	public ArrayList<B> getBListByACD(A a, C c, D d)
	{
		ArrayList<B> out = Auto.ArrayList();
		
		for(int index : indicesOfACD(a, c, d))
			out.add(getB0(index));
		
		return out;
	}
	
	public ArrayList<C> getCListByABD(A a, B b, D d)
	{
		ArrayList<C> out = Auto.ArrayList();
		
		for(int index : indicesOfABD(a, b, d))
			out.add(getC0(index));
		
		return out;
	}
	
	public ArrayList<D> getDListByABC(A a, B b, C c)
	{
		ArrayList<D> out = Auto.ArrayList();
		
		for(int index : indicesOfABC(a, b, c))
			out.add(getD0(index));
		
		return out;
	}
	
	
	
	public ArrayList<Pair4<A,B,C,D>> getListByABC(A a, B b, C c)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfABC(a, b, c))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByABD(A a, B b, D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfABD(a, b, d))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>> getListByACD(A a, C c, D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfACD(a, c, d))
			out.add(get0(index));
		
		return out;
	}
	
	public ArrayList<Pair4<A,B,C,D>>getListByBCD(B b, C c, D d)
	{
		ArrayList<Pair4<A,B,C,D>> out = Auto.ArrayList();
		
		for(int index : indicesOfBCD(b, c, d))
			out.add(get0(index));
		
		return out;
	}
	
	
	
	public List<A> a() { return this.a; }
	
	public List<B> b() { return this.b; }
	
	public List<C> c() { return this.c; }
	
	public List<D> d() { return this.d; }
	
	
	
	public int size() { return this.size; }
	
	
	
	public DMapping4<A,B,C,D> add(IPair4Base<A,B,C,D> entry) { return add(entry.getA(), entry.getB(), entry.getC(), entry.getD()); }
	
	public DMapping4<A,B,C,D> add(A a, B b,C c, D d)
	{
		this.a.add(a);
		this.b.add(b);
		this.c.add(c);
		this.d.add(d);
		this.size++;
		
		return this;
	}
	
	
	
	public DMapping4<A,B,C,D> remove(int index)
	{
		this.a.remove(index);
		this.b.remove(index);
		this.c.remove(index);
		this.d.remove(index);
		this.size--;
		
		return this;
	}

	
	
	public int indexOfA(A a) { return this.a.indexOf(a); }
	
	public int indexOfB(B b) { return this.b.indexOf(b); }
	
	public int indexOfC(C c) { return this.c.indexOf(c); }
	
	public int indexOfD(D d) { return this.d.indexOf(d); }
	
	
	
	public int[] indicesOfA(A a) { return ListUtils.<A>indicesOf(this.a, a); }
	
	public int[] indicesOfB(B b) { return ListUtils.<B>indicesOf(this.b, b); }
	
	public int[] indicesOfC(C c) { return ListUtils.<C>indicesOf(this.c, c); }
	
	public int[] indicesOfD(D d) { return ListUtils.<D>indicesOf(this.d, d); }
	
	
	
	public int[] indicesOfAB(A a, B b)
	{
		if(Check.notTrueOOO(containsA(a), containsB(b))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
	
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isEqual(b, getB0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfAC(A a, C c)
	{
		if(Check.notTrueOOO(containsA(a), containsC(c))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isEqual(c, getC0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfAD(A a, D d)
	{
		if(Check.notTrueOOO(containsA(a), containsD(d))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isEqual(d, getD0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfBC(B b, C c)
	{
		if(Check.notTrueOOO(containsB(b), containsC(c))) return null;
		if(Check.isNull(indicesOfB(b))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfB(b))
			if(Check.isEqual(c, getC0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfBD(B b, D d)
	{
		if(Check.notTrueOOO(containsB(b), containsD(d))) return null;
		if(Check.isNull(indicesOfB(b))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfB(b))
			if(Check.isEqual(d, getD0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfCD(C c, D d)
	{
		if(Check.notTrueOOO(containsC(c), containsD(d))) return null;
		if(Check.isNull(indicesOfC(c))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfC(c))
			if(Check.isEqual(d, getD0(x))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	
	
	public int[] indicesOfABC(A a, B b, C c)
	{
		if(Check.notTrueOOO(containsA(a), containsB(b), containsC(c))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isTrue(Check.isEqual(b, getB0(x)), Check.isEqual(c, getC0(x)))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfACD(A a, C c, D d)
	{
		if(Check.notTrueOOO(containsA(a), containsC(c), containsD(d))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isTrue(Check.isEqual(c, getC0(x)), Check.isEqual(d, getD0(x)))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfABD(A a, B b, D d)
	{
		if(Check.notTrueOOO(containsA(a), containsB(b), containsD(d))) return null;
		if(Check.isNull(indicesOfA(a))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfA(a))
			if(Check.isTrue(Check.isEqual(b, getB0(x)), Check.isEqual(d, getD0(x)))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	public int[] indicesOfBCD(B b, C c, D d)
	{
		if (Check.notTrueOOO(containsB(b), containsC(c), containsD(d))) return null;
		if(Check.isNull(indicesOfB(b))) return null;
		
		ArrayList<Integer> out = Auto.ArrayList();
		
		for(int x : indicesOfB(b))
			if(Check.isTrue(Check.isEqual(c, getC0(x)), Check.isEqual(d, getD(x)))) out.add(x);
		
		if(out.size() == 0) return null;
		
		return PrimeUtils.toInt(ListUtils.<Integer>ListToArray(out, Integer.class));
	}
	
	
	
	public int indexOfAB(A a, B b) { return indicesOfAB(a, b) == null ? -1 : indicesOfAB(a, b)[0]; }
	
	public int indexOfAC(A a, C c) { return indicesOfAC(a, c) == null ? -1 : indicesOfAC(a, c)[0]; }
	
	public int indexOfAD(A a, D d) { return indicesOfAD(a, d) == null ? -1 : indicesOfAD(a, d)[0]; }
	
	public int indexOfBC(B b, C c) { return indicesOfBC(b, c) == null ? -1 : indicesOfBC(b, c)[0]; }
	
	public int indexOfBD(B b, D d) { return indicesOfBD(b, d) == null ? -1 : indicesOfBD(b, d)[0]; }
	
	public int indexOfCD(C c, D d) { return indicesOfCD(c, d) == null ? -1 : indicesOfCD(c, d)[0]; }
	
	
	
	public int indexOfABC(A a, B b, C c) { return indicesOfABC(a, b, c) == null ? -1 : indicesOfABC(a, b, c)[0]; }
	
	public int indexOfACD(A a, C c, D d) { return indicesOfACD(a, c, d) == null ? -1 : indicesOfACD(a, c, d)[0]; }
	
	public int indexOfABD(A a, B b, D d) { return indicesOfABD(a, b, d) == null ? -1 : indicesOfABD(a, b, d)[0]; }
	
	public int indexOfBCD(B b, C c, D d) { return indicesOfBCD(b, c, d) == null ? -1 : indicesOfBCD(b, c, d)[0]; }
	
	

	public int indexOf(IPair4Base<A,B,C,D> m) { return indexOf(m.getA(), m.getB(), m.getC(), m.getD()); }
	
	public int indexOf(A a, B b, C c, D d)
	{
		if(Check.notTrueOOO(containsA(a), containsB(b), containsC(c), containsD(d))) return -1;
		
		for(int i : indicesOfAB(a,b))
			if(Check.isEqual(c, getC0(i)))
				if(Check.isEqual(d, getD0(i))) return i;
		
		return -1;
	}
	
	
	
	public boolean containsA(A a) { return this.a.contains(a); }
	
	public boolean containsB(B b) { return this.b.contains(b); }
	
	public boolean containsC(C c) { return this.c.contains(c); }
	
	public boolean containsD(D d) { return this.d.contains(d); }
	
	
	
	public boolean contains(A a,B b,C c, D d) { return indexOf(a, b, c, d) == -1 ? false : true; }
	
	public boolean contains(IPair4Base<A,B,C,D> m) { return contains(m.getA(), m.getB(), m.getC(), m.getD()); }
	
	
	
	public boolean containsAB(A a , B b) { return indexOfAB(a, b) != -1; }
	
	public boolean containsAC(A a , C c) { return indexOfAC(a, c) != -1; }
	
	public boolean containsAD(A a , D d) { return indexOfAD(a, d) != -1; }
	
	public boolean containsBC(B b , C c) { return indexOfBC(b, c) != -1; }
	
	public boolean containsBD(B b , D d) { return indexOfBD(b, d) != -1; }
	
	public boolean containsCD(C c , D d) { return indexOfCD(c, d) != -1; }
	
	
	
	public boolean containsABC(A a, B b, C c) { return indexOfABC(a, b, c) != -1; }
	
	public boolean containsABD(A a, B b, D d) { return indexOfABD(a, b, d) != -1; }
	
	public boolean containsACD(A a, C c, D d) { return indexOfACD(a, c, d) != -1; }
	
	public boolean containsBCD(B b, C c, D d) { return indexOfBCD(b, c, d) != -1; }
	
	
	
	protected void validate0(int i)
	{
		
	}
	

	
	private Pair4<A,B,C,D> get0(int index) { return index == -1 ? null : get(index); }	
	
	
	
	private A getA0(int index) { return index == -1 ? null : getA(index); }
	
	private B getB0(int index) { return index == -1 ? null : getB(index); }
	
	private C getC0(int index) { return index == -1 ? null : getC(index); }
	
	private D getD0(int index) { return index == -1 ? null : getD(index); }
	
}
