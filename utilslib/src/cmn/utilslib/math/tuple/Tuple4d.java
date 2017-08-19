package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup4d;
import cmn.utilslib.math.tuple.api.Tup4dBase;
import cmn.utilslib.math.tuple.api.Tup4fBase;

public class Tuple4d implements Tup4d
{
	public double[] v = new double[4];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple4d TEMP = new Tuple4d();
	public static final Tuple4d TEMP0 = new Tuple4d();
	public static final Tuple4d TEMP1 = new Tuple4d();
	public static final Tuple4d TEMP2 = new Tuple4d();
	public static final Tuple4d TEMP3 = new Tuple4d();
	public static final Tuple4d TEMP4 = new Tuple4d();
	public static final Tuple4d TEMP5 = new Tuple4d();
	public static final Tuple4d TEMP6 = new Tuple4d();
	public static final Tuple4d TEMP7 = new Tuple4d();
	public static final Tuple4d TEMP8 = new Tuple4d();
	public static final Tuple4d TEMP9 = new Tuple4d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple4d> allocator = new Allocator<Tuple4d>(Tuple4d.class);
	
	public static Tuple4d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple4d alloc(Tuple4f t)
	{
		Tuple4d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		
		return t0;
	}
	
	public static Tuple4d alloc(Tuple4d t)
	{
		Tuple4d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		
		return t0;
	}
	
	public static Tuple4d alloc(Tup4fBase t)
	{
		Tuple4d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		
		return t0;
	}
	
	public static Tuple4d alloc(Tup4dBase t)
	{
		Tuple4d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		
		return t0;
	}
	
	public static Tuple4d alloc(float scalar)
	{
		Tuple4d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		
		return t;
	}
	
	public static Tuple4d alloc(double scalar)
	{
		Tuple4d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		
		return t;
	}
	
	public static Tuple4d alloc(float v0, float v1, float v2, float v3)
	{
		Tuple4d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		
		return t;
	}
	
	public static Tuple4d alloc(double v0, double v1, double v2, double v3)
	{
		Tuple4d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		
		return t;
	}
	
	public static void dealloc(Tuple4d t) { allocator.dealloc(t); }
	
	public Tuple4d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
	}
	
	public Tuple4d(Tuple4f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
	}
	
	public Tuple4d(Tuple4d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
	}
	
	public Tuple4d(Tup4fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
	}
	
	public Tuple4d(Tup4dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
	}

	public Tuple4d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
	}
	
	public Tuple4d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
	}
	
	public Tuple4d(float v0, float v1, float v2, float v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
	}
	
	public Tuple4d(double v0, double v1, double v2, double v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
	}
	
	@Override
	public double get(int index) { return this.v[index]; }

	@Override
	public Tuple4d clone() { return new Tuple4d(this); }


	@Override
	public Tuple4d setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		return this;
	}

	public Tuple4d set(Tuple4f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		return this;
	}
	
	public Tuple4d set(Tuple4d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		return this;
	}
	
	@Override
	public Tuple4d set(Tup4fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		return this;
	}

	@Override
	public Tuple4d set(Tup4dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		return this;
		}

	@Override
	public Tuple4d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		return this;
		}

	@Override
	public Tuple4d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		return this;
	}

	@Override
	public Tuple4d set(float v0, float v1, float v2, float v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		return this;
		}

	@Override
	public Tuple4d set(double v0, double v1, double v2, double v3)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		return this;
	}

	@Override
	public Tuple4d set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple4d set(int index, double value) { this.v[index] = value; return this; }
}
