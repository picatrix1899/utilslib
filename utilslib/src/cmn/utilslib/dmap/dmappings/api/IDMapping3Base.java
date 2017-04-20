package cmn.utilslib.dmap.dmappings.api;

import java.util.List;

import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping3Base<A,B,C>
{

	List<A> a();
	List<B> b();
	List<C> c();

	
	
	List<IDMap3Base<A,B,C>> list();
	
	
	
	IDMap3Base<A,B,C> get(int index);
	A getA(int index);
	B getB(int index);
	C getC(int index);
	
	
	
	List<IDMap3Base<A,B,C>> get(int... index);
	List<A> getA(int... index);
	List<B> getB(int... index);
	List<C> getC(int... index);
	
	
	
	IDMap3Base<A,B,C> getFirstByA(A a);
	IDMap3Base<A,B,C> getFirstByB(B b);
	IDMap3Base<A,B,C> getFirstByC(C c);
	
	
	
	A getFirstAByB(B b);
	A getFirstAByC(C c);
	
	B getFirstBByA(A a);
	B getFirstBByC(C c);
	
	C getFirstCByA(A a);
	C getFirstCByB(B b);
	
	
	
	List<IDMap3Base<A,B,C>> getByA(A a);
	List<IDMap3Base<A,B,C>> getByB(B b);
	List<IDMap3Base<A,B,C>> getByC(C c);
	
	
	
	List<A> getAByB(B b);
	List<A> getAByC(C c);
	
	List<B> getBByA(A a);
	List<B> getBByC(C c);
	
	List<C> getCByA(A a);
	List<C> getCByB(B b);

	
	
	int firstIndexOf(A a, B b, C c);
	int firstIndexOf(IDMap3Base<A,B,C> entry);
	int firstIndexOfA(A a);
	int firstIndexOfB(B b);
	int firstIndexOfC(C c);
	
	
	
	int[] indicesOf(A a, B b, C c);
	int[] indicesOf(IDMap3Base<A,B,C> entry);
	int[] indicesOfA(A a);
	int[] indicesOfB(B b);
	int[] indicesOfC(C c);
	
	
	
	int occurrencesOf(A a, B b, C c);
	int occurrencesOf(IDMap3Base<A,B,C> entry);
	int occurrencesOfA(A a);
	int occurrencesOfB(B b);
	int occurrencesOfC(C c);
	
	
	
	boolean contains(A a, B b, C c);	
	boolean contains(IDMap3Base<A,B,C> entry);
	boolean containsA(A a);
	boolean containsB(B b);
	boolean containsC(C c);
	
	
	
	
	MemoryIterator<IDMap3Base<A,B,C>> iterator();
	MemoryIterator<A> iteratorA();
	MemoryIterator<B> iteratorB();
	MemoryIterator<C> iteratorC();
	
	
	
	int size();
	
}
