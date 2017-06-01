package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector3d;

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
	
	default Vec3d inverted() { return clone().invert(); }
	
	default Vec3d normalized() { return clone().normalize(); }

	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vec3d addN(float x, float y, float z) { return clone().add(x, y, z); }
	default Vec3d addN(double x, double y, double z) { return clone().add(x, y, z); }

	default Vec3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
	default Vec3d subN(double x, double y, double z) { return clone().sub(x, y, z); }

	default Vec3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	default Vec3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }

	default Vec3d divN(float x, float y, float z) { return clone().div(x, y, z); }
	default Vec3d divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	Vec3d clone();

	
	
	default Vec3d addN(Vec3dBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default Vec3d addN(float scalar) { return addN(scalar, scalar, scalar); }
	default Vec3d addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default Vec3d subN(Vec3dBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default Vec3d subN(float scalar) { return subN(scalar, scalar, scalar); }
	default Vec3d subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default Vec3d mulN(Vec3dBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default Vec3d mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default Vec3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default Vec3d divN(Vec3dBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default Vec3d divN(float scalar) { return divN(scalar, scalar, scalar); }
	default Vec3d divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	default Vec3d cross(Vec3dBase v) 
	{
		return new Vector3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	default Vec3d project(Vec3dBase v)
	{	
		Vec3d vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vec3d rot(Vec3dBase axis, float angle)
	{
		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
		
		return rot(rotation);
	}
	
	default Vec3d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector3d(w.getX(), w.getY(), w.getZ());
	}

	
	default Vec3d reflected(Vec3dBase normal)
	{
		Vec3d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vec3d lerped(Vec3dBase v, float f)
	{
		Vec3d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vec3dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec3dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec3dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
}
