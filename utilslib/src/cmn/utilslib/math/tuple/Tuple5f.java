package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup5dBase;
import cmn.utilslib.math.tuple.api.Tup5f;
import cmn.utilslib.math.tuple.api.Tup5fBase;

public class Tuple5f implements Tup5f
{
	public float[] v = new float[5];
	
	public Tuple5f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
	}
	
	public Tuple5f(Tup5fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
	}
	
	public Tuple5f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
	}
	
	public Tuple5f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
	}
	
	public Tuple5f(float v0, float v1, float v2, float v3, float v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
	}
	
	public Tuple5f(double v0, double v1, double v2, double v3, double v4)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
	}
	
	public float get(int index) { return this.v[index]; }

	public Tuple5f clone() { return new Tuple5f(this); }

	public Tuple5f setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		return this;
	}

	public Tuple5f set(Tup5fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		return this;
	}
	
	public Tuple5f set(Tup5dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
		return this;
	}

	public Tuple5f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		return this;
	}

	public Tuple5f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
		return this;
	}

	public Tuple5f set(float v0, float v1, float v2, float v3, float v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		return this;
	}

	public Tuple5f set(double v0, double v1, double v2, double v3, double v4)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
		return this;
	}

	public Tuple5f set(int index, float value) { this.v[index] = value; return this; }

	public Tuple5f set(int index, double value) { this.v[index] = (float)value; return this; }
}
