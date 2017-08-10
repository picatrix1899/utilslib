package cmn.utilslib.dmap.dmaps;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmaps.api.IDMap3;
import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class LinkedDMap3<A,B,C> implements IDMap3<A,B,C>
{

	private LinkedValue<A,IDMap3Base<A,B,C>> a = Auto.LinkedValue(this);
	private LinkedValue<B,IDMap3Base<A,B,C>> b = Auto.LinkedValue(this);
	private LinkedValue<C,IDMap3Base<A,B,C>> c = Auto.LinkedValue(this);

	
	
	public LinkedDMap3()
	{
		this.a.value(null);
		this.b.value(null);
		this.c.value(null);
	}
	
	public LinkedDMap3(A a, B b, C c)
	{
		this.a.value(a);
		this.b.value(b);
		this.c.value(c);
	}
	
	public LinkedDMap3(IDMap3Base<A,B,C> value)
	{
		this.a.value(value.getA());
		this.b.value(value.getB());
		this.c.value(value.getC());
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
	public LinkedDMap3<A,B,C> set(A a, B b, C c) { this.a.value(a); this.b.value(b); this.c.value(c); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap3<A,B,C> set(IDMap3Base<A,B,C> dmap) { this.a.value(dmap.getA()); this.b.value(dmap.getB()); this.c.value(dmap.getC()); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap3<A,B,C> setA(A a) { this.a.value(a); return this; }

	/** {@inheritDoc} **/
	@Override
	public LinkedDMap3<A,B,C> setB(B b) { this.b.value(b); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap3<A,B,C> setC(C c) { this.c.value(c); return this; }

	
	
	public LinkedValue<A,IDMap3Base<A,B,C>> getLinkedA() { return this.a; }
	
	public LinkedValue<B,IDMap3Base<A,B,C>> getLinkedB() { return this.b; }

	public LinkedValue<C,IDMap3Base<A,B,C>> getLinkedC() { return this.c; }

	/** {@inheritDoc} */
	@Override
	public LinkedDMap3<A,B,C> clone()
	{		
		return new LinkedDMap3<A,B,C>(this);
	}
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.value().hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.value().hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.value().hashCode() : 0);
		
		return hash;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof IDMap3Base<?,?,?>)) return false;
		
		IDMap3Base<?,?,?> d = (IDMap3Base<?,?,?>)obj;
		
		if(!(Check.isSaveEqual(this.a.value(), d.getA()))) return false;
		if(!(Check.isSaveEqual(this.b.value(), d.getB()))) return false;
		if(!(Check.isSaveEqual(this.c.value(), d.getC()))) return false;
			
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
				"\n)";
	}
	
}
