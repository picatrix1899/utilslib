package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup6dBase;
import cmn.utilslib.math.tuple.api.Tup6f;
import cmn.utilslib.math.tuple.api.Tup6fBase;

public class Tuple6f implements Tup6f
{
	public float[] v = new float[6];
	
	public Tuple6f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
	}
	
	public Tuple6f(Tup6fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
	}
	
	public Tuple6f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
	}
	
	public Tuple6f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
		this.v[5] = (float)scalar;
	}
	
	public Tuple6f(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
	}
	
	public Tuple6f(double v0, double v1, double v2, double v3, double v4, double v5)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
		this.v[5] = (float)v5;
	}
	
	public float get(int index) { return this.v[index]; }

	public Tuple6f clone() { return new Tuple6f(this); }

	public Tuple6f setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		return this;
	}

	public Tuple6f set(Tup6fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		return this;
	}
	
	public Tuple6f set(Tup6dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
		this.v[5] = (float)t.get(5);
		return this;
	}

	public Tuple6f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		return this;
	}

	public Tuple6f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
		this.v[5] = (float)scalar;
		return this;
	}

	public Tuple6f set(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		return this;
	}

	public Tuple6f set(double v0, double v1, double v2, double v3, double v4, double v5)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
		this.v[5] = (float)v5;
		return this;
	}

	public Tuple6f set(int index, float v) { this.v[index] = v; return this; }

	public Tuple6f set(int index, double v) { this.v[index] = (float)v; return this; }
}
