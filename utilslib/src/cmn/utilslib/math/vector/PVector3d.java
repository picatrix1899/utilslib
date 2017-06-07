
package cmn.utilslib.math.vector;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec3dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3d implements Vec3dBase
{

	public abstract Vector3d clone();
	
	/** generates a new persistent vector2f */
	public static PVector3d gen(final float x, final float y, final float z)
	{
		return new PVector3d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			

			@Override
			public Vector3d clone()
			{
				return new Vector3d(this);
			}
			
			
		 	public Vector3d inverted() { return clone().invert(); }
			
		 	public Vector3d normalized() { return clone().normalize(); }
			
		 	public Vector3d addN(Vec3dBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3d addN(float scalar) { return addN(scalar, scalar, scalar); }
		 	public Vector3d addN(double scalar) { return addN(scalar, scalar, scalar); }
		 	public Vector3d addN(float x, float y, float z) { return clone().add(x, y, z); }
		 	public Vector3d addN(double x, double y, double z) { return clone().add(x, y, z); }
			
		 	public Vector3d subN(Vec3dBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3d subN(float scalar) { return subN(scalar, scalar, scalar); }
		 	public Vector3d subN(double scalar) { return subN(scalar, scalar, scalar); }	
		 	public Vector3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
		 	public Vector3d subN(double x, double y, double z) { return clone().sub(x, y, z); }
			
		 	public Vector3d mulN(Vec3dBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3d mulN(float scalar) { return mulN(scalar, scalar, scalar); }
		 	public Vector3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
		 	public Vector3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
		 	public Vector3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }
			
		 	public Vector3d divN(Vec3dBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3d divN(float scalar) { return divN(scalar, scalar, scalar); }
		 	public Vector3d divN(double scalar) { return divN(scalar, scalar, scalar); }
		 	public Vector3d divN(float x, float y, float z) { return clone().div(x, y, z); }
		 	public Vector3d divN(double x, double y, double z) { return clone().div(x, y, z); }
			
			
			
		 	public Vector3d cross(Vec3dBase v) 
			{
				return new Vector3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
			}
			
		 	public Vector3d project(Vec3dBase v)
			{	
				Vector3d vn = (Vector3d) v.normalized();
				 double f = this.dot(vn);
				 
				 return vn.mul((float)f);
			}
			
			
		 	public Vector3d rot(Vec3dBase axis, float angle)
			{
				
				angle *= 0.5f;
				angle *= Maths.DEG_TO_RAD;
				
				double sinHalfAngle = Math.sin(angle);
				double cosHalfAngle = Math.cos(angle);
				
				double rX = axis.getX() * sinHalfAngle;
				double rY = axis.getY() * sinHalfAngle;
				double rZ = axis.getZ() * sinHalfAngle;
				double rW = cosHalfAngle;
				
				Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
				
				return rot(rotation);
			}
			
		 	public Vector3d rot(Quaternion q)
			{
				Quaternion conjugate = q.conjugated();
				Quaternion w = q.mulN(this).mulN(conjugate);

				return new Vector3d(w.getX(), w.getY(), w.getZ());
			}

			
		 	public Vector3d reflected(Vec3dBase normal)
			{
				Vector3d out = clone();
				
				out.reflect(normal);
				
				return out;
			}
			
		 	public Vector3d lerped(Vec3dBase v, float f)
			{
				Vector3d out = clone();
				out.lerp(v, f);
				return out;
			}
			
		};
	}
	
}
