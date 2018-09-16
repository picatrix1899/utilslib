
package cmn.utilslib.math.vector;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec4f;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector4f implements Vec4f
{

	public abstract Vector4f clone();
	
	/** generates a new persistent vector2f */
	public static PVector4f gen(final float x, final float y, final float z, final float a)
	{
		return new PVector4f()
		{
			/*
			###############
			##           ##
			##  GETTERS  ##
			##           ##
			###############
			 */
			
			/** {@inheritDoc} */
			public float getX() { return x; }
			
			/** {@inheritDoc} */
			public float getY() { return y; }
			
			/** {@inheritDoc} */
			public float getZ() { return z; }
			
			/** {@inheritDoc} */
			public float getA() { return a; }

			
			/*
			#########################
			##                     ##
			##  BASIC ARITHMETICS  ##
			##                     ##
			#########################
			*/

			/** {@inheritDoc} */
		 	public Vector4f addN(Vec4f v) { return clone().add(v); }

		 	/** {@inheritDoc} */
		 	public Vector4f addN(float scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f addN(double scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f subN(Vec4f v) { return clone().sub(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f subN(float scalar) { return clone().sub(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f subN(double scalar) { return clone().sub(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f mulN(Vec4f v) { return clone().mul(v); }

		 	/** {@inheritDoc} */
		 	public Vector4f mulN(float scalar) { return clone().mul(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f mulN(double scalar) { return clone().mul(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f divN(Vec4f v) { return clone().div(v); }

		 	/** {@inheritDoc} */
		 	public Vector4f divN(float scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f divN(double scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vector4f invertFromN(Vec4f v) { return clone().invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector4f invertFromN(float max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector4f invertFromN(double max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector4f invertFromN(float x, float y, float z, float a) { return clone().invertFrom(x, y, z, a); }
			
			/** {@inheritDoc} */
			public Vector4f invertFromN(double x, double y, double z, double a) { return clone().invertFrom(x, y, z, a); }

			
			
			/** {@inheritDoc} */
			public Vector4f negateN() { return clone().negate(); }
			
			
			
			/** {@inheritDoc} */
			public Vector4f inverseN() { return clone().inverse(); }
			
			/*
			##########################
			##                      ##
			##  VECTOR ARITHMETICS  ##
			##                      ##
			##########################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec4f v) { return (double) getX() * v.getX() + getY() * v.getY(); }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec4f v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			
			
			/** {@inheritDoc} */
			public double angleDeg(Vec4f v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
		 	
			
			/** {@inheritDoc} */
			public Vector4f normalizeN() { return clone().normalize(); }
			
			
			
			/** {@inheritDoc} */
			public Vector4f reflectN(Vec4f normal) { return clone().reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length() { return Math.sqrt(squaredLength()); }
			
			/** {@inheritDoc} */
			public double squaredLength() { return getX() * getX() + getY() * getY(); }
			
			
			
			/** {@inheritDoc} */
			public Vector4f rotateN(Vec4f axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector4f rotateN(Vec4f axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector4f rotateN(Quaternion q) { return clone().rotate(q); }
			
			/*
			#######################
			##                   ##
			##  OBJECT OVERRIDE  ##
			##                   ##
			#######################
			 */
			
			/** {@inheritDoc} */
			@Override
			public Vector4f clone() { return new Vector4f(this); }

			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec4f(" + getX() + "f, " + getY() + "f, " + getZ() + "f, " + getA() + "f)"; }
		};
	}
	
}
