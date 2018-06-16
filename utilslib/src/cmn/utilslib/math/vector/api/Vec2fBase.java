package cmn.utilslib.math.vector.api;



import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.vector.PVector2f;

public interface Vec2fBase extends Tup2fBase
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
	float getX();
	
	/** Returns the Y-Dimension */
	float getY();

	/** Returns the Dimension by Index. */
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: return Float.NaN;
		}
	}
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec2f addN(Vec2fBase v);
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec2f addN(Vec2dBase v);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2f addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2f addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec2f addN(float x, float y);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec2f addN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec2f subN(Vec2fBase v);
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec2f subN(Vec2dBase v);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2f subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2f subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec2f subN(float x, float y);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec2f subN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec2f mulN(Vec2fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec2f mulN(Vec2dBase v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2f mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2f mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec2f mulN(float x, float y);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec2f mulN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec2f divN(Vec2fBase v);
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec2f divN(Vec2dBase v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2f divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2f divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec2f divN(float x, float y);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec2f divN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec2f invertFromN(Vec2fBase v);
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec2f invertFromN(Vec2dBase v);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2f invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2f invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec2f invertFromN(float x, float y);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec2f invertFromN(double x ,double y);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec2f inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec2f negateN();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Return a normalized clone of the Vector */
	Vec2f normalizeN();
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2f reflectN(Vec2fBase normal);
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2f reflectN(Vec2dBase normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2fBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2dBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2fBase axis, double angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2dBase axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec2f rotateN(Quaternion q);
	
	
	
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
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f lerpN(Vec2fBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f lerpN(Vec2dBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f lerpN(Vec2fBase v, double f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f lerpN(Vec2dBase v, double f);
	
	
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f slerpN(Vec2fBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f slerpN(Vec2dBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f slerpN(Vec2fBase v, double f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec2f slerpN(Vec2dBase v, double f);
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** Returns a clone of the Vector */
	Vec2f clone();
	
}
