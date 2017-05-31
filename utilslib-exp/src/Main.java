import cmn.utilslib.exp.vector.PVec3f;
import cmn.utilslib.exp.vector.api.Vector3f;
import cmn.utilslib.exp.vector.api.Vector3fBaseE;
import cmn.utilslib.exp.vector.api.Vector3fE;
import cmn.utilslib.exp.vector.Vec3f;

public class Main
{

	public static void main(String[] args)
	{
		PVec3f pv = PVec3f.gen(0.0f, 1.0f, 2.0f);
		
		Vec3f v = pv.addN(4.0f);
		
		Vector3fE<?> v2 = v;
		
		v2.add(1);
		
		print(v);
		print(pv);
	}

	public static void print(Vector3fBaseE<?> v)
	{
		System.out.println(v.getX() + ", " + v.getY() + ", " + v.getZ());
	}
}
