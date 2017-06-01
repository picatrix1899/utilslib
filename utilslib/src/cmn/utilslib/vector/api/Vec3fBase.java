package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector3f;
import cmn.utilslib.vector.Quaternion;

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
	
	Vec3f lerped(Vec3fBase v, float f);
	
	
	default double dot(Vec3fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
}
