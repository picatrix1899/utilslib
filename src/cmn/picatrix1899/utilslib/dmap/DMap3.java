
package cmn.picatrix1899.utilslib.dmap;



/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap3<A,B,C> extends DMap2<A,B>
{
	
	/** Number of entries */
	public static final int DIMENSIONS = 2;

	
	
	private C c = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap3()
	{
		this(null, null, null);
	}
	/**
	 * Constructor with initial values
	 */
	public DMap3(A a, B b, C c)
	{
		super(a, b);
		this.c = c;
	}
	/**
	 * Constructor for cloning
	 * 
	 * @param dmap : The DMap for cloning
	 */
	public DMap3(DMap3<A,B,C> dmap)
	{
		this(dmap.getA(), dmap.getB(), dmap.getC());
	}
	
	
	
	/**
	 * Sets entry A
	 * 
	 * @param a : The new value
	 * @return The current packet
	 */
	public DMap3<A,B,C> setA(A a) { super.setA(a); return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap3<A,B,C> setB(B b) { super.setB(b); return this; }
	/**
	 * Set entry C
	 * 
	 * @param c : The new value
	 * @return The current packet
	 */
	public DMap3<A,B,C> setC(C c) { this.c = c; return this; }
	
	
	
	/**
	 * Gets entry A
	 * 
	 * @return The value
	 */
	public A getA() { return super.getA(); }
	/**
	 * Gets entry B
	 * 
	 * @return The value
	 */
	public B getB() { return super.getB(); }
	/**
	 * Gets entry C
	 * 
	 * @return The value
	 */
	public C getC() { return this.c; }
	
	
	
	@Override
	public DMap3<A,B,C> clone()
	{
		return new DMap3<A,B,C>(this);
	}
	
}
