package cmn.utilslib.math.geometry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Cubef implements Shape3f
{
	public Point3f center = new Point3f();
	
	public float halfExtend = 1;

	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
	} 
}
