package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public interface Vec2f extends Vec2fBase, Tup2f
{
	
	/* 
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	*/
	
	/** Sets the Dimensions to 0 and returns the Vector */
	Vec2f setZero();
	
	
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec2f set(Vec2fBase v);
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec2f set(Vec2dBase v);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec2f set(Tup2fBase t);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec2f set(Tup2dBase t);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec2f set(float scalar);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec2f set(double scalar);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec2f set(float x, float y);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec2f set(double x, double y);
	
	
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2f setX(float x);
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2f setX(double x); 
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2f setY(float y);
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2f setY(double y); 
	
	
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2f setA(float a);
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2f setA(double a); 
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2f setB(float b);
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2f setB(double b); 

	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns the Vector with addition of the Vector v */
	Vec2f add(Vec2fBase v);
	
	/** Returns the Vector with addition of the Vector v */
	Vec2f add(Vec2dBase v);
	
	/** Returns the Vector with addition of the Tuple t */
	Vec2f add(Tup2fBase v);
	
	/** Returns the Vector with addition of the Tuple t */
	Vec2f add(Tup2dBase v);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec2f add(float scalar);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec2f add(double scalar);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec2f add(float x, float y);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec2f add(double x, double y);
	
	
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec2f sub(Vec2fBase v);
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec2f sub(Vec2dBase v);

	/** Returns the Vector with subtraction of the Tuple t */
	Vec2f sub(Tup2fBase t);
	
	/** Returns the Vector with subtraction of the Tuple t */
	Vec2f sub(Tup2dBase t);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec2f sub(float scalar);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec2f sub(double scalar);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec2f sub(float x, float y);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec2f sub(double x, double y);
	
	
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec2f mul(Vec2fBase v);
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec2f mul(Vec2dBase v);
	
	/** Returns the Vector with multiplication of the Tuple t */
	Vec2f mul(Tup2fBase t);
	
	/** Returns the Vector with multiplication of the Tuple t */
	Vec2f mul(Tup2dBase t);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec2f mul(float scalar);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec2f mul(double scalar);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec2f mul(float x, float y);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec2f mul(double x, double y);
	
	
	
	/** Returns the Vector with division of the Vector v */
	Vec2f div(Vec2fBase v);
	
	/** Returns the Vector with division of the Vector v */
	Vec2f div(Vec2dBase v);
	
	/** Returns the Vector with division of the Tuple t */
	Vec2f div(Tup2fBase t);
	
	/** Returns the Vector with division of the Tuple t */
	Vec2f div(Tup2dBase t);
	
	/** Returns the Vector with division of the Value scalar */
	Vec2f div(float scalar);
	
	/** Returns the Vector with division of the Value scalar */
	Vec2f div(double scalar);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec2f div(float x, float y);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec2f div(double x, double y);
	
	
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec2f invertFrom(Vec2fBase v);
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec2f invertFrom(Vec2dBase v);
	
	/** inverses the Vector based on the Tuple t and returns it(i.e. out.x = t.x - this.x) */
	Vec2f invertFrom(Tup2fBase t);
	
	/** inverses the Vector based on the Tuple t and returns it(i.e. out.x = t.x - this.x) */
	Vec2f invertFrom(Tup2dBase t);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec2f invertFrom(float max);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec2f invertFrom(double max);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec2f invertFrom(float x, float y);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec2f invertFrom(double x ,double y);
	
	
	
	/** inverses the Vector and returns it */
	Vec2f inverse();
	
	
	
	/** negates the Vector and returns it */
	Vec2f negate();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** normalizes the Vector and returns it */
	Vec2f normalize();
	
	
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec2f reflect(Vec2fBase normal);
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec2f reflect(Vec2dBase normal);	
	
	
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2f rotate(Vec2fBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2f rotate(Vec2dBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2f rotate(Vec2fBase axis, double angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2f rotate(Vec2dBase axis, double angle);
	
	
	
	/** Rotates the Vector by the Quaternion q and returns it */
	Vec2f rotate(Quaternion q);

	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f lerp(Vec2fBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f lerp(Vec2dBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f lerp(Vec2fBase v, double f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f lerp(Vec2dBase v, double f);
	
	
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f slerp(Vec2fBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f slerp(Vec2dBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f slerp(Vec2fBase v, double f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2f slerp(Vec2dBase v, double f);
	
}
