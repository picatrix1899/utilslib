package cmn.utilslib.dmap.dmaps;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmaps.api.IDMap4;
import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class LinkedDMap4<A,B,C,D> implements IDMap4<A,B,C,D>
{

	private LinkedValue<A,IDMap4Base<A,B,C,D>> a = Auto.LinkedValue(this);
	private LinkedValue<B,IDMap4Base<A,B,C,D>> b = Auto.LinkedValue(this);
	private LinkedValue<C,IDMap4Base<A,B,C,D>> c = Auto.LinkedValue(this);
	private LinkedValue<D,IDMap4Base<A,B,C,D>> d = Auto.LinkedValue(this);

	
	
	public LinkedDMap4()
	{
		this.a.value(null);
		this.b.value(null);
		this.c.value(null);
		this.d.value(null);
	}
	
	public LinkedDMap4(A a, B b, C c, D d)
	{
		this.a.value(a);
		this.b.value(b);
		this.c.value(c);
		this.d.value(d);
	}
	
	public LinkedDMap4(IDMap4Base<A,B,C,D> value)
	{
		this.a.value(value.getA());
		this.b.value(value.getB());
		this.c.value(value.getC());
		this.d.value(value.getD());
	}

	
	
	/** {@inheritDoc} **/
	@Override
	public A getA() { return this.a.value(); }

	/** {@inheritDoc} **/
	@Override
	public B getB() { return this.b.value(); }
	
	/** {@inheritDoc} **/
	@Override
	public C getC() { return this.c.value(); }
	
	/** {@inheritDoc} **/
	@Override
	public D getD() { return this.d.value(); }

	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> set(A a, B b, C c, D d) { this.a.value(a); this.b.value(b); this.c.value(c); this.d.value(d); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> set(IDMap4Base<A,B,C,D> dmap) { this.a.value(dmap.getA()); this.b.value(dmap.getB()); this.c.value(dmap.getC()); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> setA(A a) { this.a.value(a); return this; }

	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> setB(B b) { this.b.value(b); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> setC(C c) { this.c.value(c); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap4<A,B,C,D> setD(D d) { this.d.value(d); return this; }
	
	
	
	public LinkedValue<A,IDMap4Base<A,B,C,D>> getLinkedA() { return this.a; }
	
	public LinkedValue<B,IDMap4Base<A,B,C,D>> getLinkedB() { return this.b; }

	public LinkedValue<C,IDMap4Base<A,B,C,D>> getLinkedC() { return this.c; }
	
	public LinkedValue<D,IDMap4Base<A,B,C,D>> getLinkedD() { return this.d; }
	
	/** {@inheritDoc} */
	@Override
	public LinkedDMap4<A,B,C,D> clone()
	{		
		return new LinkedDMap4<A,B,C,D>(this);
	}
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.value().hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.value().hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.value().hashCode() : 0);
		hash = 37 * hash + (this.d != null ? this.d.value().hashCode() : 0);
		
		return hash;
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
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "linkedDMap3(\n" +
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
