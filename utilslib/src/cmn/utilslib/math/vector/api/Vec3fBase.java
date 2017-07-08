/*
 * 
 * IF ANYONE HAS THE NUTS TO BREAK THIS INTERFACE BE SURE YOU HAD YOUR NUTS THE LONGEST TIME!!!
 * 
 */

package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.vector.PVector3f;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public interface Vec3fBase extends Vecf, Tup3fBase
{
	
	/*
	#################
	##             ##
	##  ITERATION  ##
	##             ##
	#################
	 */
	
	/** The Count of Dimensions of the Vector. Used for Iterations. */
	static int DIMENSIONS = 3;
	
	
	
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return DIMENSIONS; }
	
	
	
	/** Returns the Dimension by Index. */
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: return 0.0f;
		}
	}

	/*
	########################
	##                    ##
	##  CONSTANT VECTORS  ##
	##                    ##
	########################
	 */
	
	/** Default Vector all initialized by 0 */
	static final PVector3f ZERO =		PVector3f.gen(0.0f, 0.0f, 0.0f);
	
	/** Default Vector all initialized by 1 */
	static final PVector3f ONE =		PVector3f.gen(1.0f, 1.0f, 1.0f);
	
	/*
	####################
	##                ##
	##  AXIS-NORMALS  ##
	##                ##
	####################
	 */
	
	/** The positive X-Axis-Normal */
	static final PVector3f aX =			PVector3f.gen(1.0f                    , 0.0f                    , 0.0f                    );
	
	/** The positive Y-Axis-Normal */
	static final PVector3f aY =			PVector3f.gen(0.0f                    , 1.0f                    , 0.0f                    );
	
	/** The positive Z-Axis-Normal */
	static final PVector3f aZ =			PVector3f.gen(0.0f                    , 0.0f                    , 1.0f                    );
	
	
	
	/** The positive XY-Axis-Normal */
	static final PVector3f aXY =		PVector3f.gen((float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 , 0.0f                    );
	
	/** The positive XZ-Axis-Normal */
	static final PVector3f aXZ =		PVector3f.gen((float) Maths.INV_SQRT2 , 0.0f                    , (float) Maths.INV_SQRT2 );
	
	/** The positive YZ-Axis-Normal */
	static final PVector3f aYZ =		PVector3f.gen(0.0f                    , (float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );
	
	
	
	/** The positive XYZ-Axis-Normal */
	static final PVector3f aXYZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 );
	
	
	
	/** The negative X-Axis-Normal */
	static final PVector3f aNX =		PVector3f.gen(-1.0f                   ,  0.0f                   ,  0.0f                   );
	
	/** The negative Y-Axis-Normal */
	static final PVector3f aNY =		PVector3f.gen( 0.0f                   , -1.0f                   ,  0.0f                   );
	
	/** The negative Z-Axis-Normal */
	static final PVector3f aNZ =		PVector3f.gen( 0.0f                   ,  0.0f                   , -1.0f                   );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Y-Axis */
	static final PVector3f aNXY =		PVector3f.gen((float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 , 0.0f                    );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3f aXNY =		PVector3f.gen((float) Maths.INV_SQRT2 , (float) -Maths.INV_SQRT2, 0.0f                    );
	
	/** The negative XY-Axis-Normal */
	static final PVector3f aNXNY =		PVector3f.gen((float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2, 0.0f                    );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Z-Axis */
	static final PVector3f aNXZ =		PVector3f.gen((float) -Maths.INV_SQRT2, 0.0f                    , (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3f aXNZ =		PVector3f.gen((float) Maths.INV_SQRT2 , 0.0f                    , (float) -Maths.INV_SQRT2);
	
	/** The negative XZ-Axis-Normal */
	static final PVector3f aNXNZ =		PVector3f.gen((float) -Maths.INV_SQRT2, 0.0f                    , (float) -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative Y-Axis and positive Z-Axis */
	static final PVector3f aNYZ =		PVector3f.gen(0.0f                    , (float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive Y-Axis and negative Z-Axis */
	static final PVector3f aYNZ =		PVector3f.gen(0.0f                    , (float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );
	
	/** The negative YZ-Axis-Normal */
	static final PVector3f aNYNZ =		PVector3f.gen(0.0f                    , (float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and positive Z-Axis */
	static final PVector3f aNXYZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3f aXNYZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3f aXYNZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of negative X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3f aNXNYZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3f aNXYNZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and negative Z-Axis */
	static final PVector3f aXNYNZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3);
	
	/** The negative XYZ-Axis-Normal */
	static final PVector3f aNXNYNZ =	PVector3f.gen((float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3);

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
	
	/** Returns the Z-Dimension */
	float getZ();

	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec3f addN(Vec3fBase v);
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec3f addN(Vec3dBase v);
	
	/** Returns a clone of the Vector with addition of the Tuple t */
	Vec3f addN(Tup3fBase t);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3f addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3f addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3f addN(float x, float y, float z);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3f addN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec3f subN(Vec3fBase v);
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec3f subN(Vec3dBase v);
	
	/** Returns a clone of the Vector with subtraction of the Tuple t */
	Vec3f subN(Tup3fBase t);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3f subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3f subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3f subN(float x, float y, float z);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3f subN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec3f mulN(Vec3fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec3f mulN(Vec3dBase v);
	
	/** Returns a clone of the Vector with multiplication of the Tuple t */
	Vec3f mulN(Tup3fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3f mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3f mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3f mulN(float x, float y, float z);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3f mulN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec3f divN(Vec3fBase v);
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec3f divN(Vec3dBase v);
	
	/** Returns a clone of the Vector with division of the Tuple t */
	Vec3f divN(Tup3fBase v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3f divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3f divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3f divN(float x, float y, float z);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3f divN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec3f invertFromN(Vec3fBase v);
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec3f invertFromN(Vec3dBase v);
	
	/** Returns a clone of the Vector with invertion based on the Tuple t (i.e. out.x = t.x - this.x) */
	Vec3f invertFromN(Tup3fBase t);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec3f invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec3f invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec3f invertFromN(float x, float y, float z);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec3f invertFromN(double x ,double y, double z);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec3f inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec3f negateN();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Return a normalized clone of the Vector */
	Vec3f normalizeN();
	
	
	
	/** Returns a new Vector with the Cross-Product from this Vector with the Vector v */
	Vec3f crossN(Vec3fBase v);
	
	/** Returns a new Vector with the Cross-Product from this Vector with the Vector v */
	Vec3f crossN(Vec3dBase v);
	
	
	
	/** Returns a new Vector with the Projection of this Vector on the Vector v */
	Vec3f projectN(Vec3fBase v);
	
	/** Returns a new Vector with the Projection of this Vector on the Vector v */
	Vec3f projectN(Vec3dBase v);
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec3f reflectN(Vec3fBase normal);
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec3f reflectN(Vec3dBase normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3fBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3dBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3fBase axis, double angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3dBase axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec3f rotateN(Quaternion q);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec3fBase v);
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec3dBase v);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec3fBase v);
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec3dBase v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec3fBase v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec3dBase v);

	
	
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
	Vec3f lerpN(Vec3fBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f lerpN(Vec3dBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f lerpN(Vec3fBase v, double f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f lerpN(Vec3dBase v, double f);
	
	
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f slerpN(Vec3fBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f slerpN(Vec3dBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f slerpN(Vec3fBase v, double f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3f slerpN(Vec3dBase v, double f);
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** Returns a clone of the Vector */
	Vec3f clone();

}
