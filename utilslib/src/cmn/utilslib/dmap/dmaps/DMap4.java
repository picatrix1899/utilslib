
package cmn.utilslib.dmap.dmaps;


import cmn.utilslib.dmap.dmaps.api.IDMap4;
import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.essentials.Check;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap4<A,B,C,D> implements IDMap4<A,B,C,D>
{

	public volatile A a;
	public volatile B b;
	public volatile C c;
	public volatile D d;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap4()
	{
		this.a = null;
		this.b = null;
		this.c = null;
		this.d = null;
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
	public DMap4(IDMap4Base<A,B,C,D> dmap)
	{
		this.a = dmap.getA();
		this.b = dmap.getB();
		this.c = dmap.getC();
		this.d = dmap.getD();
	}
	
	
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> set(A a, B b, C c, D d) { this.a = a; this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> set(IDMap4Base<A,B,C,D> dmap) { this.a = dmap.getA(); this.b = dmap.getB(); this.c = dmap.getC(); this.d = dmap.getD(); return this; }
	
	public DMap4<A,B,C,D> set(DMap4<A,B,C,D> dmap) { this.a = dmap.a; this.b = dmap.b; this.c = dmap.c; this.d = dmap.d; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setB(B b) { this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setC(C c) { this.c = c; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setD(D d) { this.d = d; return this; }
	
	
	
	/** {@inheritDoc} **/
	@Override
	public A getA() { return this.a; }
	
	/** {@inheritDoc} **/
	@Override
	public B getB() { return this.b; }
	
	/** {@inheritDoc} **/
	@Override
	public C getC() { return this.c; }
	
	/** {@inheritDoc} **/
	@Override
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
		if(!(obj instanceof IDMap4Base<?,?,?,?>)) return false;
		IDMap4Base<?,?,?,?> d = (IDMap4Base<?,?,?,?>)obj;
		
		if(!(Check.isSaveEqual(this.a, d.getA()))) return false;
		if(!(Check.isSaveEqual(this.b, d.getB()))) return false;
		if(!(Check.isSaveEqual(this.c, d.getC()))) return false;
		if(!(Check.isSaveEqual(this.d, d.getD()))) return false;

		
		return true;
	}
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 1;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.hashCode() : 0);
		hash = 37 * hash + (this.d != null ? this.d.hashCode() : 0);
		
		return hash;
	}
	
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap4(\n" +
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
