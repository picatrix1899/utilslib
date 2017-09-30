package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.matrix.Matrix4f;

public class ConvexTriangleMesh3f implements ConvexPolygonalShape3f
{

	private List<Triangle3f> triangles;
	
	public ConvexTriangleMesh3f(List<Triangle3f> triangles)
	{
		this.triangles = triangles;
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

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		ConvexTriangleMesh3f mesh = transform(t);
		
		return mesh.getAABBf(aabb);

	}

	public OBB3f getOBBf(Matrix4f t)
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		return new OBB3f(min, max, t);
	}
	
	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		
		
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}

	public AABB3f getAABBf(AABB3f aabb)
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		return new AABB3f(min, max);
	}

	public OBB3f getOBBf()
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		return new OBB3f(min, max, new Matrix4f());
	}

	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}

	public Point3f[] getPoints(Matrix4f t)
	{
		return null;
	}

	public ConvexTriangleMesh3f transform(Matrix4f t)
	{
		
		ArrayList<Triangle3f> tr = Auto.ArrayList();
		
		for(Triangle3f triangle : this.triangles)
		{
			tr.add(triangle.transform(t, new Triangle3f()));
		}
		
		return new ConvexTriangleMesh3f(tr);
	}

}
