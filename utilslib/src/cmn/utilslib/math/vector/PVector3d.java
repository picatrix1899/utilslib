
package cmn.utilslib.math.vector;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3d implements Vec3dBase
{

	public abstract Vector3d clone();
	
	/** generates a new persistent vector2f */
	public static PVector3d gen(final double x, final double y, final double z)
	{
		return new PVector3d()
		{
			
			/*
			###############
			##           ##
			##  GETTERS  ##
			##           ##
			###############
			 */
			
			/** {@inheritDoc} */
			public double getX() { return x; }
			
			/** {@inheritDoc} */
			public double getY() { return y; }
			
			/** {@inheritDoc} */
			public double getZ() { return z; }
			
			
			
			/** {@inheritDoc} */
			public double get(int index)
			{
				switch(index)
				{
					case 0: return x;
					case 1: return y;
				}
				
				return Float.NaN;
			}

			/*
			#########################
			##                     ##
			##  BASIC ARITHMETICS  ##
			##                     ##
			#########################
			*/

			/** {@inheritDoc} */
		 	public Vector3d addN(Vec3fBase v) { return clone().add(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d addN(Vec3dBase v) { return clone().add(v); }

		 	/** {@inheritDoc} */
		 	public Vector3d addN(float scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d addN(double scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d addN(float x, float y, float z) { return clone().add(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d addN(double x, double y, double z) { return clone().add(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d subN(Vec3fBase v) { return clone().sub(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d subN(Vec3dBase v) { return clone().sub(v); }

		 	/** {@inheritDoc} */
		 	public Vector3d subN(float scalar) { return clone().sub(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d subN(double scalar) { return clone().sub(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d subN(double x, double y, double z) { return clone().sub(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d mulN(Vec3fBase v) { return clone().mul(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d mulN(Vec3dBase v) { return clone().mul(v); }

		 	/** {@inheritDoc} */
		 	public Vector3d mulN(float scalar) { return clone().mul(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d mulN(double scalar) { return clone().mul(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d divN(Vec3fBase v) { return clone().div(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d divN(Vec3dBase v) { return clone().div(v); }

		 	/** {@inheritDoc} */
		 	public Vector3d divN(float scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d divN(double scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d divN(float x, float y, float z) { return clone().div(x, y, z); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d divN(double x, double y, double z) { return clone().div(x, y, z); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vector3d invertFromN(Vec3fBase v) { return clone().invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector3d invertFromN(Vec3dBase v) { return clone().invertFrom(v); }

			/** {@inheritDoc} */
			public Vector3d invertFromN(float max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector3d invertFromN(double max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector3d invertFromN(float x, float y, float z) { return clone().invertFrom(x, y, z); }
			
			/** {@inheritDoc} */
			public Vector3d invertFromN(double x, double y, double z) { return clone().invertFrom(x, y, z); }

			
			
			/** {@inheritDoc} */
			public Vector3d negateN() { return clone().negate(); }
			
			
			
			/** {@inheritDoc} */
			public Vector3d inverseN() { return clone().inverse(); }
			
			/*
			##########################
			##                      ##
			##  VECTOR ARITHMETICS  ##
			##                      ##
			##########################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec3fBase v) { return (double) getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ(); }
			
			/** {@inheritDoc} */
			public double dot(Vec3dBase v) { return (double) getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ(); }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			/** {@inheritDoc} */
			public double angleRad(Vec3dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			
			
			/** {@inheritDoc} */
			public double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
			/** {@inheritDoc} */
			public double angleDeg(Vec3dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
		 	
			
			/** {@inheritDoc} */
			public Vector3d normalizeN() { return clone().normalize(); }

			
		 	
		 	/** {@inheritDoc} */
		 	public Vector3d crossN(Vec3fBase v) { return clone().cross(v); }
			
			/** {@inheritDoc} */
			public Vector3d crossN(Vec3dBase v) { return clone().cross(v); }

			
			
			/** {@inheritDoc} */
			public Vector3d projectN(Vec3fBase v) { return clone().project(v); }
			
			/** {@inheritDoc} */
			public Vector3d projectN(Vec3dBase v) { return clone().project(v); }
			
			
			
			/** {@inheritDoc} */
			public Vector3d reflectN(Vec3fBase normal) { return clone().reflect(normal); }
			
			/** {@inheritDoc} */
			public Vector3d reflectN(Vec3dBase normal) { return clone().reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length() { return Math.sqrt(squaredLength()); }
			
			/** {@inheritDoc} */
			public double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
			
			
			
			/** {@inheritDoc} */
			public Vector3d rotateN(Vec3fBase axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3d rotateN(Vec3dBase axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3d rotateN(Vec3fBase axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3d rotateN(Vec3dBase axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector3d rotateN(Quaternion q) { return clone().rotate(q); }
		 	
			/*
			############################
			##                        ##
			##  VECTOR INTERPOLATION  ##
			##                        ##
			############################
			 */

			/** {@inheritDoc} */
			public Vector3d lerpN(Vec3fBase v, float f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d lerpN(Vec3dBase v, float f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d lerpN(Vec3fBase v, double f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d lerpN(Vec3dBase v, double f) { return clone().lerp(v, f); }

			
			
			/** {@inheritDoc} */
			public Vector3d slerpN(Vec3fBase v, float f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d slerpN(Vec3dBase v, float f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d slerpN(Vec3fBase v, double f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector3d slerpN(Vec3dBase v, double f) { return clone().slerp(v, f); }
			
			/*
			#######################
			##                   ##
			##  OBJECT OVERRIDE  ##
			##                   ##
			#######################
			 */
			
			/** {@inheritDoc} */
			@Override
			public Vector3d clone() { return new Vector3d(this); }

			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec3f(" + getX() + "f, " + getY() + "f, " + getZ() + "f)"; }
		};
	}
	
}
