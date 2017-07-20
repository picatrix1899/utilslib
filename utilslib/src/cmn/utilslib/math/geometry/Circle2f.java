package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;

public class Circle2f implements Shape2f
{
	public Point2f origin = new Point2f();
	public float radius = 1.0f;
	
	public Circle2f(Point2f origin, float radius)
	{
		this.origin.set(origin);
		this.radius = radius;
	}

	@Override
	public AABB2f getAABB()
	{
		return new AABB2f(new Point2f(this.origin.asVector2f(Vector2f.TEMP0).sub(radius)), new Point2f(this.origin.asVector2f(Vector2f.TEMP1).add(radius)));
	}

}
