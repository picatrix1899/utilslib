package cmn.utilslib.dmap.dmaps;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmaps.api.IDMap3;
import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.essentials.Auto;

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

	
	
	@Override
	public A getA() { return this.a.value(); }

	@Override
	public B getB() { return this.b.value(); }
	
	@Override
	public C getC() { return this.c.value(); }

	
	
	@Override
	public LinkedDMap3<A,B,C> setA(A a) { this.a.value(a); return this; }

	@Override
	public LinkedDMap3<A,B,C> setB(B b) { this.b.value(b); return this; }
	
	@Override
	public LinkedDMap3<A,B,C> setC(C c) { this.c.value(c); return this; }

	
	
	public LinkedValue<A,IDMap3Base<A,B,C>> getLinkedA() { return this.a; }
	
	public LinkedValue<B,IDMap3Base<A,B,C>> getLinkedB() { return this.b; }

	public LinkedValue<C,IDMap3Base<A,B,C>> getLinkedC() { return this.c; }
	
}
