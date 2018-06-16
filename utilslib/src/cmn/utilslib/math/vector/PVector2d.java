
package cmn.utilslib.math.vector;


import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.api.Vec2d;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2fBase;

/** 
 * A persistent representation of a Vector2d
 * @category Vector
 * @author picatrix1899
 */
@SuppressWarnings("unused")
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
			#####################################
			##                                 ##
			##  BASIC ARITHMETICS WITH QUARRY  ##
			##                                 ##
			#####################################
			*/

			/** {@inheritDoc} */
		 	public Vec2d add(Vec2fBase v, Vec2d r) { return r.set(getX() + v.getX(), getY() + v.getY()); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d add(Vec2dBase v, Vec2d r) { return r.set(getX() + v.getX(), getY() + v.getY()); }
		 	
			/** {@inheritDoc} */
		 	public Vec2d add(Vector2f v, Vec2d r) { return r.set(getX() + v.x, getY() + v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d add(Vector2d v, Vec2d r) { return r.set(getX() + v.x, getY() + v.y); }

		 	/** {@inheritDoc} */
		 	public Vec2d add(float scalar, Vec2d r) { return r.set(getX() + scalar, getY() + scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d add(double scalar, Vec2d r) { return r.set(getX() + scalar, getY() + scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d add(float x, float y, Vec2d r) { return r.set(getX() + x, getY() + y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d add(double x, double y, Vec2d r) { return r.set(getX() + x, getY() + y); }
			
			/** {@inheritDoc} */
		 	public Vector2d add(Vec2fBase v, Vector2d r) { r.x = getX() + v.getX(); r.y = getY() + v.getY(); return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(Vec2dBase v, Vector2d r) { r.x = getX() + v.getX(); r.y = getY() + v.getY(); return r; }

			/** {@inheritDoc} */
		 	public Vector2d add(Vector2f v, Vector2d r) { r.x = getX() + v.x; r.y = getY() + v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(Vector2d v, Vector2d r) { r.x = getX() + v.x; r.y = getY() + v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(float scalar, Vector2d r) { r.x = getX() + scalar; r.y = getY() + scalar; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(double scalar, Vector2d r) { r.x = getX() + scalar; r.y = getY() + scalar; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(float x, float y, Vector2d r) { r.x = getX() + x; r.y = getY() + y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d add(double x, double y, Vector2d r) { return r.set(this).add(x, y); }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(Vec2fBase v, Vec2d r) { return r.set(getX() - v.getX(), getY() - v.getY()); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(Vec2dBase v, Vec2d r) { return r.set(getX() - v.getX(), getY() - v.getY()); }

		 	/** {@inheritDoc} */
		 	public Vec2d sub(Vector2f v, Vec2d r) { return r.set(getX() - v.x, getY() - v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(Vector2d v, Vec2d r) { return r.set(getX() - v.x, getY() - v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(float scalar, Vec2d r) { return r.set(getX() - scalar, getY() - scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(double scalar, Vec2d r) { return r.set(getX() - scalar, getY() - scalar);  }	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(float x, float y, Vec2d r) { return r.set(getX() - x, getY() - y);  }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d sub(double x, double y, Vec2d r) { return r.set(getX() - x, getY() - y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(Vec2fBase v, Vector2d r) { r.x = getX() - v.getX(); r.y = getY() - v.getY(); return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(Vec2dBase v, Vector2d r) { r.x = getX() - v.getX(); r.y = getY() - v.getY(); return r; }

		 	/** {@inheritDoc} */
		 	public Vector2d sub(Vector2f v, Vector2d r) { r.x = getX() - v.x; r.y = getY() - v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(Vector2d v, Vector2d r) { r.x = getX() - v.x; r.y = getY() - v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(float scalar, Vector2d r) { r.x = getX() - scalar; r.y = getY() - scalar; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(double scalar, Vector2d r) { r.x = getX() - scalar; r.y = getY() - scalar; return r; }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(float x, float y, Vector2d r) { r.x = getX() - x; r.y = getY() - y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d sub(double x, double y, Vector2d r) { r.x = getX() - x; r.y = getY() - y; return r; }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(Vec2fBase v, Vec2d r) { return r.set(getX() * v.getX(), getY() * v.getY()); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(Vec2dBase v, Vec2d r) { return r.set(getX() * v.getX(), getY() * v.getY()); }

		 	/** {@inheritDoc} */
		 	public Vec2d mul(Vector2f v, Vec2d r) { return r.set(getX() * v.x, getY() * v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(Vector2d v, Vec2d r) { return r.set(getX() * v.x, getY() * v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(float scalar, Vec2d r) { return r.set(getX() * scalar, getY() * scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(double scalar, Vec2d r) { return r.set(getX() * scalar, getY() * scalar);  }	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(float x, float y, Vec2d r) { return r.set(getX() * x, getY() * y);  }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d mul(double x, double y, Vec2d r) { return r.set(getX() * x, getY() * y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(Vec2fBase v, Vector2d r) { r.x = getX() * v.getX(); r.y = getY() * v.getY(); return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(Vec2dBase v, Vector2d r) { r.x = getX() * v.getX(); r.y = getY() * v.getY(); return r; }

		 	/** {@inheritDoc} */
		 	public Vector2d mul(Vector2f v, Vector2d r) { r.x = getX() * v.x; r.y = getY() * v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(Vector2d v, Vector2d r) { r.x = getX() * v.x; r.y = getY() * v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(float scalar, Vector2d r) { r.x = getX() * scalar; r.y = getY() * scalar; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(double scalar, Vector2d r) { r.x = getX() * scalar; r.y = getY() * scalar; return r; }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(float x, float y, Vector2d r) { r.x = getX() * x; r.y = getY() * y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d mul(double x, double y, Vector2d r) { r.x = getX() * x; r.y = getY() * y; return r; }
			
		 	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(Vec2fBase v, Vec2d r) { return r.set(getX() / v.getX(), getY() / v.getY()); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(Vec2dBase v, Vec2d r) { return r.set(getX() / v.getX(), getY() / v.getY()); }

		 	/** {@inheritDoc} */
		 	public Vec2d div(Vector2f v, Vec2d r) { return r.set(getX() / v.x, getY() / v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(Vector2d v, Vec2d r) { return r.set(getX() / v.x, getY() / v.y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(float scalar, Vec2d r) { return r.set(getX() / scalar, getY() / scalar); }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(double scalar, Vec2d r) { return r.set(getX() / scalar, getY() / scalar);  }	
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(float x, float y, Vec2d r) { return r.set(getX() / x, getY() / y);  }
		 	
		 	/** {@inheritDoc} */
		 	public Vec2d div(double x, double y, Vec2d r) { return r.set(getX() / x, getY() / y); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(Vec2fBase v, Vector2d r) { r.x = getX() / v.getX(); r.y = getY() / v.getY(); return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(Vec2dBase v, Vector2d r) { r.x = getX() / v.getX(); r.y = getY() / v.getY(); return r; }

		 	/** {@inheritDoc} */
		 	public Vector2d div(Vector2f v, Vector2d r) { r.x = getX() / v.x; r.y = getY() / v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(Vector2d v, Vector2d r) { r.x = getX() / v.x; r.y = getY() / v.y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(float scalar, Vector2d r) { r.x = getX() / scalar; r.y = getY() / scalar; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(double scalar, Vector2d r) { r.x = getX() / scalar; r.y = getY() / scalar; return r; }	
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(float x, float y, Vector2d r) { r.x = getX() / x; r.y = getY() / y; return r; }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d div(double x, double y, Vector2d r) { r.x = getX() / x; r.y = getY() / y; return r; }
		 	
		 	
		 	
		 	/** {@inheritDoc} */
			public Vec2d invertFrom(Vec2fBase v, Vec2d r) { return r.set(this).invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vec2d invertFrom(Vec2dBase v, Vec2d r) { return r.set(this).invertFrom(v); }

			/** {@inheritDoc} */
			public Vec2d invertFrom(float max, Vec2d r) { return r.set(this).invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vec2d invertFrom(double max, Vec2d r) { return r.set(this).invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vec2d invertFrom(float x, float y, Vec2d r) { return r.set(this).invertFrom(x, y); }
			
			/** {@inheritDoc} */
			public Vec2d invertFrom(double x, double y, Vec2d r) { return r.set(this).invertFrom(x, y); }
			
		 	/** {@inheritDoc} */
			public Vector2d invertFrom(Vec2fBase v, Vector2d r) { return r.set(this).invertFrom(v); }

			/** {@inheritDoc} */
			public Vector2d invertFrom(Vec2dBase v, Vector2d r) { return r.set(this).invertFrom(v); }
			
			/** {@inheritDoc} */
			public Vector2d invertFrom(float max, Vector2d r) { return r.set(this).invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2d invertFrom(double max, Vector2d r) { return r.set(this).invertFrom(max); }
			
			/** {@inheritDoc} */
			public Vector2d invertFrom(float x, float y, Vector2d r) { return r.set(this).invertFrom(x, y); }
			
			/** {@inheritDoc} */
			public Vector2d invertFrom(double x, double y, Vector2d r) { return r.set(this).invertFrom(x, y); }
			
			
			
			/** {@inheritDoc} */
			public Vec2d negate(Vec2d r) { return r.set(this).negate(); }

			/** {@inheritDoc} */
			public Vec2d inverse(Vec2d r) { return r.set(this).inverse(); }
			
			/** {@inheritDoc} */
			public Vector2d negate(Vector2d r) { return r.set(this).negate(); }
			
			/** {@inheritDoc} */
			public Vector2d inverse(Vector2d r) { return r.set(this).inverse(); }
			
			/*
			######################################
			##                                  ##
			##  BASIC ARITHMETICS WITH CLONING  ##
			##                                  ##
			######################################
			*/

			/** {@inheritDoc} */
		 	public Vector2d addN(Vec2fBase v) { return clone().add(v); }
		 	
		 	/** {@inheritDoc} */
		 	public Vector2d addN(Vec2dBase v) { return clone().add(v); }

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
			######################################
			##                                  ##
			##  VECTOR ARITHMETICS WITH QUARRY  ##
			##                                  ##
			######################################
			 */

		 	/** {@inheritDoc} */
			public double dot(Vec2fBase v, double[] r) { return r[0] = (double) getX() * v.getX() + getY() * v.getY(); }
			
			/** {@inheritDoc} */
			public double dot(Vec2dBase v, double[] r) { return r[0] = (double) getX() * v.getX() + getY() * v.getY(); }
			
		 	/** {@inheritDoc} */
			public double dot(Vector2f v, double[] r) { return r[0] = (double) getX() * v.x + getY() * v.y; }
			
			/** {@inheritDoc} */
			public double dot(Vector2d v, double[] r) { return r[0] = (double) getX() * v.x + getY() * v.y; }
			
			
			
			/** {@inheritDoc} */
			public double angleRad(Vec2fBase v, double[] r)
			{ return r[0] = Math.acos((getX() * v.getX() + getY() * v.getY()) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY()))); }
			
			/** {@inheritDoc} */
			public double angleRad(Vec2dBase v, double[] r)
			{ return r[0] = Math.acos((getX() * v.getX() + getY() * v.getY()) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY()))); }
			
			/** {@inheritDoc} */
			public double angleRad(Vector2f v, double[] r)
			{ return r[0] = Math.acos((getX() * v.x + getY() * v.y) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.x * v.x + v.y * v.y))); }
			
			/** {@inheritDoc} */
			public double angleRad(Vector2d v, double[] r)
			{ return r[0] = Math.acos((getX() * v.x + getY() * v.y) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.x * v.x + v.y * v.y))); }
			
			/** {@inheritDoc} */
			public double angleDeg(Vec2fBase v, double[] r)
			{ return r[0] = Math.acos((getX() * v.getX() + getY() * v.getY()) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY()))) * Maths.RAD_TO_DEG; }
			
			/** {@inheritDoc} */
			public double angleDeg(Vec2dBase v, double[] r)
			{ return r[0] = Math.acos((getX() * v.getX() + getY() * v.getY()) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY()))) * Maths.RAD_TO_DEG; }
			
			/** {@inheritDoc} */
			public double angleDeg(Vector2f v, double[] r)
			{ return r[0] = Math.acos((getX() * v.x + getY() * v.x) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.x * v.x + v.y * v.y))) * Maths.RAD_TO_DEG; }
			
			/** {@inheritDoc} */
			public double angleDeg(Vector2d v, double[] r)
			{ return r[0] = Math.acos((getX() * v.x + getY() * v.x) /
									  (Math.sqrt(getX() * getX() + getY() * getY()) * Math.sqrt(v.x * v.x + v.y * v.y))) * Maths.RAD_TO_DEG; }
			
		 	
			/** {@inheritDoc} */
			public Vec2d normalize(Vec2d r) { return r.set(this).normalize(); }
			
			/** {@inheritDoc} */
			public Vector2d normalize(Vector2d r) { return r.set(this).normalize(); }
			
			
			
			/** {@inheritDoc} */
			public Vec2d reflect(Vec2fBase normal, Vec2d r) { return r.set(this).reflect(normal); }
			
			/** {@inheritDoc} */
			public Vec2d reflect(Vec2dBase normal, Vec2d r) { return r.set(this).reflect(normal); }
			
			/** {@inheritDoc} */
			public Vector2d reflect(Vec2fBase normal, Vector2d r) { return r.set(this).reflect(normal); }
			
			/** {@inheritDoc} */
			public Vector2d reflect(Vec2dBase normal, Vector2d r) { return r.set(this).reflect(normal); }

			
			
		 	/** {@inheritDoc} */
			public double length(double[] r) { return r[0] = Math.sqrt(getX() * getX() + getY() * getY()); }
			
			/** {@inheritDoc} */
			public double squaredLength(double[] r) { return r[0] = getX() * getX() + getY() * getY(); }
			
			
			
			/** {@inheritDoc} */
			public Vec2d rotate(Vec2fBase axis, float angle, Vec2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vec2d rotate(Vec2dBase axis, float angle, Vec2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vec2d rotate(Vec2fBase axis, double angle, Vec2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vec2d rotate(Vec2dBase axis, double angle, Vec2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vec2d rotate(Quaternion q, Vec2d r) { return r.set(this).rotate(q); }
			
			/** {@inheritDoc} */
			public Vector2d rotate(Vec2fBase axis, float angle, Vector2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotate(Vec2dBase axis, float angle, Vector2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotate(Vec2fBase axis, double angle, Vector2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotate(Vec2dBase axis, double angle, Vector2d r) { return r.set(this).rotate(axis, angle); }
			
			/** {@inheritDoc} */
			public Vector2d rotate(Quaternion q, Vector2d r) { return r.set(this).rotate(q); }
			
			/*
			######################################
			##                                  ##
			##  VECTOR ARITHMETICS WITH CLONING ##
			##                                  ##
			######################################
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
			########################################
			##                                    ##
			##  VECTOR INTERPOLATION WITH QUERRY  ##
			##                                    ##
			########################################
			 */

			/** {@inheritDoc} */
			public Vec2d lerp(Vec2fBase v, float f, Vec2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d lerp(Vec2dBase v, float f, Vec2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d lerp(Vec2fBase v, double f, Vec2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d lerp(Vec2dBase v, double f, Vec2d r) { return r.set(this).lerp(v, f); }

			/** {@inheritDoc} */
			public Vector2d lerp(Vec2fBase v, float f, Vector2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerp(Vec2dBase v, float f, Vector2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerp(Vec2fBase v, double f, Vector2d r) { return r.set(this).lerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d lerp(Vec2dBase v, double f, Vector2d r) { return r.set(this).lerp(v, f); }
			
			
			
			/** {@inheritDoc} */
			public Vec2d slerp(Vec2fBase v, float f, Vec2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d slerp(Vec2dBase v, float f, Vec2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d slerp(Vec2fBase v, double f, Vec2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vec2d slerp(Vec2dBase v, double f, Vec2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerp(Vec2fBase v, float f, Vector2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerp(Vec2dBase v, float f, Vector2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerp(Vec2fBase v, double f, Vector2d r) { return r.set(this).slerp(v, f); }
			
			/** {@inheritDoc} */
			public Vector2d slerp(Vec2dBase v, double f, Vector2d r) { return r.set(this).slerp(v, f); }
			
			/*
			#########################################
			##                                     ##
			##  VECTOR INTERPOLATION WITH CLONING  ##
			##                                     ##
			#########################################
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
