package cmn.utilslib.dmap;

public interface IDMap4<R extends IDMap4<?,A,B,C,D>,A,B,C,D> extends IDMap3<R,A,B,C>, IDMap4Base<A,B,C,D>
{
	/**
	 * Sets entry D
	 * @param d : The new value
	 * @return The current packet
	 */
	public abstract R setD(D d);
}
