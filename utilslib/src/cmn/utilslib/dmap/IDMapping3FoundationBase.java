package cmn.utilslib.dmap;

import java.util.List;

public interface IDMapping3FoundationBase<R extends IPair3Base<A,B,C>,
										  P extends IPair3Base<A,B,C>,
										  A,B,C>
extends IDMapping2FoundationBase<R,P,A,B>
{

	public abstract List<C> c();
	

	public abstract C getC(int index);
	
	public abstract R getbyC(C c);
	
	public abstract A getAbyC(C c);
	public abstract B getBbyC(C c);
	public abstract C getCbyA(A a);
	public abstract C getCbyB(B b);

	public abstract int indexOf(P m);
	
	public abstract int indexOfC(C c);
	
	public abstract int[] indicesOfC(C c);
	
	public abstract boolean contains(P m);
	
	public abstract boolean containsC(C c);
	
	public default int getDimensions() { return 3; }
	
	
	
	
	
	
	public static interface IDMapping3ExtendedBase<R extends IPair3<?,A,B,C>,
												   P extends IPair3Base<A,B,C>,
												   A,B,C>
	extends IDMapping3FoundationBase<R,P,A,B,C>
	{
	
	}

	
	
	
	
	
	public static interface IDMapping3Base<A,B,C>
	extends IDMapping3ExtendedBase<Pair3<A,B,C>,IPair3Base<A,B,C>,A,B,C>
	{ }
	
}
