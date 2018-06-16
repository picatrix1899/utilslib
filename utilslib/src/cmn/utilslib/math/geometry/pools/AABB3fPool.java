package cmn.utilslib.math.geometry.pools;

import cmn.utilslib.Pool;
import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.vector.Vector3f;

public class AABB3fPool
{
	public static Pool<AABB3f> pool = new Pool<AABB3f>(AABB3f.class);
	
	public static AABB3f get() { return pool.get(); }
	
	public static AABB3f get(AABB3f aabb) { return pool.get().set(aabb); }
	
	public static AABB3f get(Point3f center, Vector3f halfExtend) { return pool.get().set(center, halfExtend); }
	
	public static void store(AABB3f aabb) { pool.store(aabb); }
}
