
package cmn.utilslib.dmap.dmaps;

import cmn.utilslib.dmap.dmaps.api.IDMap3;
import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.essentials.Check;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap3<A,B,C> implements IDMap3<A,B,C>
{
	
	public volatile A a;
	public volatile B b;
	public volatile C c;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap3()
	{
		
		this.a = null;
		this.b = null;
		this.c = null;
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
	public DMap3(IDMap3Base<A,B,C> dmap)
	{
		this.a = dmap.getA();
		this.b = dmap.getB();
		this.c = dmap.getC();
	}
	
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> set(A a, B b, C c) { this.a = a; this.b = b; this.c = c; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> set(IDMap3Base<A,B,C> dmap) { this.a = dmap.getA(); this.b = dmap.getB(); this.c = dmap.getC(); return this; }
	
	public DMap3<A,B,C> set(DMap3<A,B,C> dmap) { this.a = dmap.a; this.b = dmap.b; this.c = dmap.c; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> setB(B b) { this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
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
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.hashCode() : 0);
		
		return hash;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof IDMap3Base<?,?,?>)) return false;
		IDMap3Base<?,?,?> d = (IDMap3Base<?,?,?>)obj;
		
		if(!(Check.isEqual(this.a, d.getA()))) return false;
		if(!(Check.isEqual(this.b, d.getB()))) return false;
		if(!(Check.isEqual(this.c, d.getC()))) return false;	
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap3(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n,\n" +
				this.c.toString() + 
				"\n)";
	}

}
