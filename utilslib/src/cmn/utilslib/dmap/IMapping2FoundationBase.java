package cmn.utilslib.dmap;

import java.util.List;

public interface IMapping2FoundationBase<R extends IDMap2Base<A,B>,
										 P extends IDMap2Base<A,B>,
										 A,B>
{

	
	
	public List<A> a();
	public List<B> b();
	
	public A getA(int index);
	public B getB(int index);
	
	public R get(int index);
	
	public R getFirstByA(A a);
	public R getFirstByB(B b);
	
	public A getFirstAByB(B b);
	public B getFirstBByA(A a);
	
	public List<R> getByA(A a);
	public List<R> getByB(B b);
	
	public List<A> getAByB(B b);
	public List<B> getBByA(A a);

	
	public int firstIndexOf(P entry);
	public int firstIndexOfA(A a);
	public int firstIndexOfB(B b);
	
	public int[] indicesOf(P entry);
	public int[] indicesOfA(A a);
	public int[] indicesOfB(B b);
	
	public int occurrencesOf(P entry);
	public int occurrencesOfA(A a);
	public int occurrencesOfB(B b);
	
	
	public boolean containsA(A a);
	public boolean containsB(B b);
	public boolean contains(P entry);
	
	public int size();
	
	public static interface IMapping2ExtendedBase<R extends IDMap2Base<A,B>,
		 										  P extends IDMap2Base<A,B>,
		 										  A,B>
	extends IMapping2FoundationBase<R,P,A,B>
	{
		public int firstIndexOf(A a, B b);
		
		public int[] indicesOf(A a, B b);
		
		public int occurrencesOf(A a, B b);
		
		public boolean contains(A a, B b);
		
	}
		
	
	
	
	
	
	public interface IMapping2Base<A,B>
	extends IMapping2ExtendedBase<IDMap2Base<A,B>,IDMap2Base<A,B>,A,B>
	{ }
	
}
