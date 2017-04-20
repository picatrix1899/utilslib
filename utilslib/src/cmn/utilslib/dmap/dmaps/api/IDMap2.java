package cmn.utilslib.dmap.dmaps.api;

public interface IDMap2<A,B> extends IDMap2Base<A,B>
{
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	public abstract IDMap2<A,B> setA(A a);
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	public abstract IDMap2<A,B> setB(B b);
}
