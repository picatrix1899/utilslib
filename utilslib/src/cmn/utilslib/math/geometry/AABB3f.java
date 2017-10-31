package cmn.utilslib.math.geometry;

import cmn.utilslib.interfaces.Source;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

public class AABB3f implements ConvexPolygonalShape3f
{
	
	public Point3f center = new Point3f();
	public Vector3f halfExtend = new Vector3f();
	
	public AABB3f() { }
	
	public AABB3f(Point3f center, Vector3f halfExtend)
	{
		this.center.set(center);
		this.halfExtend.set(halfExtend);
	}
	
	public AABB3f(AABB3f aabb)
	{
		this.center.set(aabb.center);
		this.halfExtend.set(aabb.halfExtend);
	}
	
	
	public AABB3f set(AABB3f aabb)
	{
		this.center.set(aabb.center);
		this.halfExtend.set(aabb.halfExtend);
		
		return this;
	}
	
	public AABB3f set(Point3f center, Vector3f halfExtend)
	{
		this.center.set(center);
		this.halfExtend.set(halfExtend);
		
		return this;
	}
	
	public AABB3f transform(Matrix4f t)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		return new AABB3f(new Point3f(center), halfExtend);
	}

	@Override
	@Source(Shape3f.class)
	public OBB3f getOBBf()
	{
		return new OBB3f(this.center, this.halfExtend, Matrix4f.identity());
	}
	
	@Override
	@Source(Shape3f.class)
	public OBB3f getOBBf(OBB3f obb)
	{
		return obb.set(this.center, this.halfExtend, Matrix4f.identity());
	}
	
	@Override
	@Source(Shape3f.class)
	public OBB3f getOBBf(Matrix4f t, Matrix4f r)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		return new OBB3f(new Point3f(center), halfExtend, r);
	}
	
	@Override
	@Source(Shape3f.class)
	public OBB3f getOBBf(Matrix4f t, Matrix4f r, OBB3f obb)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		return obb.set(new Point3f(center), halfExtend, r);
	}

	@Override
	@Source(Shape3f.class)
	public AABB3f getAABBf()
	{
		return new AABB3f(this);
	}
	
	@Override
	@Source(Shape3f.class)
	public AABB3f getAABBf(AABB3f aabb)
	{
		return aabb.set(this);
	}
	
	@Override
	@Source(Shape3f.class)
	public AABB3f getAABBf(Matrix4f t)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return new AABB3f(new Point3f(center), halfExtend);
	}
	
	@Override
	@Source(Shape3f.class)
	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return aabb.set(new Point3f(center), halfExtend);
	}

	@Override
	@Source(Shape3f.class)
	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingSpheref getBoundingSpheref(BoundingSpheref s)
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingSpheref getBoundingSpheref(Matrix4f t, BoundingSpheref s)
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingElipsoidf getBoundingElisoidf(BoundingElipsoidf e)
	{
		return null;
	}

	@Override
	@Source(Shape3f.class)
	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}
	
	@Override
	@Source(Shape3f.class)
	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t, BoundingElipsoidf e)
	{
		return null;
	}
	
	@Override
	@Source(ConvexPolygonalShape3f.class)
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
	
	@Override
	@Source(ConvexPolygonalShape3f.class)
	public Point3f[] getPoints(Matrix4f t)
	{
		return null;
	}
	
	public String toString()
	{
		return String.format("aabb3f(center: %sf, %sf, %sf; extend: %sf, %sf, %sf)",
							 this.center.x, this.center.y, this.center.z,
							 this.halfExtend.x, this.halfExtend.y, this.halfExtend.z);
	}

	public String toStringMinMax()
	{
		Point3f max = center.jumpN(halfExtend);
		Point3f min = center.jumpN(halfExtend.negateN());

		return String.format("aabb3f(min: %sf, %sf, %sf; max: %sf, %sf, %sf)",
							 min.x, min.y, min.z,
							 max.x, max.y, max.z);
	}
	
	public String toStringCenterExtend()
	{
		return String.format("aabb3f(center: %sf, %sf, %sf; extend: %sf, %sf, %sf)",
							 this.center.x, this.center.y, this.center.z,
							 this.halfExtend.x, this.halfExtend.y, this.halfExtend.z);
	}

}
