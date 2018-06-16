package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class LineSegment3f
{
	public Point3f p;
	public Vector3f v;
	
	public Ray3f asStraightLine()
	{
		return new Ray3f(p, v);
	}
	
}
