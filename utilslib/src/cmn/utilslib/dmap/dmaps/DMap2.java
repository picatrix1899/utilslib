
package cmn.utilslib.dmap.dmaps;



import cmn.utilslib.dmap.dmaps.api.IDMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;

/**
 * Packet system with 2 entries
 * @author picatrix1899
 * @category DMaps
 */
public class DMap2<A,B> implements IDMap2<A,B>
{
	
	private volatile A a = null;
	private volatile B b = null;
	
	
	
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
	 * @param dmap : The DMap for cloning
	 */
	public DMap2(IDMap2Base<A,B> dmap)
	{
		this(dmap.getA(), dmap.getB());
	}
	
	
	
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	public DMap2<A,B> setA(A a) { this.a = a; return this; }
	/**
	 * Set entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	public DMap2<A,B> setB(B b) { this.b = b; return this; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public A getA() { return this.a; }
	/** {@inheritDoc} */
	@Override
	public B getB() { return this.b; }
	
	
	/** {@inheritDoc} */
	@Override
	public DMap2<A,B> clone()
	{		
		return new DMap2<A,B>(this);
	}
	
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		
		return hash;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof DMap2<?,?>)) return false;
		DMap2<?,?> d = (DMap2<?,?>)obj;
		
		if(!(d.a.equals(this.a))) return false;
		if(!(d.b.equals(this.b))) return false;
			
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
				"\n)";
	}
	
}
