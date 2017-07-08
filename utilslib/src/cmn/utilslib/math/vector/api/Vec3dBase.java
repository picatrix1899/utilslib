package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.PVector3d;

public interface Vec3dBase extends Vecd, Tup3dBase
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
	default double get(int index)
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
	static final PVector3d ZERO =		PVector3d.gen(0.0, 0.0, 0.0);
	
	/** Default Vector all initialized by 1 */
	static final PVector3d ONE =		PVector3d.gen(1.0, 1.0, 1.0);
	
	/*
	####################
	##                ##
	##  AXIS-NORMALS  ##
	##                ##
	####################
	 */
	
	/** The positive X-Axis-Normal */
	static final PVector3d aX =			PVector3d.gen(1.0              , 0.0              , 0.0              );
	
	/** The positive Y-Axis-Normal */
	static final PVector3d aY =			PVector3d.gen(0.0              , 1.0              , 0.0              );
	
	/** The positive Z-Axis-Normal *
	static final PVector3d aZ =			PVector3d.gen(0.0              , 0.0              , 1.0              );
	
	
	
	/** The positive XY-Axis-Normal */
	static final PVector3d aXY =		PVector3d.gen( Maths.INV_SQRT2 ,  Maths.INV_SQRT2 , 0.0              );
	
	/** The positive XZ-Axis-Normal */
	static final PVector3d aXZ =		PVector3d.gen( Maths.INV_SQRT2 , 0.0              ,  Maths.INV_SQRT2 );
	
	/** The positive YZ-Axis-Normal */
	static final PVector3d aYZ =		PVector3d.gen(0.0f             ,  Maths.INV_SQRT2 ,  Maths.INV_SQRT2 );
	
	
	
	/** The positive XYZ-Axis-Normal */
	static final PVector3d aXYZ =		PVector3d.gen( Maths.INV_SQRT3 ,  Maths.INV_SQRT3 ,  Maths.INV_SQRT3 );
	
	
	
	/** The negative X-Axis-Normal */
	static final PVector3d aNX =		PVector3d.gen(-1.0             ,  0.0             ,  0.0             );
	
	/** The negative Y-Axis-Normal */
	static final PVector3d aNY =		PVector3d.gen( 0.0             , -1.0             ,  0.0             );
	
	/** The negative Z-Axis-Normal */
	static final PVector3d aNZ =		PVector3d.gen( 0.0             ,  0.0             , -1.0             );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Y-Axis */
	static final PVector3d aNXY =		PVector3d.gen( -Maths.INV_SQRT2,  Maths.INV_SQRT2 , 0.0              );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3d aXNY =		PVector3d.gen( Maths.INV_SQRT2 ,  -Maths.INV_SQRT2, 0.0              );
	
	/** The negative XY-Axis-Normal */
	static final PVector3d aNXNY =		PVector3d.gen( -Maths.INV_SQRT2,  -Maths.INV_SQRT2, 0.0              );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Z-Axis */
	static final PVector3d aNXZ =		PVector3d.gen( -Maths.INV_SQRT2, 0.0              ,  Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3d aXNZ =		PVector3d.gen( Maths.INV_SQRT2 , 0.0              ,  -Maths.INV_SQRT2);
	
	/** The negative XZ-Axis-Normal */
	static final PVector3d aNXNZ =		PVector3d.gen( -Maths.INV_SQRT2, 0.0              ,  -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative Y-Axis and positive Z-Axis */
	static final PVector3d aNYZ =		PVector3d.gen(0.0              ,  -Maths.INV_SQRT2,  Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive Y-Axis and negative Z-Axis */
	static final PVector3d aYNZ =		PVector3d.gen(0.0              ,  Maths.INV_SQRT2 ,  Maths.INV_SQRT2 );
	
	/** The negative YZ-Axis-Normal */
	static final PVector3d aNYNZ =		PVector3d.gen(0.0              ,  -Maths.INV_SQRT2,  -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and positive Z-Axis */
	static final PVector3d aNXYZ =		PVector3d.gen( -Maths.INV_SQRT3,  Maths.INV_SQRT3 ,  Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3d aXNYZ =		PVector3d.gen( Maths.INV_SQRT3 ,  -Maths.INV_SQRT3,  Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3d aXYNZ =		PVector3d.gen( Maths.INV_SQRT3 ,  Maths.INV_SQRT3 ,  -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of negative X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3d aNXNYZ =		PVector3d.gen( -Maths.INV_SQRT3,  -Maths.INV_SQRT3,  Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3d aNXYNZ =		PVector3d.gen( -Maths.INV_SQRT3,  Maths.INV_SQRT3 ,  -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and negative Z-Axis */
	static final PVector3d aXNYNZ =		PVector3d.gen( Maths.INV_SQRT3 ,  -Maths.INV_SQRT3,  -Maths.INV_SQRT3);
	
	/** The negative XYZ-Axis-Normal */
	static final PVector3d aNXNYNZ =	PVector3d.gen( -Maths.INV_SQRT3,  -Maths.INV_SQRT3,  -Maths.INV_SQRT3);

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
	
	/** Returns the Z-Dimension */
	double getZ();
	
	
	
	/** Returns the X-Dimension */
	double getA();
	
	/** Returns the Y-Dimension */
	double getB();
	
	/** Returns the Z-Dimension */
	double getC();

	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec3d addN(Vec3fBase v);
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec3d addN(Vec3dBase v);
	
	/** Returns a clone of the Vector with addition of the Tuple t */
	Vec3d addN(Tup3fBase t);
	
	/** Returns a clone of the Vector with addition of the Tuple t */
	Vec3d addN(Tup3dBase t);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3d addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3d addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3d addN(float x, float y, float z);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3d addN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec3d subN(Vec3fBase v);
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec3d subN(Vec3dBase v);
	
	/** Returns a clone of the Vector with subtraction of the Tuple t */
	Vec3d subN(Tup3fBase t);
	
	/** Returns a clone of the Vector with subtraction of the Tuple t */
	Vec3d subN(Tup3dBase t);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3d subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3d subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3d subN(float x, float y, float z);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3d subN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec3d mulN(Vec3fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec3d mulN(Vec3dBase v);
	
	/** Returns a clone of the Vector with multiplication of the Tuple t */
	Vec3d mulN(Tup3fBase v);
	
	/** Returns a clone of the Vector with multiplication of the Tuple t */
	Vec3d mulN(Tup3dBase v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3d mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3d mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3d mulN(float x, float y, float z);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3d mulN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec3d divN(Vec3fBase v);
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec3d divN(Vec3dBase v);
	
	/** Returns a clone of the Vector with division of the Tuple t */
	Vec3d divN(Tup3fBase v);
	
	/** Returns a clone of the Vector with division of the Tuple t */
	Vec3d divN(Tup3dBase v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3d divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3d divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3d divN(float x, float y, float z);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3d divN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec3d invertFromN(Vec3fBase v);
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec3d invertFromN(Vec3dBase v);
	
	/** Returns a clone of the Vector with invertion based on the Tuple t (i.e. out.x = t.x - this.x) */
	Vec3d invertFromN(Tup3fBase t);
	
	/** Returns a clone of the Vector with invertion based on the Tuple t (i.e. out.x = t.x - this.x) */
	Vec3d invertFromN(Tup3dBase t);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec3d invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec3d invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec3d invertFromN(float x, float y, float z);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y and z (i.e. out.x = x - this.x) */
	Vec3d invertFromN(double x ,double y, double z);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec3d inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec3d negateN();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Return a normalized clone of the Vector */
	Vec3d normalizeN();
	
	
	
	/** Returns a new Vector with the Cross-Product from this Vector with the Vector v */
	Vec3d crossN(Vec3fBase v);
	
	/** Returns a new Vector with the Cross-Product from this Vector with the Vector v */
	Vec3d crossN(Vec3dBase v);
	
	
	
	/** Returns a new Vector with the Projection of this Vector on the Vector v */
	Vec3d projectN(Vec3fBase v);
	
	/** Returns a new Vector with the Projection of this Vector on the Vector v */
	Vec3d projectN(Vec3dBase v);
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec3d reflectN(Vec3fBase normal);
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec3d reflectN(Vec3dBase normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3d rotateN(Vec3fBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3d rotateN(Vec3dBase axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3d rotateN(Vec3fBase axis, double angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3d rotateN(Vec3dBase axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec3d rotateN(Quaternion q);
	
	
	
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
	Vec3d lerpN(Vec3fBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d lerpN(Vec3dBase v, float f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d lerpN(Vec3fBase v, double f);
	
	/** Returns a new Vector with the result of linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d lerpN(Vec3dBase v, double f);
	
	
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d slerpN(Vec3fBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d slerpN(Vec3dBase v, float f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d slerpN(Vec3fBase v, double f);
	
	/** Returns a new Vector with the result of spherical linear interpolation between this Vector and the Vector v by the Value f */
	Vec3d slerpN(Vec3dBase v, double f);
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** Returns a clone of the Vector */
	Vec3d clone();

}
