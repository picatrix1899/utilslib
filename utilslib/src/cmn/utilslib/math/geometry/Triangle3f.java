package cmn.utilslib.math.geometry;

import cmn.utilslib.Pool;
import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Triangle3f implements ConvexPolygonalShape3f
{	
	public Point3f a = new Point3f();
	public Point3f b = new Point3f();
	public Point3f c = new Point3f();
	
	public static final Pool<Triangle3f> pool = new Pool<Triangle3f>(Triangle3f.class);
	
	public Triangle3f() { }
	public Triangle3f(Vector3f a, Vector3f b, Vector3f c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Vector3d a, Vector3d b, Vector3d c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Vec3fBase a, Vec3fBase b, Vec3fBase c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Vec3dBase a, Vec3dBase b, Vec3dBase c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Tuple3f a, Tuple3f b, Tuple3f c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Tuple3d a, Tuple3d b, Tuple3d c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Tup3fBase a, Tup3fBase b, Tup3fBase c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Tup3dBase a, Tup3dBase b, Tup3dBase c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Point3f a, Point3f b, Point3f c) { this.a.set(a); this.b.set(b); this.c.set(c); }
	public Triangle3f(Triangle3f t) { this.a.set(t.a); this.b.set(t.b); this.c.set(t.c); }
	
	
	public Triangle3f set(Vector3f a, Vector3f b, Vector3f c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Vector3d a, Vector3d b, Vector3d c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Vec3fBase a, Vec3fBase b, Vec3fBase c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Vec3dBase a, Vec3dBase b, Vec3dBase c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Tuple3f a, Tuple3f b, Tuple3f c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Tuple3d a, Tuple3d b, Tuple3d c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Tup3fBase a, Tup3fBase b, Tup3fBase c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Tup3dBase a, Tup3dBase b, Tup3dBase c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Point3f a, Point3f b, Point3f c) { this.a.set(a); this.b.set(b); this.c.set(c); return this; }
	public Triangle3f set(Triangle3f t) { this.a.set(t.a); this.b.set(t.b); this.c.set(t.c); return this; }
	
	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] {this.a, this.b, this.c};
	}

	public Point3f[] getPoints(Matrix4f t)
	{
		Point3f a = t.transformN(this.a);
		Point3f b = t.transformN(this.b);
		Point3f c = t.transformN(this.c);
		
		return new Point3f[] {a, b, c};
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
		Triangle3f tr = transform(t);
		
		Vector3f min = new Vector3f(tr.getMinX(), tr.getMinY(), tr.getMinZ());
		Vector3f max = new Vector3f(tr.getMaxX(), tr.getMaxY(), tr.getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		return new AABB3f(new Point3f(center), halfExtend);
	}
	
	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		Triangle3f tr = transform(t);
		
		Vector3f min = new Vector3f(tr.getMinX(), tr.getMinY(), tr.getMinZ());
		Vector3f max = new Vector3f(tr.getMaxX(), tr.getMaxY(), tr.getMaxZ());
		
		Vector3f halfExtend = max.subN(min).mul(0.5);
		Vector3f center = min.addN(halfExtend);
		
		return new AABB3f(new Point3f(center), halfExtend);
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


	public Triangle3f transform(Matrix4f m)
	{
		Point3f a = m.transformN(this.a);
		Point3f b = m.transformN(this.b);
		Point3f c = m.transformN(this.c);
		
		return new Triangle3f(a, b, c);
	}
	
	public Triangle3f transform(Matrix4f m, Triangle3f t)
	{
		if(t == null) t = new Triangle3f();
		
		Point3f a = m.transformN(this.a);
		Point3f b = m.transformN(this.b);
		Point3f c = m.transformN(this.c);
		
		return t.set(a, b, c);
	}

	public Triangle3f transform(Matrix3f m, Triangle3f t)
	{
		if(t == null) t = new Triangle3f();
		
		Point3f a = new Point3f(Matrix3f.transform(m, this.a.asVector3f(new Vector3f()), null));
		Point3f b = new Point3f(Matrix3f.transform(m, this.b.asVector3f(new Vector3f()), null));
		Point3f c = new Point3f(Matrix3f.transform(m, this.c.asVector3f(new Vector3f()), null));
		
		return t.set(a, b, c);
	}
	


	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}
	
	public boolean containsPointProjection(Point3f p)
	{
		Vector3f u = this.a.vectorTof(this.b, new Vector3f());
		Vector3f v = this.a.vectorTof(this.c, new Vector3f());
		Vector3f n = u.cross(v);
		Vector3f w = this.a.vectorTof(p, new Vector3f());
		
		double gamma = n.dot(u.cross(w)) / n.dot(n);
		double beta = n.dot(w.cross(v)) / n.dot(n);
		double alpha = 1 - gamma - beta;
		
		return 0 <= alpha && alpha <= 1 && 0 <= beta && beta <= 1 && 0 <= gamma && gamma <= 1;
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
