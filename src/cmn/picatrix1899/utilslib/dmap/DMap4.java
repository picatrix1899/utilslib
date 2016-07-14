
package cmn.picatrix1899.utilslib.dmap;



/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap4<A,B,C,D> extends DMap3<A,B,C>
{
	
	/** Number of entries */
	public static final int DIMENSIONS = 2;

	
	
	private D d = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap4()
	{
		this(null, null, null, null);
	}
	/**
	 * Constructor with initial values
	 */
	public DMap4(A a, B b, C c, D d)
	{
		super(a, b, c);
		this.d = d;
	}
	/**
	 * Constructor for cloning
	 * 
	 * @param dmap : The DMap for cloning
	 */
	public DMap4(DMap4<A,B,C,D> dmap)
	{
		this(dmap.getA(), dmap.getB(), dmap.getC(), dmap.getD());
	}
	
	
	
	/**
	 * Sets entry A
	 * 
	 * @param a : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setA(A a) { super.setA(a); return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setB(B b) { super.setB(b); return this; }
	/**
	 * Set entry C
	 * 
	 * @param c : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setC(C c) { super.setC(c); return this; }
	/**
	 * Set entry D
	 * 
	 * @param d : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setD(D d) { this.d = d; return this; }
	
	
	
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
	public C getC() { return super.getC(); }
	/**
	 * Gets entry D
	 * 
	 * @return The value
	 */
	public D getD() { return this.d; }
	
	
	
	@Override
	public DMap4<A,B,C,D> clone()
	{
		return new DMap4<A,B,C,D>(this);
	}
	
}
