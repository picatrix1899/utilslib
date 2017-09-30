package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rectangle3f implements ConvexPolygonalShape3f
{

	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
	}

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		return null;
	}

	public OBB3f getOBBf(Matrix4f t)
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

}
