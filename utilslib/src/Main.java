
import cmn.utilslib.math.Quaternion;
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
		
		s = (Vector3f) q1.getForwardf();
		
		System.out.println(s);
		

		
		//Vector3f s = new Vector3f(0.0f, 3.0f, 0.0f);//.normalize();
		
		System.out.println(onStraightLine(new Vector3f(0.0f, 0.0f, 1.0f), new Vector3f(2.0f, 1.0f, 1.0f), new Vector3f(2f, 2f, 1f)));
		
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
	
	public static boolean onLineSegment(Vec3fBase q, Vec3fBase x, Vector3f p)
	{
		
		
		return false;
	}
}
