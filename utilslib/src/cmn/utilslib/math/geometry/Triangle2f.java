package cmn.utilslib.math.geometry;

public class Triangle2f implements ConvexPolygonalShape2f
{
	public Point2f a = new Point2f();
	public Point2f b = new Point2f();
	public Point2f c = new Point2f();
	
	@Override
	public Point2f[] getPoints()
	{
		return new Point2f[] {this.a, this.b, this.c};
	}

	@Override
	public AABB2f getAABB()
	{
		float minX = Float.POSITIVE_INFINITY;
		float minY = Float.POSITIVE_INFINITY;
		
		float maxX = Float.NEGATIVE_INFINITY;
		float maxY = Float.NEGATIVE_INFINITY;
		
		if(a.x < minX) minX = a.x;
		if(b.x < minX) minX = b.x;
		if(c.x < minX) minX = c.x;
		
		if(a.y < minY) minX = a.y;
		if(b.y < minY) minX = b.y;
		if(c.y < minY) minX = c.y;
		
		if(a.x > maxX) minX = a.x;
		if(b.x > maxX) minX = b.x;
		if(c.x > maxX) minX = c.x;
		
		if(a.y > maxY) minY = a.y;
		if(b.y > maxY) minY = b.y;
		if(c.y > maxY) minY = c.y;
		
		return new AABB2f(new Point2f(minX, minY), new Point2f(maxX, maxY));
	}
}
