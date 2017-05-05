package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVec2f;

public interface Vector2fBase extends Iterable<Float>, Streamable.Readable
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

	Vector2f clone();
	

	
	default Vector2f absN(boolean x, boolean y) { return clone().abs(x, y); }

	

	
	
	default Vector2f addN(Vector2fBase v) { return addN(v.getX(), v.getY()); }
	default Vector2f addN(float scalar) { return addN(scalar, scalar); }
	default Vector2f addN(double scalar) { return addN(scalar, scalar); }
	default Vector2f addN(float x, float y) { return clone().add(x, y); }
	default Vector2f addN(double x, double y) { return clone().add(x, y); }
	
	default Vector2f subN(Vector2fBase v) { return subN(v.getX(), v.getY()); }
	default Vector2f subN(float scalar) { return subN(scalar, scalar); }
	default Vector2f subN(double scalar) { return subN(scalar, scalar); }
	default Vector2f subN(float x, float y) { return clone().sub(x, y); }
	default Vector2f subN(double x, double y) { return clone().sub(x, y); }
	
	default Vector2f mulN(Vector2fBase v) { return mulN(v.getX(), v.getY()); }
	default Vector2f mulN(float scalar) { return mulN(scalar, scalar); }
	default Vector2f mulN(double scalar) { return mulN(scalar, scalar); }
	default Vector2f mulN(float x, float y) { return clone().sub(x, y); }
	default Vector2f mulN(double x, double y) { return clone().sub(x, y); }
	
	default Vector2f divN(Vector2fBase v) { return divN(v.getX(), v.getY()); }
	default Vector2f divN(float scalar) { return divN(scalar, scalar); }
	default Vector2f divN(double scalar) { return divN(scalar, scalar); }
	default Vector2f divN(float x, float y) { return clone().sub(x, y); }
	default Vector2f divN(double x, double y) { return clone().sub(x, y); }
	
	
	
	default float dot(Vector2fBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector2fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector2fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
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
					}
					
					index++;
					
					return out;					
				}
			
				return 0.0f;
			}
			
		};
	}
	
	default Vector2f inverted() { return clone().invert(); }
	
	default Vector2f normalized() { return clone().normalize(); }
	
	default Vector2f floorN() { return clone().floor(); }
	default Vector2f ceilN() { return clone().ceil(); }
	default Vector2f roundN() { return clone().round(); }
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
	}
	 
}
