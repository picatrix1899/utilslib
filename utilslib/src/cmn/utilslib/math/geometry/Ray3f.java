package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public class Ray3f
{
	public Point3f p;
	public Vector3f v;
	
	public Ray3f(Point3f p, Vector3f v)
	{
		this.p = p;
		this.v = v;
	}
	
	public boolean liesPointOnRay(Point3f p)
	{
		Vector3f vx = p.asVector3f(Vector3f.TEMP0);
		Vector3f vv = this.v;
		Vector3f vp = this.p.asVector3f(Vector3f.TEMP1);
		
		Vector3f lambda = vx.subN(vp).div(vv);
		
		return lambda.getX() == lambda.getY() && lambda.getY() == lambda.getZ();
	}
}
