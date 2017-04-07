package cmn.utilslib.dmap;

import cmn.utilslib.essentials.Auto;

public class LinkedDMap2<A,B> implements IDMap2<LinkedDMap2<A,B>,A,B>
{

	private LinkedEntry<A,IDMap2Base<A,B>> a = Auto.LinkedEntry(this);
	private LinkedEntry<B,IDMap2Base<A,B>> b = Auto.LinkedEntry(this);
	

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

	@Override
	public A getA()
	{
		return this.a.value();
	}

	@Override
	public B getB()
	{
		return this.b.value();
	}

	@Override
	public LinkedDMap2<A,B> setA(A a)
	{
		this.a.value(a);
		
		return this;
	}

	@Override
	public LinkedDMap2<A,B> setB(B b)
	{
		this.b.value(b);
		
		return this;
	}
	
	public LinkedEntry<A,IDMap2Base<A,B>> getLinkedA()
	{
		return this.a;
	}
	
	public LinkedEntry<B,IDMap2Base<A,B>> getLinkedB()
	{
		return this.b;
	}

}
