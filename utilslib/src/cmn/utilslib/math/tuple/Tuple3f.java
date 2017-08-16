package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public class Tuple3f implements Tup3f
{

	public float[] v = new float[3];
	
	public Tuple3f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
	}
	
	public Tuple3f(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
	}
	
	public Tuple3f(Tup3dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
	}
	
	public Tuple3f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
	}
	
	public Tuple3f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
	}
	
	public Tuple3f(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
	}
	
	public Tuple3f(double v0, double v1, double v2)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
	}
	
	@Override
	public float get(int index) { return this.v[index]; }

	@Override
	public Tuple3f clone() { return new Tuple3f(this); }


	@Override
	public Tuple3f setZero() { this.v[0] = 0; this.v[1] = 0; this.v[2] = 0; return this; }

	@Override
	public Tuple3f set(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		return this;
	}

	@Override
	public Tuple3f set(Tup3dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		return this;
	}

	@Override
	public Tuple3f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		return this;
	}

	@Override
	public Tuple3f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		return this;
	}

	@Override
	public Tuple3f set(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		return this;
	}

	@Override
	public Tuple3f set(double v0, double v1, double v2)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		return this;
	}

	@Override
	public Tuple3f set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple3f set(int index, double value) { this.v[index] = (float)value; return this; }

}
