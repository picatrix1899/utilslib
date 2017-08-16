package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup7dBase;
import cmn.utilslib.math.tuple.api.Tup7f;
import cmn.utilslib.math.tuple.api.Tup7fBase;

public class Tuple7f implements Tup7f
{
	public float[] v = new float[7];
	
	public Tuple7f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		this.v[6] = 0;
	}
	
	public Tuple7f(Tup7fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
	}
	
	public Tuple7f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
	}
	
	public Tuple7f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
		this.v[5] = (float)scalar;
		this.v[6] = (float)scalar;
	}
	
	public Tuple7f(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
	}
	
	public Tuple7f(double v0, double v1, double v2, double v3, double v4, double v5, double v6)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
		this.v[5] = (float)v5;
		this.v[6] = (float)v6;
	}
	
	public float get(int index) { return this.v[index]; }

	public Tuple7f clone() { return new Tuple7f(this); }

	public Tuple7f setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		this.v[6] = 0;
		return this;
	}

	public Tuple7f set(Tup7fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
		return this;
	}
	
	public Tuple7f set(Tup7dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
		this.v[5] = (float)t.get(5);
		this.v[6] = (float)t.get(6);
		return this;
	}

	public Tuple7f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
		return this;
	}

	public Tuple7f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		this.v[2] = (float)scalar;
		this.v[3] = (float)scalar;
		this.v[4] = (float)scalar;
		this.v[5] = (float)scalar;
		this.v[6] = (float)scalar;
		return this;
	}

	public Tuple7f set(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
		return this;
	}

	public Tuple7f set(double v0, double v1, double v2, double v3, double v4, double v5, double v6)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		this.v[3] = (float)v3;
		this.v[4] = (float)v4;
		this.v[5] = (float)v5;
		this.v[6] = (float)v6;
		return this;
	}

	public Tuple7f set(int index, float value) { this.v[index] = value; return this; }

	public Tuple7f set(int index, double value) { this.v[index] = (float)value; return this; }
}
