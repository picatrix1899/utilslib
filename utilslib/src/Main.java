
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector3f;
import cmn.utilslib.vector.api.Vec3f;
import cmn.utilslib.vector.api.Vec3fBase;

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
		
		System.out.println(onLine(Vec3f.ZERO, Vec3f.ONE, new Vector3f(2,2,1)));
		
	}
	
	public static boolean onLine(Vec3fBase q, Vec3fBase x, Vec3fBase p)
	{
		Vector3f v = (Vector3f) p.clone();
		v.sub(q);
		v.div(x);
		
		return v.getX() == v.getY() && v.getY() == v.getZ();
	}
	
}
