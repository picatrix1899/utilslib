package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public interface ConvexPolygonalShape3f extends Shape3f
{
	Point3f[] getPoints();
	
	Point3f[] getPoints(Matrix4f t);
	
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
	
	default float getMaxX(Matrix4f t)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : getPoints(t))
		{
			if(p.x > max)
			{
				max = p.x;
			}
		}
		
		return max;
	}
	
	default Point3f getMaxXPoint()
	{
		Point3f point = new Point3f(Float.NEGATIVE_INFINITY, 0, 0);
		
		for(Point3f p : getPoints())
		{
			if(p.x > point.x)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMaxXPoint(Matrix4f t)
	{
		Point3f point = new Point3f(Float.NEGATIVE_INFINITY, 0, 0);
		
		for(Point3f p : getPoints(t))
		{
			if(p.x > point.x)
			{
				point = p;
			}
		}
			
		return point;
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
	
	default float getMaxY(Matrix4f t)
	{
		float max = Float.NEGATIVE_INFINITY;
		
		for(Point3f p : getPoints(t))
		{
			if(p.y > max)
			{
				max = p.y;
			}
		}
		
		return max;
	}
	
	default Point3f getMaxYPoint()
	{
		Point3f point = new Point3f(0, Float.NEGATIVE_INFINITY, 0);
		
		for(Point3f p : getPoints())
		{
			if(p.y > point.y)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMaxYPoint(Matrix4f t)
	{
		Point3f point = new Point3f(0, Float.NEGATIVE_INFINITY, 0);
		
		for(Point3f p : getPoints(t))
		{
			if(p.y > point.y)
			{
				point = p;
			}
		}
			
		return point;
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
	
	default float getMaxZ(Matrix4f t)
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
	
	default Point3f getMaxZPoint()
	{
		Point3f point = new Point3f(0, 0, Float.NEGATIVE_INFINITY);
		
		for(Point3f p : getPoints())
		{
			if(p.z > point.z)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMaxZPoint(Matrix4f t)
	{
		Point3f point = new Point3f(0, 0, Float.NEGATIVE_INFINITY);
		
		for(Point3f p : getPoints(t))
		{
			if(p.z > point.z)
			{
				point = p;
			}
		}
			
		return point;
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
	
	default float getMinX(Matrix4f t)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : getPoints(t))
		{
			if(p.x < min)
			{
				min = p.x;
			}
		}
		
		return min;
	}
	
	default Point3f getMinXPoint()
	{
		Point3f point = new Point3f(Float.POSITIVE_INFINITY, 0, 0);
		
		for(Point3f p : getPoints())
		{
			if(p.x < point.x)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMinXPoint(Matrix4f t)
	{
		Point3f point = new Point3f(Float.POSITIVE_INFINITY, 0, 0);
		
		for(Point3f p : getPoints(t))
		{
			if(p.x < point.x)
			{
				point = p;
			}
		}
			
		return point;
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
	
	default float getMinY(Matrix4f t)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : getPoints(t))
		{
			if(p.y < min)
			{
				min = p.y;
			}
		}
		
		return min;
	}
	
	default Point3f getMinYPoint()
	{
		Point3f point = new Point3f(0, Float.POSITIVE_INFINITY, 0);
		
		for(Point3f p : getPoints())
		{
			if(p.y < point.y)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMinYPoint(Matrix4f t)
	{
		Point3f point = new Point3f(0, Float.POSITIVE_INFINITY, 0);
		
		for(Point3f p : getPoints(t))
		{
			if(p.y < point.y)
			{
				point = p;
			}
		}
			
		return point;
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
	
	default float getMinZ(Matrix4f t)
	{
		float min = Float.POSITIVE_INFINITY;
		
		for(Point3f p : getPoints(t))
		{
			if(p.z < min)
			{
				min = p.z;
			}
		}
		
		return min;
	}
	
	default Point3f getMinZPoint()
	{
		Point3f point = new Point3f(0, 0, Float.POSITIVE_INFINITY);
		
		for(Point3f p : getPoints())
		{
			if(p.z < point.z)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	default Point3f getMinZPoint(Matrix4f t)
	{
		Point3f point = new Point3f(0, 0, Float.POSITIVE_INFINITY);
		
		for(Point3f p : getPoints(t))
		{
			if(p.z < point.z)
			{
				point = p;
			}
		}
			
		return point;
	}
	
	static Point3f getFarthestPointInDirection(ConvexPolygonalShape3f s, Vec3f directionToMove)
    {
		Point3f[] points = s.getPoints();
		double max = Double.NEGATIVE_INFINITY;
        int index = 0;
        
        for (int i = 0; i < points.length; i++)
        {
            double dot = points[i].asVector3f(new Vector3f()).dot(directionToMove);
            
            if (dot > max)
            {
                max = dot;
                index = i;
            }
        }
        return points[index];
    }
	
	static Point3f getSupportPointInDirection(ConvexPolygonalShape3f a, ConvexPolygonalShape3f b, Vec3f v)
	{
		Point3f p1 = getFarthestPointInDirection(a, v);
		Point3f p2 = getFarthestPointInDirection(b, v.negateN());
		
		return p2.jump(p1.vectorFromf(p2, new Vector3f()));
	}
}
