package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector2f;

public interface ConvexPolygonalShape2f extends Shape2f
{
	Point2f[] getPoints();
	
	default float getMaxX()
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point2f p : getPoints())
		{
			if(p.x > max)
			{
				max = p.x;
			}
		}
		
		return max;
	}
	
	default float getMaxY()
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point2f p : getPoints())
		{
			if(p.y > max)
			{
				max = p.y;
			}
		}
		
		return max;
	}

	
	default float getMinX()
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point2f p : getPoints())
		{
			if(p.x < min)
			{
				min = p.x;
			}
		}
		
		return min;
	}
	
	default float getMinY()
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point2f p : getPoints())
		{
			if(p.y < min)
			{
				min = p.y;
			}
		}
		
		return min;
	}

	static Point2f getFarthestPointInDirection(ConvexPolygonalShape2f s, Vector2f directionToMove)
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
	
	static Point2f getSupportPointInDirection(ConvexPolygonalShape2f a, ConvexPolygonalShape2f b, Vector2f v)
	{
		Point2f p1 = getFarthestPointInDirection(a, v);
		Point2f p2 = getFarthestPointInDirection(b, v.negateN());
		
		return p2.jump(p1.vectorFromf(p2));
	}
}
