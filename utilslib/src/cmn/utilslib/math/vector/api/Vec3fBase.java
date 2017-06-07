package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.vector.PVector3f;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;

public interface Vec3fBase extends Vecf
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVector3f ZERO = PVector3f.gen(0.0f, 0.0f, 0.0f);
	static final PVector3f ONE = PVector3f.gen(1.0f, 1.0f, 1.0f);
	static final PVector3f aX = PVector3f.gen(1.0f, 0.0f, 0.0f);
	static final PVector3f aY = PVector3f.gen(0.0f, 1.0f, 0.0f);
	static final PVector3f aZ = PVector3f.gen(0.0f, 0.0f, 1.0f);
	static final PVector3f aNX = PVector3f.gen(-1.0f, 0.0f, 0.0f);
	static final PVector3f aNY = PVector3f.gen(0.0f, -1.0f, 0.0f);
	static final PVector3f aNZ = PVector3f.gen(0.0f, 0.0f, -1.0f);
	
	static int DIMENSIONS = 3;
	
	
	
	float getX();
	float getY();
	float getZ();

	@Override
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

	@Override
	default int getDimensions() { return DIMENSIONS; }
	
	


	
	Vec3f clone();

	
	Vec3f inverted();
	Vec3f normalized();
	
	Vec3f addN(Vec3fBase v);
	Vec3f addN(float scalar);
	Vec3f addN(double scalar);
	Vec3f addN(float x, float y, float z);
	Vec3f addN(double x, double y, double z);
	
	Vec3f subN(Vec3fBase v);
	Vec3f subN(float scalar);
	Vec3f subN(double scalar);
	Vec3f subN(float x, float y, float z);
	Vec3f subN(double x, double y, double z);
	
	Vec3f mulN(Vec3fBase v);
	Vec3f mulN(float scalar);
	Vec3f mulN(double scalar);
	Vec3f mulN(float x, float y, float z);
	Vec3f mulN(double x, double y, double z);
	
	Vec3f divN(Vec3fBase v);
	Vec3f divN(float scalar);
	Vec3f divN(double scalar);
	Vec3f divN(float x, float y, float z);
	Vec3f divN(double x, double y, double z);
	
	
	
	Vec3f cross(Vec3fBase v);
	
	Vec3f project(Vec3fBase v);
	
	
	Vec3f rot(Vec3fBase axis, float angle);
	
	Vec3f rot(Quaternion q);

	
	Vec3f reflected(Vec3fBase normal);
	
	Vec3f lerp(Vec3fBase v, float f);
	
	Vec3f slerp(Vec3fBase v, double f);
	
	default double dot(Vec3fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY() + this.getZ() * v.getZ(); }
	
	default double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
}