package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVec2f;

public interface Vector2dBase extends Streamable.Readable, Iterable<Double>
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
	
	
	
	double getX();
	double getY();

	Vector2d clone();
	

	
	default Vector2d absN(boolean x, boolean y) { return clone().abs(x, y); }

	

	
	
	default Vector2d addN(Vector2dBase v) { return addN(v.getX(), v.getY()); }
	default Vector2d addN(float scalar) { return addN(scalar, scalar); }
	default Vector2d addN(double scalar) { return addN(scalar, scalar); }
	default Vector2d addN(float x, float y) { return clone().add(x, y); }
	default Vector2d addN(double x, double y) { return clone().add(x, y); }
	
	default Vector2d subN(Vector2dBase v) { return subN(v.getX(), v.getY()); }
	default Vector2d subN(float scalar) { return subN(scalar, scalar); }
	default Vector2d subN(double scalar) { return subN(scalar, scalar); }
	default Vector2d subN(float x, float y) { return clone().sub(x, y); }
	default Vector2d subN(double x, double y) { return clone().sub(x, y); }
	
	default Vector2d mulN(Vector2dBase v) { return mulN(v.getX(), v.getY()); }
	default Vector2d mulN(float scalar) { return mulN(scalar, scalar); }
	default Vector2d mulN(double scalar) { return mulN(scalar, scalar); }
	default Vector2d mulN(float x, float y) { return clone().sub(x, y); }
	default Vector2d mulN(double x, double y) { return clone().sub(x, y); }
	
	default Vector2d divN(Vector2dBase v) { return divN(v.getX(), v.getY()); }
	default Vector2d divN(float scalar) { return divN(scalar, scalar); }
	default Vector2d divN(double scalar) { return divN(scalar, scalar); }
	default Vector2d divN(float x, float y) { return clone().sub(x, y); }
	default Vector2d divN(double x, double y) { return clone().sub(x, y); }
	
	
	
	default double dot(Vector2dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vector2dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vector2dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	default double max() { return Math.max(this.getX(), this.getY()); }
	default double min() { return Math.min(this.getX(), this.getY()); }
	
	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY(); }
	
	
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
					}
					
					index++;
					
					return out;					
				}
			
				return 0.0d;
			}
			
		};
	}
	
	default Vector2d inverted() { return clone().invert(); }
	
	default Vector2d normalized() { return clone().normalize(); }
	
	default Vector2d floorN() { return clone().floor(); }
	default Vector2d ceilN() { return clone().ceil(); }
	default Vector2d roundN() { return clone().round(); }
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(getX());
		dos.writeDouble(getY());
	}
}
