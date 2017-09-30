package cmn.utilslib.math.tuple;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public class Tuple2f implements Tup2f
{

	public float[] v = new float[2];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple2f TEMP = new Tuple2f();
	public static final Tuple2f TEMP0 = new Tuple2f();
	public static final Tuple2f TEMP1 = new Tuple2f();
	public static final Tuple2f TEMP2 = new Tuple2f();
	public static final Tuple2f TEMP3 = new Tuple2f();
	public static final Tuple2f TEMP4 = new Tuple2f();
	public static final Tuple2f TEMP5 = new Tuple2f();
	public static final Tuple2f TEMP6 = new Tuple2f();
	public static final Tuple2f TEMP7 = new Tuple2f();
	public static final Tuple2f TEMP8 = new Tuple2f();
	public static final Tuple2f TEMP9 = new Tuple2f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Tuple2f> pool = new Pool<Tuple2f>(Tuple2f.class);
	
	public static Tuple2f getInstance()
	{
		return pool.get();
	}
	
	public static Tuple2f getInstance(Tuple2f t)
	{
		Tuple2f t0 = pool.get();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		
		return t0;
	}
	
	public static Tuple2f getInstance(Tuple2d t)
	{
		Tuple2f t0 = pool.get();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		
		return t0;
	}
	
	public static Tuple2f getInstance(Tup2fBase t)
	{
		Tuple2f t0 = pool.get();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		
		return t0;
	}
	
	public static Tuple2f getInstance(Tup2dBase t)
	{
		Tuple2f t0 = pool.get();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		
		return t0;
	}
	
	public static Tuple2f getInstance(float scalar)
	{
		Tuple2f t = pool.get();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		
		return t;
	}
	
	public static Tuple2f getInstance(double scalar)
	{
		Tuple2f t = pool.get();
		
		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		
		return t;
	}
	
	public static Tuple2f getInstance(float v0, float v1)
	{
		Tuple2f t = pool.get();
		
		t.v[0] = v0;
		t.v[1] = v1;
		
		return t;
	}
	
	public static Tuple2f getInstance(double v0, double v1)
	{
		Tuple2f t = pool.get();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		
		return t;
	}
	
	public static void store(Tuple2f t) { pool.store(t); }
	
	public Tuple2f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
	}
	
	public Tuple2f(Tuple2f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
	}
	
	public Tuple2f(Tuple2d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
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
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
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

	public Tuple2f set(Tuple2f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		return this;
	}
	
	public Tuple2f set(Tuple2d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
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
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
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
