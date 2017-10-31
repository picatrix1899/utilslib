package cmn.utilslib.math.geometry;


import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class CollisionResolver
{
	
	public static boolean intersectAABBAABB3f(AABB3f a, AABB3f b)
	{	
			Vector3f aMin = a.center.asVector3f(new Vector3f()).sub(a.halfExtend);
			Vector3f bMax = b.center.asVector3f(new Vector3f()).add(b.halfExtend);
		
			Vector3f aSize = a.halfExtend.mulN(2);
			Vector3f bSize = b.halfExtend.mulN(2);
			
			Vec3f topLeft = aMin.subN(bMax);
			Vec3f fullSize = aSize.addN(bSize);
			
			Vec3f ext = fullSize.mulN(0.5f);
			Vec3f c = topLeft.addN(ext);
			
			Vec3f min = c.subN(ext);
			Vec3f max = c.addN(ext);
		
			return	min.getX() < 0 && max.getX() > 0 &&
					min.getY() < 0 && max.getY() > 0 &&
					min.getZ() < 0 && max.getZ() > 0 ;
	}
	
	public static Vector3f resolveAABBAABB3f(AABB3f a, AABB3f b)
	{
		return null;
	}
	
	public static boolean iAABBAABB3f(AABB3f a, AABB3f b)
	{
		Vector3f aCenter = a.center.asVector3f(new Vector3f());
		Vector3f bCenter = b.center.asVector3f(new Vector3f());
		
		double aMinX = a.halfExtend.negateN().x + aCenter.x;
		double aMaxX = a.halfExtend.x + aCenter.x;
		
		double bMinX = b.halfExtend.negateN().x + bCenter.x;
		double bMaxX = b.halfExtend.x + bCenter.x;
		
		double aMinY = a.halfExtend.negateN().y + aCenter.y;
		double aMaxY = a.halfExtend.y + aCenter.y;
		
		double bMinY = b.halfExtend.negateN().y + bCenter.y;
		double bMaxY = b.halfExtend.y + bCenter.y;
		
		double aMinZ = a.halfExtend.negateN().z + aCenter.z;
		double aMaxZ = a.halfExtend.z + aCenter.z;
		
		double bMinZ = b.halfExtend.negateN().z + bCenter.z;
		double bMaxZ = b.halfExtend.z + bCenter.z;

		if(aCenter.x < bCenter.x)
		{
			if(aMaxX <= bMinX)
			{
				return false;
			}
			
		}
		else
		{
			if(bMaxX <= aMinX)
			{
				return false;
			}
		}
		
		if(aCenter.y < bCenter.y)
		{
			if(aMaxY <= bMinY)
			{
				return false;
			}
			
		}
		else
		{
			if(bMaxY <= aMinY)
			{
				return false;
			}
		}
		
		if(aCenter.z < bCenter.z)
		{
			if(aMaxZ <= bMinZ)
			{
				return false;
			}
			
		}
		else
		{
			if(bMaxZ <= aMinZ)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static Vector3f rAABBAABB3f(AABB3f a, AABB3f b)
	{
		Vector3f aCenter = a.center.asVector3f(new Vector3f());
		Vector3f bCenter = b.center.asVector3f(new Vector3f());
		
		double aMinX = a.halfExtend.negateN().x + aCenter.x;
		double aMaxX = a.halfExtend.x + aCenter.x;
		
		double bMinX = b.halfExtend.negateN().x + bCenter.x;
		double bMaxX = b.halfExtend.x + bCenter.x;
		
		double aMinY = a.halfExtend.negateN().y + aCenter.y;
		double aMaxY = a.halfExtend.y + aCenter.y;
		
		double bMinY = b.halfExtend.negateN().y + bCenter.y;
		double bMaxY = b.halfExtend.y + bCenter.y;
		
		double aMinZ = a.halfExtend.negateN().z + aCenter.z;
		double aMaxZ = a.halfExtend.z + aCenter.z;
		
		double bMinZ = b.halfExtend.negateN().z + bCenter.z;
		double bMaxZ = b.halfExtend.z + bCenter.z;

		double signX = 0;
		double valX = 0;
		double signY = 0;
		double valY = 0;
		double signZ = 0;
		double valZ = 0;
		
		if(aCenter.x < bCenter.x)
		{
			if(aMaxX > bMinX)
			{
				valX = aMaxX - bMinX;
				signX = -1;
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
				valX = bMaxX - aMinX;
				signX = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aCenter.y < bCenter.y)
		{
			if(aMaxY > bMinY)
			{
				valY = aMaxY - bMinY;
				signY = -1;
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
				valY = bMaxY - aMinY;
				signY = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		if(aCenter.z < bCenter.z)
		{
			if(aMaxZ > bMinZ)
			{
				valZ = aMaxZ - bMinZ;
				signZ = -1;
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
				valZ = bMaxZ - aMinZ;
				signZ = 1;
			}
			else
			{
				return new Vector3f();
			}
		}
		
		Vector3f out = new Vector3f();
		
		if(valX <= valY && valX <= valZ)
		{
			out.x = (float)(valX * signX);
		}
		
		if(valY <= valX && valY <= valZ)
		{
			out.y = (float)(valY * signY);
		}
		
		if(valZ <= valX && valZ <= valY)
		{
			out.z = (float)(valZ * signZ);
		}
		
		
		return out;
	}

}
