package cmn.utilslib.math.geometry;

public class Line3f
{
	public Point3f p1 = new Point3f();
	public Point3f p2 = new Point3f();
	
	public Line3f(Point3f p1, Point3f p2)
	{
		this.p1.set(p1);
		this.p2.set(p2);
	}
}
