package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;

public interface Vec4f extends Vec4fBase
{
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec4f addN(Vec4f v);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec4f addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec4f addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x, y, z and a */
	Vec4f addN(float x, float y, float z, float a);
	
	/** Returns a clone of the Vector with addition of the Values x, y, z and a */
	Vec4f addN(double x, double y, double z, double a);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec4f subN(Vec4f v);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec4f subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec4f subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y, z and a */
	Vec4f subN(float x, float y, float z ,float a);
	
	/** Returns a clone of the Vector with subtraction of the Values x, y, z and a */
	Vec4f subN(double x, double y, double z, double a);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec4f mulN(Vec4f v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec4f mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec4f mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y, z and a*/
	Vec4f mulN(float x, float y, float z, float a);
	
	/** Returns a clone of the Vector with multiplication of the Values x, y, z and a */
	Vec4f mulN(double x, double y, double z, double a);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec4f divN(Vec4f v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec4f divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec4f divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x, y, z and a */
	Vec4f divN(float x, float y, float z, float a);
	
	/** Returns a clone of the Vector with division of the Values x, y, z and */
	Vec4f divN(double x, double y, double z, double a);
	
	
	

	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec4f invertFromN(Vec4f v);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec4f invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec4f invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y, z and a (i.e. out.x = x - this.x) */
	Vec4f invertFromN(float x, float y, float z, float a);
	
	/** Returns a clone of the Vector with invertion based on the Values x, y, z and a (i.e. out.x = x - this.x) */
	Vec4f invertFromN(double x ,double y, double z, double a);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec4f inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec4f negateN();
	
	
	
	/** Return a normalized clone of the Vector */
	Vec4f normalizeN();
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec4f reflectN(Vec4f normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec4f rotateN(Vec4f axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec4f rotateN(Vec4f axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec4f rotateN(Quaternion q);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec4f v);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec4f v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec4f v);

	
	
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
	Vec4f clone();
}
