package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;

public interface Vec2f extends Vec2fBase
{
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns a clone of the Vector with addition of the Vector v */
	Vec2f addN(Vec2f v);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2f addN(float scalar);
	
	/** Returns a clone of the Vector with addition of the Value scalar */
	Vec2f addN(double scalar);
	
	/** Returns a clone of the Vector with addition of the Values x and y */
	Vec2f addN(float x, float y);
	
	/** Returns a clone of the Vector with addition of the Values x and y */
	Vec2f addN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with subtraction of the Vector v */
	Vec2f subN(Vec2f v);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2f subN(float scalar);
	
	/** Returns a clone of the Vector with subtraction of the Value scalar */
	Vec2f subN(double scalar);
	
	/** Returns a clone of the Vector with subtraction of the Values x and y */
	Vec2f subN(float x, float y);
	
	/** Returns a clone of the Vector with subtraction of the Values x and y */
	Vec2f subN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with multiplication of the Vector v */
	Vec2f mulN(Vec2f v);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2f mulN(float scalar);
	
	/** Returns a clone of the Vector with multiplication of the Value scalar */
	Vec2f mulN(double scalar);
	
	/** Returns a clone of the Vector with multiplication of the Values x and y */
	Vec2f mulN(float x, float y);
	
	/** Returns a clone of the Vector with multiplication of the Values xand y */
	Vec2f mulN(double x, double y);
	
	
	
	/** Returns a clone of the Vector with division of the Vector v */
	Vec2f divN(Vec2f v);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2f divN(float scalar);
	
	/** Returns a clone of the Vector with division of the Value scalar */
	Vec2f divN(double scalar);
	
	/** Returns a clone of the Vector with division of the Values x and y */
	Vec2f divN(float x, float y);
	
	/** Returns a clone of the Vector with division of the Values x and y */
	Vec2f divN(double x, double y);
	
	
	

	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** Returns a clone of the Vector with invertion based on the Vector v (i.e. out.x = v.x - this.x) */
	Vec2f invertFromN(Vec2f v);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2f invertFromN(float max);
	
	/** Returns a clone of the Vector with invertion based on the Value max (i.e. out.x = max - this.x) */
	Vec2f invertFromN(double max);
	
	/** Returns a clone of the Vector with invertion based on the Values x and y (i.e. out.x = x - this.x) */
	Vec2f invertFromN(float x, float y);
	
	/** Returns a clone of the Vector with invertion based on the Values x and y (i.e. out.x = x - this.x) */
	Vec2f invertFromN(double x ,double y);
	
	
	
	/** Returns a inversed clone of the Vector */
	Vec2f inverseN();
	
	
	
	/** Returns a negated clone of the Vector */
	Vec2f negateN();
	
	
	
	/** Return a normalized clone of the Vector */
	Vec2f normalizeN();
	
	
	
	/** Returns a new Vector with the Reflection of this Vector on the Vector normal */
	Vec2f reflectN(Vec2f normal);
	
	
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2f axis, float angle);
	
	/** Return a clone of this Vector rotated around the Vector axis and the Amount of angle in Degrees */
	Vec2f rotateN(Vec2f axis, double angle);
	
	
	
	/** Return a clone of this Vector rotated by the Qauternion q */
	Vec2f rotateN(Quaternion q);
	
	
	
	/** Returns the Dot-Product/Scalar-Product of this Vector with the Vector v */
	double dot(Vec2f v);
	
	
	
	/** Returns the angle in Radians between this Vector and the Vector v */
	double angleRad(Vec2f v);
	
	/** Returns the angle in Degrees between this Vector and the Vector v */
	double angleDeg(Vec2f v);

	
	
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
	Vec2f clone();
}
