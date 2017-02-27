package cmn.utilslib.dmap;

public interface IDMap3Base<A,B,C> extends IDMap2Base<A,B>
{
	/**
	 * Gets entry C
	 * @return The value
	 */
	public abstract C getC();
}
