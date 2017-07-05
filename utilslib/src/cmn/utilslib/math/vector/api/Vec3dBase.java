package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Quaternion;

public interface Vec3dBase extends Vecd
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	
	static int DIMENSIONS = 3;
	
	
	
	double getX();
	double getY();
	double getZ();

	@Override
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: return 0.0d;
		}
	}

	@Override
	default int getDimensions() { return DIMENSIONS; }
	


	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }

	Vec3d clone();

	
	Vec3d inverted();
	
	Vec3d normalized();
	
	Vec3d addN(Vec3dBase v);
	Vec3d addN(float scalar);
	Vec3d addN(double scalar);
	Vec3d addN(float x, float y, float z);
	Vec3d addN(double x, double y, double z);
	
	Vec3d subN(Vec3dBase v);
	Vec3d subN(float scalar);
	Vec3d subN(double scalar);
	Vec3d subN(float x, float y, float z);
	Vec3d subN(double x, double y, double z);
	
	Vec3d mulN(Vec3dBase v);
	Vec3d mulN(float scalar);
	Vec3d mulN(double scalar);
	Vec3d mulN(float x, float y, float z);
	Vec3d mulN(double x, double y, double z);
	
	Vec3d divN(Vec3dBase v);
	Vec3d divN(float scalar);
	Vec3d divN(double scalar);
	Vec3d divN(float x, float y, float z);
	Vec3d divN(double x, double y, double z);
	
	
	
	Vec3d cross(Vec3dBase v);
	
	Vec3d project(Vec3dBase v);
	
	
	Vec3d rot(Vec3dBase axis, float angle);
	
	Vec3d rot(Quaternion q);

	
	Vec3d reflected(Vec3dBase normal);
	
	Vec3d lerped(Vec3dBase v, float f);
	
	double dot(Vec3dBase v);
	
	double angleRad(Vec3dBase v);
	double angleDeg(Vec3dBase v);

	double length();
	double squaredLength();
}
