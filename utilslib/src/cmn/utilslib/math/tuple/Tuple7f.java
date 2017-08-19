package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup7dBase;
import cmn.utilslib.math.tuple.api.Tup7f;
import cmn.utilslib.math.tuple.api.Tup7fBase;

public class Tuple7f implements Tup7f
{
	public float[] v = new float[7];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple7f TEMP = new Tuple7f();
	public static final Tuple7f TEMP0 = new Tuple7f();
	public static final Tuple7f TEMP1 = new Tuple7f();
	public static final Tuple7f TEMP2 = new Tuple7f();
	public static final Tuple7f TEMP3 = new Tuple7f();
	public static final Tuple7f TEMP4 = new Tuple7f();
	public static final Tuple7f TEMP5 = new Tuple7f();
	public static final Tuple7f TEMP6 = new Tuple7f();
	public static final Tuple7f TEMP7 = new Tuple7f();
	public static final Tuple7f TEMP8 = new Tuple7f();
	public static final Tuple7f TEMP9 = new Tuple7f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple7f> allocator = new Allocator<Tuple7f>(Tuple7f.class);
	
	public static Tuple7f alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple7f alloc(Tuple7f t)
	{
		Tuple7f t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		t0.v[6] = t.v[6];
		
		return t0;
	}
	
	public static Tuple7f alloc(Tuple7d t)
	{
		Tuple7f t0 = allocator.alloc();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		t0.v[2] = (float)t.v[2];
		t0.v[3] = (float)t.v[3];
		t0.v[4] = (float)t.v[4];
		t0.v[5] = (float)t.v[5];
		t0.v[6] = (float)t.v[6];
		
		return t0;
	}
	
	public static Tuple7f alloc(Tup7fBase t)
	{
		Tuple7f t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		t0.v[6] = t.get(6);
		
		return t0;
	}
	
	public static Tuple7f alloc(Tup7dBase t)
	{
		Tuple7f t0 = allocator.alloc();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		t0.v[2] = (float)t.get(2);
		t0.v[3] = (float)t.get(3);
		t0.v[4] = (float)t.get(4);
		t0.v[5] = (float)t.get(5);
		t0.v[6] = (float)t.get(6);
		
		return t0;
	}
	
	public static Tuple7f alloc(float scalar)
	{
		Tuple7f t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		t.v[6] = scalar;
		
		return t;
	}
	
	public static Tuple7f alloc(double scalar)
	{
		Tuple7f t = allocator.alloc();
		
		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		t.v[2] = scl;
		t.v[3] = scl;
		t.v[4] = scl;
		t.v[5] = scl;
		t.v[6] = scl;
		
		return t;
	}
	
	public static Tuple7f alloc(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		Tuple7f t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		t.v[6] = v6;
		
		return t;
	}
	
	public static Tuple7f alloc(double v0, double v1, double v2, double v3 ,double v4, double v5, double v6)
	{
		Tuple7f t = allocator.alloc();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		t.v[2] = (float)v2;
		t.v[3] = (float)v3;
		t.v[4] = (float)v4;
		t.v[5] = (float)v5;
		t.v[6] = (float)v6;
		
		return t;
	}
	
	public static void dealloc(Tuple7f t) { allocator.dealloc(t); }
	
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
	
	public Tuple7f(Tuple7f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
	}
	
	public Tuple7f(Tuple7d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
		this.v[5] = (float)t.v[5];
		this.v[6] = (float)t.v[6];
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
	
	public Tuple7f(Tup7dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		this.v[3] = (float)t.get(3);
		this.v[4] = (float)t.get(4);
		this.v[5] = (float)t.get(5);
		this.v[6] = (float)t.get(6);
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
		
		float scl = (float) scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
		this.v[5] = scl;
		this.v[6] = scl;
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

	public Tuple7f set(Tuple7f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
		return this;
	}
	
	public Tuple7f set(Tuple7d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		this.v[3] = (float)t.v[3];
		this.v[4] = (float)t.v[4];
		this.v[5] = (float)t.v[5];
		this.v[6] = (float)t.v[6];
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
		
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		this.v[3] = scl;
		this.v[4] = scl;
		this.v[5] = scl;
		this.v[6] = scl;
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
