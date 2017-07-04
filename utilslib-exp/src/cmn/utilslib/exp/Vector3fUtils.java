package cmn.utilslib.exp;

import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Vector3fUtils
{
 	public static Vec3f add(Vec3fBase v1, Vec3fBase v2, Vec3f dst) { return add(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f add(Vec3fBase v1, Vec3dBase v2, Vec3f dst) { return add(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f add(Vec3fBase v1, float scalar, Vec3f dst) { return add(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f add(Vec3fBase v1, double scalar, Vec3f dst) { return add(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f add(Vec3fBase v1, float x, float y, float z, Vec3f dst) { return dst.set(v1).add(x, y, z); }
 	public static Vec3f add(Vec3fBase v1, double x, double y, double z, Vec3f dst) { return dst.set(v1).add(x, y, z); }
	
 	public static Vec3f sub(Vec3fBase v1, Vec3fBase v2, Vec3f dst) { return sub(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f sub(Vec3fBase v1, Vec3dBase v2, Vec3f dst) { return sub(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f sub(Vec3fBase v1, float scalar, Vec3f dst) { return sub(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f sub(Vec3fBase v1, double scalar, Vec3f dst) { return sub(v1, scalar, scalar, scalar, dst); }	
 	public static Vec3f sub(Vec3fBase v1, float x, float y, float z, Vec3f dst) { return dst.set(v1).sub(x, y, z); }
 	public static Vec3f sub(Vec3fBase v1, double x, double y, double z, Vec3f dst) { return dst.set(v1).sub(x, y, z); }
	
 	public static Vec3f mul(Vec3fBase v1, Vec3fBase v2, Vec3f dst) { return mul(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f mul(Vec3fBase v1, Vec3dBase v2, Vec3f dst) { return mul(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f mul(Vec3fBase v1, float scalar, Vec3f dst) { return mul(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f mul(Vec3fBase v1, double scalar, Vec3f dst) { return mul(v1, scalar, scalar, scalar, dst); }	
 	public static Vec3f mul(Vec3fBase v1, float x, float y, float z, Vec3f dst) { return dst.set(v1).mul(x, y, z); }
 	public static Vec3f mul(Vec3fBase v1, double x, double y, double z, Vec3f dst) { return dst.set(v1).mul(x, y, z); }
	
 	public static Vec3f div(Vec3fBase v1, Vec3fBase v2, Vec3f dst) { return div(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f div(Vec3fBase v1, Vec3dBase v2, Vec3f dst) { return div(v1, v2.getX(), v2.getY(), v2.getZ(), dst); }
 	public static Vec3f div(Vec3fBase v1, float scalar, Vec3f dst) { return div(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f div(Vec3fBase v1, double scalar, Vec3f dst) { return div(v1, scalar, scalar, scalar, dst); }
 	public static Vec3f div(Vec3fBase v1, float x, float y, float z, Vec3f dst) { return dst.set(v1).div(x, y, z); }
 	public static Vec3f div(Vec3fBase v1, double x, double y, double z, Vec3f dst) { return dst.set(v1).div(x, y, z); }

}
