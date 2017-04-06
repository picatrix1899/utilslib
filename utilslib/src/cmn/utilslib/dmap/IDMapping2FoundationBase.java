package cmn.utilslib.dmap;

import java.util.List;

public interface IDMapping2FoundationBase<R extends IDMap2Base<A,B>,
										  P extends IDMap2Base<A,B>,
										  A,B>
{
	public abstract List<A> a();
	public abstract List<B> b();
	
	public abstract R get(int index);
	
	public abstract A getA(int index);
	public abstract B getB(int index);
	
	public abstract R getbyA(A a);
	public abstract R getbyB(B b);
	
	public abstract A getAbyB(B b);
	public abstract B getBbyA(A a);
	
	public abstract int indexOf(P m);
	
	public abstract int indexOfA(A a);
	public abstract int indexOfB(B b);
	
	public abstract int[] indicesOfA(A a);
	public abstract int[] indicesOfB(B b);
	
	public abstract boolean contains(P m);

	public abstract boolean containsA(A a);
	public abstract boolean containsB(B b);
	
	public abstract int size();
	
	public default int getDimensions() { return 2; }
	
	
	
	
	
	
	public static interface IDMapping2ExtendedBase<R extends IDMap2<?,A,B>,
		 										   P extends IDMap2Base<A,B>,
		 										   A,B>
	extends IDMapping2FoundationBase<R,P,A,B>
	{
		
		public abstract int indexOf(A a, B b);
		
		public abstract boolean contains(A a, B b);
		
	}
		
	
	
	
	
	
	public interface IDMapping2Base<A,B>
	extends IDMapping2ExtendedBase<DMap2<A,B>,IDMap2Base<A,B>,A,B>
	{ }
	
}
