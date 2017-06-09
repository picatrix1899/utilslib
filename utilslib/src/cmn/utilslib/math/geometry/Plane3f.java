package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class Plane3f
{
	public Point3f pointA;
	public Vector3f s;
	public Vector3f v;
	
	public Plane3f(Point3f pointA, Vector3f s, Vector3f v)
	{
		this.pointA = pointA;
		this.s = s;
		this.v = v;
	}
	
	public Plane3f(Point3f pointA, Point3f pointB, Point3f pointD)
	{
		this.pointA = pointA;
		this.s = pointB.asVector3f().subN(pointA.asVector3f());
		this.v = pointD.asVector3f().subN(pointB.asVector3f());
	}
	
	public Vector3f getNormal()
	{
		return this.s.cross(v);
	}
}
