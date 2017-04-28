import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.api.IVec3f;

public class Main
{

	public static void main(String[] args)
	{
		
		IVec3f v1 = new Vec3f(0.0f, 1.0f, 0.0f);
		IVec3f v2 = new Vec3f(10.0f, 0.0f, 0.0f);
		
		IVec3f v3 = v1.slerp(v2, 0.5f);
		
		System.out.println(v3);
		
		
		//HDRColor3Examples.Test5();
	}

}
