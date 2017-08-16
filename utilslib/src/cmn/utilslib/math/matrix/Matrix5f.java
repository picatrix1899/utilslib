package cmn.utilslib.math.matrix;

import cmn.utilslib.math.tuple.Tuple5f;
import cmn.utilslib.math.vector.api.Vec4fBase;

public class Matrix5f
{
	public static final int ROWS = 5;
	public static final int COLS = 5;
	public static final int ENTS = 25;
	
	public final Tuple5f m0 = new Tuple5f();
	public final Tuple5f m1 = new Tuple5f();
	public final Tuple5f m2 = new Tuple5f();
	public final Tuple5f m3 = new Tuple5f();
	public final Tuple5f m4 = new Tuple5f();
	
	public Matrix5f()
	{
		initZero();
	}
	
	public Matrix5f(Matrix5f m)
	{
		set(m);
	}
	
	public Matrix5f set(Matrix5f m)
	{
		this.m0.set(m.m0);
		this.m1.set(m.m1);
		this.m2.set(m.m2);
		this.m3.set(m.m3);
		this.m4.set(m.m4);
		
		return this;
	}
	
	public static Matrix5f zero() { return new Matrix5f().initZero(); }
	
	public Matrix5f initZero()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
		this.m3.setZero();
		this.m4.setZero();
		
		return this;
	}
	
	public static Matrix5f identity() { return new Matrix5f().initIdendity(); }
	
	public Matrix5f initIdendity()
	{
		this.m0.set(1, 0, 0, 0, 0);
		this.m1.set(0, 1, 0, 0, 0);
		this.m2.set(0, 0, 1, 0, 0);
		this.m3.set(0, 0, 0, 1, 0);
		this.m4.set(0, 0, 0, 0, 1);
		
		return this;
	}
	
	public Matrix5f initScale(Vec4fBase v)
	{
		this.m0.set(v.getX(), 0, 0, 0, 0);
		this.m1.set(0, v.getY(), 0, 0, 0);
		this.m2.set(0, 0, v.getZ(), 0, 0);
		this.m3.set(0, 0, 0, v.getA(), 0);
		this.m4.set(0, 0, 0, 0, 1);
		
		return this;
	}
	
	public Matrix5f initTranslate(Vec4fBase v)
	{
		this.m0.set(1, 0, 0, 0, v.getX());
		this.m1.set(0, 1, 0, 0, v.getY());
		this.m2.set(0, 0, 1, 0, v.getZ());
		this.m3.set(0, 0, 0, 1, v.getA());
		this.m4.set(0, 0, 0, 0, 1);
		
		return this;
	}
}
