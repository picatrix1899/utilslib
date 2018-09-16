package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;

public interface Vec3f extends Vec3fBase
{
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec3f addN(Vec3f v);

	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3f addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec3f addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3f addN(float x, float y, float z);
	
	/** Returns a clone of the Vector with addition of the Values x, y and z */
	Vec3f addN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec3f subN(Vec3f v);

	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3f subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec3f subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3f subN(float x, float y, float z);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y and z */
	Vec3f subN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec3f mulN(Vec3f v);

	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3f mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec3f mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3f mulN(float x, float y, float z);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y and z */
	Vec3f mulN(double x, double y, double z);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec3f divN(Vec3f v);

	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3f divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec3f divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3f divN(float x, float y, float z);
	
	/** Returns a clone of the Vector with division of the Values x, y and z */
	Vec3f divN(double x, double y, double z);
	
	
	

	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec3f invertFromN(Vec3f v);

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


	
	/** Return a normalized clone of the Vector */
	Vec3f normalizeN();
	
	
	
	/** Returns a new Vector with the Cross-Product from this Vector with the Vector v */
	Vec3f crossN(Vec3f v);
	
	
	
	/** Returns a new Vector with the Projection of this Vector on the Vector v */
	Vec3f projectN(Vec3f v);
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec3f reflectN(Vec3f normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3f axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec3f rotateN(Vec3f axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec3f rotateN(Quaternion q);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec3f v);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec3f v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec3f v);

	
	
	/** Returns the length of the Vector */
	double length();
	
	/** Returns the squared length of the Vector */
	double squaredLength();
	
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
