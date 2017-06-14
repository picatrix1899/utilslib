package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class LineSegment3f
{
	public Point3f p;
	public Vector3f v;
	
	public StraightLine3f asStraightLine()
	{
		return new StraightLine3f(p, v);
	}
	
}
