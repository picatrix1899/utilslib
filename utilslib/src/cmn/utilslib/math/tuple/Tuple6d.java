package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup6d;
import cmn.utilslib.math.tuple.api.Tup6dBase;
import cmn.utilslib.math.tuple.api.Tup6fBase;

public class Tuple6d implements Tup6d
{
	public double[] v = new double[6];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple6d TEMP = new Tuple6d();
	public static final Tuple6d TEMP0 = new Tuple6d();
	public static final Tuple6d TEMP1 = new Tuple6d();
	public static final Tuple6d TEMP2 = new Tuple6d();
	public static final Tuple6d TEMP3 = new Tuple6d();
	public static final Tuple6d TEMP4 = new Tuple6d();
	public static final Tuple6d TEMP5 = new Tuple6d();
	public static final Tuple6d TEMP6 = new Tuple6d();
	public static final Tuple6d TEMP7 = new Tuple6d();
	public static final Tuple6d TEMP8 = new Tuple6d();
	public static final Tuple6d TEMP9 = new Tuple6d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple6d> allocator = new Allocator<Tuple6d>(Tuple6d.class);
	
	public static Tuple6d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple6d alloc(Tuple6f t)
	{
		Tuple6d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		
		return t0;
	}
	
	public static Tuple6d alloc(Tuple6d t)
	{
		Tuple6d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		
		return t0;
	}
	
	public static Tuple6d alloc(Tup6fBase t)
	{
		Tuple6d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		
		return t0;
	}
	
	public static Tuple6d alloc(Tup6dBase t)
	{
		Tuple6d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		
		return t0;
	}
	
	public static Tuple6d alloc(float scalar)
	{
		Tuple6d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		
		return t;
	}
	
	public static Tuple6d alloc(double scalar)
	{
		Tuple6d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		
		return t;
	}
	
	public static Tuple6d alloc(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		Tuple6d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		
		return t;
	}
	
	public static Tuple6d alloc(double v0, double v1, double v2, double v3 ,double v4, double v5)
	{
		Tuple6d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		
		return t;
	}
	
	public static void dealloc(Tuple6d t) { allocator.dealloc(t); }
	
	public Tuple6d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
	}
	
	public Tuple6d(Tuple6f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
	}
	
	public Tuple6d(Tuple6d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
	}
	
	public Tuple6d(Tup6fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
	}
	
	public Tuple6d(Tup6dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
	}
	
	public Tuple6d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
	}
	
	public Tuple6d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
	}
	
	public Tuple6d(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
	}
	
	public Tuple6d(double v0, double v1, double v2, double v3, double v4, double v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
	}
	
	public double get(int index) { return this.v[index]; }

	public Tuple6d clone() { return new Tuple6d(this); }

	public Tuple6d setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		return this;
	}

	public Tuple6d set(Tuple6f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		return this;
	}
	
	public Tuple6d set(Tuple6d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		return this;
	}
	
	public Tuple6d set(Tup6fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		return this;
	}
	
	public Tuple6d set(Tup6dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		return this;
	}

	public Tuple6d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		return this;
	}

	public Tuple6d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		return this;
	}

	public Tuple6d set(float v0, float v1, float v2, float v3, float v4, float v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		return this;
	}

	public Tuple6d set(double v0, double v1, double v2, double v3, double v4, double v5)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		return this;
	}

	public Tuple6d set(int index, float v) { this.v[index] = v; return this; }

	public Tuple6d set(int index, double v) { this.v[index] = v; return this; }
}
