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
		
		Matrix4f m1 = Matrix4f.rotation(Quaternion.getFromAxis(Vector3f.aY, 45));
		
		Matrix3f model1 = Matrix3f.identity();
		
		model1.m0.set(m1.transformN(Vector3f.aX));
		model1.m1.set(m1.transformN(Vector3f.aY));
		model1.m2.set(m1.transformN(Vector3f.aZ));

		Vector3f v1 = m1.transform(v);
		
		System.out.println(v1);
		
		Matrix4f m2 = Matrix4f.rotation(Quaternion.getFromAxis(Vector3f.aY, 45));
		
		Matrix3f model2 = Matrix3f.identity();
		
		model2.m0.set(m2.transformN(Vector3f.aX));
		model2.m1.set(m2.transformN(Vector3f.aY));
		model2.m2.set(m2.transformN(Vector3f.aZ));
		
		Vector3f v2 = m2.transform(v1);
		
		System.out.println(v2);
		
		Vector3f v3 = m2.transform(v);
		
		System.out.println(v3);
	}
	
}
