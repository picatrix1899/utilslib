import cmn.utilslib.exp.vector.PVec3f;
import cmn.utilslib.exp.vector.TestVec;
import cmn.utilslib.exp.vector.api.Vector3fBaseE;
import cmn.utilslib.exp.vector.Vec3f;

public class Main
{

	public static void main(String[] args)
	{
		PVec3f pv = PVec3f.gen(0.0f, 1.0f, 2.0f);
		
		Vec3f v = pv.addN(4.0f);
		
		TestVec v1 = new TestVec();
		v1.set(0.0f, 1.0f, 2.0f);
		v1.add(30.0f);
		
		print(v);
		print(pv);
		print(v1);
	}

	public static void print(Vector3fBaseE<?> v)
	{
		System.out.println(v.getX() + ", " + v.getY() + ", " + v.getZ());
	}
}
