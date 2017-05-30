package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3d;

public interface Vector3dBase extends Iterable<Double>, Streamable.Readable
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


	
	default Vector3d inverted() { return clone().invert(); }
	
	default Vector3d normalized() { return clone().normalize(); }

	default Vector3d floorN() { return clone().floor(); }
	default Vector3d ceilN() { return clone().ceil(); }
	default Vector3d roundN() { return clone().round(); }
	
	default Vector3d absN(boolean x, boolean y, boolean z) { return clone().abs(x, y, z); }
	
	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default Vector3d addN(float x, float y, float z) { return clone().add(x, y, z); }
	default Vector3d addN(double x, double y, double z) { return clone().add(x, y, z); }

	default Vector3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
	default Vector3d subN(double x, double y, double z) { return clone().sub(x, y, z); }

	default Vector3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	default Vector3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }

	default Vector3d divN(float x, float y, float z) { return clone().div(x, y, z); }
	default Vector3d divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	Vector3d clone();

	
	
	default Vector3d addN(Vector3dBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default Vector3d addN(float scalar) { return addN(scalar, scalar, scalar); }
	default Vector3d addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default Vector3d subN(Vector3dBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default Vector3d subN(float scalar) { return subN(scalar, scalar, scalar); }
	default Vector3d subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default Vector3d mulN(Vector3dBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default Vector3d mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default Vector3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default Vector3d divN(Vector3dBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default Vector3d divN(float scalar) { return divN(scalar, scalar, scalar); }
	default Vector3d divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	default Vector3d cross(Vector3dBase v) 
	{
		return new Vec3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	default Vector3d project(Vector3dBase v)
	{	
		Vector3d vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default Vector3d rot(Vector3dBase axis, float angle)
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
	
	default Vector3d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec3d(w.getX(), w.getY(), w.getZ());
	}

	
	default Vector3d reflected(Vector3dBase normal)
	{
		Vector3d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default Vector3d lerped(Vector3dBase v, float f)
	{
		Vector3d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(Vector3dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector3dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector3dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY() + getZ() * getZ(); }
	
	
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
					double out = 0;
					
					switch(this.index)
					{
						case 0: out = getX();
						case 1: out = getY();
						case 2: out = getZ();
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
	}
}
