package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup5d;
import cmn.utilslib.math.tuple.api.Tup5dBase;
import cmn.utilslib.math.tuple.api.Tup5fBase;

public class Tuple5d implements Tup5d
{
	public double[] v = new double[5];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple5d TEMP = new Tuple5d();
	public static final Tuple5d TEMP0 = new Tuple5d();
	public static final Tuple5d TEMP1 = new Tuple5d();
	public static final Tuple5d TEMP2 = new Tuple5d();
	public static final Tuple5d TEMP3 = new Tuple5d();
	public static final Tuple5d TEMP4 = new Tuple5d();
	public static final Tuple5d TEMP5 = new Tuple5d();
	public static final Tuple5d TEMP6 = new Tuple5d();
	public static final Tuple5d TEMP7 = new Tuple5d();
	public static final Tuple5d TEMP8 = new Tuple5d();
	public static final Tuple5d TEMP9 = new Tuple5d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple5d> allocator = new Allocator<Tuple5d>(Tuple5d.class);
	
	public static Tuple5d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple5d alloc(Tuple5f t)
	{
		Tuple5d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		
		return t0;
	}
	
	public static Tuple5d alloc(Tuple5d t)
	{
		Tuple5d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		
		return t0;
	}
	
	public static Tuple5d alloc(Tup5fBase t)
	{
		Tuple5d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		
		return t0;
	}
	
	public static Tuple5d alloc(Tup5dBase t)
	{
		Tuple5d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		
		return t0;
	}
	
	public static Tuple5d alloc(float scalar)
	{
		Tuple5d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		
		return t;
	}
	
	public static Tuple5d alloc(double scalar)
	{
		Tuple5d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		
		return t;
	}
	
	public static Tuple5d alloc(float v0, float v1, float v2, float v3, float v4)
	{
		Tuple5d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		
		return t;
	}
	
	public static Tuple5d alloc(double v0, double v1, double v2, double v3 ,double v4)
	{
		Tuple5d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		
		return t;
	}
	
	public static void dealloc(Tuple5d t) { allocator.dealloc(t); }
	
	public Tuple5d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
	}
	
	public Tuple5d(Tuple5f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
	}
	
	public Tuple5d(Tuple5d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
	}
	
	public Tuple5d(Tup5fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
	}
	
	public Tuple5d(Tup5dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
	}
	
	public Tuple5d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
	}
	
	public Tuple5d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
	}
	
	public Tuple5d(float v0, float v1, float v2, float v3, float v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
	}
	
	public Tuple5d(double v0, double v1, double v2, double v3, double v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
	}
	
	public double get(int index) { return this.v[index]; }

	public Tuple5d clone() { return new Tuple5d(this); }

	public Tuple5d setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		return this;
	}

	public Tuple5d set(Tuple5f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		return this;
	}
	
	public Tuple5d set(Tuple5d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		return this;
	}
	
	public Tuple5d set(Tup5fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		return this;
	}
	
	public Tuple5d set(Tup5dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		return this;
	}

	public Tuple5d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		return this;
	}

	public Tuple5d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		return this;
	}

	public Tuple5d set(float v0, float v1, float v2, float v3, float v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		return this;
	}

	public Tuple5d set(double v0, double v1, double v2, double v3, double v4)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		return this;
	}

	public Tuple5d set(int index, float value) { this.v[index] = value; return this; }

	public Tuple5d set(int index, double value) { this.v[index] = value; return this; }
}
