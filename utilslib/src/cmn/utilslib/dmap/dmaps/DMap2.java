
package cmn.utilslib.dmap.dmaps;



import cmn.utilslib.dmap.dmaps.api.IDMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.essentials.Check;

/**
 * Packet system with 2 entries
 * @author picatrix1899
 * @category DMaps
 */
public class DMap2<A,B> implements IDMap2<A,B>
{
	
	public volatile A a;
	public volatile B b;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap2()
	{
		this.a = null;
		this.b = null;
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
		this.a = dmap.getA();
		this.b = dmap.getB();
	}
	
	
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> set(A a, B b) { this.a = a; this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> set(IDMap2Base<A,B> dmap) { this.a = dmap.getA(); this.b = dmap.getB(); return this; }
	
	public DMap2<A,B> set(DMap2<A,B> dmap) { this.a = dmap.a; this.b = dmap.b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
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
	
	/** {@inheritDoc} **/
	@Override
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
		if(!(obj instanceof IDMap2Base<?,?>)) return false;
		
		IDMap2Base<?,?> d = (IDMap2Base<?,?>)obj;
		
		if(!(Check.isSaveEqual(this.a, d.getA()))) return false;
		if(!(Check.isSaveEqual(this.b, d.getB()))) return false;
			
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap2(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n)";
	}
	
}
