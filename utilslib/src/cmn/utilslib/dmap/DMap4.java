
package cmn.utilslib.dmap;

import cmn.utilslib.interfaces.IObjectable;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap4<A,B,C,D> implements IDMap4<DMap4<A,B,C,D>,A,B,C,D>, IObjectable<DMap4<A,B,C,D>>
{
	
	/** Number of entries */
	public static final int DIMENSIONS = 4;

	
	private A a = null;
	private B b = null;
	private C c = null;
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
		this.a = a;
		this.b = b;
		this.c = c;
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
	public DMap4<A,B,C,D> setA(A a) { this.a = a; return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setB(B b) { this.b = b; return this; }
	/**
	 * Set entry C
	 * 
	 * @param c : The new value
	 * @return The current packet
	 */
	public DMap4<A,B,C,D> setC(C c) { this.c = c; return this; }
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
	/**
	 * Gets entry D
	 * 
	 * @return The value
	 */
	public D getD() { return this.d; }
	
	
	/** {@inheritDoc}} */
	@Override
	public DMap4<A,B,C,D> clone()
	{
		return new DMap4<A,B,C,D>(this);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof DMap4<?,?,?,?>)) return false;
		DMap4<?,?,?,?> d = (DMap4<?,?,?,?>)obj;
		
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
				"\n,\n" +
				this.d.toString() + 
				"\n)";
	}

}
