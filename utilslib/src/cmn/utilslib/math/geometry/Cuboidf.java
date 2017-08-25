package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Cuboidf implements ConvexPolygonalShape3f
{
	private Point3f center = new Point3f();
	private Vector3f halfExtend = new Vector3f();
	
	public Cuboidf(Point3f min, Point3f max)
	{
		this.halfExtend.set(min.vectorTo(max, Vector3f.TEMP).mul(0.5));
		this.center.set(min.asVector3f(Vector3f.TEMP).add(this.halfExtend));
		
	}
	
	public Cuboidf(Point3f center, Vector3f halfExtend)
	{
		this.center.set(center); this.halfExtend.set(halfExtend);
	}

	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
	}

	public AABB3f getAABBf(Shape3f s)
	{
		return null;
	}
}
