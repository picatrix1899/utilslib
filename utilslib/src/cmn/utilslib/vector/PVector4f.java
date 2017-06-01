
package cmn.utilslib.vector;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.api.Vec4fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector4f implements Vec4fBase
{

	public abstract Vector4f clone();
	
	/** generates a new persistent vector2f */
	public static PVector4f gen(final float x, final float y, final float z, final float a)
	{
		return new PVector4f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			public float getA() { return a; }

			@Override
			public Vector4f clone()
			{
				return new Vector4f(this);
			}
			
			public Vector4f inverted() { return clone().invert(); }
			
			public Vector4f normalized() { return clone().normalize(); }
			
			
			public Vector4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
			public Vector4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
			public Vector4f addN(Vec4fBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
			public Vector4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
			
			public Vector4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
			public Vector4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
			public Vector4f subN(Vec4fBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
			public Vector4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
			
			public Vector4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
			public Vector4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
			public Vector4f mulN(Vec4fBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
			public Vector4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
			
			public Vector4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
			public Vector4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
			public Vector4f divN(Vec4fBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
			public Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
			public Vector4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
			
			public Vector4f project(Vec4fBase v)
			{
				Vector4f vn = (Vector4f) v.normalized();
				 double f = this.dot(vn);
				 
				 return vn.mul((float)f);
			}
			
			
			public Vector4f rot(Vec4fBase axis, float angle)
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
			
			public Vector4f rot(Quaternion q)
			{
				Quaternion conjugate = q.conjugated();
				Quaternion w = q.mulN(this).mulN(conjugate);

				return new Vector4f((float)w.getX(), (float)w.getY(), (float)w.getZ(), (float)w.getW());
			}

			
			public Vector4f reflected(Vec4fBase normal)
			{
				Vector4f out = clone();
				
				out.reflect(normal);
				
				return out;
			}
			
			public Vector4f lerped(Vec4fBase v, double f)
			{
				Vector4f out = clone();
				out.lerp(v, f);
				return out;
			}
			
		};
	}
	
}
