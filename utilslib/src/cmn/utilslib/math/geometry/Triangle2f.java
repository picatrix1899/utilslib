package cmn.utilslib.math.geometry;

public class Triangle2f implements ConvexPolygonalShape2f
{
	public final Point2f[] p = new Point2f[3];
	
	@Override
	public Point2f[] getPoints()
	{
		return p;
	}

	@Override
	public AABB2f getAABB()
	{
		float minX = Float.POSITIVE_INFINITY;
		float minY = Float.POSITIVE_INFINITY;
		
		float maxX = Float.NEGATIVE_INFINITY;
		float maxY = Float.NEGATIVE_INFINITY;
		
		if(p[0].x < minX) minX = p[0].x;
		if(p[1].x < minX) minX = p[1].x;
		if(p[2].x < minX) minX = p[2].x;
		
		if(p[0].y < minY) minX = p[0].y;
		if(p[1].y < minY) minX = p[1].y;
		if(p[2].y < minY) minX = p[2].y;
		
		if(p[0].x > maxX) minX = p[0].x;
		if(p[1].x > maxX) minX = p[1].x;
		if(p[2].x > maxX) minX = p[2].x;
		
		if(p[0].y > maxY) minY = p[0].y;
		if(p[1].y > maxY) minY = p[1].y;
		if(p[2].y > maxY) minY = p[2].y;
		
		return new AABB2f(new Point2f(minX, minY), new Point2f(maxX, maxY));
	}
}
