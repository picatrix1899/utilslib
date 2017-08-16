package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public class Tuple2f implements Tup2f
{

	public float[] v = new float[2];
	
	public Tuple2f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		}
	
	public Tuple2f(Tup2fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		}
	
	public Tuple2f(Tup2dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		}
	
	public Tuple2f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
	}
	
	public Tuple2f(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		}
	
	public Tuple2f(float v0, float v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
	}
	
	public Tuple2f(double v0, double v1)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		}
	
	@Override
	public float get(int index)
	{
		return this.v[index];
		}

	@Override
	public Tuple2f clone() { return new Tuple2f(this); }

	@Override
	public Tuple2f setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		return this;
	}

	@Override
	public Tuple2f set(Tup2fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		return this;
	}

	@Override
	public Tuple2f set(Tup2dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		return this;
		}

	@Override
	public Tuple2f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		return this;
		}

	@Override
	public Tuple2f set(double scalar)
	{
		this.v[0] = (float)scalar;
		this.v[1] = (float)scalar;
		return this;
	}

	@Override
	public Tuple2f set(float v0, float v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		return this;
	}

	@Override
	public Tuple2f set(double v0, double v1)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		return this;
	}

	@Override
	public Tuple2f set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple2f set(int index, double value) { this.v[index] = (float)value; return this; }




}
