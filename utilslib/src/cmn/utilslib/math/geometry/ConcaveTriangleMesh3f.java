package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.matrix.Matrix4f;

public class ConcaveTriangleMesh3f implements ConcavePolygonalShape3f
{

	private List<Triangle3f> triangles;
	
	public ConcaveTriangleMesh3f(List<Triangle3f> triangles)
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
		ConcaveTriangleMesh3f mesh = transform(t);
		
		return mesh.getAABBf(aabb);
	}

	public OBB3f getOBBf(Matrix4f t)
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		return new OBB3f(min, max, t);
	}
	
	public OBB3f getOBBf(Matrix4f TS, Matrix4f R)
	{

		ConcaveTriangleMesh3f mesh = transform(TS);
		
		Point3f min = new Point3f(mesh.getMinX(), mesh.getMinY(), mesh.getMinZ());
		Point3f max = new Point3f(mesh.getMaxX(), mesh.getMaxY(), mesh.getMaxZ());
		
		return new OBB3f(min, max, R);
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
		
		return new OBB3f(min, max, Matrix4f.identity());
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

	public ConcaveTriangleMesh3f transform(Matrix4f t)
	{
		
		ArrayList<Triangle3f> tr = Auto.ArrayList();
		
		for(Triangle3f triangle : this.triangles)
		{
			tr.add(triangle.transform(t, new Triangle3f()));
		}
		
		return new ConcaveTriangleMesh3f(tr);
	}
	
}
