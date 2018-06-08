package cmn.utilslib.math.vector.pools;

import cmn.utilslib.Pool;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Vector3fPool
{
	private static Pool<Vector3f> pool = new Pool<Vector3f>(Vector3f.class);
	
	public static Vector3f get() { return pool.get().setZero(); }
	public static Vector3f get(Vector3f v) { return pool.get().set(v); }
	public static Vector3f get(Vector3d v) { return pool.get().set(v); }
	public static Vector3f get(Vec3fBase v) { return pool.get().set(v); }
	public static Vector3f get(Vec3dBase v) { return pool.get().set(v); }
	public static Vector3f get(Tuple3f t) { return pool.get().set(t); }
	public static Vector3f get(Tuple3d t) { return pool.get().set(t); }
	public static Vector3f get(Tup3fBase t) { return pool.get().set(t); }
	public static Vector3f get(Tup3dBase t) { return pool.get().set(t); }
	public static Vector3f get(Point3f p) { return pool.get().set(p); }
	public static Vector3f get(float scalar) { return pool.get().set(scalar); }
	public static Vector3f get(double scalar) { return pool.get().set(scalar); }
	public static Vector3f get(float x, float y, float z) { return pool.get().set(x, y, z); }
	public static Vector3f get(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void store(Vector3f v) { pool.store(v); }
}
