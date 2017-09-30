package cmn.utilslib.math.tuple;

import cmn.utilslib.Pool;
import cmn.utilslib.math.tuple.api.Tup6dBase;
import cmn.utilslib.math.tuple.api.Tup6f;
import cmn.utilslib.math.tuple.api.Tup6fBase;

public class Tuple6f implements Tup6f
{
	public float[] v = new float[6];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple6f TEMP = new Tuple6f();
	public static final Tuple6f TEMP0 = new Tuple6f();
	public static final Tuple6f TEMP1 = new Tuple6f();
	public static final Tuple6f TEMP2 = new Tuple6f();
	public static final Tuple6f TEMP3 = new Tuple6f();
	public static final Tuple6f TEMP4 = new Tuple6f();
	public static final Tuple6f TEMP5 = new Tuple6f();
	public static final Tuple6f TEMP6 = new Tuple6f();
	public static final Tuple6f TEMP7 = new Tuple6f();
	public static final Tuple6f TEMP8 = new Tuple6f();
	public static final Tuple6f TEMP9 = new Tuple6f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Tuple6f> pool = new Pool<Tuple6f>(Tuple6f.class);
	
	public static Tuple6f getInstance()
	{
		return pool.get();
	}
	
	public static Tuple6f getInstance(Tuple6f t)
	{
		Tuple6f t0 = pool.get();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		
		return t0;
	}
	
	public static Tuple6f getInstance(Tuple6d t)
	{
		Tuple6f t0 = pool.get();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		t0.v[2] = (float)t.v[2];
		t0.v[3] = (float)t.v[3];
		t0.v[4] = (float)t.v[4];
		t0.v[5] = (float)t.v[5];
		
		return t0;
	}
	
	public static Tuple6f getInstance(Tup6fBase t)
	{
		Tuple6f t0 = pool.get();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		
		return t0;
	}
	
	public static Tuple6f getInstance(Tup6dBase t)
	{
		Tuple6f t0 = pool.get();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		t0.v[2] = (float)t.get(2);
		t0.v[3] = (float)t.get(3);
		t0.v[4] = (float)t.get(4);
		t0.v[5] = (float)t.get(5);
		
		return t0;
	}
	
	public static Tuple6f getInstance(float scalar)
	{
		Tuple6f t = pool.get();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		
		return t;
	}
	
	public static Tuple6f getInstance(double scalar)
	{
		Tuple6f t = pool.get();

		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		t.v[2] = scl;
		t.v[3] = scl;
		t.v[4] = scl;
		t.v[5] = scl;
		
		return t;
	}
	
	public static Tuple6f getInstance(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		Tuple6f t = pool.get();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		
		return t;
	}
	
	public static Tuple6f getInstance(double v0, double v1, double v2, double v3 ,double v4, double v5)
	{
		Tuple6f t = pool.get();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		t.v[2] = (float)v2;
		t.v[3] = (float)v3;
		t.v[4] = (float)v4;
		t.v[5] = (float)v5;
		
		return t;
	}
	
	public static void storeInstance(Tuple6f t) { pool.store(t); }
	
	public Tuple6f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
	}
	
	public Tuple6f(Tuple6f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
	}
	
	public Tuple6f(Tuple6d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
		this.v[5] = (float)t.v[5];
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
	
	public Tuple6f(Tup6dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
		this.v[5] = (float)t.get(5);
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
		
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
		this.v[5] = scl;
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

	public Tuple6f set(Tuple6f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		return this;
	}
	
	public Tuple6f set(Tuple6d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
		this.v[5] = (float)t.v[5];
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
		
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
		this.v[5] = scl;
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
