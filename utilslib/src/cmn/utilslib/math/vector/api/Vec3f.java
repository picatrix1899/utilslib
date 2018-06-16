package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public interface Vec3f extends Vec3fBase, Tup3f
{
	
	/* 
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	*/
	
	/** Sets the Dimensions to 0 and returns the Vector */
	Vec3f setZero();
	
	
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec3f set(Vec3fBase v);
	
	/** Sets the Dimensions based on the Vector v and returns the Vector */
	Vec3f set(Vec3dBase v);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec3f set(Tup3fBase t);
	
	/** Sets the Dimensions based on the Tuple t and returns the Vector */
	Vec3f set(Tup3dBase t);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec3f set(float scalar);
	
	/** Sets the Dimensions based on the Value scalar and returns the Vector */
	Vec3f set(double scalar);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec3f set(float x, float y, float z);
	
	/** Sets the Dimensions based on the Values x, y and z and returns the Vector */
	Vec3f set(double x, double y, double z);
	
	
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec3f setX(float x);
	
	/** Sets the X-Dimension based on the Value x and returns the Vector */
	Vec3f setX(double x); 
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec3f setY(float y);
	
	/** Sets the Y-Dimension based on the Value y and returns the Vector */
	Vec3f setY(double y); 
	
	/** Sets the Z-Dimension based on the Value z and returns the Vector */
	Vec3f setZ(float z);
	
	/** Sets the Z-Dimension based on the Value z and returns the Vector */
	Vec3f setZ(double z);
	
	
	
	default Vec3f set(int index, float value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
			case 2: setZ(value); break;
		}
		
		return this;
	}
	
	default Vec3f set(int index, double value)
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
	Vec3f add(Vec3fBase v);
	
	/** Returns the Vector with addition of the Vector v */
	Vec3f add(Vec3dBase v);

	/** Returns the Vector with addition of the Value scalar */
	Vec3f add(float scalar);
	
	/** Returns the Vector with addition of the Value scalar */
	Vec3f add(double scalar);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec3f add(float x, float y, float z);
	
	/** Returns the Vector with addition of the Values x, y and z */
	Vec3f add(double x, double y, double z);
	
	
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec3f sub(Vec3fBase v);
	
	/** Returns the Vector with subtraction of the Vector v */
	Vec3f sub(Vec3dBase v);

	/** Returns the Vector with subtraction of the Value scalar */
	Vec3f sub(float scalar);
	
	/** Returns the Vector with subtraction of the Value scalar */
	Vec3f sub(double scalar);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec3f sub(float x, float y, float z);
	
	/** Returns the Vector with subtraction of the Values x, y and z */
	Vec3f sub(double x, double y, double z);
	
	
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec3f mul(Vec3fBase v);
	
	/** Returns the Vector with multiplication of the Vector v */
	Vec3f mul(Vec3dBase v);

	/** Returns the Vector with multiplication of the Value scalar */
	Vec3f mul(float scalar);
	
	/** Returns the Vector with multiplication of the Value scalar */
	Vec3f mul(double scalar);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec3f mul(float x, float y, float z);
	
	/** Returns the Vector with multiplication of the Values x, y and z */
	Vec3f mul(double x, double y, double z);
	
	
	
	/** Returns the Vector with division of the Vector v */
	Vec3f div(Vec3fBase v);
	
	/** Returns the Vector with division of the Vector v */
	Vec3f div(Vec3dBase v);

	/** Returns the Vector with division of the Value scalar */
	Vec3f div(float scalar);
	
	/** Returns the Vector with division of the Value scalar */
	Vec3f div(double scalar);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec3f div(float x, float y, float z);
	
	/** Returns the Vector with division of the Values x, y and z */
	Vec3f div(double x, double y, double z);
	
	
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec3f invertFrom(Vec3fBase v);
	
	/** inverses the Vector based on the Vector v and returns it(i.e. out.x = v.x - this.x) */
	Vec3f invertFrom(Vec3dBase v);

	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec3f invertFrom(float max);
	
	/** inverses the Vector based on the Value max and returns it(i.e. out.x = max - this.x) */
	Vec3f invertFrom(double max);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec3f invertFrom(float x, float y, float z);
	
	/** inverses the Vector based on the Values x, y and z and returns it(i.e. out.x = x - this.x) */
	Vec3f invertFrom(double x ,double y, double z);
	
	
	
	/** inverses the Vector and returns it */
	Vec3f inverse();
	
	
	
	/** negates the Vector and returns it */
	Vec3f negate();
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */
	
	/** normalizes the Vector and returns it */
	Vec3f normalize();

	
	
	/** Sets the Vector to the Cross-Product of the Vector and the Vector v and return it */
	Vec3f cross(Vec3fBase v);
	
	/** Sets the Vector to the Cross-Product of the Vector and the Vector v and return it */
	Vec3f cross(Vec3dBase v);
	
	
	
	/** Sets the Vector to the projection of the Vector on the Vector v and returns it */
	Vec3f project(Vec3fBase v);
	
	/** Sets the Vector to the projection of the Vector on the Vector v and returns it */
	Vec3f project(Vec3dBase v);
	
	
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec3f reflect(Vec3fBase normal);
	
	/** Sets the Vector to the reflection of the Vector on the Vector normal and returns it */
	Vec3f reflect(Vec3dBase normal);	
	
	
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3f rotate(Vec3fBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3f rotate(Vec3dBase axis, float angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3f rotate(Vec3fBase axis, double angle);
	
	/** Rotates the Vector around the Vector axis by the Amount of angle in degrees and returns it */
	Vec3f rotate(Vec3dBase axis, double angle);
	
	
	
	/** Rotates the Vector by the Quaternion q and returns it */
	Vec3f rotate(Quaternion q);
	
}
