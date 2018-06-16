package cmn.utilslib.math.vector.api;


import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.vector.PVector2f;

public interface Vec2dBase extends Tup2dBase
{

	/*
	########################
	##                    ##
	##  CONSTANT VECTORS  ##
	##                    ##
	########################
	 */
	
	/** Default Vector all initialized by 0 */
	static final PVector2f ZERO =		PVector2f.gen(0.0f, 0.0f);
	
	/** Default Vector all initialized by 1 */
	static final PVector2f ONE =		PVector2f.gen(1.0f, 1.0f);
	
	/*
	####################
	##                ##
	##  AXIS-NORMALS  ##
	##                ##
	####################
	 */
	
	/** The positive X-Axis-Normal */
	static final PVector2f aX =			PVector2f.gen(1.0f                    , 0.0f                    );
	
	/** The positive Y-Axis-Normal */
	static final PVector2f aY =			PVector2f.gen(0.0f                    , 1.0f                    );
	
	
	
	/** The positive XY-Axis-Normal */
	static final PVector2f aXY =		PVector2f.gen((float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );

	
	
	/** The negative X-Axis-Normal */
	static final PVector2f aNX =		PVector2f.gen(-1.0f                   ,  0.0f                   );

	/** The negative Y-Axis-Normal */
	static final PVector2f aNY =		PVector2f.gen( 0.0f                   , -1.0f                   );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Y-Axis */
	static final PVector2f aNXY =		PVector2f.gen((float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector2f aXNY =		PVector2f.gen((float) Maths.INV_SQRT2 , (float) -Maths.INV_SQRT2);
	
	/** The negative XY-Axis-Normal */
	static final PVector2f aNXNY =		PVector2f.gen((float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2);

	/*
	###############
	##           ##
	##  GETTERS  ##
	##           ##
	###############
	 */
	
	/** Returns the X-Dimension */
	double getX();
	
	/** Returns the Y-Dimension */
	double getY();

	/** Returns the Dimension by Index. */
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: return Float.NaN;
		}
	}
	
	/*
	####################################
	##                                ##
	##  BASIC ARITHMETICS WITH QUARRY ##
	##                                ##
	####################################
	 */
	
	/** Returns the addition of this and the Vector v as the Vector r */
	Vec2d add(Vec2fBase v, Vec2d r);
	
	/** Returns the addition of this and the Vector v as the Vector r */
	Vec2d add(Vec2dBase v, Vec2d r);
	
	/** Returns the addition of this and the Scalar scalar as the Vector r */
	Vec2d add(float scalar, Vec2d r);
	
	/** Returns the addition of this and the Scalar scalar as the Vector r */
	Vec2d add(double scalar, Vec2d r);
	
	/** Returns the addition of this and the Values x and y as the Vector r */
	Vec2d add(float x, float y, Vec2d r);
	
	/** Returns the addition of this and the Values x and y as the Vector r */
	Vec2d add(double x, double y, Vec2d r);
	
	
	
	/** Returns the subtraction of this and the Vector v as the Vector r */
	Vec2d sub(Vec2fBase v, Vec2d r);
	
	/** Returns the subtraction of this and the Vector v as the Vector r */
	Vec2d sub(Vec2dBase v, Vec2d r);
	
	/** Returns the subtraction of this and the Scalar scalar as the Vector r */
	Vec2d sub(float scalar, Vec2d r);
	
	/** Returns the subtraction of this and the Scalar scalar as the Vector r */
	Vec2d sub(double scalar, Vec2d r);
	
	/** Returns the subtraction of this and the Values x and y as the Vector r */
	Vec2d sub(float x, float y, Vec2d r);
	
	/** Returns the subtraction of this and the Values x and y as the Vector r */
	Vec2d sub(double x, double y, Vec2d r);
	
	
	
	/** Returns the multiplication of this and the Vector v as the Vector r */
	Vec2d mul(Vec2fBase v, Vec2d r);
	
	/** Returns the multiplication of this and the Vector v as the Vector r */
	Vec2d mul(Vec2dBase v, Vec2d r);
	
	/** Returns the multiplication of this and the Scalar scalar as the Vector r */
	Vec2d mul(float scalar, Vec2d r);
	
	/** Returns the multiplication of this and the Scalar scalar as the Vector r */
	Vec2d mul(double scalar, Vec2d r);
	
	/** Returns the multiplication of this and the Values x and y as the Vector r */
	Vec2d mul(float x, float y, Vec2d r);
	
	/** Returns the multiplication of this and the Values x and y as the Vector r */
	Vec2d mul(double x, double y, Vec2d r);
	
	
	
	/** Returns the division of this and the Vector v as the Vector r */
	Vec2d div(Vec2fBase v, Vec2d r);
	
	/** Returns the division of this and the Vector v as the Vector r */
	Vec2d div(Vec2dBase v, Vec2d r);
	
	/** Returns the division of this and the Scalar scalar as the Vector r */
	Vec2d div(float scalar, Vec2d r);
	
	/** Returns the division of this and the Scalar scalar as the Vector r */
	Vec2d div(double scalar, Vec2d r);
	
	/** Returns the division of this and the Values x and y as the Vector r */
	Vec2d div(float x, float y, Vec2d r);
	
	/** Returns the division of this and the Values x and y as the Vector r */
	Vec2d div(double x, double y, Vec2d r);
	
	
	
	/** Returns the invertion of this based on the Vector v (i.e. out.x = v.x - this.x) as Vector r */
	Vec2d invertFrom(Vec2fBase v, Vec2d r);
	
	/** Returns the invertion of this based on the Vector v (i.e. out.x = v.x - this.x) as Vector r */
	Vec2d invertFrom(Vec2dBase v, Vec2d r);
	
	/** Returns the invertion of this based on the Value max (i.e. out.x = max - this.x) as Vector r */
	Vec2d invertFrom(float max, Vec2d r);
	
	/** Returns the invertion of this based on the Value max (i.e. out.x = max - this.x) as Vector r */
	Vec2d invertFrom(double max, Vec2d r);
	
	/** Returns the invertion of this based on the Values x, y and z (i.e. out.x = x - this.x) as Vector r */
	Vec2d invertFrom(float x, float y, Vec2d r);
	
	/** Returns the invertion of this based on the Values x, y and z (i.e. out.x = x - this.x) as Vector r */
	Vec2d invertFrom(double x ,double y, Vec2d r);
	
	
	
	/** Returns the inversed Vector as Vector r */
	Vec2d inverse(Vec2d r);
	
	
	
	/** Returns the negated Vector as Vector r */
	Vec2d negate(Vec2d r);
	
	/*
	#####################################
	##                                 ##
	##  BASIC ARITHMETICS WITH CLONING ##
	##                                 ##
	#####################################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec2d addN(Vec2fBase v);
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec2d addN(Vec2dBase v);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2d addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2d addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec2d addN(float x, float y);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec2d addN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec2d subN(Vec2fBase v);
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec2d subN(Vec2dBase v);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2d subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2d subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec2d subN(float x, float y);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec2d subN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec2d mulN(Vec2fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec2d mulN(Vec2dBase v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2d mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2d mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec2d mulN(float x, float y);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec2d mulN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec2d divN(Vec2fBase v);
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec2d divN(Vec2dBase v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2d divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2d divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec2d divN(float x, float y);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec2d divN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec2d invertFromN(Vec2fBase v);
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec2d invertFromN(Vec2dBase v);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2d invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2d invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec2d invertFromN(float x, float y);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec2d invertFromN(double x ,double y);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec2d inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec2d negateN();
	
	/*
	#####################################
	##                                 ##
	##  VECTOR ARITHMETICS WITH QUARRY ##
	##                                 ##
	#####################################
	 */
	
	/** Return a normalized clone of the Vector */
	Vec2d normalize(Vec2d r);
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2d reflect(Vec2fBase normal, Vec2d r);
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2d reflect(Vec2dBase normal, Vec2d r);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotate(Vec2fBase axis, float angle, Vec2d r);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotate(Vec2dBase axis, float angle, Vec2d r);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotate(Vec2fBase axis, double angle, Vec2d r);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotate(Vec2dBase axis, double angle, Vec2d r);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec2d rotate(Quaternion q, Vec2d r);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec2fBase v, double[] r);
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec2dBase v, double[] r);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec2fBase v, double[] r);
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec2dBase v, double[] r);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec2fBase v, double[] r);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec2dBase v, double[] r);

	
	
	/** Returns the length of the Vector */
	double length(double[] r);
	
	/** Returns the squared length of the Vector */
	double squaredLength(double[] r);
	
	/*
	######################################
	##                                  ##
	##  VECTOR ARITHMETICS WITH CLONING ##
	##                                  ##
	######################################
	 */
	
	/** Return a normalized clone of the Vector */
	Vec2d normalizeN();
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2d reflectN(Vec2fBase normal);
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2d reflectN(Vec2dBase normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotateN(Vec2fBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotateN(Vec2dBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotateN(Vec2fBase axis, double angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2d rotateN(Vec2dBase axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec2d rotateN(Quaternion q);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec2fBase v);
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec2dBase v);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec2fBase v);
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec2dBase v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec2fBase v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec2dBase v);

	
	
	/** Returns the length of the Vector */
	double length();
	
	/** Returns the squared length of the Vector */
	double squaredLength();
	
	/*
	#######################################
	##                                   ##
	##  VECTOR INTERPOLATION WITH QUARRY ##
	##                                   ##
	#######################################
	 */
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerp(Vec2fBase v, float f, Vec2d r);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerp(Vec2dBase v, float f, Vec2d r);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerp(Vec2fBase v, double f, Vec2d r);
	
	/** Returns  a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerp(Vec2dBase v, double f, Vec2d r);
	
	
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerp(Vec2fBase v, float f, Vec2d r);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerp(Vec2dBase v, float f, Vec2d r);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerp(Vec2fBase v, double f, Vec2d r);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerp(Vec2dBase v, double f, Vec2d r);
	
	/*
	########################################
	##                                    ##
	##  VECTOR INTERPOLATION WITH CLONING ##
	##                                    ##
	########################################
	 */
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerpN(Vec2fBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerpN(Vec2dBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerpN(Vec2fBase v, double f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d lerpN(Vec2dBase v, double f);
	
	
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerpN(Vec2fBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerpN(Vec2dBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerpN(Vec2fBase v, double f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2d slerpN(Vec2dBase v, double f);
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** Returns a clone of the Vector */
	Vec2d clone();
	
}
