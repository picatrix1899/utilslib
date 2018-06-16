package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;

public class Square2f implements ConvexPolygonalShape2f
{

	public Point2f center = new Point2f();
	public float halfExtend = 1.0f;



	@Override
	public AABB2f getAABB()
	{
		return new AABB2f(this.center, Vector2f.TEMP.set(this.halfExtend));
	}



	@Override
	public Point2f[] getPoints()
	{
		return null;
	}

}
