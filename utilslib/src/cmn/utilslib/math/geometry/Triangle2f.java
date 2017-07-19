package cmn.utilslib.math.geometry;

public class Triangle2f implements Shape2f
{
	public Point2f a = new Point2f();
	public Point2f b = new Point2f();
	public Point2f c = new Point2f();
	
	@Override
	public Point2f[] getPoints()
	{
		return new Point2f[] {this.a, this.b, this.c};
	}
}
