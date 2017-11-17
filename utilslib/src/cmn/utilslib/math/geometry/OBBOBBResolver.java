package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

public class OBBOBBResolver
{
	public static Point3f[] getPointsInSpace(OBB3f obb, Matrix4f space)
	{
		
		Point3f[] points = obb.getPoints();
		
		for(int i = 0; i < points.length; i++)
		{
			points[i] = space.transform(points[i]);
		}
		
		return points;
	}
	
	public static float getMinXInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float min = Float.MAX_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].x < min)
			{
				min = points[i].x;
			}
		}
		
		return min;
	}
	
	public static float getMinYInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float min = Float.MAX_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].y < min)
			{
				min = points[i].y;
			}
		}
		
		return min;
	}
	
	public static float getMinZInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float min = Float.MAX_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].z < min)
			{
				min = points[i].z;
			}
		}
		
		return min;
	}
	
	public static float getMaxXInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float max = Float.MIN_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].x > max)
			{
				max = points[i].x;
			}
		}
		
		return max;
	}
	
	public static float getMaxYInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float max = Float.MIN_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].y > max)
			{
				max = points[i].y;
			}
		}
		
		return max;
	}
	
	public static float getMaxZInSpace(OBB3f obb, Matrix4f space)
	{
		Point3f[] points = getPointsInSpace(obb, space);
		
		float max = Float.MIN_VALUE;
		
		for(int i = 0; i < points.length; i++)
		{
			if(points[i].z > max)
			{
				max = points[i].z;
			}
		}
		
		return max;
	}
	
	public static boolean iOBBOBB3f(OBB3f a, OBB3f b)
	{
		Vector3f aCenter = a.center.asVector3f(new Vector3f());
		Vector3f bCenter = b.center.asVector3f(new Vector3f());
		
		Matrix3f modelSpaceA = a.getModelSpaceMatrix();
		Matrix3f modelSpaceB = b.getModelSpaceMatrix();
		
		Matrix4f spaceA = Matrix4f.identity();
		spaceA.m0.set(modelSpaceA.m0.get(0), modelSpaceA.m0.get(1), modelSpaceA.m0.get(2),0);
		spaceA.m1.set(modelSpaceA.m1.get(0), modelSpaceA.m1.get(1), modelSpaceA.m1.get(2),0);
		spaceA.m2.set(modelSpaceA.m2.get(0), modelSpaceA.m2.get(1), modelSpaceA.m2.get(2),0);
		
		Matrix4f spaceB = Matrix4f.identity();
		spaceB.m0.set(modelSpaceB.m0.get(0), modelSpaceB.m0.get(1), modelSpaceB.m0.get(2),0);
		spaceB.m1.set(modelSpaceB.m1.get(0), modelSpaceB.m1.get(1), modelSpaceB.m1.get(2),0);
		spaceB.m2.set(modelSpaceB.m2.get(0), modelSpaceB.m2.get(1), modelSpaceB.m2.get(2),0);
		
		Vector3f centerA = spaceA.transformN(aCenter);
		Vector3f centerB = spaceA.transformN(bCenter);
		
		double aMinX = a.getMinX();
		double aMaxX = a.getMaxX();
		
		double bMinX = getMinXInSpace(b, spaceA);
		double bMaxX = getMaxXInSpace(b, spaceA);
		
		double aMinY = a.getMinY();
		double aMaxY = a.getMaxY();
		
		double bMinY = getMinYInSpace(b, spaceA);
		double bMaxY = getMaxYInSpace(b, spaceA);
		
		double aMinZ = a.getMinZ();
		double aMaxZ = a.getMaxZ();
		
		double bMinZ = getMinZInSpace(b, spaceA);
		double bMaxZ = getMaxZInSpace(b, spaceA);

//		if(centerA.x < centerB.x)
//		{
//			if(!(aMaxX > bMinX))
//				return false;
//		}
//		else
//		{
//			if(!(bMaxX > aMinX))
//				return false;
//		}
		
//		if(centerA.y < centerB.y)
//		{
//			if(!(aMaxY > bMinY))
//				return false;
//		}
//		else
//		{
//			if(!(bMaxY > aMinY))
//				return false;
//		}
//		
//		if(centerA.z < centerB.z)
//		{
//			if(!(aMaxZ > bMinZ))
//				return false;
//		}
//		else
//		{
//			if(!(bMaxZ > aMinZ))
//				return false;
//		}
//		
		centerA = spaceB.transformN(aCenter);
		centerB = spaceB.transformN(bCenter);
		
		aMinX = getMinXInSpace(a, spaceB);
		aMaxX = getMaxXInSpace(a, spaceB);
		
		bMinX = b.getMinX();
		bMaxX = b.getMaxX();
		
		aMinY = getMinYInSpace(a, spaceB);
		aMaxY = getMaxYInSpace(a, spaceB);
		
		bMinY = b.getMinY();
		bMaxY = b.getMaxY();
		
		aMinZ = getMinZInSpace(a, spaceB);
		aMaxZ = getMaxZInSpace(a, spaceB);
		
		bMinZ = b.getMinZ();
		bMaxZ = b.getMaxZ();

		if(centerA.x < centerB.x)
		{
			System.out.println("before");
			if(!(aMaxX > bMinX))
				return false;
		}
		else
		{
			System.out.println("after");
			if(!(bMaxX > aMinX))
				return false;
		}
		
//		if(centerA.y < centerB.y)
//		{
//			if(!(aMaxY > bMinY))
//				return false;
//		}
//		else
//		{
//			if(!(bMaxY > aMinY))
//				return false;
//		}
//		
//		if(centerA.z < centerB.z)
//		{
//			if(!(aMaxZ > bMinZ))
//				return false;
//		}
//		else
//		{
//			if(!(bMaxZ > aMinZ))
//				return false;
//		}
		
		return true;
	}
}
