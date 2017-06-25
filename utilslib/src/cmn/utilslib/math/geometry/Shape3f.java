package cmn.utilslib.math.geometry;

import cmn.utilslib.math.vector.Vector3f;

public interface Shape3f
{

	Point3f[] getPoints();
	
	
	
	static Point3f getFarthestPointInDirection(Shape3f s, Vector3f directionToMove)
    {
        
		Point3f[] points = s.getPoints();
		double max = Double.NEGATIVE_INFINITY;
        int index = 0;
        
        for (int i = 0; i < points.length; i++)
        {
            double dot = points[i].asVector3f().dot(directionToMove);
            
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
		Point3f p2 = getFarthestPointInDirection(b, v.inverted());
		
		return p2.jump(p1.vectorFrom(p2));
	}
}
