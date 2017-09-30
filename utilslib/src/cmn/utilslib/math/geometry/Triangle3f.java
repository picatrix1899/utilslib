package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3f;

public class Triangle3f implements ConvexPolygonalShape3f
{
	public Point3f a = new Point3f();
	public Point3f b = new Point3f();
	public Point3f c = new Point3f();
	
	public Triangle3f() { }
	
	public Triangle3f(Tup3fBase a, Tup3fBase b, Tup3fBase c)
	{
		this.a.set(a);
		this.b.set(b);
		this.c.set(c);
	}
	
	public Triangle3f(Triangle3f t)
	{
		this.a.set(t.a);
		this.b.set(t.b);
		this.c.set(t.c);
	}
	
	public Triangle3f set(Triangle3f t)
	{
		this.a.set(t.a);
		this.b.set(t.b);
		this.c.set(t.c);
		
		return this;
	}
	
	public Triangle3f set(Tup3fBase a, Tup3fBase b, Tup3fBase c)
	{
		this.a.set(a);
		this.b.set(b);
		this.c.set(c);
		
		return this;
	}
	
	public Triangle3f set(Point3f a, Point3f b, Point3f c)
	{
		this.a.set(a);
		this.b.set(b);
		this.c.set(c);
		
		return this;
	}
	
	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] {this.a, this.b, this.c};
	}

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		Triangle3f tr = transform(t, new Triangle3f());
		
		AABB3f out = tr.getAABBf(aabb);
		
		return out;
	}

	public OBB3f getOBBf(Matrix4f t)
	{
		Point3f min = new Point3f(getMinX(), getMinY(), getMinZ());
		Point3f max = new Point3f(getMaxX(), getMaxY(), getMaxZ());
		
		Matrix4f.transform(t, min, min);
		Matrix4f.transform(t, max, max);
		
		return new OBB3f(min, max, Matrix4f.identity());
	}

	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}

	public Point3f[] getPoints(Matrix4f t)
	{
		Point3f a = Matrix4f.transform(t, this.a, new Point3f());
		Point3f b = Matrix4f.transform(t, this.b, new Point3f());
		Point3f c = Matrix4f.transform(t, this.c, new Point3f());
		
		return new Point3f[] {a, b, c};
	}

	public Triangle3f transform(Matrix4f m, Triangle3f t)
	{
		if(t == null) t = new Triangle3f();
		
		Point3f a = Matrix4f.transform(m, this.a, new Point3f());
		Point3f b = Matrix4f.transform(m, this.b, new Point3f());
		Point3f c = Matrix4f.transform(m, this.c, new Point3f());
		
		return t.set(a, b, c);
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
	
	public boolean containsPointProjection(Point3f p)
	{
		Vector3f u = this.a.vectorTo(this.b, new Vector3f());
		Vector3f v = this.a.vectorTo(this.c, new Vector3f());
		Vector3f n = u.cross(v);
		Vector3f w = this.a.vectorTo(p, new Vector3f());
		
		double gamma = n.dot(u.cross(w)) / n.dot(n);
		double beta = n.dot(w.cross(v)) / n.dot(n);
		double alpha = 1 - gamma - beta;
		
		return 0 <= alpha && alpha <= 1 && 0 <= beta && beta <= 1 && 0 <= gamma && gamma <= 1;
	}
}
