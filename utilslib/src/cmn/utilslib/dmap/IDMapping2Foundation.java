package cmn.utilslib.dmap;


public interface IDMapping2Foundation<RI extends IDMapping2Foundation<?,?,?,A,B>,
									  R extends IDMap2<?,A,B>,
									  P extends IDMap2Base<A,B>,
									  A,B>
extends IDMapping2FoundationBase<R,P,A,B>
{
	
	public abstract RI set(int index, P entry);
	
	public abstract RI setA(int index, A a);
	public abstract RI setB(int index, B b);
	
	public abstract RI add(P entry);
	
	public abstract RI remove(int index);
	
	
	
	
	
	
	public static interface IDMapping2Extended<RI extends IDMapping2Extended<?,?,?,A,B>,
											   R extends IDMap2<?,A,B>,
											   P extends IDMap2Base<A,B>,
											   A,B>
	extends IDMapping2ExtendedBase<R,P,A,B>, IDMapping2Foundation<RI,R,P,A,B>
	{
		
		public abstract RI set(int index, A a, B b);
		
		public abstract RI add(A a, B b);
	}
	
	
	
	
	
	
	public static interface IDMapping2<RI extends IDMapping2<?,A,B>,
								A,B>
	extends IDMapping2Base<A,B>, IDMapping2Extended<RI,DMap2<A,B>,IDMap2Base<A,B>,A,B>
	{ }

}
