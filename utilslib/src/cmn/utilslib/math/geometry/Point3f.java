package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class Point3f
{
	private Vector3f point = Vec3f.ZERO.clone();
	
	public Point3f(Vector3f p)
	{
		this.point = p;
	}
	
	public Point3f(float x, float y, float z)
	{
		this.point = new Vector3f(x, y, z);
	}
	
	public Point3f set(Vector3f v)
	{
		this.point = v; return this;
	}
	
	public Vector3f asVector3f()
	{
	 	return this.point;
	}
}
