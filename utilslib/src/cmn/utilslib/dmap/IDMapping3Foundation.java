package cmn.utilslib.dmap;


public interface IDMapping3Foundation<RI extends IDMapping3Foundation<?,?,?,A,B,C>,
									  R extends IPair3<?,A,B,C>,
									  P extends IPair3Base<A,B,C>,
									  A,B,C>
extends IDMapping3FoundationBase<R,P,A,B,C>, IDMapping2Foundation<RI,R,P,A,B> 
{

	
	
	
	
	
	
	public static interface IDMapping3Extended<RI extends IDMapping3Extended<?,?,?,A,B,C>,
	 										   R extends IPair3<?,A,B,C>,
	 										   P extends IPair3Base<A,B,C>,
	 										   A,B,C>
	extends IDMapping3ExtendedBase<R,P,A,B,C>, IDMapping3Foundation<RI,R,P,A,B,C>
	{

	}
	
	
	
	
	
	
	public static interface IDMapping3<RI extends IDMapping3<?,A,B,C>,
									   A,B,C>
	extends IDMapping3Base<A,B,C>, IDMapping3Extended<RI,Pair3<A,B,C>, IPair3Base<A,B,C>,A,B,C>
	{ }
	
}
