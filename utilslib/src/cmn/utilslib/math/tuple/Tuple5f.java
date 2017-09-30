package cmn.utilslib.math.tuple;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.api.Tup5dBase;
import cmn.utilslib.math.tuple.api.Tup5f;
import cmn.utilslib.math.tuple.api.Tup5fBase;

public class Tuple5f implements Tup5f
{
	public float[] v = new float[5];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple5f TEMP = new Tuple5f();
	public static final Tuple5f TEMP0 = new Tuple5f();
	public static final Tuple5f TEMP1 = new Tuple5f();
	public static final Tuple5f TEMP2 = new Tuple5f();
	public static final Tuple5f TEMP3 = new Tuple5f();
	public static final Tuple5f TEMP4 = new Tuple5f();
	public static final Tuple5f TEMP5 = new Tuple5f();
	public static final Tuple5f TEMP6 = new Tuple5f();
	public static final Tuple5f TEMP7 = new Tuple5f();
	public static final Tuple5f TEMP8 = new Tuple5f();
	public static final Tuple5f TEMP9 = new Tuple5f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Tuple5f> pool = new Pool<Tuple5f>(Tuple5f.class);
	
	public static Tuple5f getInstance()
	{
		return pool.get();
	}
	
	public static Tuple5f getInstance(Tuple5f t)
	{
		Tuple5f t0 = pool.get();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		
		return t0;
	}
	
	public static Tuple5f getInstance(Tuple5d t)
	{
		Tuple5f t0 = pool.get();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		t0.v[2] = (float)t.v[2];
		t0.v[3] = (float)t.v[3];
		t0.v[4] = (float)t.v[4];
		
		return t0;
	}
	
	public static Tuple5f getInstance(Tup5fBase t)
	{
		Tuple5f t0 = pool.get();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		
		return t0;
	}
	
	public static Tuple5f getInstance(Tup5dBase t)
	{
		Tuple5f t0 = pool.get();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		t0.v[2] = (float)t.get(2);
		t0.v[3] = (float)t.get(3);
		t0.v[4] = (float)t.get(4);
		
		return t0;
	}
	
	public static Tuple5f getInstance(float scalar)
	{
		Tuple5f t = pool.get();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		
		return t;
	}
	
	public static Tuple5f getInstance(double scalar)
	{
		Tuple5f t = pool.get();
		
		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		t.v[2] = scl;
		t.v[3] = scl;
		t.v[4] = scl;
		
		return t;
	}
	
	public static Tuple5f getInstance(float v0, float v1, float v2, float v3, float v4)
	{
		Tuple5f t = pool.get();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		
		return t;
	}
	
	public static Tuple5f getInstance(double v0, double v1, double v2, double v3 ,double v4)
	{
		Tuple5f t = pool.get();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		t.v[2] = (float)v2;
		t.v[3] = (float)v3;
		t.v[4] = (float)v4;
		
		return t;
	}
	
	public static void storeInstance(Tuple5f t) { pool.store(t); }
	
	public Tuple5f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
	}
	
	public Tuple5f(Tuple5f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
	}
	
	public Tuple5f(Tuple5d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
	}
	
	public Tuple5f(Tup5fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
	}
	
	public Tuple5f(Tup5dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
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
		
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
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

	public Tuple5f set(Tuple5f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		return this;
	}
	
	public Tuple5f set(Tuple5d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
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
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
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
