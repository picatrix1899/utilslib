package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVec4d;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec4d;

public interface Vector4dBase extends Iterable<Double>, Streamable.Readable
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVec4d ZERO = PVec4d.gen(0.0d, 0.0d, 0.0d, 0.0d);
	static final PVec4d ONE = PVec4d.gen(1.0d, 1.0d, 1.0d, 0.0d);
	static final PVec4d aX = PVec4d.gen(1.0d, 0.0d, 0.0d, 0.0d);
	static final PVec4d aY = PVec4d.gen(0.0d, 1.0d, 0.0d, 0.0d);
	static final PVec4d aZ = PVec4d.gen(0.0d, 0.0d, 1.0d, 0.0d);
	static final PVec4d aNX = PVec4d.gen(-1.0d, 0.0d, 0.0d, 0.0d);
	static final PVec4d aNY = PVec4d.gen(0.0d, -1.0d, 0.0d, 0.0d);
	static final PVec4d aNZ = PVec4d.gen(0.0d, 0.0d, -1.0d, 0.0d);
	
	static int DIMENSIONS = 4;
	
	
	
	double getX();
	double getY();
	double getZ();
	double getA();


	
	default Vector4d inverted() { return clone().invert(); }
	
	default Vector4d normalized() { return clone().normalize(); }

	default Vector4d floorN() { return clone().floor(); }
	default Vector4d ceilN() { return clone().ceil(); }
	default Vector4d roundN() { return clone().round(); }
	
	default Vector4d absN(boolean x, boolean y, boolean z, boolean a) { return clone().abs(x, y, z, a); }
	
	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vector4d addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	default Vector4d addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }

	default Vector4d subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	default Vector4d subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }

	default Vector4d mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	default Vector4d mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }

	default Vector4d divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	default Vector4d divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }

	
	Vector4d clone();

	
	
	default Vector4d addN(Vector4dBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	default Vector4d addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	default Vector4d subN(Vector4dBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	default Vector4d subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	default Vector4d mulN(Vector4dBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	default Vector4d mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	default Vector4d divN(Vector4dBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	default Vector4d divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	default Vector4d project(Vector4dBase v)
	{
		Vector4d vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vector4d rot(Vector4dBase axis, float angle)
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
	
	default Vector4d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec4d(w.getX(), w.getY(), w.getZ(), w.getW());
	}

	
	default Vector4d reflected(Vector4dBase normal)
	{
		Vector4d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vector4d lerped(Vector4dBase v, double f)
	{
		Vector4d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vector4dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector4dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector4dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
	
	
	/** */ @Override
	default Iterator<Double> iterator()
	{
		return new Iterator<Double>()
		{

			private int index = 0;
			
			/**  */
			@Override
			public boolean hasNext() { return this.index < DIMENSIONS; }

			/** */
			@Override
			public Double next()
			{
				if(hasNext())
				{
					double out = 0.0d;
					
					switch(this.index)
					{
						case 0: out = getX();
						case 1: out = getY();
						case 2: out = getZ();
						case 3: out = getA();
					}
					
					index++;
					
					return out;					
				}
			
				return 0.0d;
			}
			
		};
	}

	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(getX());
		dos.writeDouble(getY());
		dos.writeDouble(getZ());
		dos.writeDouble(getA());
	}
}
