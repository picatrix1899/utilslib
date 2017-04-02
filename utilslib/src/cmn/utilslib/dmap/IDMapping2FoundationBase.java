package cmn.utilslib.dmap;

import java.util.List;

public interface IDMapping2FoundationBase<R extends IPair2Base<A,B>,
										  P extends IPair2Base<A,B>,
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
	
	public abstract int[] indicesOfA(A a);
	public abstract int[] indicesOfB(B b);
	
	public abstract boolean contains(P m);

	public abstract boolean containsA(A a);
	public abstract boolean containsB(B b);
	
	public abstract int getSize();
	
	public default int getDimensions() { return 2; }
	
	
	
	
	
	
	public static interface IDMapping2ExtendedBase<R extends IPair2<?,A,B>,
		 										   P extends IPair2Base<A,B>,
		 										   A,B>
	extends IDMapping2FoundationBase<R,P,A,B>
	{
	
	}
		
	
	
	
	
	
	public interface IDMapping2Base<A,B>
	extends IDMapping2ExtendedBase<Pair2<A,B>,IPair2Base<A,B>,A,B>
	{ }
	
}
