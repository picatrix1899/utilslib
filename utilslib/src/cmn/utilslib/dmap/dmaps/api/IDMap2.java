package cmn.utilslib.dmap.dmaps.api;

public interface IDMap2<A,B> extends IDMap2Base<A,B>
{
	/**
	 * Sets both entry
	 * @param a : The new value A
	 * @param b : The new value B
	 * @return The current packet
	 */
	IDMap2<A,B> set(A a, B b);
	
	/**
	 * Sets both entry based on another IDMap2Base
	 * @param dmap : the dmap to copy the values from
	 * @return The current packet
	 */
	IDMap2<A,B> set(IDMap2Base<A,B> dmap);
	
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	IDMap2<A,B> setA(A a);
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	IDMap2<A,B> setB(B b);
}
