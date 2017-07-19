package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public interface Shape3f
{

	Point3f[] getPoints();
	
	
	static float getMaxX(Shape3f s)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.x > max)
			{
				max = p.x;
			}
		}
		
		return max;
	}
	
	static float getMaxY(Shape3f s)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.y > max)
			{
				max = p.y;
			}
		}
		
		return max;
	}
	
	
	static float getMaxZ(Shape3f s)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.z > max)
			{
				max = p.z;
			}
		}
		
		return max;
	}
	
	static float getMinX(Shape3f s)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.x < min)
			{
				min = p.x;
			}
		}
		
		return min;
	}
	
	static float getMinY(Shape3f s)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.y < min)
			{
				min = p.y;
			}
		}
		
		return min;
	}
	
	static float getMinZ(Shape3f s)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : s.getPoints())
		{
			if(p.z < min)
			{
				min = p.z;
			}
		}
		
		return min;
	}
	
	static AABB3f getAABBf(Shape3f s)
	{
		
		Point3f min = Point3f.alloc(getMinX(s), getMinY(s), getMinZ(s));
		Point3f max = Point3f.alloc(getMaxX(s), getMaxY(s), getMaxZ(s));
		
		return new AABB3f(min, max);		
	}
	
	static Point3f getFarthestPointInDirection(Shape3f s, Vector3f directionToMove)
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
	
	static Point3f getSupportPointInDirection(Shape3f a, Shape3f b, Vector3f v)
	{
		Point3f p1 = getFarthestPointInDirection(a, v);
		Point3f p2 = getFarthestPointInDirection(b, v.negateN());
		
		return p2.jump(p1.vectorFrom(p2, Vector3f.TEMP.setZero()));
	}
}
