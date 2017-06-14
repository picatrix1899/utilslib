package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class Point3f
{
	private Vector3f point = Vec3f.ZERO.clone();
	
	public Point3f() { }
	public Point3f(Vector3f v) { this.point.set(v); }
	public Point3f(Point3f p) { this.point.set(p.point); }
	public Point3f(float x, float y, float z) { this.point.set(x, y, z); }
	
	public Vector3f asVector3f() { return this.point.clone(); }
	
	public Point3f clone() { return new Point3f(this); }
	
	public float getX() { return this.point.getX(); }
	public float getY() { return this.point.getY(); }
	public float getZ() { return this.point.getZ(); }
	
	public Point3f setX(float x) { this.point.setX(x); return this; }
	public Point3f setY(float y) { this.point.setY(y); return this; }
	public Point3f setZ(float z) { this.point.setZ(z); return this; }
	
	public Point3f set(Vector3f v) { this.point.set(v); return this; }
	public Point3f set(Point3f p) { this.point.set(p.point); return this; }
	public Point3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	public Vector3f add(Point3f p) { return asVector3f().add(p.asVector3f()); }
	public Vector3f add(Vector3f v) { return asVector3f().add(v); }
	public Vector3f add(float x, float y, float z) { return asVector3f().add(x, y, z); }
	public Vector3f add(float scalar) { return asVector3f().add(scalar); }
	
	public Vector3f sub(Point3f p) { return asVector3f().sub(p.asVector3f()); }
	public Vector3f sub(Vector3f v) { return asVector3f().sub(v); }
	public Vector3f sub(float x, float y, float z) { return asVector3f().sub(x, y, z); }
	public Vector3f sub(float scalar) { return asVector3f().sub(scalar); }
	
	public Vector3f mul(Point3f p) { return asVector3f().mul(p.asVector3f()); }
	public Vector3f mul(Vector3f v) { return asVector3f().mul(v); }
	public Vector3f mul(float x, float y, float z) { return asVector3f().mul(x, y, z); }
	public Vector3f mul(float scalar) { return asVector3f().mul(scalar); }
	
	public Vector3f div(Point3f p) { return asVector3f().div(p.asVector3f()); }
	public Vector3f div(Vector3f v) { return asVector3f().div(v); }
	public Vector3f div(float x, float y, float z) { return asVector3f().div(x, y, z); }
	public Vector3f div(float scalar) { return asVector3f().div(scalar); }
	
	public Vector3f vectorTo(Point3f p) { return p.asVector3f().sub(asVector3f()); }
	public Vector3f vectorFrom(Point3f p) { return asVector3f().sub(p.asVector3f()); }
	
	public Point3f jump(Vector3f v) { return set(asVector3f().add(v)); }
	public Point3f jumpN(Vector3f v) { return clone().jump(v); }
	
	public String toString() { return String.format("point3f({0},{1},{2})", getX(), getY(), getZ()); }
}
