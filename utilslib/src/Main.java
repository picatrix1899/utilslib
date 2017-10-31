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
		
		Vector3f v = new Vector3f(10, 0, 90);
		
		Matrix4f m1 = Matrix4f.rotation(Quaternion.getFromAxis(Vector3f.aY, 40));
		Matrix4f m2 = Matrix4f.rotation(Quaternion.getFromAxis(Vector3f.aY, 50));
		
		Matrix4f m = Matrix4f.mul(m1, m2, new Matrix4f());
		
		m.transform(v);
		
		System.out.println(v);
	}
	
}
