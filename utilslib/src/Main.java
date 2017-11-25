import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.geometry.CollisionResolver;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.Vector3f;

public class Main
{
	public static void main(String[] args)
	{
		
		Vector3f v = new Vector3f(20,20,20);
		Vector3f a = new Vector3f(0.5,0,0).normalizeN();
		
		double dot = v.dot(a);
		
		System.out.println(dot);
	}
	
}
