package cmn.utilslib.math.geometry.pools;

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

public class Point3fPool
{
	private static Pool<Point3f> pool = new Pool<Point3f>(Point3f.class);
	
	public static Point3f getInstance() { return pool.get().setZero(); }
	public static Point3f getInstance(Vector3f v) { return pool.get().set(v); }
	public static Point3f getInstance(Vector3d v) { return pool.get().set(v); }
	public static Point3f getInstance(Vec3fBase v) { return pool.get().set(v); }
	public static Point3f getInstance(Vec3dBase v) { return pool.get().set(v); }
	public static Point3f getInstance(Tuple3f t) { return pool.get().set(t); }
	public static Point3f getInstance(Tuple3d t) { return pool.get().set(t); }
	public static Point3f getInstance(Tup3fBase t) { return pool.get().set(t); }
	public static Point3f getInstance(Tup3dBase t) { return pool.get().set(t); }
	public static Point3f getInstance(Point3f p) { return pool.get().set(p); }
	public static Point3f getInstance(float scalar) { return pool.get().set(scalar); }
	public static Point3f getInstance(double scalar) { return pool.get().set(scalar); }
	public static Point3f getInstance(float x, float y, float z) { return pool.get().set(x, y, z); }
	public static Point3f getInstance(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void storeInstance(Point3f v) { pool.store(v); }
}
