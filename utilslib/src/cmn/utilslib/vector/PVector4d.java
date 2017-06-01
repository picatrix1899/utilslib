
package cmn.utilslib.vector;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.api.Vec4dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector4d implements Vec4dBase
{

	public abstract Vector4d clone();
	
	/** generates a new persistent vector2f */
	public static PVector4d gen(final double x, final double y, final double z, final double a)
	{
		return new PVector4d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			public double getA() { return a; }

			@Override
			public Vector4d clone()
			{
				return new Vector4d(this);
			}
			
			
			public Vector4d inverted() { return clone().invert(); }
			
			public Vector4d normalized() { return clone().normalize(); }
			
			
			public Vector4d addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
			public Vector4d addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
			public Vector4d addN(Vec4dBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4d addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
			public Vector4d addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
			
			public Vector4d subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
			public Vector4d subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
			public Vector4d subN(Vec4dBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4d subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
			public Vector4d subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
			
			public Vector4d mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
			public Vector4d mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
			public Vector4d mulN(Vec4dBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4d mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
			public Vector4d mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
			
			public Vector4d divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
			public Vector4d divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
			public Vector4d divN(Vec4dBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4d divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
			public Vector4d divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
			
			public Vector4d project(Vec4dBase v)
			{
				Vector4d vn = (Vector4d) v.normalized();
				 double f = this.dot(vn);
				 
				 return vn.mul((float)f);
			}
			
			
			public Vector4d rot(Vec4dBase axis, float angle)
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
			
			public Vector4d rot(Quaternion q)
			{
				Quaternion conjugate = q.conjugated();
				Quaternion w = q.mulN(this).mulN(conjugate);

				return new Vector4d(w.getX(), w.getY(), w.getZ(), w.getW());
			}

			
			public Vector4d reflected(Vec4dBase normal)
			{
				Vector4d out = clone();
				
				out.reflect(normal);
				
				return out;
			}
			
			public Vector4d lerped(Vec4dBase v, double f)
			{
				Vector4d out = clone();
				out.lerp(v, f);
				return out;
			}
			
		};
	}
	
}
