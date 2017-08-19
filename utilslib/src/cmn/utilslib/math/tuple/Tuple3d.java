package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup3d;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public class Tuple3d implements Tup3d
{

	public double[] v = new double[3];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple3d TEMP = new Tuple3d();
	public static final Tuple3d TEMP0 = new Tuple3d();
	public static final Tuple3d TEMP1 = new Tuple3d();
	public static final Tuple3d TEMP2 = new Tuple3d();
	public static final Tuple3d TEMP3 = new Tuple3d();
	public static final Tuple3d TEMP4 = new Tuple3d();
	public static final Tuple3d TEMP5 = new Tuple3d();
	public static final Tuple3d TEMP6 = new Tuple3d();
	public static final Tuple3d TEMP7 = new Tuple3d();
	public static final Tuple3d TEMP8 = new Tuple3d();
	public static final Tuple3d TEMP9 = new Tuple3d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple3d> allocator = new Allocator<Tuple3d>(Tuple3d.class);
	
	public static Tuple3d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple3d alloc(Tuple3f t)
	{
		Tuple3d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		
		return t0;
	}
	
	public static Tuple3d alloc(Tuple3d t)
	{
		Tuple3d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		
		return t0;
	}
	
	public static Tuple3d alloc(Tup3fBase t)
	{
		Tuple3d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		
		return t0;
	}
	
	public static Tuple3d alloc(Tup3dBase t)
	{
		Tuple3d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		
		return t0;
	}
	
	public static Tuple3d alloc(float scalar)
	{
		Tuple3d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		
		return t;
	}
	
	public static Tuple3d alloc(double scalar)
	{
		Tuple3d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		
		return t;
	}
	
	public static Tuple3d alloc(float v0, float v1, float v2)
	{
		Tuple3d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		
		return t;
	}
	
	public static Tuple3d alloc(double v0, double v1, double v2)
	{
		Tuple3d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		
		return t;
	}
	
	public static void dealloc(Tuple3d t) { allocator.dealloc(t); }
	
	public Tuple3d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
	}
	
	public Tuple3d(Tuple3f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
	}
	
	public Tuple3d(Tuple3d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
	}
	
	public Tuple3d(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
	}
	
	public Tuple3d(Tup3dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
	}
	
	public Tuple3d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
	}
	
	public Tuple3d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
	}
	
	public Tuple3d(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
	}
	
	public Tuple3d(double v0, double v1, double v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
	}
	
	@Override
	public double get(int index) { return this.v[index]; }

	@Override
	public Tuple3d clone() { return new Tuple3d(this); }


	@Override
	public Tuple3d setZero() { this.v[0] = 0; this.v[1] = 0; this.v[2] = 0; return this; }

	public Tuple3d set(Tuple3f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		return this;
	}
	
	public Tuple3d set(Tuple3d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		return this;
	}
	
	@Override
	public Tuple3d set(Tup3fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		return this;
	}

	@Override
	public Tuple3d set(Tup3dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		return this;
	}

	@Override
	public Tuple3d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		return this;
	}

	@Override
	public Tuple3d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		return this;
	}

	@Override
	public Tuple3d set(float v0, float v1, float v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		return this;
	}

	@Override
	public Tuple3d set(double v0, double v1, double v2)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		return this;
	}

	@Override
	public Tuple3d set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple3d set(int index, double value) { this.v[index] = value; return this; }

}
