package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public class MinkowskiSum2f implements ConvexPolygonalShape2f
{
	private Point2f[] points;
	
	public MinkowskiSum2f(ConvexPolygonalShape2f a, ConvexPolygonalShape2f b)
	{
		this(a, b, false);
	}
	
	public MinkowskiSum2f(ConvexPolygonalShape2f a, ConvexPolygonalShape2f b, boolean difference)
	{
		
		ArrayList<Point2f> sumPoints = Auto.ArrayList();
		
		if(difference)
		{
			for(Point2f as : a.getPoints())
			{
				sumPoints.addAll(calculatePointDifference(as, b));
			}
		}
		else
		{
			for(Point2f as : a.getPoints())
			{
				sumPoints.addAll(calculatePointSum(as, b));
			}
		}
		
		ArrayList<Point2f> filtered = Auto.ArrayList();
		
		for(Point2f v : sumPoints)
		{
			if(!filtered.contains(v))
				filtered.add(v);
		}
		
		this.points = (Point2f[]) filtered.toArray();
	}
	
	public Point2f[] getPoints()
	{
		return this.points;
	}
	
	public List<Point2f> getPointList()
	{
		return Auto.ArrayList(this.points);
	}
	
	private List<Point2f> calculatePointSum(Point2f a, ConvexPolygonalShape2f b)
	{
		ArrayList<Point2f> out = Auto.ArrayList();
		
		Point2f next;
		
		for(Point2f bs : b.getPoints())
		{
			next = a.addN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
	
	private List<Point2f> calculatePointDifference(Point2f a, ConvexPolygonalShape2f b)
	{
		ArrayList<Point2f> out = Auto.ArrayList();
		
		Point2f next;
		
		for(Point2f bs : b.getPoints())
		{
			next = a.subN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}

	public AABB2f getAABB()
	{
		Point2f min = Point2f.TEMP0.set(getMinX(), getMinY());
		Point2f max = Point2f.TEMP0.set(getMaxX(), getMaxY());
		
		return new AABB2f(min, max);
	}
}
