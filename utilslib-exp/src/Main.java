import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.Vector3fUtils;

public class Main
{

	public static void main(String[] args)
	{
		Vector3f a = new Vector3f();
		
		Vector3f b = Vector3fUtils.add(a, 1, 1, 1, a);
	}

	static class A
	{
		public int a;
	}
	
	static class B
	{
		public A a;
	}
}
