package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup3d;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public interface Vec3d extends Vec3dBase, Tup3d
{
	
	/* 
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	*/
	
	/** Sets the Dimensions to 0 and returns the Vector */
	Vec3d setZero();
	
	
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec3d set(Vec3fBase v);
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec3d set(Vec3dBase v);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec3d set(Tup3fBase t);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec3d set(Tup3dBase t);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec3d set(float scalar);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec3d set(double scalar);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec3d set(float x, float y, float z);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec3d set(double x, double y, double z);
	
	
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec3d setX(float x);
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec3d setX(double x); 
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec3d setY(float y);
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec3d setY(double y); 
	
	/** Sets the Z-Dimension based on the Value z and returns the Vector */
	Vec3d setZ(float z);
	
	/** Sets the Z-Dimension based on the Value z and returns the Vector */
	Vec3d setZ(double z);

	
	
	default Vec3d set(int index, float value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
			case 2: setZ(value); break;
		}
		
		return this;
	}
	
	default Vec3d set(int index, double value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
			case 2: setZ(value); break;
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
	Vec3d add(Vec3fBase v);
	
	/** Returns the Vector with addition of the Vector v */
	Vec3d add(Vec3dBase v);

	/** Returns the Vector with addition of the Value scalar */
	Vec3d add(float scalar);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec3d add(double scalar);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec3d add(float x, float y, float z);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec3d add(double x, double y, double z);
	
	
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec3d sub(Vec3fBase v);
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec3d sub(Vec3dBase v);

	/** Returns the Vector with subtraction of the Value scalar */
	Vec3d sub(float scalar);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec3d sub(double scalar);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec3d sub(float x, float y, float z);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec3d sub(double x, double y, double z);
	
	
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec3d mul(Vec3fBase v);
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec3d mul(Vec3dBase v);

	/** Returns the Vector with multiplication of the Value scalar */
	Vec3d mul(float scalar);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec3d mul(double scalar);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec3d mul(float x, float y, float z);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec3d mul(double x, double y, double z);
	
	
	
	/** Returns the Vector with division of the Vector v */
	Vec3d div(Vec3fBase v);
	
	/** Returns the Vector with division of the Vector v */
	Vec3d div(Vec3dBase v);

	/** Returns the Vector with division of the Value scalar */
	Vec3d div(float scalar);
	
	/** Returns the Vector with division of the Value scalar */
	Vec3d div(double scalar);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec3d div(float x, float y, float z);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec3d div(double x, double y, double z);
	
	
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec3d invertFrom(Vec3fBase v);
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec3d invertFrom(Vec3dBase v);

	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec3d invertFrom(float max);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec3d invertFrom(double max);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec3d invertFrom(float x, float y, float z);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec3d invertFrom(double x ,double y, double z);
	
	
	
	/** inverses the Vector and returns it */
	Vec3d inverse();
	
	
	
	/** negates the Vector and returns it */
	Vec3d negate();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** normalizes the Vector and returns it */
	Vec3d normalize();

	
	
	/** Sets the Vector to the Cross-Product of the Vector and the Vector v and return it */
	Vec3d cross(Vec3fBase v);
	
	/** Sets the Vector to the Cross-Product of the Vector and the Vector v and return it */
	Vec3d cross(Vec3dBase v);
	
	
	
	/** Sets the Vector to the projection of the Vector on the Vector v and returns it */
	Vec3d project(Vec3fBase v);
	
	/** Sets the Vector to the projection of the Vector on the Vector v and returns it */
	Vec3d project(Vec3dBase v);
	
	
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec3d reflect(Vec3fBase normal);
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec3d reflect(Vec3dBase normal);	
	
	
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3d rotate(Vec3fBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3d rotate(Vec3dBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3d rotate(Vec3fBase axis, double angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3d rotate(Vec3dBase axis, double angle);
	
	
	
	/** Rotates the Vector by the Quaternion q and returns it */
	Vec3d rotate(Quaternion q);

	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d lerp(Vec3fBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d lerp(Vec3dBase v, float f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d lerp(Vec3fBase v, double f);
	
	/** Sets the Vector to the result of the linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d lerp(Vec3dBase v, double f);
	
	
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d slerp(Vec3fBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d slerp(Vec3dBase v, float f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d slerp(Vec3fBase v, double f);
	
	/** Sets the Vector to the result of the spherical linear interpolation between the Vector and the Vector v with the Value f and returns it */
	Vec3d slerp(Vec3dBase v, double f);
	
}
