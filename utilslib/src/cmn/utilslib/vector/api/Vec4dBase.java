package cmn.utilslib.vector.api;



import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector4d;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector4d;

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
	
	
	default Vec4d inverted() { return clone().invert(); }
	
	default Vec4d normalized() { return clone().normalize(); }

	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vec4d addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	default Vec4d addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }

	default Vec4d subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	default Vec4d subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }

	default Vec4d mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	default Vec4d mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }

	default Vec4d divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	default Vec4d divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }

	
	Vec4d clone();

	
	
	default Vec4d addN(Vec4dBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	default Vec4d addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	default Vec4d subN(Vec4dBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	default Vec4d subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	default Vec4d mulN(Vec4dBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	default Vec4d mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	default Vec4d divN(Vec4dBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	default Vec4d divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	default Vec4d project(Vec4dBase v)
	{
		Vec4d vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vec4d rot(Vec4dBase axis, float angle)
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
	
	default Vec4d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector4d(w.getX(), w.getY(), w.getZ(), w.getW());
	}

	
	default Vec4d reflected(Vec4dBase normal)
	{
		Vec4d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vec4d lerped(Vec4dBase v, double f)
	{
		Vec4d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vec4dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec4dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec4dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
}
