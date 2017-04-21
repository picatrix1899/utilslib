package cmn.utilslib.dmap.dmappings.api;

import java.util.List;

import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping2Base<A,B>
{

	List<A> a();
	List<B> b();

	
	
	List<IDMap2Base<A,B>> list();
	
	
	
	IDMap2Base<A,B> get(int index);
	A getA(int index);
	B getB(int index);
	
	
	
	List<IDMap2Base<A,B>> get(int... index);
	List<A> getA(int... index);
	List<B> getB(int... index);
	
	
	
	IDMap2Base<A,B> getFirstByA(A a);
	IDMap2Base<A,B> getFirstByB(B b);
	
	
	
	A getFirstAByB(B b);
	B getFirstBByA(A a);
	
	
	
	List<IDMap2Base<A,B>> getByA(A a);
	List<IDMap2Base<A,B>> getByB(B b);
	
	
	
	List<A> getAByB(B b);
	List<B> getBByA(A a);

	
	
	int firstIndexOf(A a, B b);
	int firstIndexOf(IDMap2Base<A,B> entry);
	int firstIndexOfA(A a);
	int firstIndexOfB(B b);
	
	
	
	int[] indicesOf(A a, B b);
	int[] indicesOf(IDMap2Base<A,B> entry);
	int[] indicesOfA(A a);
	int[] indicesOfB(B b);
	
	
	int occurrencesOf(A a, B b);
	int occurrencesOf(IDMap2Base<A,B> entry);
	int occurrencesOfA(A a);
	int occurrencesOfB(B b);
	
	
	boolean contains(A a, B b);	
	boolean contains(IDMap2Base<A,B> entry);
	boolean containsA(A a);
	boolean containsB(B b);
	
		
	
	MemoryIterator<IDMap2Base<A,B>> iterator();
	MemoryIterator<A> iteratorA();
	MemoryIterator<B> iteratorB();
	
	
	
	int size();

}
