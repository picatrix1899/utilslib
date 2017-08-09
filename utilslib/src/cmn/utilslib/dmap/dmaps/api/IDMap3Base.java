package cmn.utilslib.dmap.dmaps.api;

public interface IDMap3Base<A,B,C> extends IDMap2Base<A,B>
{
	/**
	 * Gets entry C
	 * @return The value
	 */
	C getC();
}
