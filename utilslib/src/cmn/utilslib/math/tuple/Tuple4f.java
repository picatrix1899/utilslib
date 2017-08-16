package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup4dBase;
import cmn.utilslib.math.tuple.api.Tup4f;
import cmn.utilslib.math.tuple.api.Tup4fBase;

public class Tuple4f implements Tup4f
{
	public float[] v = new float[4];
	
	public Tuple4f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
	}
	
	public Tuple4f(Tup4fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
	}
	
	public Tuple4f(Tup4dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
	}

	public Tuple4f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
	}
	
	public Tuple4f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
	}
	
	public Tuple4f(float v0, float v1, float v2, float v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
	}
	
	public Tuple4f(double v0, double v1, double v2, double v3)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
	}
	
	@Override
	public float get(int index) { return this.v[index]; }

	@Override
	public Tuple4f clone() { return new Tuple4f(this); }


	@Override
	public Tuple4f setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		return this;
	}

	@Override
	public Tuple4f set(Tup4fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		return this;
	}

	@Override
	public Tuple4f set(Tup4dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		return this;
		}

	@Override
	public Tuple4f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		return this;
		}

	@Override
	public Tuple4f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		return this;
	}

	@Override
	public Tuple4f set(float v0, float v1, float v2, float v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		return this;
		}

	@Override
	public Tuple4f set(double v0, double v1, double v2, double v3)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		return this;
	}

	@Override
	public Tuple4f set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple4f set(int index, double value) { this.v[index] = (float)value; return this; }
}
