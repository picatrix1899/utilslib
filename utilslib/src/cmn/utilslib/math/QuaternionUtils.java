package cmn.utilslib.math;

import cmn.utilslib.math.vector.api.Vec3fBase;

public class QuaternionUtils
{
	public static Quaternion mulR(Quaternion dest, Quaternion q, Vec3fBase v) { return dest.set(q).mul(v); }
	
	public static Quaternion conjugateR(Quaternion dest, Quaternion q) { return dest.set(q).conjugate(); }
}
