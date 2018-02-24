package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.vector.Vector3f;

public class RayOBBResolver
{
	
	public static boolean hit(Vector3f origin, Vector3f dir, OBB3f obb)
	{
		dir = dir.normalizeN();
		
		Matrix3f m = obb.getModelSpaceMatrix();
		
		Vector3f min = obb.halfExtend.negateN();
		Vector3f max = obb.halfExtend.clone();
		
		Vector3f delta = obb.center.asVector3f().subN(origin);
		
		double tMin = 0;
		double tMax = 100000;
		
		double e = m.m0.dot(delta);
		double f = dir.dot(m.m0);
		
		if(Math.abs(f) > 0.001f)
		{
			double t1 = (e + min.x) / f;
			double t2 = (e + max.x) / f;
			
		    if(t1 > t2)
		    {
		    	double temp0 = t1;
		    	t1 = t2;
		    	t2 = temp0;
		    }
		    
		    if(t2 < tMax) tMax = t2;
		    if(t1 > tMin) tMin = t1;
		    
		    if(tMax < tMin) return false;
		}
		
		e = m.m1.dot(delta);
		f = dir.dot(m.m1);
		
		if(Math.abs(f) > 0.001f)
		{
			double t1 = (e + min.y) / f;
			double t2 = (e + max.y) / f;
			
		    if(t1 > t2)
		    {
		    	double temp0 = t1;
		    	t1 = t2;
		    	t2 = temp0;
		    }
		    
		    if(t2 < tMax) tMax = t2;
		    if(t1 > tMin) tMin = t1;
		    
		    if(tMax < tMin) return false;
		}
		
		e = m.m2.dot(delta);
		f = dir.dot(m.m2);
		
		if(Math.abs(f) > 0.001f)
		{
			double t1 = (e + min.z) / f;
			double t2 = (e + max.z) / f;
			
		    if(t1 > t2)
		    {
		    	double temp0 = t1;
		    	t1 = t2;
		    	t2 = temp0;
		    }
		    
		    if(t2 < tMax) tMax = t2;
		    if(t1 > tMin) tMin = t1;
		    
		    if(tMax < tMin) return false;
		}
		
		return true;
	}
}
