package cmn.utilslib.dmap;

public interface IPair2Base<A,B>
{
	/**
	 * Gets entry A
	 * @return The value
	 */
	public abstract A getA();
	
	/**
	 * Gets entry B
	 * @return The value
	 */
	public abstract B getB();
}
