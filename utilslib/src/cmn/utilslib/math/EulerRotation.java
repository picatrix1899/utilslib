package cmn.utilslib.math;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class EulerRotation implements Rotation
{
	public double rotPitch;
	public double rotYaw;
	public double rotRoll;
	
	public EulerRotation()
	{
		this.rotPitch = 0.0d;
		this.rotYaw = 0.0d;
		this.rotRoll = 0.0d;
	}
	
	public Quaternion getRotation()
	{
		return getRotationRoll().mulN(getRotationYaw().mulN(getRotationPitch()));
	}
	
	public void rotate(double pitch, double yaw, double roll)
	{
		this.rotPitch += pitch;
		this.rotYaw += yaw;
		this.rotRoll += roll;
	}
	
	public void rotate(Vec3f v, double angle)
	{
		
		rotate(angle * v.getX(), angle * v.getY(), angle * v.getZ());
	}

	public double getEulerPitch()
	{
		return this.rotPitch;
	}

	public double getEulerYaw()
	{
		return this.rotYaw;
	}

	public double getEulerRoll()
	{
		return this.rotRoll;
	}
	
	public Quaternion getRotationPitch()
	{
		return Quaternion.getFromAxis(Vector3f.aNX, getEulerPitch());
	}

	public Quaternion getRotationYaw()
	{
		return Quaternion.getFromAxis(Vector3f.aY, getEulerYaw());
	}

	public Quaternion getRotationRoll()
	{
		return Quaternion.getFromAxis(Vector3f.aZ, getEulerRoll());
	}
	
}
