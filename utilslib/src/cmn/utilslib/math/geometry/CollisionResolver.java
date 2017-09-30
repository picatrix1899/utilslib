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
}
