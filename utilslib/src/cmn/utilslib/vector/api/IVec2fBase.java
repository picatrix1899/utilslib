package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.PVec2f;

public interface IVec2fBase<T extends IVec2fBase<?>> extends Iterable<Float>, IStreamable.Readable
{
	
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	/** The x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVec2f aX = PVec2f.gen(1.0f, 0.0f);
	/** The y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVec2f aY = PVec2f.gen(0.0f, 1.0f);
	
	/** The inverted x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVec2f aNX = PVec2f.gen(-1.0f, 0.0f);
	/** The inverted y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVec2f aNY = PVec2f.gen(0.0f, -1.0f);
	
	static int DIMENSIONS = 2;
	
	
	
	float getX();
	float getY();


	

	
	T absN(boolean x, boolean y);
	
	
	
	T addN(float x, float y); 
	T addN(double x, double y); 

	
	
	
	T subN(float x, float y);
	T subN(double x, double y);

	
	
	
	T mulN(float x, float y); 
	T mulN(double x, double y); 

	
	

	T divN(float x, float y); 
	T divN(double x, double y);

	
	T clone();

	
	
	default T addN(IVec2fBase<?> v) { return addN(v.getX(), v.getY()); }
	default T addN(float scalar) { return addN(scalar, scalar); }
	default T addN(double scalar) { return addN(scalar, scalar); }
	
	default T subN(IVec2fBase<?> v) { return subN(v.getX(), v.getY()); }
	default T subN(float scalar) { return subN(scalar, scalar); }
	default T subN(double scalar) { return subN(scalar, scalar); }	
	
	default T mulN(IVec2fBase<?> v) { return mulN(v.getX(), v.getY()); }
	default T mulN(float scalar) { return mulN(scalar, scalar); }
	default T mulN(double scalar) { return mulN(scalar, scalar); }	
	
	default T divN(IVec2fBase<?> v) { return divN(v.getX(), v.getY()); }
	default T divN(float scalar) { return divN(scalar, scalar); }
	default T divN(double scalar) { return divN(scalar, scalar); }
	
	
	
	default float dot(IVec2fBase<?> v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(IVec2fBase<?> v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(IVec2fBase<?> v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	default float max() { return Math.max(this.getX(), this.getY()); }
	default float min() { return Math.min(this.getX(), this.getY()); }
	
	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY(); }
	
	
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
					}
					
					index++;
					
					return out;					
				}
			
				return 0.0f;
			}
			
		};
	}
	
	
	default int getDimensions() { return IVec2fBase.DIMENSIONS; }
	
	
	T inverted();
	
	T normalized();
	
	T floorN();
	T ceilN();
	T roundN();
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
	}
	 
}
