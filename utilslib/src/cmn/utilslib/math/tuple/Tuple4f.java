package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup4dBase;
import cmn.utilslib.math.tuple.api.Tup4f;
import cmn.utilslib.math.tuple.api.Tup4fBase;

public class Tuple4f implements Tup4f
{
	public float[] values = new float[4];
	
	public Tuple4f()
	{
		this.values[0] = 0;
		this.values[1] = 0;
		this.values[2] = 0;
	}
	
	public Tuple4f(Tup4fBase t)
	{
		this.values[0] = t.get(0);
		this.values[1] = t.get(1);
		this.values[2] = t.get(2);
		this.values[3] = t.get(3);
	}
	
	public Tuple4f(Tup4dBase t)
	{
		this.values[0] = (float)t.get(0);
		this.values[1] = (float)t.get(1);
		this.values[2] = (float)t.get(2);
		this.values[3] = (float)t.get(3);
	}

	public Tuple4f(float scalar)
	{
		this.values[0] = scalar;
		this.values[1] = scalar;
		this.values[2] = scalar;
		this.values[3] = scalar;
	}
	
	public Tuple4f(double scalar)
	{
		this.values[0] = (float)scalar;
		this.values[1] = (float)scalar;
		this.values[2] = (float)scalar;
		this.values[3] = (float)scalar;
	}
	
	public Tuple4f(float a, float b, float c, float d)
	{
		this.values[0] = a;
		this.values[1] = b;
		this.values[2] = c;
		this.values[3] = d;
	}
	
	public Tuple4f(double a, double b, double c, double d)
	{
		this.values[0] = (float)a;
		this.values[1] = (float)b;
		this.values[2] = (float)c;
		this.values[3] = (float)d;
	}
	
	@Override
	public float get(int index) { return this.values[index]; }

	@Override
	public Tuple4f clone() { return new Tuple4f(this); }


	@Override
	public Tuple4f setZero()
	{
		this.values[0] = 0;
		this.values[1] = 0;
		this.values[2] = 0;
		this.values[3] = 0;
		return this;
	}

	@Override
	public Tuple4f set(Tup4fBase t)
	{
		this.values[0] = t.get(0);
		this.values[1] = t.get(1);
		this.values[2] = t.get(2);
		this.values[3] = t.get(3);
		return this;
	}

	@Override
	public Tuple4f set(Tup4dBase t)
	{
		this.values[0] = (float)t.get(0);
		this.values[1] = (float)t.get(1);
		this.values[2] = (float)t.get(2);
		this.values[3] = (float)t.get(3);
		return this;
		}

	@Override
	public Tuple4f set(float scalar)
	{
		this.values[0] = scalar;
		this.values[1] = scalar;
		this.values[2] = scalar;
		this.values[3] = scalar;
		return this;
		}

	@Override
	public Tuple4f set(double scalar)
	{
		this.values[0] = (float)scalar;
		this.values[1] = (float)scalar;
		this.values[2] = (float)scalar;
		return this;
	}

	@Override
	public Tuple4f set(float... values)
	{
		this.values[0] = values[0];
		this.values[1] = values[1];
		this.values[2] = values[2];
		return this;
		}

	@Override
	public Tuple4f set(double... values)
	{
		this.values[0] = (float)values[0];
		this.values[1] = (float)values[1];
		this.values[2] = (float)values[2];
		return this;
	}

	@Override
	public Tuple4f set(int index, float value) { this.values[index] = value; return this; }

	@Override
	public Tuple4f set(int index, double value) { this.values[index] = (float)value; return this; }
}
