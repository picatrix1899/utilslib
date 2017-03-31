package cmn.utilslib.dmap;

public interface IPair4<R extends IPair4<?,A,B,C,D>,A,B,C,D> extends IPair3<R,A,B,C>, IPair4Base<A,B,C,D>
{
	/**
	 * Sets entry D
	 * @param d : The new value
	 * @return The current packet
	 */
	public abstract R setD(D d);
}
