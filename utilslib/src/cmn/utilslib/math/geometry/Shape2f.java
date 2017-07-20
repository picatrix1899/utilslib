package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;

public interface Shape2f
{

	Point2f[] getPoints();
	
	
	static float getMaxX(Shape2f s)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point2f p : s.getPoints())
		{
			if(p.x > max)
			{
				max = p.x;
			}
		}
		
		return max;
	}
	
	static float getMaxY(Shape2f s)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point2f p : s.getPoints())
		{
			if(p.y > max)
			{
				max = p.y;
			}
		}
		
		return max;
	}

	
	static float getMinX(Shape2f s)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point2f p : s.getPoints())
		{
			if(p.x < min)
			{
				min = p.x;
			}
		}
		
		return min;
	}
	
	static float getMinY(Shape2f s)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point2f p : s.getPoints())
		{
			if(p.y < min)
			{
				min = p.y;
			}
		}
		
		return min;
	}
	
	static AABB2f getAABB(Shape2f s)
	{
		
		Point2f min = Point2f.alloc(getMinX(s), getMinY(s));
		Point2f max = Point2f.alloc(getMaxX(s), getMaxY(s));
		
		return new AABB2f(min, max);		
	}
	
	static Point2f getFarthestPointInDirection(Shape2f s, Vector2f directionToMove)
    {
        
		Point2f[] points = s.getPoints();
		double max = Double.NEGATIVE_INFINITY;
        int index = 0;
        
        for (int i = 0; i < points.length; i++)
        {
            double dot = points[i].asVector2f(Vector2f.TEMP).dot(directionToMove);
            
            if (dot > max)
            {
                max = dot;
                index = i;
            }
        }
        return points[index];
    }
	
	static Point2f getSupportPointInDirection(Shape2f a, Shape2f b, Vector2f v)
	{
		Point2f p1 = getFarthestPointInDirection(a, v);
		Point2f p2 = getFarthestPointInDirection(b, v.negateN());
		
		return p2.jump(p1.vectorFrom(p2, Vector2f.TEMP));
	}
}
