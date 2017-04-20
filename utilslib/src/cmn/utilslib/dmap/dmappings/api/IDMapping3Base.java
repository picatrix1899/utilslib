package cmn.utilslib.dmap.dmappings.api;

import java.util.List;

import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping3Base<A,B,C>
{

	public List<A> a();
	public List<B> b();
	public List<C> c();

	
	
	public List<IDMap3Base<A,B,C>> list();
	
	
	
	public IDMap3Base<A,B,C> get(int index);
	public A getA(int index);
	public B getB(int index);
	public C getC(int index);
	
	
	
	public List<IDMap3Base<A,B,C>> get(int... index);
	public List<A> getA(int... index);
	public List<B> getB(int... index);
	public List<C> getC(int... index);
	
	
	
	public IDMap3Base<A,B,C> getFirstByA(A a);
	public IDMap3Base<A,B,C> getFirstByB(B b);
	public IDMap3Base<A,B,C> getFirstByC(C c);
	
	
	
	public A getFirstAByB(B b);
	public A getFirstAByC(C c);
	
	public B getFirstBByA(A a);
	public B getFirstBByC(C c);
	
	public C getFirstCByA(A a);
	public C getFirstCByB(B b);
	
	
	
	public List<IDMap3Base<A,B,C>> getByA(A a);
	public List<IDMap3Base<A,B,C>> getByB(B b);
	public List<IDMap3Base<A,B,C>> getByC(C c);
	
	
	
	public List<A> getAByB(B b);
	public List<A> getAByC(C c);
	
	public List<B> getBByA(A a);
	public List<B> getBByC(C c);
	
	public List<C> getCByA(A a);
	public List<C> getCByB(B b);

	
	
	public int firstIndexOf(A a, B b, C c);
	public int firstIndexOf(IDMap3Base<A,B,C> entry);
	public int firstIndexOfA(A a);
	public int firstIndexOfB(B b);
	public int firstIndexOfC(C c);
	
	
	
	public int[] indicesOf(A a, B b, C c);
	public int[] indicesOf(IDMap3Base<A,B,C> entry);
	public int[] indicesOfA(A a);
	public int[] indicesOfB(B b);
	public int[] indicesOfC(C c);
	
	
	
	public int occurrencesOf(A a, B b, C c);
	public int occurrencesOf(IDMap3Base<A,B,C> entry);
	public int occurrencesOfA(A a);
	public int occurrencesOfB(B b);
	public int occurrencesOfC(C c);
	
	
	
	public boolean contains(A a, B b, C c);	
	public boolean contains(IDMap3Base<A,B,C> entry);
	public boolean containsA(A a);
	public boolean containsB(B b);
	public boolean containsC(C c);
	
	
	
	
	public MemoryIterator<IDMap3Base<A,B,C>> iterator();
	public MemoryIterator<A> iteratorA();
	public MemoryIterator<B> iteratorB();
	public MemoryIterator<C> iteratorC();
	
	
	
	public int size();
	
}
