package cmn.utilslib.dmap.dmappings.api;

import java.util.List;

import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping4Base<A,B,C,D>
{


	List<A> a();
	List<B> b();
	List<C> c();
	List<D> d();

	
	
	List<IDMap4Base<A,B,C,D>> list();
	
	
	
	IDMap4Base<A,B,C,D> get(int index);
	A getA(int index);
	B getB(int index);
	C getC(int index);
	D getD(int index);
	
	
	
	List<IDMap4Base<A,B,C,D>> get(int... index);
	List<A> getA(int... index);
	List<B> getB(int... index);
	List<C> getC(int... index);
	List<D> getD(int... index);
	
	
	
	IDMap4Base<A,B,C,D> getFirstByA(A a);
	IDMap4Base<A,B,C,D> getFirstByB(B b);
	IDMap4Base<A,B,C,D> getFirstByC(C c);
	IDMap4Base<A,B,C,D> getFirstByD(D d);
	
	
	
	A getFirstAByB(B b);
	A getFirstAByC(C c);
	A getFirstAByD(D d);
	
	B getFirstBByA(A a);
	B getFirstBByC(C c);
	B getFirstBByD(D d);
	
	C getFirstCByA(A a);
	C getFirstCByB(B b);
	C getFirstCByD(D d);
	
	D getFirstDByA(A a);
	D getFirstDByB(B b);
	D getFirstDByC(C c);
	
	
	
	List<IDMap4Base<A,B,C,D>> getByA(A a);
	List<IDMap4Base<A,B,C,D>> getByB(B b);
	List<IDMap4Base<A,B,C,D>> getByC(C c);
	List<IDMap4Base<A,B,C,D>> getByD(D d);
	
	
	
	List<A> getAByB(B b);
	List<A> getAByC(C c);
	List<A> getAByD(D d);
	
	List<B> getBByA(A a);
	List<B> getBByC(C c);
	List<B> getBByD(D d);
	
	List<C> getCByA(A a);
	List<C> getCByB(B b);
	List<C> getCByD(D d);

	List<D> getDByA(A a);
	List<D> getDByB(B b);
	List<D> getDByC(C c);
	
	
	int firstIndexOf(A a, B b, C c, D d);
	int firstIndexOf(IDMap4Base<A,B,C,D> entry);
	int firstIndexOfA(A a);
	int firstIndexOfB(B b);
	int firstIndexOfC(C c);
	int firstIndexOfD(D d);
	
	
	
	int[] indicesOf(A a, B b, C c, D d);
	int[] indicesOf(IDMap4Base<A,B,C,D> entry);
	int[] indicesOfA(A a);
	int[] indicesOfB(B b);
	int[] indicesOfC(C c);
	int[] indicesOfD(D d);
	
	
	
	int occurrencesOf(A a, B b, C c, D d);
	int occurrencesOf(IDMap4Base<A,B,C,D> entry);
	int occurrencesOfA(A a);
	int occurrencesOfB(B b);
	int occurrencesOfC(C c);
	int occurrencesOfD(D d);
	
	
	boolean contains(A a, B b, C c, D d);	
	boolean contains(IDMap4Base<A,B,C,D> entry);
	boolean containsA(A a);
	boolean containsB(B b);
	boolean containsC(C c);
	boolean containsD(D d);
	
	
	
	
	MemoryIterator<IDMap4Base<A,B,C,D>> iterator();
	MemoryIterator<A> iteratorA();
	MemoryIterator<B> iteratorB();
	MemoryIterator<C> iteratorC();
	MemoryIterator<D> iteratorD();
	
	
	
	int size();

}
