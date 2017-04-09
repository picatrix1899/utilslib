package cmn.utilslib.dmap;

import cmn.utilslib.essentials.Auto;

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

	
	
	@Override
	public A getA() { return this.a.value(); }

	@Override
	public B getB() { return this.b.value(); }
	
	@Override
	public C getC() { return this.c.value(); }
	
	@Override
	public D getD() { return this.d.value(); }

	
	
	@Override
	public LinkedDMap4<A,B,C,D> setA(A a) { this.a.value(a); return this; }

	@Override
	public LinkedDMap4<A,B,C,D> setB(B b) { this.b.value(b); return this; }
	
	@Override
	public LinkedDMap4<A,B,C,D> setC(C c) { this.c.value(c); return this; }
	
	@Override
	public LinkedDMap4<A,B,C,D> setD(D d) { this.d.value(d); return this; }
	
	
	
	public LinkedValue<A,IDMap4Base<A,B,C,D>> getLinkedA() { return this.a; }
	
	public LinkedValue<B,IDMap4Base<A,B,C,D>> getLinkedB() { return this.b; }

	public LinkedValue<C,IDMap4Base<A,B,C,D>> getLinkedC() { return this.c; }
	
	public LinkedValue<D,IDMap4Base<A,B,C,D>> getLinkedD() { return this.d; }
	
}
