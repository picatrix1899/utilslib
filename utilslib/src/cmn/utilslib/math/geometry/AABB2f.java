package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;

public class AABB2f extends Rectangle2f
{
	public AABB2f(Point2f min, Point2f max)
	{
		super(min, max);
	}

	public AABB2f(Point2f center, Vector2f halfExtend)
	{
		super(center, halfExtend);
	}
}
