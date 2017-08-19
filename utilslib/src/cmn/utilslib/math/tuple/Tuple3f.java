package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public class Tuple3f implements Tup3f
{

	public float[] v = new float[3];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple3f TEMP = new Tuple3f();
	public static final Tuple3f TEMP0 = new Tuple3f();
	public static final Tuple3f TEMP1 = new Tuple3f();
	public static final Tuple3f TEMP2 = new Tuple3f();
	public static final Tuple3f TEMP3 = new Tuple3f();
	public static final Tuple3f TEMP4 = new Tuple3f();
	public static final Tuple3f TEMP5 = new Tuple3f();
	public static final Tuple3f TEMP6 = new Tuple3f();
	public static final Tuple3f TEMP7 = new Tuple3f();
	public static final Tuple3f TEMP8 = new Tuple3f();
	public static final Tuple3f TEMP9 = new Tuple3f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple3f> allocator = new Allocator<Tuple3f>(Tuple3f.class);
	
	public static Tuple3f alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple3f alloc(Tuple3f t)
	{
		Tuple3f t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		
		return t0;
	}
	
	public static Tuple3f alloc(Tuple3d t)
	{
		Tuple3f t0 = allocator.alloc();
		
		t0.v[0] = (float)t.v[0];
		t0.v[1] = (float)t.v[1];
		t0.v[2] = (float)t.v[2];
		
		return t0;
	}
	
	public static Tuple3f alloc(Tup3fBase t)
	{
		Tuple3f t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		
		return t0;
	}
	
	public static Tuple3f alloc(Tup3dBase t)
	{
		Tuple3f t0 = allocator.alloc();
		
		t0.v[0] = (float)t.get(0);
		t0.v[1] = (float)t.get(1);
		t0.v[2] = (float)t.get(2);
		
		return t0;
	}
	
	public static Tuple3f alloc(float scalar)
	{
		Tuple3f t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		
		return t;
	}
	
	public static Tuple3f alloc(double scalar)
	{
		Tuple3f t = allocator.alloc();
		
		float scl = (float)scalar;
		
		t.v[0] = scl;
		t.v[1] = scl;
		t.v[2] = scl;
		
		return t;
	}
	
	public static Tuple3f alloc(float v0, float v1, float v2)
	{
		Tuple3f t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		
		return t;
	}
	
	public static Tuple3f alloc(double v0, double v1, double v2)
	{
		Tuple3f t = allocator.alloc();
		
		t.v[0] = (float)v0;
		t.v[1] = (float)v1;
		t.v[2] = (float)v2;
		
		return t;
	}
	
	public static void dealloc(Tuple3f t) { allocator.dealloc(t); }
	
	public Tuple3f()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
	}
	
	public Tuple3f(Tuple3f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
	}
	
	public Tuple3f(Tuple3d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
	}
	
	public Tuple3f(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
	}
	
	public Tuple3f(Tup3dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
	}
	
	public Tuple3f(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
	}
	
	public Tuple3f(double scalar)
	{
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
	}
	
	public Tuple3f(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
	}
	
	public Tuple3f(double v0, double v1, double v2)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
	}
	
	@Override
	public float get(int index) { return this.v[index]; }

	@Override
	public Tuple3f clone() { return new Tuple3f(this); }


	@Override
	public Tuple3f setZero() { this.v[0] = 0; this.v[1] = 0; this.v[2] = 0; return this; }

	public Tuple3f set(Tuple3f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		return this;
	}
	
	public Tuple3f set(Tuple3d t)
	{
		this.v[0] = (float)t.v[0];
		this.v[1] = (float)t.v[1];
		this.v[2] = (float)t.v[2];
		return this;
	}
	
	@Override
	public Tuple3f set(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		return this;
	}

	@Override
	public Tuple3f set(Tup3dBase t)
	{
		this.v[0] = (float)t.get(0);
		this.v[1] = (float)t.get(1);
		this.v[2] = (float)t.get(2);
		return this;
	}

	@Override
	public Tuple3f set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		return this;
	}

	@Override
	public Tuple3f set(double scalar)
	{
		float scl = (float)scalar;
		
		this.v[0] = scl;
		this.v[1] = scl;
		this.v[2] = scl;
		return this;
	}

	@Override
	public Tuple3f set(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		return this;
	}

	@Override
	public Tuple3f set(double v0, double v1, double v2)
	{
		this.v[0] = (float)v0;
		this.v[1] = (float)v1;
		this.v[2] = (float)v2;
		return this;
	}

	@Override
	public Tuple3f set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple3f set(int index, double value) { this.v[index] = (float)value; return this; }

}
