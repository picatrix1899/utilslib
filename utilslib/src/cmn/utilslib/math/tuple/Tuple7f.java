package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup7f;

public class Tuple7f implements Tup7f
{
	public float[] values = new float[7];
	
	public Tuple7f()
	{
		this.values[0] = 0;
		this.values[1] = 0;
		this.values[2] = 0;
		this.values[3] = 0;
		this.values[4] = 0;
		this.values[5] = 0;
		this.values[6] = 0;
	}
	
	public Tuple7f(Tuple7f t)
	{
		this.values[0] = t.get(0);
		this.values[1] = t.get(1);
		this.values[1] = t.get(2);
		this.values[1] = t.get(3);
		this.values[1] = t.get(4);
		this.values[1] = t.get(5);
		this.values[1] = t.get(6);
	}
	
	public Tuple7f(float scalar)
	{
		this.values[0] = scalar;
		this.values[1] = scalar;
		this.values[2] = scalar;
		this.values[3] = scalar;
		this.values[4] = scalar;
		this.values[5] = scalar;
		this.values[6] = scalar;
	}
	
	public Tuple7f(double scalar)
	{
		this.values[0] = (float)scalar;
		this.values[1] = (float)scalar;
		this.values[2] = (float)scalar;
		this.values[3] = (float)scalar;
		this.values[4] = (float)scalar;
		this.values[5] = (float)scalar;
		this.values[6] = (float)scalar;
	}
	
	public Tuple7f(float... values)
	{
		this.values[0] = values[0];
		this.values[1] = values[1];
		this.values[2] = values[1];
		this.values[3] = values[1];
		this.values[4] = values[1];
		this.values[5] = values[1];
		this.values[6] = values[1];
		}
	
	public Tuple7f(double... values)
	{
		this.values[0] = (float)values[0];
		this.values[1] = (float)values[1];
		this.values[2] = (float)values[1];
		this.values[3] = (float)values[1];
		this.values[4] = (float)values[1];
		this.values[5] = (float)values[1];
		this.values[6] = (float)values[1];
	}
	
	public float get(int index) { return this.values[index]; }

	public Tuple7f clone() { return new Tuple7f(this); }

	public Tuple7f setZero()
	{
		this.values[0] = 0;
		this.values[1] = 0;
		this.values[2] = 0;
		this.values[3] = 0;
		this.values[4] = 0;
		this.values[5] = 0;
		this.values[6] = 0;
		return this;
	}

	public Tuple7f set(Tuple7f t)
	{
		this.values[0] = t.get(0);
		this.values[1] = t.get(1);
		this.values[2] = t.get(2);
		this.values[3] = t.get(3);
		this.values[4] = t.get(4);
		this.values[5] = t.get(5);
		this.values[6] = t.get(6);
		return this;
	}

	public Tuple7f set(float scalar)
	{
		this.values[0] = scalar;
		this.values[1] = scalar;
		this.values[2] = scalar;
		this.values[3] = scalar;
		this.values[4] = scalar;
		this.values[5] = scalar;
		this.values[6] = scalar;
		return this;
	}

	public Tuple7f set(double scalar)
	{
		this.values[0] = (float)scalar;
		this.values[1] = (float)scalar;
		this.values[2] = (float)scalar;
		this.values[3] = (float)scalar;
		this.values[4] = (float)scalar;
		this.values[5] = (float)scalar;
		this.values[6] = (float)scalar;
		return this;
	}

	public Tuple7f set(float... values)
	{
		this.values[0] = values[0];
		this.values[1] = values[1];
		this.values[2] = values[2];
		this.values[3] = values[3];
		this.values[4] = values[4];
		this.values[5] = values[5];
		this.values[6] = values[6];
		return this;
	}

	public Tuple7f set(double... values)
	{
		this.values[0] = (float)values[0];
		this.values[1] = (float)values[1];
		this.values[2] = (float)values[2];
		this.values[3] = (float)values[3];
		this.values[4] = (float)values[4];
		this.values[5] = (float)values[5];
		this.values[6] = (float)values[6];
		return this;
	}

	public Tuple7f set(int index, float value) { this.values[index] = value; return this; }

	public Tuple7f set(int index, double value) { this.values[index] = (float)value; return this; }
}
