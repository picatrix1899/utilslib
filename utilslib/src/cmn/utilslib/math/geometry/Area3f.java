package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class Area3f
{
	public Point3f p1; // top-left
	public Point3f p2; // bottom-left
	public Point3f p3; // bottom-right
	public Point3f p4; // top-right
	
	public Area3f(Point3f p1, Point3f p2, Point3f p3, Point3f p4)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public Plane3f asPlane()
	{
		return new Plane3f(this.p2, this.p3.asVector3f().subN(this.p2.asVector3f()).normalize() , this.p1.asVector3f().subN(this.p2.asVector3f()).normalize());
	}

	
	
	public Point3f intersectPointWithPlane(StraightLine3f g)
	{
		Point3f p = asPlane().intersectPointWithPlane(g);
		
		if(p == null) return null;
		
		Vector3f vp = asPlane().intersectPointWithPlane(g).asVector3f();
	
		Vector3f p2vp = vp.subN(p2.asVector3f());
		
		// calculate border line functions
		Vector3f minXLine = p3.asVector3f().subN(p2.asVector3f());
		minXLine = minXLine.div(minXLine.getX());
		Vector3f maxXLine = p4.asVector3f().subN(p1.asVector3f());
		maxXLine = maxXLine.div(maxXLine.getX());
		
		Vector3f minYLine = p1.asVector3f().subN(p2.asVector3f());
		minYLine = minYLine.div(minYLine.getY());
		Vector3f maxYLine = p4.asVector3f().subN(p3.asVector3f());
		maxYLine = maxYLine.div(maxYLine.getY());
		
		Vector3f minPosX = p2.asVector3f().addN(minXLine.mulN(p2vp.getX()));
		Vector3f maxPosX = p1.asVector3f().addN(maxXLine.mulN(p2vp.getX()));
		Vector3f minPosY = p2.asVector3f().addN(minYLine.mulN(p2vp.getY()));
		Vector3f maxPosY = p3.asVector3f().addN(maxYLine.mulN(p2vp.getY()));
		
		if(p2vp.getY() < minPosX.getY() || p2vp.getZ() < minPosX.getZ()) return null;
		
		if(p2vp.getX() < minPosY.getX() || p2vp.getZ() < minPosY.getZ()) return null;
		
		if(p2vp.getY() > maxPosX.getY() || p2vp.getZ() > maxPosX.getZ()) return null;
		
		if(p2vp.getX() > maxPosY.getX() || p2vp.getZ() > maxPosY.getZ()) return null;
		
		return asPlane().intersectPointWithPlane(g);
	}
	
	public Point3f intersectPointWithPlane(LineSegment3f g)
	{
		Point3f p = asPlane().intersectPointWithPlane(g);
		
		if(p == null) return null;
		
		Vector3f vp = asPlane().intersectPointWithPlane(g).asVector3f();
	
		Vector3f p2vp = vp.subN(p2.asVector3f());
		
		// calculate border line functions
		Vector3f minXLine = p3.asVector3f().subN(p2.asVector3f());
		minXLine = minXLine.div(minXLine.getX());
		Vector3f maxXLine = p4.asVector3f().subN(p1.asVector3f());
		maxXLine = maxXLine.div(maxXLine.getX());
		
		Vector3f minYLine = p1.asVector3f().subN(p2.asVector3f());
		minYLine = minYLine.div(minYLine.getY());
		Vector3f maxYLine = p4.asVector3f().subN(p3.asVector3f());
		maxYLine = maxYLine.div(maxYLine.getY());
		
		Vector3f minPosX = p2.asVector3f().addN(minXLine.mulN(p2vp.getX()));
		Vector3f maxPosX = p1.asVector3f().addN(maxXLine.mulN(p2vp.getX()));
		Vector3f minPosY = p2.asVector3f().addN(minYLine.mulN(p2vp.getY()));
		Vector3f maxPosY = p3.asVector3f().addN(maxYLine.mulN(p2vp.getY()));
		
		if(p2vp.getY() < minPosX.getY() || p2vp.getZ() < minPosX.getZ()) return null;
		
		if(p2vp.getX() < minPosY.getX() || p2vp.getZ() < minPosY.getZ()) return null;
		
		if(p2vp.getY() > maxPosX.getY() || p2vp.getZ() > maxPosX.getZ()) return null;
		
		if(p2vp.getX() > maxPosY.getX() || p2vp.getZ() > maxPosY.getZ()) return null;
		
		return asPlane().intersectPointWithPlane(g);
	}
}
