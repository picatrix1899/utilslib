package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rectangle2f implements Shape2f
{

	public Point2f center = new Point2f();
	public Vector2f halfExtend = new Vector2f(); 
	
	public Rectangle2f(Point2f min, Point2f max)
	{
		
	}

	public Rectangle2f(Point2f center, Vector2f halfExtend)
	{
		
	}
	
	@Override
	public Point2f[] getPoints()
	{
		throw new NotImplementedException();
	}

}
