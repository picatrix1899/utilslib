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
		return new Plane3f(this.p2, this.p2.directionTo(this.p3, Vector3f.TEMP0) , this.p2.directionTo(p1, Vector3f.TEMP1));
	}

	
	
	public Point3f intersectPointWithPlane(Ray3f g)
	{
		Point3f p = asPlane().intersectPointWithPlane(g);
		
		if(p == null) return null;
		
		Vector3f vp = p.asVector3f(Vector3f.TEMP0);
	
		Vector3f p2vp = vp.sub(p2.asVector3f(Vector3f.TEMP));
		
		// calculate border line functions
		Vector3f minXLine = p2.vectorTo(p3, Vector3f.TEMP1);
		minXLine = minXLine.div(minXLine.getX());
		Vector3f maxXLine = p1.vectorTo(p4, Vector3f.TEMP2);
		maxXLine = maxXLine.div(maxXLine.getX());
		
		Vector3f minYLine = p2.vectorTo(p1, Vector3f.TEMP3);
		minYLine = minYLine.div(minYLine.getY());
		Vector3f maxYLine = p3.vectorTo(p4, Vector3f.TEMP4);
		maxYLine = maxYLine.div(maxYLine.getY());
		
		Vector3f minPosX = p2.asVector3f(Vector3f.TEMP1).add(minXLine.mul(p2vp.getX()));
		Vector3f maxPosX = p1.asVector3f(Vector3f.TEMP2).add(maxXLine.mul(p2vp.getX()));
		Vector3f minPosY = p2.asVector3f(Vector3f.TEMP3).add(minYLine.mul(p2vp.getY()));
		Vector3f maxPosY = p3.asVector3f(Vector3f.TEMP4).add(maxYLine.mul(p2vp.getY()));
		
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
		
		Vector3f vp = p.asVector3f(Vector3f.TEMP0);
	
		Vector3f p2vp = vp.sub(p2.asVector3f(Vector3f.TEMP));
		
		// calculate border line functions
		Vector3f minXLine = p2.vectorTo(p3, Vector3f.TEMP1);
		minXLine = minXLine.div(minXLine.getX());
		Vector3f maxXLine = p1.vectorTo(p4, Vector3f.TEMP2);
		maxXLine = maxXLine.div(maxXLine.getX());
		
		Vector3f minYLine = p2.vectorTo(p1, Vector3f.TEMP3);
		minYLine = minYLine.div(minYLine.getY());
		Vector3f maxYLine = p3.vectorTo(p4, Vector3f.TEMP4);
		maxYLine = maxYLine.div(maxYLine.getY());
		
		Vector3f minPosX = p2.asVector3f(Vector3f.TEMP1).add(minXLine.mul(p2vp.getX()));
		Vector3f maxPosX = p1.asVector3f(Vector3f.TEMP2).add(maxXLine.mul(p2vp.getX()));
		Vector3f minPosY = p2.asVector3f(Vector3f.TEMP3).add(minYLine.mul(p2vp.getY()));
		Vector3f maxPosY = p3.asVector3f(Vector3f.TEMP4).add(maxYLine.mul(p2vp.getY()));
		
		if(p2vp.getY() < minPosX.getY() || p2vp.getZ() < minPosX.getZ()) return null;
		
		if(p2vp.getX() < minPosY.getX() || p2vp.getZ() < minPosY.getZ()) return null;
		
		if(p2vp.getY() > maxPosX.getY() || p2vp.getZ() > maxPosX.getZ()) return null;
		
		if(p2vp.getX() > maxPosY.getX() || p2vp.getZ() > maxPosY.getZ()) return null;
		
		return p;
	}
}
