package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

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

	public Point3f[] getPoints(Matrix4f t)
	{
		return null;
	}
	
	public AABB3f getAABBf()
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return new AABB3f(center, halfExtend);
	}

	public AABB3f getAABBf(AABB3f aabb)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return aabb.set(center, halfExtend);
	}
	
	public AABB3f getAABBf(Matrix4f t)
	{
		ConcaveTriangleMesh3f mesh = transform(t);
		
		return mesh.getAABBf();
	}
	
	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		ConcaveTriangleMesh3f mesh = transform(t);
		
		return mesh.getAABBf(aabb);
	}

	public OBB3f getOBBf()
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());

		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return new OBB3f(center, halfExtend, Matrix4f.identity());
	}
	
	public OBB3f getOBBf(OBB3f obb)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());

		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return obb.set(center, halfExtend, Matrix4f.identity());
	}
	

	public OBB3f getOBBf(Matrix4f t, Matrix4f r)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());

		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return new OBB3f(center, halfExtend, r);
	}
	
	public OBB3f getOBBf(Matrix4f t, Matrix4f r, OBB3f obb)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());

		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5f);
		Point3f center = new Point3f(min.addN(halfExtend));
		
		return obb.set(center, halfExtend, r);
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
	
	public ConcaveTriangleMesh3f transform(Matrix3f t)
	{
		ArrayList<Triangle3f> tr = Auto.ArrayList();
		
		for(Triangle3f triangle : this.triangles)
		{
			tr.add(triangle.transform(t, new Triangle3f()));
		}
		
		return new ConcaveTriangleMesh3f(tr);
	}


	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}

	
	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		
		
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}


	public BoundingSpheref getBoundingSpheref(BoundingSpheref s)
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref(Matrix4f t, BoundingSpheref s)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf(BoundingElipsoidf e)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t, BoundingElipsoidf e)
	{
		return null;
	}
	
}
