
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

public class Main
{

	public static void main(String[] args)
	{
		
		Vector3f v = new Vector3f(2,4,8);
		

		Matrix4f t = Matrix4f.translation(1,1,0);
		Matrix4f s = Matrix4f.scaling(new Vector3f(0.5));
		Matrix4f r = Matrix4f.rotation(Quaternion.getFromAxis(Vector3f.aY, 90));
		
		System.out.println(v);
		
		//Matrix4f.transform(r, v, v); // r * v (8, 4, -2)
		
		Matrix4f ts = Matrix4f.mul(t, s, new Matrix4f());
		
		Matrix4f model = Matrix4f.mul(r, ts, new Matrix4f());
		
		//Matrix4f.transform(ts, v, v); // ts * v (2, 3, 4) -> (4, 3, -2)
		
		//Matrix4f.transform(r, v, v);
		
		Matrix4f.transform(model,  v, v);
		
		System.out.println(v);
		
	}
	
}
