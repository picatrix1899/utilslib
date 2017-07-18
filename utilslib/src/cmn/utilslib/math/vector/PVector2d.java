
package cmn.utilslib.math.vector;


import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2fBase;

/** 
 * A persistent representation of a Vector2d
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector2d implements Vec2dBase
{

	/** {@inheritDoc} */ @Override
	public Vector2d clone() { return new Vector2d(this); }


	/** generates a new persistent Vector2d */
	public static PVector2d gen(final double x, final double y)
	{
		
		
		return new PVector2d()
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
			public double getA() { return x; }
			
			/** {@inheritDoc} */
			public double getB() { return y; }

			/*
			#########################
			##                     ##
			##  BASIC ARITHMETICS  ##
			##                     ##
			#########################
			*/

			/** {@inheritDoc} */
		 	public Vector2d addN(Vec2fBase v) { return clone().add(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(Vec2dBase v) { return clone().add(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(Tup2fBase t) { return clone().add(t); }

		 	/** {@inheritDoc} */
		 	public Vector2d addN(Tup2dBase t) { return clone().add(t); }

		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(float scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(double scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(float x, float y) { return clone().add(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(double x, double y) { return clone().add(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(Vec2fBase v) { return clone().sub(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(Vec2dBase v) { return clone().sub(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(Tup2fBase t) { return clone().sub(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(Tup2dBase t) { return clone().sub(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(float scalar) { return clone().sub(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(double scalar) { return clone().sub(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(float x, float y) { return clone().sub(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d subN(double x, double y) { return clone().sub(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(Vec2fBase v) { return clone().mul(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(Vec2dBase v) { return clone().mul(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(Tup2fBase t) { return clone().mul(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(Tup2dBase t) { return clone().mul(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(float scalar) { return clone().mul(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(double scalar) { return clone().mul(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(float x, float y) { return clone().mul(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mulN(double x, double y) { return clone().mul(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(Vec2fBase v) { return clone().div(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(Vec2dBase v) { return clone().div(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(Tup2fBase t) { return clone().div(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(Tup2dBase t) { return clone().div(t); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(float scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(double scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(float x, float y) { return clone().div(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d divN(double x, double y) { return clone().div(x, y); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vector2d invertFromN(Vec2fBase v) { return clone().invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(Vec2dBase v) { return clone().invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(Tup2fBase t) { return clone().invertFrom(t); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(Tup2dBase t) { return clone().invertFrom(t); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(float max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(double max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(float x, float y) { return clone().invertFrom(x, y); }
			
			/** {@inheritDoc} */
			public Vector2d invertFromN(double x, double y) { return clone().invertFrom(x, y); }

			
			
			/** {@inheritDoc} */
			public Vector2d negateN() { return clone().negate(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2d inverseN() { return clone().inverse(); }
			
			/*
			##########################
			##                      ##
			##  VECTOR ARITHMETICS  ##
			##                      ##
			##########################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec2fBase v) { return (double) getX() * v.getX() + getY() * v.getY(); }
			
			/** {@inheritDoc} */
			public double dot(Vec2dBase v) { return (double) getX() * v.getX() + getY() * v.getY(); }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec2fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			/** {@inheritDoc} */
			public double angleRad(Vec2dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			
			
			/** {@inheritDoc} */
			public double angleDeg(Vec2fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
			/** {@inheritDoc} */
			public double angleDeg(Vec2dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
		 	
			
			/** {@inheritDoc} */
			public Vector2d normalizeN() { return clone().normalize(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2d reflectN(Vec2fBase normal) { return clone().reflect(normal); }
			
			/** {@inheritDoc} */
			public Vector2d reflectN(Vec2dBase normal) { return clone().reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length() { return Math.sqrt(squaredLength()); }
			
			/** {@inheritDoc} */
			public double squaredLength() { return getX() * getX() + getY() * getY(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2d rotateN(Vec2fBase axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotateN(Vec2dBase axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotateN(Vec2fBase axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotateN(Vec2dBase axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotateN(Quaternion q) { return clone().rotate(q); }
		 	
			/*
			############################
			##                        ##
			##  VECTOR INTERPOLATION  ##
			##                        ##
			############################
			 */

			/** {@inheritDoc} */
			public Vector2d lerpN(Vec2fBase v, float f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerpN(Vec2dBase v, float f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerpN(Vec2fBase v, double f) { return clone().lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerpN(Vec2dBase v, double f) { return clone().lerp(v, f); }

			
			
			/** {@inheritDoc} */
			public Vector2d slerpN(Vec2fBase v, float f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerpN(Vec2dBase v, float f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerpN(Vec2fBase v, double f) { return clone().slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerpN(Vec2dBase v, double f) { return clone().slerp(v, f); }
			
			/*
			#######################
			##                   ##
			##  OBJECT OVERRIDE  ##
			##                   ##
			#######################
			 */
			
			/** {@inheritDoc} */
			@Override
			public Vector2d clone() { return new Vector2d(this); }

			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec2d(" + getX() + "f, " + getY() + "f, "; }
			
		};
	}
	
}
