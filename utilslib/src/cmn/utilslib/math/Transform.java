package cmn.utilslib.math;

import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

public class Transform
{
	private Vector3f pos;
	private Rotation rot;
	private Vector3f scale;
	
	private Transform parent;
	
	public Transform()
	{
		this.pos = new Vector3f();
		this.rot = new EulerRotation();
		this.scale = Vec3f.ONE.clone();
	}
	
	public Transform(RotationType type)
	{
		this.pos = new Vector3f();
		this.scale = Vec3f.ONE.clone();	

		if(type == RotationType.EULER)
			this.rot = new EulerRotation();
		else
			this.rot = new QuaternionRotation();
	}
	
	public Transform setScale(Vec3fBase scale) { this.scale.set(scale); return this; }
	public Vector3f getScale() { return this.scale; }

	
	public Transform setParent(Transform parent) { this.parent = parent; return this; }
	public Transform getParent() { return this.parent; }
	
	
	public Transform rotate(double pitch, double yaw, double roll) { this.rot.rotate(pitch, yaw, roll); return this; }
	public Transform rotate(Vec3fBase v, double angle) { this.rot.rotate(v, angle); return this; }
	public Quaternion getRot() { return this.rot.getRotation(); }
	public Quaternion getTransformedRot()
	{
		if(this.parent != null)
			return this.parent.getTransformedRot().mulN(this.rot.getRotation());
		return this.rot.getRotation();
	}	
	
	
	public Rotation getRotation() { return this.rot; }
	
	public Transform moveBy(Vec3fBase velocity) { this.pos.add(velocity); return this; }
	public Transform setPos(Vec3fBase pos) { this.pos.set(pos); return this; }
	public Vector3f getPos() { return this.pos; }
	public Vector3f getTransformedPos()
	{
		if(this.parent != null)
			return this.parent.getTransformationMatrix().transformN(this.pos);
		return this.pos;
	}
	
	

	
	
	public Matrix4f getTransformationMatrix()
	{
		if(this.parent == null)
			return Matrix4f.modelMatrix(this.pos, this.rot.getRotation(), this.scale);

		return this.parent.getTransformationMatrix().mul(Matrix4f.modelMatrix(this.pos, this.rot.getRotation(), this.scale));
	}
	
}
