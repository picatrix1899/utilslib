package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;

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

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		return null;
	}

	public OBB3f getOBBf(Matrix3f t)
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

	public AABB3f getAABBf(AABB3f aabb)
	{
		return null;
	}

	public OBB3f getOBBf()
	{
		return null;
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

	public ConvexPolygonalShape3f transform(Matrix4f t)
	{
		return null;
	}

	public AABB3f getAABBf()
	{
		return null;
	}

	public AABB3f getAABBf(Matrix4f t)
	{
		return null;
	}

	public OBB3f getOBBf(OBB3f obb)
	{
		return null;
	}

	public OBB3f getOBBf(Matrix4f t, Matrix4f r)
	{
		return null;
	}

	public OBB3f getOBBf(Matrix4f t, Matrix4f r, OBB3f obb)
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
