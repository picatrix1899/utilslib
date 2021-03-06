
package cmn.utilslib.math.vector;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec2f;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector2f implements Vec2f
{

	/** {@inheritDoc} */ @Override
	public Vector2f clone() { return new Vector2f(this); }


	/** generates a new persistent vector2f */
	public static PVector2f gen(final float x, final float y)
	{
		return new PVector2f()
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

			
			/*
			#########################
			##                     ##
			##  BASIC ARITHMETICS  ##
			##                     ##
			#########################
			*/

			/** {@inheritDoc} */
		 	public Vector2f addN(Vec2f v) { return clone().add(v); }

		 	/** {@inheritDoc} */
		 	public Vector2f addN(float scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f addN(double scalar) { return clone().add(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f addN(float x, float y) { return clone().add(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f addN(double x, double y) { return clone().add(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f subN(Vec2f v) { return clone().sub(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f subN(float scalar) { return clone().sub(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f subN(double scalar) { return clone().sub(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f subN(float x, float y) { return clone().sub(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f subN(double x, double y) { return clone().sub(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f mulN(Vec2f v) { return clone().mul(v); }

		 	/** {@inheritDoc} */
		 	public Vector2f mulN(float scalar) { return clone().mul(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f mulN(double scalar) { return clone().mul(scalar); }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f mulN(double x, double y) { return clone().mul(x, y); }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f divN(Vec2f v) { return clone().div(v); }

		 	/** {@inheritDoc} */
		 	public Vector2f divN(float scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f divN(double scalar) { return clone().div(scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f divN(float x, float y) { return clone().div(x, y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2f divN(double x, double y) { return clone().div(x, y); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vector2f invertFromN(Vec2f v) { return clone().invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector2f invertFromN(float max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2f invertFromN(double max) { return clone().invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2f invertFromN(float x, float y) { return clone().invertFrom(x, y); }
			
			/** {@inheritDoc} */
			public Vector2f invertFromN(double x, double y) { return clone().invertFrom(x, y); }

			
			
			/** {@inheritDoc} */
			public Vector2f negateN() { return clone().negate(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2f inverseN() { return clone().inverse(); }
			
			/*
			##########################
			##                      ##
			##  VECTOR ARITHMETICS  ##
			##                      ##
			##########################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec2f v) { return (double) getX() * v.getX() + getY() * v.getY(); }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec2f v) { return Math.acos((dot(v)) / (length() * v.length())); }
			
			
			
			/** {@inheritDoc} */
			public double angleDeg(Vec2f v) { return angleRad(v) * Maths.RAD_TO_DEG; }
			
		 	
			
			/** {@inheritDoc} */
			public Vector2f normalizeN() { return clone().normalize(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2f reflectN(Vec2f normal) { return clone().reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length() { return Math.sqrt(squaredLength()); }
			
			/** {@inheritDoc} */
			public double squaredLength() { return getX() * getX() + getY() * getY(); }
			
			
			
			/** {@inheritDoc} */
			public Vector2f rotateN(Vec2f axis, float angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2f rotateN(Vec2f axis, double angle) { return clone().rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2f rotateN(Quaternion q) { return clone().rotate(q); }
			
			/*
			#######################
			##                   ##
			##  OBJECT OVERRIDE  ##
			##                   ##
			#######################
			 */
			
			/** {@inheritDoc} */
			@Override
			public Vector2f clone() { return new Vector2f(this); }

			/** {@inheritDoc} */
			@Override
			public String toString() { return "PVec2f(" + getX() + "f, " + getY() + "f)"; }
			
		};
	}
	
}
