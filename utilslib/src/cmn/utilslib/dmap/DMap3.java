
package cmn.utilslib.dmap;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStringParser;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap3<A,B,C> implements IObjectable<DMap3<A,B,C>>
{
	
	/** Number of entries */
	public static final int DIMENSIONS = 3;

	
	private A a = null;
	private B b = null;
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
		this.a = a;
		this.b = b;
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
	public DMap3<A,B,C> setA(A a) { this.a = a; return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap3<A,B,C> setB(B b) { this.b = b; return this; }
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
	public A getA() { return this.a; }
	/**
	 * Gets entry B
	 * 
	 * @return The value
	 */
	public B getB() { return this.b; }
	/**
	 * Gets entry C
	 * 
	 * @return The value
	 */
	public C getC() { return this.c; }
	
	
	/** {@inheritDoc} */
	@Override
	public DMap3<A,B,C> clone()
	{
		return new DMap3<A,B,C>(this);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof DMap3<?,?,?>)) return false;
		DMap3<?,?,?> d = (DMap3<?,?,?>)obj;
		
		if(!(d.a.equals(this.a))) return false;
		if(!(d.b.equals(this.b))) return false;
		if(!(d.c.equals(this.c))) return false;	
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "dmap2(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n,\n" +
				this.c.toString() + 
				"\n)";
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString(IStringParser<DMap3<A,B,C>> parser) { return parser.parse(this); }
	
}
