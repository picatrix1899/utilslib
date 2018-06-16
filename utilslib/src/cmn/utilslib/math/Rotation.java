package cmn.utilslib.math;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec3fBase;

public interface Rotation
{
	
	Quaternion getRotation();
	
	void rotate(double rx, double ry, double rz);

	void rotate(Vec3fBase v, double angle);

	double getEulerPitch();
	double getEulerYaw();
	double getEulerRoll();
	
	Quaternion getRotationPitch();
	Quaternion getRotationYaw();
	Quaternion getRotationRoll();
}
