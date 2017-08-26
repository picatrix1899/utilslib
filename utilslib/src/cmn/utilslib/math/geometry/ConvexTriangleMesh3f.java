package cmn.utilslib.math.geometry;

import java.util.List;

public class ConvexTriangleMesh3f implements ConvexPolygonalShape3f
{

	private List<Triangle3f> triangles;
	
	public ConvexTriangleMesh3f(List<Triangle3f> triangles)
	{
		this.triangles = triangles;
	}
	
	public AABB3f getAABBf()
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		return new AABB3f(min, max);
	}

	public Point3f[] getPoints()
	{
		Point3f[] p = new Point3f[triangles.size() * 3];
		
		for(int i = 0; i < triangles.size(); i++)
		{
			p[i * 3] = triangles.get(i).a;
			p[i * 3 + 1] = triangles.get(i).b;
			p[i * 3 + 2] = triangles.get(i).c;
		}
		
		return p;
	}

}
