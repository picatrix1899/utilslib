package cmn.utilslib.dmap;

import java.util.List;

public interface IDMapping4FoundationBase<R extends IDMap4Base<A,B,C,D>,
										  P extends IDMap4Base<A,B,C,D>,
										  A,B,C,D>
	extends IDMapping3FoundationBase<R,P,A,B,C>
{

	public abstract List<D> d();
	

	public abstract D getD(int index);
	
	public abstract R getbyD(D d);
	
	public abstract A getAbyD(D d);
	public abstract B getBbyD(D d);
	public abstract C getCbyD(D d);

	public abstract int indexOf(P m);
	
	public abstract int indexOfD(D d);
	
	public abstract int[] indicesOfD(D d);
	
	public abstract boolean contains(P m);
	
	public abstract boolean containsD(D d);
	
	public default int getDimensions() { return 4; }
	
	
	
	
	
	
	public static interface IDMapping4ExtendedBase<R extends IDMap4<?,A,B,C,D>,
											P extends IDMap4Base<A,B,C,D>,
											A,B,C,D>
	extends IDMapping4FoundationBase<R,P,A,B,C,D>
	{

	}
	
	
	
	
	
	
	public static interface IDMapping4Base<A,B,C,D>
	extends IDMapping4ExtendedBase<DMap4<A,B,C,D>, IDMap4Base<A,B,C,D>,A,B,C,D>
	{ }
	
}
