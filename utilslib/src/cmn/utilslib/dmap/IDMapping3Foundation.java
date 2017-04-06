package cmn.utilslib.dmap;


public interface IDMapping3Foundation<RI extends IDMapping3Foundation<?,?,?,A,B,C>,
									  R extends IDMap3<?,A,B,C>,
									  P extends IDMap3Base<A,B,C>,
									  A,B,C>
extends IDMapping3FoundationBase<R,P,A,B,C>, IDMapping2Foundation<RI,R,P,A,B> 
{

	public abstract RI setC(int index, C c);
	
	
	
	
	
	
	public static interface IDMapping3Extended<RI extends IDMapping3Extended<?,?,?,A,B,C>,
	 										   R extends IDMap3<?,A,B,C>,
	 										   P extends IDMap3Base<A,B,C>,
	 										   A,B,C>
	extends IDMapping3ExtendedBase<R,P,A,B,C>, IDMapping3Foundation<RI,R,P,A,B,C>
	{

	}
	
	
	
	
	
	
	public static interface IDMapping3<RI extends IDMapping3<?,A,B,C>,
									   A,B,C>
	extends IDMapping3Base<A,B,C>, IDMapping3Extended<RI,DMap3<A,B,C>, IDMap3Base<A,B,C>,A,B,C>
	{ }
	
}
