
package cmn.utilslib.dmap;

import cmn.utilslib.interfaces.IObjectable;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap3<A,B,C> implements IDMap3<DMap3<A,B,C>,A,B,C>, IObjectable<DMap3<A,B,C>>
{
	
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
	
	
	
	/** {@inheritDoc} */
	@Override
	public A getA() { return this.a; }
	
	/** {@inheritDoc} */
	@Override
	public B getB() { return this.b; }
	
	/** {@inheritDoc} */
	@Override
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

}
