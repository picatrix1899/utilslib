package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector4f;
import cmn.utilslib.vector.Quaternion;

public interface Vec4fBase extends Vecf
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVector4f ZERO = PVector4f.gen(0.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f ONE = PVector4f.gen(1.0f, 1.0f, 1.0f, 0.0f);
	static final PVector4f aX = PVector4f.gen(1.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f aY = PVector4f.gen(0.0f, 1.0f, 0.0f, 0.0f);
	static final PVector4f aZ = PVector4f.gen(0.0f, 0.0f, 1.0f, 0.0f);
	static final PVector4f aNX = PVector4f.gen(-1.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f aNY = PVector4f.gen(0.0f, -1.0f, 0.0f, 0.0f);
	static final PVector4f aNZ = PVector4f.gen(0.0f, 0.0f, -1.0f, 0.0f);
	
	static int DIMENSIONS = 4;
	
	
	
	float getX();
	float getY();
	float getZ();
	float getA();

	@Override
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getA();
			default: return 0.0f;
		}
	}

	@Override
	default int getDimensions() { return DIMENSIONS; }

	Vec4f clone();
	
	default float max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default float min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	Vec4f inverted();
	
	Vec4f normalized();


	
	
	Vec4f addN(float x, float y, float z, float a);
	Vec4f addN(double x, double y, double z, double a);
	Vec4f addN(Vec4fBase v);
	Vec4f addN(float scalar);
	Vec4f addN(double scalar);
	
	Vec4f subN(float x, float y, float z, float a);
	Vec4f subN(double x, double y, double z, double a);
	Vec4f subN(Vec4fBase v);
	Vec4f subN(float scalar);
	Vec4f subN(double scalar);
	
	Vec4f mulN(float x, float y, float z, float a);
	Vec4f mulN(double x, double y, double z, double a);
	Vec4f mulN(Vec4fBase v);
	Vec4f mulN(float scalar);
	Vec4f mulN(double scalar);
	
	Vec4f divN(float x, float y, float z, float a);
	Vec4f divN(double x, double y, double z, double a);
	Vec4f divN(Vec4fBase v);
	Vec4f divN(float scalar);
	Vec4f divN(double scalar);
	
	Vec4f project(Vec4fBase v);
	
	
	Vec4f rot(Vec4fBase axis, float angle);
	
	Vec4f rot(Quaternion q);


	
	Vec4f reflected(Vec4fBase normal);

	
	Vec4f lerped(Vec4fBase v, double f);
	
	
	
	
	default double dot(Vec4fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec4fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec4fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
}
