package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector4f;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector4f;

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
	
	default Vec4f inverted() { return clone().invert(); }
	
	default Vec4f normalized() { return clone().normalize(); }

	default float max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default float min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vec4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	default Vec4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }

	default Vec4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	default Vec4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }

	default Vec4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	default Vec4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }

	default Vec4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	default Vec4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }

	
	Vec4f clone();

	
	
	default Vec4f addN(Vec4fBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	default Vec4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	default Vec4f subN(Vec4fBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	default Vec4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	default Vec4f mulN(Vec4fBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	default Vec4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	default Vec4f divN(Vec4fBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	default Vec4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	default Vec4f project(Vec4fBase v)
	{	
		Vec4f vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vec4f rot(Vec4f axis, float angle)
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
	
	default Vec4f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector4f((float)w.getX(), (float)w.getY(), (float)w.getZ(), (float)w.getW());
	}

	
	default Vec4f reflected(Vec4fBase normal)
	{
		Vec4f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vec4f lerped(Vec4fBase v, float f)
	{
		Vec4f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vec4fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec4fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec4fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
}
