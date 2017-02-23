
package cmn.picatrix1899.utilslib.dmap;



/**
 * Packet system with 2 entries
 * 
 * @author picatrix1899
 */
public class DMap2<A,B>
{
	
	/** Number of entries */
	public static final int DIMENSIONS = 2;

	
	
	private A a = null;
	private B b = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap2()
	{
		this(null, null);
	}
	/**
	 * Constructor with initial values
	 * 
	 *  @param a : Value a
	 *  @param b : Value b
	 */
	public DMap2(A a, B b)
	{
		this.a = a;
		this.b = b;
	}
	/**
	 * Constructor for cloning
	 * 
	 * @param dmap : The DMap for cloning
	 */
	public DMap2(DMap2<A,B> dmap)
	{
		this(dmap.getA(), dmap.getB());
	}
	
	
	
	/**
	 * Sets entry A
	 * 
	 * @param a : The new value
	 * @return The current packet
	 */
	public DMap2<A,B> setA(A a) { this.a = a; return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap2<A,B> setB(B b) { this.b = b; return this; }
	
	
	
	/**
	 * Gets entry A
	 * 
	 * @return The value
	 */
	public A getA() { return this.a; }
	/**
	 * Gets entry B
	 * 
	 * @return The value
	 */
	public B getB() { return this.b; }
	
	
	
	@Override
	public DMap2<A,B> clone()
	{		
		return new DMap2<A,B>(this);
	}
	
}
