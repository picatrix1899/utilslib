package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.PVec3f;

public interface IVec3fBase<T extends IVec3fBase<?>> extends Iterable<Float>, IStreamable.Readable
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
	
	static int DIMENSIONS = 2;
	
	
	
	float getX();
	float getY();
	float getZ();


	
	T inverted();
	
	T normalized();
	
	T floorN();
	T ceilN();
	T roundN();
	
	T absN(boolean x, boolean y, boolean z);
	
	
	
	T addN(float x, float y, float z); 
	T addN(double x, double y, double z);

	T subN(float x, float y, float z); 
	T subN(double x, double y, double z);

	T mulN(float x, float y, float z); 
	T mulN(double x, double y, double z);

	T divN(float x, float y, float z); 
	T divN(double x, double y, double z);

	
	T clone();

	
	
	default T addN(IVec3fBase<?> v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default T addN(float scalar) { return addN(scalar, scalar, scalar); }
	default T addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	default T subN(IVec3fBase<?> v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default T subN(float scalar) { return subN(scalar, scalar, scalar); }
	default T subN(double scalar) { return subN(scalar, scalar, scalar); }	
	
	default T mulN(IVec3fBase<?> v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default T mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	default T mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	
	default T divN(IVec3fBase<?> v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default T divN(float scalar) { return divN(scalar, scalar, scalar); }
	default T divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	
	
	default float dot(IVec3fBase<?> v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(IVec3fBase<?> v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(IVec3fBase<?> v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	default float max() { return Math.max(this.getX(), this.getY()); }
	default float min() { return Math.min(this.getX(), this.getY()); }
	
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
			public boolean hasNext() { return this.index < getDimensions(); }

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
	
	
	default int getDimensions() { return IVec3fBase.DIMENSIONS; }
	

	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
		dos.writeFloat(getZ());
	}
}
