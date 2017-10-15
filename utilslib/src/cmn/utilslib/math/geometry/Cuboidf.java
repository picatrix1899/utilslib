package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Cuboidf implements ConvexPolygonalShape3f
{
	public Point3f center = new Point3f();
	public Vector3f halfExtend = new Vector3f();
	
	public Cuboidf() { }
	
	public Cuboidf(Point3f min, Point3f max)
	{
		this.halfExtend.set(min.vectorTo(max, new Vector3f()).mul(0.5));
		this.center.set(min.asVector3f(new Vector3f()).add(this.halfExtend));
	}
	
	public Cuboidf(Point3f center, Vector3f halfExtend)
	{
		this.center.set(center); this.halfExtend.set(halfExtend);
	}

	public Cuboidf set(Cuboidf c)
	{
		this.center.set(c.center);
		this.halfExtend.set(c.halfExtend);
		
		return this;
	}
	
	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
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
}
