package cmn.picatrix1899.utilslib.dmap;

/**
 * 
 * @author picatrix1899
 *
 */
public class DMaps
{
	public static <A,B> DMap2<A,B> newDMap2()
	{
		return new DMap2<A,B>();
	}
	
	public static <A,B> DMap2<A,B> newDMap2(A a, B b)
	{
		return new DMap2<A,B>(a, b);
	}
	
	public static <A,B,C> DMap3<A,B,C> newDMap3()
	{
		return new DMap3<A,B,C>();
	}
	
	public static <A,B,C> DMap3<A,B,C> newDMap3(A a, B b, C c)
	{
		return new DMap3<A,B,C>(a, b, c);
	}
	
	public static <A,B,C,D> DMap4<A,B,C,D> newDMap4()
	{
		return new DMap4<A,B,C,D>();
	}
	
	public static <A,B,C,D> DMap4<A,B,C,D> newDMap4(A a, B b, C c, D d)
	{
		return new DMap4<A,B,C,D>(a, b, c, d);
	}
	
	
	
	public static <A,B> DMapping2<A,B> newDMapping2()
	{
		return new DMapping2<A,B>();
	}
	
	public static <A,B,C> DMapping3<A,B,C> newDMapping3()
	{
		return new DMapping3<A,B,C>();
	}
	
	public static <A,B,C,D> DMapping4<A,B,C,D> newDMapping4()
	{
		return new DMapping4<A,B,C,D>();
	}
	
	
}
