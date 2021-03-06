package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rectangle2f implements ConvexPolygonalShape2f
{

	public Point2f center = new Point2f();
	public Vector2f halfExtend = new Vector2f(); 
	
	public Rectangle2f(Point2f min, Point2f max)
	{
		this.halfExtend.set(min.vectorTof(max, new Vector2f()).mul(0.5));
		this.center.set(min.addVector(this.halfExtend, new Vector2f()));
	}

	public Rectangle2f(Point2f center, Vector2f halfExtend)
	{
		this.center.set(center);
		this.halfExtend.set(halfExtend);
	}
	
	@Override
	public Point2f[] getPoints()
	{
		throw new NotImplementedException();
	}

	@Override
	public AABB2f getAABB()
	{
		return new AABB2f(this.center, this.halfExtend);
	}

	public Point2f getMin()
	{
		return new Point2f(this.center.asVector2f(new Vector2f()).sub(this.halfExtend));
	}
	
	public Point2f getMax()
	{
		return new Point2f(this.center.asVector2f(new Vector2f()).add(this.halfExtend));
	}
	
}
