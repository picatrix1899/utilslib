package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public class Tuple2f implements Tup2f
{

	public float a;
	public float b;
	
	public Tuple2f() { this.a = 0; this.b = 0; }
	
	public Tuple2f(Tup2fBase t) { this.a = t.getA(); this.b = t.getB(); }
	
	public Tuple2f(Tup2dBase t) { this.a = (float)t.getA(); this.b = (float)t.getB(); }
	
	public Tuple2f(float scalar) { this.a = scalar; this.b = scalar; }
	
	public Tuple2f(double scalar) {  this.a = (float)scalar; this.b = (float)scalar; }
	
	public Tuple2f(float a, float b) { this.a = a; this.b = b; }
	
	public Tuple2f(double a, double b) { this.a = (float)a; this.b = (float)b; }
	
	@Override
	public float getA() { return this.a; }

	@Override
	public float getB() { return this.b; }

	@Override
	public Tuple2f clone() { return new Tuple2f(this); }

	@Override
	public Tuple2f addN(Tup2fBase t) { return clone().add(t); }

	@Override
	public Tuple2f addN(Tup2dBase t) { return clone().add(t); }

	@Override
	public Tuple2f addN(float scalar) { return clone().add(scalar); }

	@Override
	public Tuple2f addN(double scalar) { return clone().add(scalar); }

	@Override
	public Tuple2f addN(float a, float b) { return clone().add(a, b); }

	@Override
	public Tuple2f addN(double a, double b) { return clone().add(a, b); }

	@Override
	public Tuple2f subN(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f subN(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f subN(float scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f subN(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f subN(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f subN(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(float scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mulN(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(Tup2fBase v)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(Tup2dBase v)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(float scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f divN(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f setZero()
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(float scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f set(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f setA(float a)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f setA(double a)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f setB(float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f setB(double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f add(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f add(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f add(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f add(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f add(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f sub(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f sub(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f sub(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f sub(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f sub(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mul(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mul(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mul(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mul(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f mul(double a, double b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f div(Tup2fBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f div(Tup2dBase t)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f div(double scalar)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f div(float a, float b)
	{
		throw new NotImplementedException();
	}

	@Override
	public Tuple2f div(double a, double b)
	{
		throw new NotImplementedException();
	}

}
