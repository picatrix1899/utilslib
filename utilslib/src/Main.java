
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.geometry.Plane3f;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.vector.Vector2d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Main
{

	public static void main(String[] args)
	{

		Quaternion q1 = new Quaternion();
		Quaternion q2 = new Quaternion();
		Vector3f s;
		
		q1.rotate(Vec3f.aX, 45);
		q2.rotate(Vec3f.aY, 90);
		
		q1 = q2.mulN(q1);
		
		//s = (Vector3f) q1.getForwardf();
		
		//System.out.println(s);
		

		
		//Vector3f s = new Vector3f(0.0f, 3.0f, 0.0f);//.normalize();
		
		//System.out.println(onStraightLine(new Vector3f(0.0f, 0.0f, 1.0f), new Vector3f(2.0f, 1.0f, 1.0f), new Vector3f(2f, 2f, 1f)));
		
		double l1 = 1.0;
		Vector2d p1 = new Vector2d(1.0);
		Vector2d v1 = new Vector2d(1.0);
		double m1 = 2.0;
		Vector2d p2 = new Vector2d(5.0, 1.0);
		Vector2d v2 = new Vector2d(-1.0, 1.0);
		
		
		
		// p1 + l1 * v1
		// p2 + m1 * v2
		
		
		
		
		
		double step1a = ((p2.getX() - p1.getX()) + v2.getX() * m1) / v1.getX();
		double step1b = ((p2.getY() - p1.getY()) + v2.getY() * m1) / v1.getY();
		
		// step1a = step2a
		
		System.out.println(step1a);
		System.out.println(step1b);
		
		
		
		
		
		
		// kehrrechnung
		
		double a = p1.getX() + step1a * v1.getX();
		double b = p2.getX() + m1 * v2.getX();
		
		System.out.println(a);
		System.out.println(a);
		
		
		//double step1b =;
	
		
		//Plane3f e = new Plane3f(new Point3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 1.0f, 0.0f));
		
		//Point3f p = new Point3f(0.0f, 1.0f, -4.0f);
		
		//Vector3f dir = new Vector3f(0.0f, 0.0f, 40.0f);
		
		//System.out.println(onPlane1(e, p));
		//System.out.println(onPlane2(e, p));
		
		//System.out.println(onPlane1(e, p, dir));
		
		
		//Vector3f res = hitPointOnPlane(p, v, e);
		
		//System.out.println(res);
	}
	
	public static boolean onStraightLine(Vec3fBase q, Vec3fBase x, Vec3fBase p)
	{
		Vector3f v = (Vector3f) p.clone();
		v.sub(q);
		v.div(x);
		
		
		System.out.println(v.getX());
		System.out.println(v.getY());
		System.out.println(v.getZ());
		
		return v.getX() == v.getY() && v.getY() == v.getZ();
	}

	public static boolean onPlane1(Plane3f e, Point3f p)
	{
		Vector3f nrm = e.getNormal();
		
		Vector3f off = nrm.mulN(p.asVector3f().subN(e.pointA.asVector3f()));
		
		return off.getX() + off.getY() + off.getZ() == 0.0f || off.getX() + off.getY() + off.getZ() == -0.0f;
	}
	
	public static boolean onPlane2(Plane3f e, Point3f p)
	{
		Vector3f nrm = e.getNormal();
		
		Vector3f a = nrm.mulN(e.pointA.asVector3f());
		Vector3f b = nrm.mulN(p.asVector3f());

		double out = (b.getX() + b.getY() + b.getZ()) - (a.getX() + a.getY() + a.getZ());
		
		return out == 0.0f || out == -0.0f;
	}
	
	public static int onPlane1(Plane3f e, Point3f p, Vector3f dir)
	{
		
		Vector3f nrm = e.getNormal();
		
		Vector3f a = nrm.mulN(e.pointA.asVector3f());
		Vector3f b = nrm.mulN(p.asVector3f().addN(dir));
		
		
		
		
		System.out.println(b.getX() + b.getY() + b.getZ());
		
		System.out.println(a.getX() + a.getY() + a.getZ());
		
		
		
		
		double out = (a.getX() + a.getY() + a.getZ()) / (b.getX() + b.getY() + b.getZ());
		
		System.out.println(out);
		
		Vector3f v = p.asVector3f().addN(dir.mulN(out));
		
		System.out.println(v);
		
		return 0;
	}
	
	public static Vector3f hitPointOnPlane(Point3f p, Vector3f dir, Plane3f e)
	{

		Vector3f nrm = e.getNormal();
		
		Vector3f a = nrm.mulN(e.pointA.asVector3f());
		Vector3f b = nrm.mulN(p.asVector3f().addN(dir));

		double scalar = (a.getX() + a.getY() + a.getZ()) / (b.getX() + b.getY() + b.getZ());
		
		
		
		return p.asVector3f().add(dir.mulN(scalar));
//		
//		Vector3f nrm = plane.getNormal();
//		
//		
//		Vector3f line = p.asVector3f().addN(dir);
//		
//		Vector3f s = nrm.mulN(line);
//		
//		double o = s.getX() + s.getY() + s.getZ() - distToO;
//		
//		System.out.println(o);;
//		
//		return p.asVector3f().addN(dir.mulN(o));
	}
}
