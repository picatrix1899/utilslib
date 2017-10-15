package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;

public class OBB3f extends Cuboidf
{

	public Matrix3f m = new Matrix3f();
	
	public OBB3f(Point3f min, Point3f max, Matrix3f m)
	{
		super(min, max);
		this.m = m;
	}

}
