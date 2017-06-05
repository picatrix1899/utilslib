
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector3f;
import cmn.utilslib.vector.api.Vec3f;

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
		
		
		
	}
	
}
