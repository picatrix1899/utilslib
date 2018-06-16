package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

public class OBB3f implements ConvexPolygonalShape3f
{

	public Point3f center = new Point3f();
	public Vector3f halfExtend = new Vector3f();
	public Matrix4f r = new Matrix4f();
	
	public OBB3f(Point3f center, Vector3f halfExtend, Matrix4f r)
	{
		this.center.set(center);
		this.halfExtend.set(halfExtend);	
		this.r.set(r);
	}
	
	public OBB3f(OBB3f obb)
	{
		this.center.set(obb.center);		
		this.halfExtend.set(obb.halfExtend);
		this.r.set(obb.r);
	}

	public OBB3f set(OBB3f obb)
	{
		this.center.set(obb.center);
		this.halfExtend.set(obb.halfExtend);	
		this.r.set(obb.r);
		
		
		return this;
	}
	
	public OBB3f set(Point3f center, Vector3f halfExtend, Matrix4f r)
	{
		this.center.set(center);
		this.halfExtend.set(halfExtend);	
		this.r.set(r);
		
		return this;
	}
	
	public Matrix3f getModelSpaceMatrix()
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.set(this.r.transformN(Vector3f.aX).normalize());
		m.m1.set(this.r.transformN(Vector3f.aY).normalize());
		m.m2.set(this.r.transformN(Vector3f.aZ).normalize());
		
		return m;
	}
	
	public OBB3f transform(Matrix4f t, Matrix4f r)
	{
		Vector3f min = this.center.asVector3f().sub(this.halfExtend);
		Vector3f max = this.center.asVector3f().add(this.halfExtend);
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		Matrix4f rotation = Matrix4f.mul(this.r, r, new Matrix4f());
		
		return new OBB3f(new Point3f(center), halfExtend, rotation);
	}
	
	public Point3f[] getPoints()
	{
		Vector3f c = center.asVector3f(new Vector3f());

		Vector3f v = new Vector3f();
		
		Matrix3f modelSpace = getModelSpaceMatrix();
		
		Matrix3f objToWorld = new Matrix3f();
		
//		objToWorld.m0.x = modelSpace.m0.x;
//		objToWorld.m0.y = modelSpace.m1.x;
//		objToWorld.m0.z = modelSpace.m2.x;
//		objToWorld.m1.x = modelSpace.m0.y;
//		objToWorld.m1.y = modelSpace.m1.y;
//		objToWorld.m1.z = modelSpace.m2.y;
//		objToWorld.m2.x = modelSpace.m0.z;
//		objToWorld.m2.y = modelSpace.m1.z;
//		objToWorld.m2.z = modelSpace.m2.z;
//		
//		v = this.halfExtend;
//		
//		return new Point3f[] {
//				new Point3f(c.addN(modelSpace.transformN(v))),
//				new Point3f(c.addN(modelSpace.transform(new Vector3f(-v.x, v.y, v.z)))),
//				new Point3f(c.addN(modelSpace.transform(new Vector3f(-v.x, -v.y, v.z)))),
//				new Point3f(c.addN(modelSpace.transform(new Vector3f(v.x, -v.y, v.z)))),
//				
//				new Point3f(c.subN(modelSpace.transformN(v))),
//				new Point3f(c.subN(modelSpace.transform(new Vector3f(-v.x, v.y, v.z)))),
//				new Point3f(c.subN(modelSpace.transform(new Vector3f(-v.x, -v.y, v.z)))),
//				new Point3f(c.subN(modelSpace.transform(new Vector3f(v.x, -v.y, v.z)))),
//		};
		
		objToWorld.m0.x = modelSpace.m0.x;
		objToWorld.m0.y = modelSpace.m1.x;
		objToWorld.m0.z = modelSpace.m2.x;
		objToWorld.m1.x = modelSpace.m0.y;
		objToWorld.m1.y = modelSpace.m1.y;
		objToWorld.m1.z = modelSpace.m2.y;
		objToWorld.m2.x = modelSpace.m0.z;
		objToWorld.m2.y = modelSpace.m1.z;
		objToWorld.m2.z = modelSpace.m2.z;
		
		v = modelSpace.transformN(this.halfExtend);
		
		return new Point3f[] {
				new Point3f(c.addN(objToWorld.transformN(v))),
				new Point3f(c.addN(objToWorld.transform(new Vector3f(-v.x, v.y, v.z)))),
				new Point3f(c.addN(objToWorld.transform(new Vector3f(-v.x, -v.y, v.z)))),
				new Point3f(c.addN(objToWorld.transform(new Vector3f(v.x, -v.y, v.z)))),
				
				new Point3f(c.subN(objToWorld.transformN(v))),
				new Point3f(c.subN(objToWorld.transform(new Vector3f(-v.x, v.y, v.z)))),
				new Point3f(c.subN(objToWorld.transform(new Vector3f(-v.x, -v.y, v.z)))),
				new Point3f(c.subN(objToWorld.transform(new Vector3f(v.x, -v.y, v.z)))),
		};
	}

	public Point3f[] getPoints(Matrix4f TS)
	{
		return null;
	}

	public AABB3f getAABBf()
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return new AABB3f(new Point3f(center), halfExtend);
	}

	public AABB3f getAABBf(AABB3f aabb)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return aabb.set(new Point3f(center), halfExtend);
	}

	public AABB3f getAABBf(Matrix4f t)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return new AABB3f(new Point3f(center), halfExtend);
	}

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		Vector3f min = new Vector3f(getMinX(), getMinY(), getMinZ());
		Vector3f max = new Vector3f(getMaxX(), getMaxY(), getMaxZ());
		
		t.transform(min);
		t.transform(max);
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);

		return aabb.set(new Point3f(center), halfExtend);
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

	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref(BoundingSpheref s)
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref(Matrix4f t, BoundingSpheref s)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf(BoundingElipsoidf e)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t, BoundingElipsoidf e)
	{
		return null;
	}
	
}
