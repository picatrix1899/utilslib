package cmn.utilslib.dmap;

import java.util.List;

import cmn.utilslib.interfaces.MemoryIterator;

public interface IDMapping2Base<A,B>
{

	public List<A> a();
	public List<B> b();

	
	
	public List<IDMap2Base<A,B>> list();
	
	
	
	public IDMap2Base<A,B> get(int index);
	public A getA(int index);
	public B getB(int index);
	
	
	
	public List<IDMap2Base<A,B>> get(int... index);
	public List<A> getA(int... index);
	public List<B> getB(int... index);
	
	
	
	public IDMap2Base<A,B> getFirstByA(A a);
	public IDMap2Base<A,B> getFirstByB(B b);
	
	
	
	public A getFirstAByB(B b);
	public B getFirstBByA(A a);
	
	
	
	public List<IDMap2Base<A,B>> getByA(A a);
	public List<IDMap2Base<A,B>> getByB(B b);
	
	
	
	public List<A> getAByB(B b);
	public List<B> getBByA(A a);

	
	
	public int firstIndexOf(A a, B b);
	public int firstIndexOf(IDMap2Base<A,B> entry);
	public int firstIndexOfA(A a);
	public int firstIndexOfB(B b);
	
	
	
	public int[] indicesOf(A a, B b);
	public int[] indicesOf(IDMap2Base<A,B> entry);
	public int[] indicesOfA(A a);
	public int[] indicesOfB(B b);
	
	
	
	public int occurrencesOf(A a, B b);
	public int occurrencesOf(IDMap2Base<A,B> entry);
	public int occurrencesOfA(A a);
	public int occurrencesOfB(B b);
	
	
	
	public boolean contains(A a, B b);	
	public boolean contains(IDMap2Base<A,B> entry);
	public boolean containsA(A a);
	public boolean containsB(B b);
	
	
	
	
	public MemoryIterator<IDMap2Base<A,B>> iterator();
	public MemoryIterator<A> iteratorA();
	public MemoryIterator<B> iteratorB();
	
	
	
	public int size();
	
}
