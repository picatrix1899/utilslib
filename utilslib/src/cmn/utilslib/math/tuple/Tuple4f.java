package cmn.utilslib.math.tuple;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.api.Tup4dBase;
import cmn.utilslib.math.tuple.api.Tup4f;
import cmn.utilslib.math.tuple.api.Tup4fBase;

public class Tuple4f implements Tup4f
{
	public float[] v = new float[4];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple4f TEMP = new Tuple4f();
	public static final Tuple4f TEMP0 = new Tuple4f();
	public static final Tuple4f TEMP1 = new Tuple4f();
	public static final Tuple4f TEMP2 = new Tuple4f();
	public static final Tuple4f TEMP3 = new Tuple4f();
	public static final Tuple4f TEMP4 = new Tuple4f();
	public static final Tuple4f TEMP5 = new Tuple4f();
	public static final Tuple4f TEMP6 = new Tuple4f();
	public static final Tuple4f TEMP7 = new Tuple4f();
	public static final Tuple4f TEMP8 = new Tuple4f();
	public static final Tuple4f TEMP9 = new Tuple4f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Tuple4f> pool = new Pool<Tuple4f>(Tuple4f.class);
	
	public static Tuple4f getInstance()
	{
		return pool.get();
	}
	
	public static Tuple4f getInstance(Tuple4f t)
	{
		Tuple4f t0 = pool.get();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		
		return t0;
	}
	
	public static Tuple4f getInstance(Tuple4d t)
	{
		Tuple4f t0 = pool.get();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		t0.v[2] = (float)t.v[2];
		t0.v[3] = (float)t.v[3];
		
		return t0;
	}
	
	public static Tuple4f getInstance(Tup4fBase t)
	{
		Tuple4f t0 = pool.get();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		
		return t0;
	}
	
	public static Tuple4f getInstance(Tup4dBase t)
	{
		Tuple4f t0 = pool.get();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		t0.v[2] = (float)t.get(2);
		t0.v[3] = (float)t.get(3);
		
		return t0;
	}
	
	public static Tuple4f getInstance(float scalar)
	{
		Tuple4f t = pool.get();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		
		return t;
	}
	
	public static Tuple4f getInstance(double scalar)
	{
		Tuple4f t = pool.get();
		
		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		t.v[2] = scl;
		t.v[3] = scl;
		
		return t;
	}
	
	public static Tuple4f getInstance(float v0, float v1, float v2, float v3)
	{
		Tuple4f t = pool.get();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		
		return t;
	}
	
	public static Tuple4f getInstance(double v0, double v1, double v2, double v3)
	{
		Tuple4f t = pool.get();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		t.v[2] = (float)v2;
		t.v[3] = (float)v3;
		
		return t;
	}
	
	public static void storeInstance(Tuple4f t) { pool.store(t); }
	
	public Tuple4f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
	}
	
	public Tuple4f(Tuple4f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
	}
	
	public Tuple4f(Tuple4d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
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

	public Tuple4f set(Tuple4f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		return this;
	}
	
	public Tuple4f set(Tuple4d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
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
