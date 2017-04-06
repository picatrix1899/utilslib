package cmn.utilslib.dmap;

public interface IDMap4Base<A,B,C,D> extends IDMap3Base<A,B,C>
{
	/**
	 * Gets entry D
	 * @return The value
	 */
	public abstract D getD();
}
