
import cmn.utilslib.math.geometry.Area3f;
import cmn.utilslib.math.geometry.Plane3f;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.geometry.StraightLine3f;
import cmn.utilslib.math.vector.Vector3f;

public class Main
{

	public static void main(String[] args)
	{
		
		Area3f a = new Area3f(new Point3f(0,6,0), new Point3f(0,0,0), new Point3f(9,0,0), new Point3f(6,6,0));
		
		Plane3f e = new Plane3f(new Point3f(0,0,0), new Vector3f(1,0,0), new Vector3f(0,1,0));
		StraightLine3f g = new StraightLine3f(new Point3f(4,4,-4), new Vector3f(0.5f,0.5f,1));
	}
}
