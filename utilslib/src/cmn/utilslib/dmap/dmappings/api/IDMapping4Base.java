package cmn.utilslib.dmap.dmappings.api;

import java.util.List;

import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping4Base<A,B,C,D>
{

	public List<A> a();
	public List<B> b();
	public List<C> c();
	public List<D> d();

	
	
	public List<IDMap4Base<A,B,C,D>> list();
	
	
	
	public IDMap4Base<A,B,C,D> get(int index);
	public A getA(int index);
	public B getB(int index);
	public C getC(int index);
	public D getD(int index);
	
	
	
	public List<IDMap4Base<A,B,C,D>> get(int... index);
	public List<A> getA(int... index);
	public List<B> getB(int... index);
	public List<C> getC(int... index);
	public List<D> getD(int... index);
	
	
	
	public IDMap4Base<A,B,C,D> getFirstByA(A a);
	public IDMap4Base<A,B,C,D> getFirstByB(B b);
	public IDMap4Base<A,B,C,D> getFirstByC(C c);
	public IDMap4Base<A,B,C,D> getFirstByD(D d);
	
	
	
	public A getFirstAByB(B b);
	public A getFirstAByC(C c);
	public A getFirstAByD(D d);
	
	public B getFirstBByA(A a);
	public B getFirstBByC(C c);
	public B getFirstBByD(D d);
	
	public C getFirstCByA(A a);
	public C getFirstCByB(B b);
	public C getFirstCByD(D d);
	
	public D getFirstDByA(A a);
	public D getFirstDByB(B b);
	public D getFirstDByC(C c);
	
	
	
	public List<IDMap4Base<A,B,C,D>> getByA(A a);
	public List<IDMap4Base<A,B,C,D>> getByB(B b);
	public List<IDMap4Base<A,B,C,D>> getByC(C c);
	public List<IDMap4Base<A,B,C,D>> getByD(D d);
	
	
	
	public List<A> getAByB(B b);
	public List<A> getAByC(C c);
	public List<A> getAByD(D d);
	
	public List<B> getBByA(A a);
	public List<B> getBByC(C c);
	public List<B> getBByD(D d);
	
	public List<C> getCByA(A a);
	public List<C> getCByB(B b);
	public List<C> getCByD(D d);

	public List<D> getDByA(A a);
	public List<D> getDByB(B b);
	public List<D> getDByC(C c);
	
	
	public int firstIndexOf(A a, B b, C c, D d);
	public int firstIndexOf(IDMap4Base<A,B,C,D> entry);
	public int firstIndexOfA(A a);
	public int firstIndexOfB(B b);
	public int firstIndexOfC(C c);
	public int firstIndexOfD(D d);
	
	
	
	public int[] indicesOf(A a, B b, C c, D d);
	public int[] indicesOf(IDMap4Base<A,B,C,D> entry);
	public int[] indicesOfA(A a);
	public int[] indicesOfB(B b);
	public int[] indicesOfC(C c);
	public int[] indicesOfD(D d);
	
	
	
	public int occurrencesOf(A a, B b, C c, D d);
	public int occurrencesOf(IDMap4Base<A,B,C,D> entry);
	public int occurrencesOfA(A a);
	public int occurrencesOfB(B b);
	public int occurrencesOfC(C c);
	public int occurrencesOfD(D d);
	
	
	
	public boolean contains(A a, B b, C c, D d);	
	public boolean contains(IDMap4Base<A,B,C,D> entry);
	public boolean containsA(A a);
	public boolean containsB(B b);
	public boolean containsC(C c);
	public boolean containsD(D d);
	
	
	
	
	public MemoryIterator<IDMap4Base<A,B,C,D>> iterator();
	public MemoryIterator<A> iteratorA();
	public MemoryIterator<B> iteratorB();
	public MemoryIterator<C> iteratorC();
	public MemoryIterator<D> iteratorD();
	
	
	
	public int size();
	
}
