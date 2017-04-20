package cmn.utilslib.dmap.dmaps.api;

public interface IDMap4<A,B,C,D> extends IDMap3<A,B,C>, IDMap4Base<A,B,C,D>
{
	
	public abstract IDMap4<A,B,C,D> setA(A a);
	public abstract IDMap4<A,B,C,D> setB(B b);
	public abstract IDMap4<A,B,C,D> setC(C c);
	
	/**
	 * Sets entry D
	 * @param d : The new value
	 * @return The current packet
	 */
	public abstract IDMap4<A,B,C,D> setD(D d);
}
