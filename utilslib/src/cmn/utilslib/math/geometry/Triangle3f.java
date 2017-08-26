package cmn.utilslib.math.geometry;

public class Triangle3f implements ConvexPolygonalShape3f
{
	public Point3f a = new Point3f();
	public Point3f b = new Point3f();
	public Point3f c = new Point3f();
	
	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] {this.a, this.b, this.c};
	}

	public AABB3f getAABBf()
	{
		return null;
	}
}
