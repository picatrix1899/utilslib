package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

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
		
		Vector3f c = center.asVector3f(new Vector3f());
		
		return new Point3f[] {
				new Point3f(c.subN(halfExtend)),
				new Point3f(c.subN(-halfExtend.x, halfExtend.y, halfExtend.z)),
				new Point3f(c.subN(-halfExtend.x, -halfExtend.y, halfExtend.z)),
				new Point3f(c.subN(halfExtend.x, -halfExtend.y, halfExtend.z)),
				
				new Point3f(c.addN(halfExtend)),
				new Point3f(c.addN(-halfExtend.x, halfExtend.y, halfExtend.z)),
				new Point3f(c.addN(-halfExtend.x, -halfExtend.y, halfExtend.z)),
				new Point3f(c.addN(halfExtend.x, -halfExtend.y, halfExtend.z)),
		};
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
		Cuboidf cube = transform(t);
		
		Vector3f c = cube.center.asVector3f(new Vector3f());
		
		return new Point3f[] {
				new Point3f(c.subN(cube.halfExtend)),
				new Point3f(c.subN(-cube.halfExtend.x, cube.halfExtend.y, cube.halfExtend.z)),
				new Point3f(c.subN(-cube.halfExtend.x, -cube.halfExtend.y, cube.halfExtend.z)),
				new Point3f(c.subN(cube.halfExtend.x, -cube.halfExtend.y, cube.halfExtend.z)),
				
				new Point3f(c.addN(cube.halfExtend)),
				new Point3f(c.addN(-cube.halfExtend.x, cube.halfExtend.y, cube.halfExtend.z)),
				new Point3f(c.addN(-cube.halfExtend.x, -cube.halfExtend.y, cube.halfExtend.z)),
				new Point3f(c.addN(cube.halfExtend.x, -cube.halfExtend.y, cube.halfExtend.z)),
		};
	}

	public Cuboidf transform(Matrix4f t)
	{
		Vector3f min = this.center.asVector3f(new Vector3f()).subN(this.halfExtend);
		Vector3f max = this.center.asVector3f(new Vector3f()).addN(this.halfExtend);
		
		Matrix4f.transform(t, min, min);
		Matrix4f.transform(t, max, max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		
		return new Cuboidf(new Point3f(center), halfExtend);
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
