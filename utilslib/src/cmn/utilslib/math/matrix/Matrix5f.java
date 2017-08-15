package cmn.utilslib.math.matrix;

import cmn.utilslib.math.vector.Vector4f;

public class Matrix5f
{
	public static final int ROWS = 5;
	public static final int COLS = 5;
	public static final int ENTS = 25;
	
	public Vector4f m0 = new Vector4f();
	public Vector4f m1 = new Vector4f();
	public Vector4f m2 = new Vector4f();
	public Vector4f m3 = new Vector4f();
	
	public Matrix5f() { initZero(); }
	
	private Matrix5f(Matrix5f m) { set(m); }
	
	public Matrix4f set(Matrix4f m)
	{
		
		this.m0.set(m.m0);
		this.m1.set(m.m1);
		this.m2.set(m.m2);
		this.m3.set(m.m3);
		
		return this;
	}
	
	public static Matrix4f zero() { return new Matrix4f().initZero(); }
	
	public Matrix4f initZero()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
		this.m3.setZero();
		
		return this;
	}
	
	public static Matrix4f identity() { return new Matrix4f().initIdendity(); }
	
	public Matrix4f initIdendity()
	{
		this.m0.set(1.0f, 0.0f, 0.0f, 0.0f);
		this.m1.set(0.0f, 1.0f, 0.0f, 0.0f);
		this.m2.set(0.0f, 0.0f, 1.0f, 0.0f);
		this.m3.set(0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}
}
