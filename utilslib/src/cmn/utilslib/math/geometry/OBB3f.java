package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;

public class OBB3f extends Cuboidf
{

	public Matrix4f m = new Matrix4f();
	
	public OBB3f(Point3f min, Point3f max, Matrix4f m)
	{
		super(min, max);
		this.m = m;
	}

}
