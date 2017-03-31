package cmn.utilslib.dmap;

public interface IPair3<R extends IPair3<?,A,B,C>,A,B,C> extends IPair2<R,A,B>, IPair3Base<A,B,C>
{
	/**
	 * Sets entry C
	 * @param c : The new value
	 * @return The current packet
	 */
	public abstract R setC(C c);
}
