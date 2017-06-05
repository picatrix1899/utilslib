
package cmn.utilslib.vector;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.api.Vec3fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3f implements Vec3fBase
{

	public abstract Vector3f clone();
	
	/** generates a new persistent vector2f */
	public static PVector3f gen(final float x, final float y, final float z)
	{
		return new PVector3f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			

			@Override
			public Vector3f clone()
			{
				return new Vector3f(this);
			}
			
		 	public Vector3f inverted() { return clone().invert(); }
			
		 	public Vector3f normalized() { return clone().normalize(); }
			
		 	public Vector3f addN(Vec3fBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3f addN(float scalar) { return addN(scalar, scalar, scalar); }
		 	public Vector3f addN(double scalar) { return addN(scalar, scalar, scalar); }
		 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
		 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
			
		 	public Vector3f subN(Vec3fBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3f subN(float scalar) { return subN(scalar, scalar, scalar); }
		 	public Vector3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
		 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
		 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
			
		 	public Vector3f mulN(Vec3fBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
		 	public Vector3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
		 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
		 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
			
		 	public Vector3f divN(Vec3fBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
		 	public Vector3f divN(float scalar) { return divN(scalar, scalar, scalar); }
		 	public Vector3f divN(double scalar) { return divN(scalar, scalar, scalar); }
		 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
		 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
			
			
			
		 	public Vector3f cross(Vec3fBase v) 
			{
				return new Vector3f(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
			}
			
		 	public Vector3f project(Vec3fBase v)
			{	
				Vector3f vn = (Vector3f) v.normalized();
				 double f = this.dot(vn);
				 
				 return vn.mul((float)f);
			}
			
			
		 	public Vector3f rot(Vec3fBase axis, float angle)
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
			
		 	public Vector3f rot(Quaternion q)
			{
				Quaternion conjugate = q.conjugated();
				Quaternion w = q.mulN(this).mulN(conjugate);

				return new Vector3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
			}

			
		 	public Vector3f reflected(Vec3fBase normal)
			{
				Vector3f out = clone();
				
				out.reflect(normal);
				
				return out;
			}
			
		 	public Vector3f lerp(Vec3fBase v, float f)
			{
		 		Vector3f out = new Vector3f();
		 		
				out.setX(getX() + (v.getX() - getX()) * f);
				out.setY(getY() + (v.getY() - getY()) * f);
				out.setZ(getZ() + (v.getZ() - getZ()) * f);
				
				return out;
			}
			
		 	public Vector3f slerp(Vec3fBase v, double f)
			{
				double angle = angleRad(v);
				
				double sinAngle = Math.sin(angle);

				double x_1 = (1 - f)	* sinAngle / sinAngle * getX();
				double x_2 = f			* sinAngle / sinAngle * v.getX();
				float x = (float) (x_1 + x_2);
				
				double y_1 = (1 - f)	* sinAngle / sinAngle * getY();
				double y_2 = f			* sinAngle / sinAngle * v.getY();
				float y = (float) (y_1 + y_2);
				
				double z_1 = (1 - f)	* sinAngle / sinAngle * getZ();
				double z_2 = f			* sinAngle / sinAngle * v.getZ();
				float z = (float) (z_1 + z_2);
				
				return new Vector3f(x, y, z);
			}
		 	
			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec3f(" + getX() + "f, " + getY() + "f, " + getZ() + "f)"; }
		};
	}
	
}
