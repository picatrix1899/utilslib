package cmn.utilslib.dmap;

public interface IDMap2<R extends IDMap2<?,A,B>,A,B> extends IDMap2Base<A,B>
{
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	public abstract R setA(A a);
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	public abstract R setB(B b);
}