package cmn.utilslib.dmap;

public interface IPair4Base<A,B,C,D> extends IPair3Base<A,B,C>
{
	/**
	 * Gets entry D
	 * @return The value
	 */
	public abstract D getD();
}
