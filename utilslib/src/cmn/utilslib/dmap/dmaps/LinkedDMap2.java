package cmn.utilslib.dmap.dmaps;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmaps.api.IDMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class LinkedDMap2<A,B> implements IDMap2<A,B>
{

	private LinkedValue<A,IDMap2Base<A,B>> a = Auto.LinkedValue(this);
	private LinkedValue<B,IDMap2Base<A,B>> b = Auto.LinkedValue(this);
	


	public LinkedDMap2()
	{
		this.a.value(null);
		this.b.value(null);
	}
	
	public LinkedDMap2(A a, B b)
	{
		this.a.value(a);
		this.b.value(b);
	}
	
	public LinkedDMap2(IDMap2Base<A,B> value)
	{
		this.a.value(value.getA());
		this.b.value(value.getB());
	}

	
	/** {@inheritDoc} **/
	@Override
	public A getA() { return this.a.value(); }

	/** {@inheritDoc} **/
	@Override
	public B getB() { return this.b.value(); }

	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap2<A,B> set(A a, B b) { this.a.value(a); this.b.value(b); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap2<A,B> set(IDMap2Base<A,B> dmap) { this.a.value(dmap.getA()); this.b.value(dmap.getB()); return this; }
	
	/** {@inheritDoc} **/
	@Override
	public LinkedDMap2<A,B> setA(A a) { this.a.value(a); return this; }

	/** {@inheritDoc} **/
	@Override
	public LinkedDMap2<A,B> setB(B b) { this.b.value(b); return this; }
	
	
	
	public LinkedValue<A,IDMap2Base<A,B>> getLinkedA() { return this.a; }
	
	public LinkedValue<B,IDMap2Base<A,B>> getLinkedB() { return this.b; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public LinkedDMap2<A,B> clone()
	{		
		return new LinkedDMap2<A,B>(this);
	}
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.value().hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.value().hashCode() : 0);
		
		return hash;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof IDMap2Base<?,?>)) return false;
		
		IDMap2Base<?,?> d = (IDMap2Base<?,?>)obj;
		
		if(!(Check.isSaveEqual(this.a.value(), d.getA()))) return false;
		if(!(Check.isSaveEqual(this.b.value(), d.getB()))) return false;
			
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "linkedDMap2(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n)";
	}
	
}
