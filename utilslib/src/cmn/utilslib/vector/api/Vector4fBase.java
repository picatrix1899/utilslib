package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVec3f;
import cmn.utilslib.vector.PVec4f;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.Vec4f;

public interface Vector4fBase extends Iterable<Float>, Streamable.Readable
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVec4f ZERO = PVec4f.gen(0.0f, 0.0f, 0.0f, 0.0f);
	static final PVec4f ONE = PVec4f.gen(1.0f, 1.0f, 1.0f, 0.0f);
	static final PVec4f aX = PVec4f.gen(1.0f, 0.0f, 0.0f, 0.0f);
	static final PVec4f aY = PVec4f.gen(0.0f, 1.0f, 0.0f, 0.0f);
	static final PVec4f aZ = PVec4f.gen(0.0f, 0.0f, 1.0f, 0.0f);
	static final PVec4f aNX = PVec4f.gen(-1.0f, 0.0f, 0.0f, 0.0f);
	static final PVec4f aNY = PVec4f.gen(0.0f, -1.0f, 0.0f, 0.0f);
	static final PVec4f aNZ = PVec4f.gen(0.0f, 0.0f, -1.0f, 0.0f);
	
	static int DIMENSIONS = 4;
	
	
	
	float getX();
	float getY();
	float getZ();
	float getA();


	
	default Vector4f inverted() { return clone().invert(); }
	
	default Vector4f normalized() { return clone().normalize(); }

	default Vector4f floorN() { return clone().floor(); }
	default Vector4f ceilN() { return clone().ceil(); }
	default Vector4f roundN() { return clone().round(); }
	
	default Vector4f absN(boolean x, boolean y, boolean z, boolean a) { return clone().abs(x, y, z, a); }
	
	default float max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default float min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vector4f addN(float x, float y, float z, float a) { return clone().add(x, y, z, a); }
	default Vector4f addN(double x, double y, double z, double a) { return clone().add(x, y, z, a); }

	default Vector4f subN(float x, float y, float z, float a) { return clone().sub(x, y, z, a); }
	default Vector4f subN(double x, double y, double z, double a) { return clone().sub(x, y, z, a); }

	default Vector4f mulN(float x, float y, float z, float a) { return clone().mul(x, y, z, a); }
	default Vector4f mulN(double x, double y, double z, double a) { return clone().mul(x, y, z, a); }

	default Vector4f divN(float x, float y, float z, float a) { return clone().div(x, y, z, a); }
	default Vector4f divN(double x, double y, double z, double a) { return clone().div(x, y, z, a); }

	
	Vector4f clone();

	
	
	default Vector4f addN(Vector4fBase v) { return addN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	default Vector4f addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	default Vector4f subN(Vector4fBase v) { return subN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	default Vector4f subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }	
	
	default Vector4f mulN(Vector4fBase v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	default Vector4f mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }	
	
	default Vector4f divN(Vector4fBase v) { return divN(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	default Vector4f divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	
	default Vector4f project(Vec4f v)
	{	
		Vector4f vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vector4f rot(Vec4f axis, float angle)
	{
		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.x * sinHalfAngle;
		double rY = axis.y * sinHalfAngle;
		double rZ = axis.z * sinHalfAngle;
		double rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
		
		return rot(rotation);
	}
	
	default Vector4f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec4f((float)w.getX(), (float)w.getY(), (float)w.getZ(), (float)w.getW());
	}

	
	default Vector4f reflected(Vector4fBase normal)
	{
		Vector4f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vector4f lerped(Vector4fBase v, float f)
	{
		Vector4f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vector4fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector4fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector4fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ() + getA() * getA(); }
	
	
	/** */ @Override
	default Iterator<Float> iterator()
	{
		return new Iterator<Float>()
		{

			private int index = 0;
			
			/**  */
			@Override
			public boolean hasNext() { return this.index < DIMENSIONS; }

			/** */
			@Override
			public Float next()
			{
				if(hasNext())
				{
					float out = 0;
					
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
			
				return 0.0f;
			}
			
		};
	}

	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
		dos.writeFloat(getZ());
		dos.writeFloat(getA());
	}
}
