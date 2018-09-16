package cmn.utilslib.math;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

public class QuaternionRotation implements Rotation
{
	public Quaternion rot;

	public QuaternionRotation()
	{
		this.rot = new Quaternion();
	}
	
	public QuaternionRotation(double pitch, double yaw, double roll)
	{
		this();
		
		rotate(pitch, yaw, roll);
	}
	
	public Quaternion getRotation()
	{
		return this.rot;
	}
	
	public void rotate(double pitch, double yaw, double roll)
	{
		this.rot.rotate(this.rot.getLeftf(), pitch);
		this.rot.rotate(this.rot.getUpf(), yaw);
		this.rot.rotate(this.rot.getForwardf(), roll);
	}
	
	public void rotate(Vec3f v, double angle)
	{
		this.rot.rotate(v, angle);
	}

	public double getEulerPitch()
	{
		return this.rot.getEulerPitch();
	}

	public double getEulerYaw()
	{
		return this.rot.getEulerYaw();
	}

	public double getEulerRoll()
	{
		return this.rot.getEulerRoll();
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
