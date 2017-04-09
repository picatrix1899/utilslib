package cmn.utilslib.dmap;

public interface IDMap3<A,B,C> extends IDMap2<A,B>, IDMap3Base<A,B,C>
{
	
	public abstract IDMap3<A,B,C> setA(A a);
	
	public abstract IDMap3<A,B,C> setB(B b);
	/**
	 * Sets entry C
	 * @param c : The new value
	 * @return The current packet
	 */
	public abstract IDMap3<A,B,C> setC(C c);
}
