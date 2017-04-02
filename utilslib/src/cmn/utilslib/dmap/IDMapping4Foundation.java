package cmn.utilslib.dmap;


public interface IDMapping4Foundation<RI extends IDMapping4Foundation<?,?,?,A,B,C,D>,
									  R extends IPair4<?,A,B,C,D>,
									  P extends IPair4Base<A,B,C,D>,
									  A,B,C,D>
extends IDMapping4FoundationBase<R,P,A,B,C,D>, IDMapping3Foundation<RI,R,P,A,B,C>
{

	
	
	
	
	public static interface IDMapping4Extended<RI extends IDMapping4Extended<?,?,?,A,B,C,D>,
											   R extends IPair4<?,A,B,C,D>,
											   P extends IPair4Base<A,B,C,D>,
											   A,B,C,D>
	extends IDMapping4ExtendedBase<R,P,A,B,C,D>, IDMapping4Foundation<RI,R,P,A,B,C,D>
	{

	}
	
	
	
	
	public static interface IDMapping4<RI extends IDMapping4<?,A,B,C,D>,
									   A,B,C,D>
	extends IDMapping4Base<A,B,C,D>, IDMapping4Extended<RI,Pair4<A,B,C,D>,IPair4Base<A,B,C,D>,A,B,C,D>
	{ }
	
}
