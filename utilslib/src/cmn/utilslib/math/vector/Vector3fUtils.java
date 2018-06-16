package cmn.utilslib.math.vector;

import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

@SuppressWarnings("unchecked")
public class Vector3fUtils
{
	/**
	 * Adds v2 to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param v2 vector to add
	 * @return dest
	 */
 	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, Vec3fBase v2) { return (T) dest.set(v1).add(v2); }
	/**
	 * Adds v2 to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param v2 vector to add
	 * @return dest
	 */
 	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, Vec3dBase v2) { return (T) dest.set(v1).add(v2); }
	/**
	 * Adds scalar to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param scalar a scalar that is added to all components
	 * @return dest
	 */
 	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, float scalar) { return (T) dest.set(v1).add(scalar); }
	/**
	 * Adds scalar to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param scalar a scalar that is added to all components
	 * @return dest
	 */
 	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, double scalar) { return (T) dest.set(v1).add(scalar); }
	/**
	 * Adds x, y and z to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param x x-component to add
	 * @param y y-component to add
	 * @param z z-component to add
	 * @return dest
	 */
 	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, float x, float y, float z) { return (T) dest.set(v1).add(x, y, z); }
	/**
	 * Adds x, y and z to v1 and saves the result in dest. Additionally it returns dest.
	 * @param dest the vector to save the result in
	 * @param v1 first vector
	 * @param x x-component to add
	 * @param y y-component to add
	 * @param z z-component to add
	 * @return dest
	 */
	public static <T extends Vec3f> T addR(T dest, Vec3fBase v1, double x, double y, double z) { return (T) dest.set(v1).add(x, y, z); }
	
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
