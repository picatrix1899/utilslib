package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVec3f;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3f;

public interface Vector3fBase extends Iterable<Float>, Streamable.Readable
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVec3f ZERO = PVec3f.gen(0.0f, 0.0f, 0.0f);
	static final PVec3f ONE = PVec3f.gen(1.0f, 1.0f, 1.0f);
	static final PVec3f aX = PVec3f.gen(1.0f, 0.0f, 0.0f);
	static final PVec3f aY = PVec3f.gen(0.0f, 1.0f, 0.0f);
	static final PVec3f aZ = PVec3f.gen(0.0f, 0.0f, 1.0f);
	static final PVec3f aNX = PVec3f.gen(-1.0f, 0.0f, 0.0f);
	static final PVec3f aNY = PVec3f.gen(0.0f, -1.0f, 0.0f);
	static final PVec3f aNZ = PVec3f.gen(0.0f, 0.0f, -1.0f);
	
	static int DIMENSIONS = 3;
	
	
	
	float getX();
	float getY();
	float getZ();


	
	default Vector3f inverted() { return clone().invert(); }
	
	default Vector3f normalized() { return clone().normalize(); }

	default Vector3f floorN() { return clone().floor(); }
	default Vector3f ceilN() { return clone().ceil(); }
	default Vector3f roundN() { return clone().round(); }
	
	default Vector3f absN(boolean x, boolean y, boolean z) { return clone().abs(x, y, z); }
	
	default float max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default float min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	default Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }

	default Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	default Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }

	default Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	default Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }

	default Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
	default Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	Vector3f clone();

	
	
	default Vector3f addN(Vector3fBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default Vector3f addN(float scalar) { return addN(scalar, scalar, scalar); }
	default Vector3f addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default Vector3f subN(Vector3fBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default Vector3f subN(float scalar) { return subN(scalar, scalar, scalar); }
	default Vector3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default Vector3f mulN(Vector3fBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default Vector3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default Vector3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default Vector3f divN(Vector3fBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default Vector3f divN(float scalar) { return divN(scalar, scalar, scalar); }
	default Vector3f divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	default Vector3f cross(Vector3fBase v) 
	{
		return new Vec3f(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	default Vector3f project(Vector3fBase v)
	{	
		Vector3f vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vector3f rot(Vector3fBase axis, float angle)
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
	
	default Vector3f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}

	
	default Vector3f reflected(Vector3fBase normal)
	{
		Vector3f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vector3f lerped(Vector3fBase v, float f)
	{
		Vector3f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vector3fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
	
	
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
	}
}
