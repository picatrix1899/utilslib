package cmn.utilslib.dmap;

public interface IDMap3<R extends IDMap3<?,A,B,C>,A,B,C> extends IDMap2<R,A,B>, IDMap3Base<A,B,C>
{
	/**
	 * Sets entry C
	 * @param c : The new value
	 * @return The current packet
	 */
	public abstract R setC(C c);
}
