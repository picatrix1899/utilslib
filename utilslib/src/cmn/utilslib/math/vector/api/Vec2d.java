package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2d;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public interface Vec2d extends Vec2dBase, Tup2d
{
	
	/* 
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	*/
	
	/** Sets the Dimensions to 0 and returns the Vector */
	Vec2d setZero();
	
	
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec2d set(Vec2fBase v);
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec2d set(Vec2dBase v);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec2d set(Tup2fBase t);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec2d set(Tup2dBase t);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec2d set(float scalar);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec2d set(double scalar);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec2d set(float x, float y);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec2d set(double x, double y);
	
	
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2d setX(float x);
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec2d setX(double x); 
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2d setY(float y);
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec2d setY(double y); 
	
	default Vec2d set(int index, float value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
		}
		
		return this;
	}
	
	default Vec2d set(int index, double value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
		}
		
		return this;
	}

	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** Returns the Vector with addition of the Vector v */
	Vec2d add(Vec2fBase v);
	
	/** Returns the Vector with addition of the Vector v */
	Vec2d add(Vec2dBase v);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec2d add(float scalar);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec2d add(double scalar);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec2d add(float x, float y);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec2d add(double x, double y);
	
	
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec2d sub(Vec2fBase v);
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec2d sub(Vec2dBase v);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec2d sub(float scalar);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec2d sub(double scalar);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec2d sub(float x, float y);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec2d sub(double x, double y);
	
	
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec2d mul(Vec2fBase v);
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec2d mul(Vec2dBase v);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec2d mul(float scalar);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec2d mul(double scalar);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec2d mul(float x, float y);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec2d mul(double x, double y);
	
	
	
	/** Returns the Vector with division of the Vector v */
	Vec2d div(Vec2fBase v);
	
	/** Returns the Vector with division of the Vector v */
	Vec2d div(Vec2dBase v);
	
	/** Returns the Vector with division of the Value scalar */
	Vec2d div(float scalar);
	
	/** Returns the Vector with division of the Value scalar */
	Vec2d div(double scalar);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec2d div(float x, float y);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec2d div(double x, double y);
	
	
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec2d invertFrom(Vec2fBase v);
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec2d invertFrom(Vec2dBase v);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec2d invertFrom(float max);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec2d invertFrom(double max);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec2d invertFrom(float x, float y);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec2d invertFrom(double x ,double y);
	
	
	
	/** inverses the Vector and returns it */
	Vec2d inverse();
	
	
	
	/** negates the Vector and returns it */
	Vec2d negate();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** normalizes the Vector and returns it */
	Vec2d normalize();
	
	
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec2d reflect(Vec2fBase normal);
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec2d reflect(Vec2dBase normal);	
	
	
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2d rotate(Vec2fBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2d rotate(Vec2dBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2d rotate(Vec2fBase axis, double angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec2d rotate(Vec2dBase axis, double angle);
	
	
	
	/** Rotates the Vector by the Quaternion q and returns it */
	Vec2d rotate(Quaternion q);

	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d lerp(Vec2fBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d lerp(Vec2dBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d lerp(Vec2fBase v, double f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d lerp(Vec2dBase v, double f);
	
	
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d slerp(Vec2fBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d slerp(Vec2dBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d slerp(Vec2fBase v, double f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec2d slerp(Vec2dBase v, double f);
	
}
