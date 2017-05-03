package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3d;

public interface IVec3dBase extends Iterable<Double>, IStreamable.Readable
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


	
	default IVec3d inverted() { return clone().invert(); }
	
	default IVec3d normalized() { return clone().normalize(); }

	default IVec3d floorN() { return clone().floor(); }
	default IVec3d ceilN() { return clone().ceil(); }
	default IVec3d roundN() { return clone().round(); }
	
	default IVec3d absN(boolean x, boolean y, boolean z) { return clone().abs(x, y, z); }
	
	default double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	default double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	default IVec3d addN(float x, float y, float z) { return clone().add(x, y, z); }
	default IVec3d addN(double x, double y, double z) { return clone().add(x, y, z); }

	default IVec3d subN(float x, float y, float z) { return clone().sub(x, y, z); }
	default IVec3d subN(double x, double y, double z) { return clone().sub(x, y, z); }

	default IVec3d mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	default IVec3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }

	default IVec3d divN(float x, float y, float z) { return clone().div(x, y, z); }
	default IVec3d divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	IVec3d clone();

	
	
	default IVec3d addN(IVec3dBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default IVec3d addN(float scalar) { return addN(scalar, scalar, scalar); }
	default IVec3d addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default IVec3d subN(IVec3dBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default IVec3d subN(float scalar) { return subN(scalar, scalar, scalar); }
	default IVec3d subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default IVec3d mulN(IVec3dBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default IVec3d mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default IVec3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default IVec3d divN(IVec3dBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default IVec3d divN(float scalar) { return divN(scalar, scalar, scalar); }
	default IVec3d divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	default IVec3d cross(IVec3dBase v) 
	{
		return new Vec3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	default IVec3d project(Vec3d v)
	{	
		IVec3d vn = v.normalized();
		 double f = this.dot(vn);
		 
		 return vn.mul((float)f);
	}
	
	
	default IVec3d rot(Vec3d axis, float angle)
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
	
	default IVec3d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec3d(w.getX(), w.getY(), w.getZ());
	}

	
	default IVec3d reflected(IVec3dBase normal)
	{
		IVec3d out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	default IVec3d lerped(IVec3dBase v, float f)
	{
		IVec3d out = clone();
		out.lerp(v, f);
		return out;
	}
	
	
	
	default double dot(IVec3dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(IVec3dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(IVec3dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }

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
