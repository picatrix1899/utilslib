package cmn.utilslib.math.geometry;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class Plane3f
{
	private Point3f p = new Point3f();
	private Vector3f x = Vec3f.aX.clone();
	private Vector3f y = Vec3f.aY.clone();
	
	public Plane3f(Point3f p, Vector3f x, Vector3f y)
	{
		this.p.set(p);
		this.x.set(x);
		this.y.set(y);
	}
	
	public Plane3f(Point3f p, Point3f pointB, Point3f pointD)
	{
		setP(p);
		
		setX(p.vectorTo(pointB));
		setY(p.vectorTo(pointD));
	}
	
	public Plane3f(Plane3f e)
	{
		set(e);
	}
	
	public Vector3f getNormal() { return this.x.cross(y); }
	public Point3f getP() { return this.p.clone(); }
	public Vector3f getX() { return this.x.clone(); }
	public Vector3f getY() { return this.y.clone(); }
	
	public Plane3f setP(Point3f p) { this.p.set(p); return this; }
	public Plane3f setP(Vector3f v) { this.p.set(v); return this; }
	public Plane3f setP(float x, float y, float z) { this.p.set(x, y, z); return this; }
	public Plane3f setPX(float x) { this.p.setX(x); return this; }
	public Plane3f setPY(float y) { this.p.setY(y); return this; }
	public Plane3f setPZ(float z) { this.p.setZ(z); return this; }
	
	public Plane3f setX(Vector3f v) { this.x.set(v); return this; }
	public Plane3f setX(float x, float y, float z) { this.x.set(x, y, z); return this; }
	public Plane3f setXX(float x) { this.x.setX(x); return this; }
	public Plane3f setXY(float y) { this.x.setY(y); return this; }
	public Plane3f setXZ(float z) { this.x.setZ(z); return this; }
	
	public Plane3f setY(Vector3f v) { this.y.set(v); return this; }
	public Plane3f setY(float x, float y, float z) { this.y.set(x, y, z); return this; }
	public Plane3f setYX(float x) { this.y.setX(x); return this; }
	public Plane3f setYY(float y) { this.y.setY(y); return this; }
	public Plane3f setYZ(float z) { this.y.setZ(z); return this; }
	
	public Plane3f set(Plane3f e) { return setP(e.p).setX(e.x).setY(e.y); }
	public Plane3f set(Point3f p, Vector3f x, Vector3f y) { return setP(p).setX(x).setY(y); }
	public Plane3f set(Point3f p, Point3f pointB, Point3f pointD) { return setP(p).setX(p.vectorTo(pointB)).setY(p.vectorTo(pointD)); }
	
	public boolean liesPointOnPlane(Point3f p)
	{
		Vector3f off = getNormal().mul(p.sub(this.p));
		
		float sum = off.getX() + off.getY() + off.getZ();
		
		return sum == 0.0f || sum == -0.0f;
	}
	
	
	public Point3f intersectPointWithPlane(StraightLine3f g)
	{
		if(g.v.length() == 0.0f) return null;
		if(this.x.length() == 0.0f) return null;
		if(this.y.length() == 0.0f) return null;
		
		// if the angle alpha between the normal and the direction is nearly perfect 90° or -90° there are only two possible situations
		// 1. the straight line does not intersect the plane
		// 2. the straight line lies on the plane and intersects n times
		double angle = g.v.angleDeg(getNormal());
					
		if(Maths.equalsDPN(angle, 90.0d, 0.000000000001d) || Maths.equalsDPN(angle, -90.0d, 0.000000000001d)) return null;
		
		Point3f p1 = g.p;
		Point3f p2 = this.p;
		Vector3f n = getNormal();
		Vector3f v = g.v;
		
		double lambda = (n.getX() * (p2.getX() -p1.getX()) + n.getY() * (p2.getY() - p1.getY()) + n.getZ() *(p2.getZ() - p1.getZ()))/(v.getX() * n.getX() + v.getY() * n.getY() + v.getZ() * n.getZ());
		
		return g.p.jumpN(g.v.mulN(lambda));
	}
	
	public Point3f intersectPointWithPlane(LineSegment3f h)
	{
		if(h.v.length() == 0.0f) return null;
		if(this.x.length() == 0.0f) return null;
		if(this.y.length() == 0.0f) return null;
		
		// if the angle alpha between the normal and the direction is nearly perfect 90° or -90° there are only two possible situations
		// 1. the straight line does not intersect the plane
		// 2. the straight line lies on the plane and intersects n times
		double angle = h.v.angleDeg(getNormal());
					
		if(Maths.equalsDPN(angle, 90.0d, 0.000000000001d) || Maths.equalsDPN(angle, -90.0d, 0.000000000001d)) return null;
		
		Point3f p1 = h.p;
		Point3f p2 = this.p;
		Vector3f n = getNormal();
		Vector3f v = h.v;
		
		double lambda = (n.getX() * (p2.getX() -p1.getX()) + n.getY() * (p2.getY() - p1.getY()) + n.getZ() *(p2.getZ() - p1.getZ()))/(v.getX() * n.getX() + v.getY() * n.getY() + v.getZ() * n.getZ());
		
		if(lambda < 0.0d) return null;

		return h.p.jumpN(h.v.mulN(lambda));
	}
	
	public Point3f intersectPointWithPlane(Line3f s)
	{
		Vector3f v = s.p1.vectorTo(s.p2);
		
		if(v.length() == 0.0f) return null;
		if(this.x.length() == 0.0f) return null;
		if(this.y.length() == 0.0f) return null;
		
		// if the angle alpha between the normal and the direction is nearly perfect 90° or -90° there are only two possible situations
		// 1. the straight line does not intersect the plane
		// 2. the straight line lies on the plane and intersects n times
		double angle = v.angleDeg(getNormal());
					
		if(Maths.equalsDPN(angle, 90.0d, 0.000000000001d) || Maths.equalsDPN(angle, -90.0d, 0.000000000001d)) return null;
		
		Point3f p1 = s.p1;
		Point3f p2 = this.p;
		Vector3f n = getNormal();
		
		double lambda = (n.getX() * (p2.getX() -p1.getX()) + n.getY() * (p2.getY() - p1.getY()) + n.getZ() *(p2.getZ() - p1.getZ()))/(v.getX() * n.getX() + v.getY() * n.getY() + v.getZ() * n.getZ());
		
		if(lambda < 0.0d) return null;
		
		Vector3f p1p2 = s.p2.sub(s.p1);
		
		if(lambda > p1p2.length()) return null;

		return s.p1.jumpN(v.mulN(lambda));
	}
}
