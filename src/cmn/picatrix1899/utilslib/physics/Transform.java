package cmn.picatrix1899.utilslib.physics;

import cmn.picatrix1899.utilslib.vector.Matrix4f;
import cmn.picatrix1899.utilslib.vector.Quaternion;
import cmn.picatrix1899.utilslib.vector.Vector3f;

public class Transform
{
	
	private Vector3f pos;
	
	private Quaternion yawRot;
	private Quaternion pitchRot;
	private Quaternion rollRot;
	
	private Vector3f scale;
	
	public Transform()
	{
		pos = new Vector3f();
		
		yawRot = new Quaternion(0, 0, 0, 1);
		pitchRot = new Quaternion(0, 0, 0, 1);
		rollRot = new Quaternion(0, 0, 0, 1);
		
		scale = new Vector3f(1.0f, 1.0f, 1.0f);
	}
	
	public Transform setPosition(Vector3f pos)
	{
		this.pos = pos;
		return this;
	}
	
	public Transform setYawRotation(Quaternion yawRot)
	{
		this.yawRot = yawRot;
		return this;
	}
	
	public Transform setPitchRotation(Quaternion pitchRot)
	{
		this.pitchRot = pitchRot;
		return this;
	}
	
	public Transform setRollRotation(Quaternion rollRot)
	{
		this.rollRot = rollRot;
		return this;
	}
	
	public Transform setScale(Vector3f scale)
	{
		this.scale = scale;
		return this;
	}
	
	public Vector3f getPosition()
	{
		return this.pos;
	}
	
	public Quaternion getYawRotation()
	{
		return this.yawRot;
	}
	
	public Quaternion getPitchRotation()
	{
		return this.pitchRot;
	}
	
	public Quaternion getRollRotation()
	{
		return this.rollRot;
	}
	
	public Vector3f getScale()
	{
		return this.scale;
	}
	
	public Quaternion getRotation()
	{
		return this.rollRot.mulN(this.yawRot.mulN(this.pitchRot));
	}
	
	public Matrix4f getTransformMatrix()
	{
		return new Matrix4f().initModelMatrix(getPosition(), getRotation(), getScale());
	}
	
}
