package cmn.utilslib.math.geometry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Line3f implements Shape3f
{
	public Point3f p1 = new Point3f();
	public Point3f p2 = new Point3f();
	
	public Line3f(Point3f p1, Point3f p2)
	{
		this.p1.set(p1);
		this.p2.set(p2);
	}

	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
	}
}
