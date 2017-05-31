import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector3f;
import cmn.utilslib.vector.api.Vec3f;

public class Main
{

	public static void main(String[] args)
	{
		Vector3f v = new Vector3f(0.0f, 4.0f, 0.0f);
		
		System.out.println(v.normalize());
	}
	
}
