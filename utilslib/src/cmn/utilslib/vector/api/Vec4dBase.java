package cmn.utilslib.vector.api;



import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector4d;
import cmn.utilslib.vector.Quaternion;

public interface Vec4dBase extends Vecd
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVector4d ZERO = PVector4d.gen(0.0d, 0.0d, 0.0d, 0.0d);
	static final PVector4d ONE = PVector4d.gen(1.0d, 1.0d, 1.0d, 0.0d);
	static final PVector4d aX = PVector4d.gen(1.0d, 0.0d, 0.0d, 0.0d);
	static final PVector4d aY = PVector4d.gen(0.0d, 1.0d, 0.0d, 0.0d);
	static final PVector4d aZ = PVector4d.gen(0.0d, 0.0d, 1.0d, 0.0d);
	static final PVector4d aNX = PVector4d.gen(-1.0d, 0.0d, 0.0d, 0.0d);
	static final PVector4d aNY = PVector4d.gen(0.0d, -1.0d, 0.0d, 0.0d);
	static final PVector4d aNZ = PVector4d.gen(0.0d, 0.0d, -1.0d, 0.0d);
	
	static int DIMENSIONS = 4;
	
	
	
	double getX();
	double getY();
	double getZ();
	double getA();

	@Override
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getA();
			default: return 0.0d;
		}
	}

	@Override
	default int getDimensions() { return DIMENSIONS; }
	
	

	
	Vec4d clone();

	
	
	
	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }

	

	

	Vec4d inverted();
	
	Vec4d normalized();


	
	
	Vec4d addN(float x, float y, float z, float a);
	Vec4d addN(double x, double y, double z, double a);
	Vec4d addN(Vec4dBase v);
	Vec4d addN(float scalar);
	Vec4d addN(double scalar);
	
	Vec4d subN(float x, float y, float z, float a);
	Vec4d subN(double x, double y, double z, double a);
	Vec4d subN(Vec4dBase v);
	Vec4d subN(float scalar);
	Vec4d subN(double scalar);
	
	Vec4d mulN(float x, float y, float z, float a);
	Vec4d mulN(double x, double y, double z, double a);
	Vec4d mulN(Vec4dBase v);
	Vec4d mulN(float scalar);
	Vec4d mulN(double scalar);
	
	Vec4d divN(float x, float y, float z, float a);
	Vec4d divN(double x, double y, double z, double a);
	Vec4d divN(Vec4dBase v);
	Vec4d divN(float scalar);
	Vec4d divN(double scalar);
	
	Vec4d project(Vec4dBase v);
	
	
	Vec4d rot(Vec4dBase axis, float angle);
	
	Vec4d rot(Quaternion q);


	
	Vec4d reflected(Vec4dBase normal);

	
	Vec4d lerped(Vec4dBase v, double f);
	
	
	
	default double dot(Vec4dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec4dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec4dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
}
