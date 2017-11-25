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
		
		float max = -Float.MAX_VALUE;
		
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
		
		float max = -Float.MAX_VALUE;
		
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
		
		float max = -Float.MAX_VALUE;
		
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
		
		Matrix4f spaceA = modelSpaceA.extend();

		Matrix4f spaceB = modelSpaceB.extend();

		double aMinX = getMinXInSpace(a, spaceA);
		double aMaxX = getMaxXInSpace(a, spaceA);
		
		double bMinX = getMinXInSpace(b, spaceA);
		double bMaxX = getMaxXInSpace(b, spaceA);
		
		double aMinY = getMinYInSpace(a, spaceA);
		double aMaxY = getMaxYInSpace(a, spaceA);
		
		double bMinY = getMinYInSpace(b, spaceA);
		double bMaxY = getMaxYInSpace(b, spaceA);
		
		double aMinZ = getMinZInSpace(a, spaceA);
		double aMaxZ = getMaxZInSpace(a, spaceA);
		
		double bMinZ = getMinZInSpace(b, spaceA);
		double bMaxZ = getMaxZInSpace(b, spaceA);

		double aPNX = aCenter.dot(new Vector3f(modelSpaceA.m0));
		double bPNX = bCenter.dot(new Vector3f(modelSpaceA.m0));
		double aPNY = aCenter.dot(new Vector3f(modelSpaceA.m1));
		double bPNY = bCenter.dot(new Vector3f(modelSpaceA.m1));
		double aPNZ = aCenter.dot(new Vector3f(modelSpaceA.m2));
		double bPNZ = bCenter.dot(new Vector3f(modelSpaceA.m2));
		
		if(aPNX < bPNX)
		{
			if(!(aMaxX > bMinX))
				return false;
		}
		else
		{
			if(!(bMaxX > aMinX))
				return false;
		}
		
		if(aPNY < bPNY)
		{
			if(!(aMaxY > bMinY))
				return false;
		}
		else
		{
			if(!(bMaxY > aMinY))
				return false;
		}
		
		if(aPNZ < bPNZ)
		{
			if(!(aMaxZ > bMinZ))
				return false;
		}
		else
		{
			if(!(bMaxZ > aMinZ))
				return false;
		}
		
		aMinX = getMinXInSpace(a, spaceB);
		aMaxX = getMaxXInSpace(a, spaceB);
		
		bMinX = getMinXInSpace(b, spaceB);
		bMaxX = getMaxXInSpace(b, spaceB);
		
		aMinY = getMinYInSpace(a, spaceB);
		aMaxY = getMaxYInSpace(a, spaceB);
		
		bMinY = getMinYInSpace(b, spaceB);
		bMaxY = getMaxYInSpace(b, spaceB);
		
		aMinZ = getMinZInSpace(a, spaceB);
		aMaxZ = getMaxZInSpace(a, spaceB);
		
		bMinZ = getMinZInSpace(b, spaceB);
		bMaxZ = getMaxZInSpace(b, spaceB);
		
		aPNX = aCenter.dot(new Vector3f(modelSpaceB.m0));
		bPNX = bCenter.dot(new Vector3f(modelSpaceB.m0));
		aPNY = aCenter.dot(new Vector3f(modelSpaceB.m1));
		bPNY = bCenter.dot(new Vector3f(modelSpaceB.m1));
		aPNZ = aCenter.dot(new Vector3f(modelSpaceB.m2));
		bPNZ = bCenter.dot(new Vector3f(modelSpaceB.m2));
		
		if(aPNX < bPNX)
		{
			if(!(aMaxX > bMinX))
				return false;
		}
		else
		{
			if(!(bMaxX > aMinX))
				return false;
		}
		
		if(aPNY < bPNY)
		{
			if(!(aMaxY > bMinY))
				return false;
		}
		else
		{
			if(!(bMaxY > aMinY))
				return false;
		}
		
		if(aPNZ < bPNZ)
		{
			if(!(aMaxZ > bMinZ))
				return false;
		}
		else
		{
			if(!(bMaxZ > aMinZ))
				return false;
		}
		
		return true;
	}
	
	public static Vector3f rOBBOBB3f(OBB3f a, OBB3f b)
	{
		Vector3f aCenter = a.center.asVector3f(new Vector3f());
		Vector3f bCenter = b.center.asVector3f(new Vector3f());
		
		Matrix3f modelSpaceA = a.getModelSpaceMatrix();
		Matrix3f modelSpaceB = b.getModelSpaceMatrix();
		
		Matrix4f spaceA = modelSpaceA.extend();

		Matrix4f spaceB = modelSpaceB.extend();

		double aMinX = getMinXInSpace(a, spaceA);
		double aMaxX = getMaxXInSpace(a, spaceA);
		
		double bMinX = getMinXInSpace(b, spaceA);
		double bMaxX = getMaxXInSpace(b, spaceA);
		
		double aMinY = getMinYInSpace(a, spaceA);
		double aMaxY = getMaxYInSpace(a, spaceA);
		
		double bMinY = getMinYInSpace(b, spaceA);
		double bMaxY = getMaxYInSpace(b, spaceA);
		
		double aMinZ = getMinZInSpace(a, spaceA);
		double aMaxZ = getMaxZInSpace(a, spaceA);
		
		double bMinZ = getMinZInSpace(b, spaceA);
		double bMaxZ = getMaxZInSpace(b, spaceA);

		double aPNX = aCenter.dot(new Vector3f(modelSpaceA.m0));
		double bPNX = bCenter.dot(new Vector3f(modelSpaceA.m0));
		double aPNY = aCenter.dot(new Vector3f(modelSpaceA.m1));
		double bPNY = bCenter.dot(new Vector3f(modelSpaceA.m1));
		double aPNZ = aCenter.dot(new Vector3f(modelSpaceA.m2));
		double bPNZ = bCenter.dot(new Vector3f(modelSpaceA.m2));
		
		double valAX = 0;
		int signAX = 0;
		double valAY = 0;
		int signAY = 0;
		double valAZ = 0;
		int signAZ = 0;
		double valBX = 0;
		int signBX = 0;
		double valBY = 0;
		int signBY = 0;
		double valBZ = 0;
		int signBZ = 0;
		
		if(aPNX < bPNX)
		{
			if(aMaxX > bMinX)
			{
				valAX = aMaxX - bMinX;
				signAX = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxX > aMinX)
			{
				valAX = bMaxX - aMinX;
				signAX = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aPNY < bPNY)
		{
			if(aMaxY > bMinY)
			{
				valAY = aMaxY - bMinY;
				signAY = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxY > aMinY)
			{
				valAY = bMaxY - aMinY;
				signAY = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aPNZ < bPNZ)
		{
			if(aMaxZ > bMinZ)
			{
				valAZ = aMaxZ - bMinZ;
				signAZ = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxZ > aMinZ)
			{
				valAZ = bMaxZ - aMinZ;
				signAZ = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		aMinX = getMinXInSpace(a, spaceB);
		aMaxX = getMaxXInSpace(a, spaceB);
		
		bMinX = getMinXInSpace(b, spaceB);
		bMaxX = getMaxXInSpace(b, spaceB);
		
		aMinY = getMinYInSpace(a, spaceB);
		aMaxY = getMaxYInSpace(a, spaceB);
		
		bMinY = getMinYInSpace(b, spaceB);
		bMaxY = getMaxYInSpace(b, spaceB);
		
		aMinZ = getMinZInSpace(a, spaceB);
		aMaxZ = getMaxZInSpace(a, spaceB);
		
		bMinZ = getMinZInSpace(b, spaceB);
		bMaxZ = getMaxZInSpace(b, spaceB);
		
		aPNX = aCenter.dot(new Vector3f(modelSpaceB.m0));
		bPNX = bCenter.dot(new Vector3f(modelSpaceB.m0));
		aPNY = aCenter.dot(new Vector3f(modelSpaceB.m1));
		bPNY = bCenter.dot(new Vector3f(modelSpaceB.m1));
		aPNZ = aCenter.dot(new Vector3f(modelSpaceB.m2));
		bPNZ = bCenter.dot(new Vector3f(modelSpaceB.m2));
		
		if(aPNX < bPNX)
		{
			if(aMaxX > bMinX)
			{
				valBX = aMaxX - bMinX;
				signBX = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxX > aMinX)
			{
				valBX = bMaxX - aMinX;
				signBX = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aPNY < bPNY)
		{
			if(aMaxY > bMinY)
			{
				valBY = aMaxY - bMinY;
				signBY = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxY > aMinY)
			{
				valBY = bMaxY - aMinY;
				signBY = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aPNZ < bPNZ)
		{
			if(aMaxZ > bMinZ)
			{
				valBZ = aMaxZ - bMinZ;
				signBZ = -1;
			}
			else
			{
				return new Vector3f();
			}
		}
		else
		{
			if(bMaxZ > aMinZ)
			{
				valBZ = bMaxZ - aMinZ;
				signBZ = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		Vector3f out = new Vector3f();
		
		Vector3f[] v = new Vector3f[6];
		
		
		v[0] = new Vector3f(modelSpaceA.m0).mul(valAX * signAX);
		v[1] = new Vector3f(modelSpaceA.m1).mul(valAY * signAY);
		v[2] = new Vector3f(modelSpaceA.m2).mul(valAZ * signAZ);
		
		v[3] = new Vector3f(modelSpaceB.m0).mul(valBX * signBX);
		v[4] = new Vector3f(modelSpaceB.m1).mul(valBY * signBY);
		v[5] = new Vector3f(modelSpaceB.m2).mul(valBZ * signBZ);
		
		int index = 0;

		
		double min = Double.MAX_VALUE;
		
		for(int i = 0; i < 6; i++)
		{
			Vector3f c = v[i];
			
			if(c.length() < min)
			{
				min = c.length();
				index = i;
			}
		}
		
		out.set(v[index]);
		
		return out;
	}
}
