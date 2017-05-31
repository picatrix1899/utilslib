package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVector3f;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vector3f;

public interface Vec3fBase extends Iterable<Float>, Streamable.Readable
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


	
	default Vec3f inverted() { return clone().invert(); }
	
	default Vec3f normalized() { return clone().normalize(); }

	default Vec3f floorN() { return clone().floor(); }
	default Vec3f ceilN() { return clone().ceil(); }
	default Vec3f roundN() { return clone().round(); }
	
	default Vec3f absN(boolean x, boolean y, boolean z) { return clone().abs(x, y, z); }
	
	default float max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default float min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vec3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	default Vec3f addN(double x, double y, double z) { return clone().add(x, y, z); }

	default Vec3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	default Vec3f subN(double x, double y, double z) { return clone().sub(x, y, z); }

	default Vec3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	default Vec3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }

	default Vec3f divN(float x, float y, float z) { return clone().div(x, y, z); }
	default Vec3f divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	Vec3f clone();

	
	
	default Vec3f addN(Vec3fBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default Vec3f addN(float scalar) { return addN(scalar, scalar, scalar); }
	default Vec3f addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default Vec3f subN(Vec3fBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default Vec3f subN(float scalar) { return subN(scalar, scalar, scalar); }
	default Vec3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default Vec3f mulN(Vec3fBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default Vec3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default Vec3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default Vec3f divN(Vec3fBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default Vec3f divN(float scalar) { return divN(scalar, scalar, scalar); }
	default Vec3f divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	default Vec3f cross(Vec3fBase v) 
	{
		return new Vector3f(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	default Vec3f project(Vec3fBase v)
	{	
		Vec3f vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vec3f rot(Vec3fBase axis, float angle)
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
	
	default Vec3f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}

	
	default Vec3f reflected(Vec3fBase normal)
	{
		Vec3f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vec3f lerped(Vec3fBase v, float f)
	{
		Vec3f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vec3fBase v) { return (double) this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec3fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec3fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

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
