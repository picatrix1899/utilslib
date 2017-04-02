
package cmn.utilslib.dmap;

import cmn.utilslib.interfaces.IObjectable;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class Pair3<A,B,C> implements IPair3<Pair3<A,B,C>,A,B,C>, IObjectable<Pair3<A,B,C>>
{
	
	private A a = null;
	private B b = null;
	private C c = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public Pair3()
	{
		this(null, null, null);
	}
	/**
	 * Constructor with initial values
	 */
	public Pair3(A a, B b, C c)
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
	public Pair3(Pair3<A,B,C> dmap)
	{
		this(dmap.getA(), dmap.getB(), dmap.getC());
	}
	
	
	
	/**
	 * Sets entry A
	 * 
	 * @param a : The new value
	 * @return The current packet
	 */
	public Pair3<A,B,C> setA(A a) { this.a = a; return this; }
	/**
	 * Set entry B
	 * 
	 * @param b : The new value
	 * @return The current packet
	 */
	public Pair3<A,B,C> setB(B b) { this.b = b; return this; }
	/**
	 * Set entry C
	 * 
	 * @param c : The new value
	 * @return The current packet
	 */
	public Pair3<A,B,C> setC(C c) { this.c = c; return this; }
	
	
	
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
	public Pair3<A,B,C> clone()
	{
		return new Pair3<A,B,C>(this);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Pair3<?,?,?>)) return false;
		Pair3<?,?,?> d = (Pair3<?,?,?>)obj;
		
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
