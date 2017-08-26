package cmn.utilslib.math.geometry;

public class Thedraederf implements ConvexPolygonalShape3f
{

	public Point3f a = new Point3f();
	public Point3f b = new Point3f();
	public Point3f c = new Point3f();
	public Point3f d = new Point3f();
	
	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] { a, b, c, d };
	}

	public AABB3f getAABBf()
	{
		return null;
	}
	
}
