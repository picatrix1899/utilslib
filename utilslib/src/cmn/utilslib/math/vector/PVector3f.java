
package cmn.utilslib.math.vector;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec3f;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3f implements Vec3f
{

	public abstract Vector3f clone();
	
	/** generates a new persistent vector2f */
	public static PVector3f gen(final float x, final float y, final float z)
	{
		return new PVector3f()
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

			/*
			#########################
			##                     ##
			##  BASIC ARITHMETICS  ##
			##                     ##
			#########################
			*/

			/** {@inheritDoc} */
		 	public Vector3f addN(Vec3f v) { return clone().add(v); }

		 	
		 	/** {@inheritDoc} */
		 	public Vector3f addN(float scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f addN(double scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f subN(Vec3f v) { return clone().sub(v); }

		 	/** {@inheritDoc} */
		 	public Vector3f subN(float scalar) { return clone().sub(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f subN(double scalar) { return clone().sub(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f mulN(Vec3f v) { return clone().mul(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f mulN(float scalar) { return clone().mul(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f mulN(double scalar) { return clone().mul(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f divN(Vec3f v) { return clone().div(v); }

		 	/** {@inheritDoc} */
		 	public Vector3f divN(float scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f divN(double scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vector3f invertFromN(Vec3f v) { return clone().invertFrom(v); }

			/** {@inheritDoc} */
			public Vector3f invertFromN(float max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector3f invertFromN(double max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector3f invertFromN(float x, float y, float z) { return clone().invertFrom(x, y, z); }
			
			/** {@inheritDoc} */
			public Vector3f invertFromN(double x, double y, double z) { return clone().invertFrom(x, y, z); }

			
			
			/** {@inheritDoc} */
			public Vector3f negateN() { return clone().negate(); }
			
			
			
			/** {@inheritDoc} */
			public Vector3f inverseN() { return clone().inverse(); }
			
			/*
			##########################
			##                      ##
			##  VECTOR ARITHMETICS  ##
			##                      ##
			##########################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec3f v) { return (double) getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ(); }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec3f v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			
			
			/** {@inheritDoc} */
			public double angleDeg(Vec3f v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
		 	
			
			/** {@inheritDoc} */
			public Vector3f normalizeN() { return clone().normalize(); }

			
		 	
		 	/** {@inheritDoc} */
		 	public Vector3f crossN(Vec3f v) { return clone().cross(v); }

			
			
			/** {@inheritDoc} */
			public Vector3f projectN(Vec3f v) { return clone().project(v); }
			
			
			
			/** {@inheritDoc} */
			public Vector3f reflectN(Vec3f normal) { return clone().reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length() { return Math.sqrt(squaredLength()); }
			
			/** {@inheritDoc} */
			public double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
			
			
			
			/** {@inheritDoc} */
			public Vector3f rotateN(Vec3f axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3f rotateN(Vec3f axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3f rotateN(Quaternion q) { return clone().rotate(q); }
		 	
			
			/*
			#######################
			##                   ##
			##  OBJECT OVERRIDE  ##
			##                   ##
			#######################
			 */
			
			/** {@inheritDoc} */
			@Override
			public Vector3f clone() { return new Vector3f(this); }

			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec3f(" + getX() + "f, " + getY() + "f, " + getZ() + "f)"; }
		};
	}
	
}
