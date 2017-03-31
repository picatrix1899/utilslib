package cmn.utilslib.dmap;

public interface IPair3Base<A,B,C> extends IPair2Base<A,B>
{
	/**
	 * Gets entry C
	 * @return The value
	 */
	public abstract C getC();
}
