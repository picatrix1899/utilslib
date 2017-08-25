package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public interface ConvexPolygonalShape3f extends Shape3f
{
	Point3f[] getPoints();
	
	
	default float getMaxX()
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : getPoints())
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
		
		for(Point3f p : getPoints())
		{
			if(p.y > max)
			{
				max = p.y;
			}
		}
		
		return max;
	}
	
	
	default float getMaxZ()
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : getPoints())
		{
			if(p.z > max)
			{
				max = p.z;
			}
		}
		
		return max;
	}
	
	default float getMinX()
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : getPoints())
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
		
		for(Point3f p : getPoints())
		{
			if(p.y < min)
			{
				min = p.y;
			}
		}
		
		return min;
	}
	
	default float getMinZ()
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : getPoints())
		{
			if(p.z < min)
			{
				min = p.z;
			}
		}
		
		return min;
	}
	
	static Point3f getFarthestPointInDirection(ConvexPolygonalShape3f s, Vector3f directionToMove)
    {
        
		Point3f[] points = s.getPoints();
		double max = Double.NEGATIVE_INFINITY;
        int index = 0;
        
        for (int i = 0; i < points.length; i++)
        {
            double dot = points[i].asVector3f(Vector3f.TEMP).dot(directionToMove);
            
            if (dot > max)
            {
                max = dot;
                index = i;
            }
        }
        return points[index];
    }
	
	static Point3f getSupportPointInDirection(ConvexPolygonalShape3f a, ConvexPolygonalShape3f b, Vector3f v)
	{
		Point3f p1 = getFarthestPointInDirection(a, v);
		Point3f p2 = getFarthestPointInDirection(b, v.negateN());
		
		return p2.jump(p1.vectorFrom(p2, Vector3f.TEMP.setZero()));
	}
}
