package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class AABB3f extends Cuboidf
{
	public AABB3f(Point3f min, Point3f max)
	{
		super(min, max);
	}

	public AABB3f(Point3f center, Vector3f halfExtend)
	{
		super(center, halfExtend);
	}
}