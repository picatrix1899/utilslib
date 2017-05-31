package cmn.utilslib.vector.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.PVector2d;

public interface Vec2dBase extends Streamable.Readable, Iterable<Double>
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	/** The x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2d aX = PVector2d.gen(1.0d, 0.0d);
	/** The y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2d aY = PVector2d.gen(0.0d, 1.0d);
	
	/** The inverted x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2d aNX = PVector2d.gen(-1.0d, 0.0d);
	/** The inverted y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2d aNY = PVector2d.gen(0.0d, -1.0d);
	
	static int DIMENSIONS = 2;
	
	
	
	double getX();
	double getY();

	Vec2d clone();
	

	
	default Vec2d absN(boolean x, boolean y) { return clone().abs(x, y); }

	

	
	
	default Vec2d addN(Vec2dBase v) { return addN(v.getX(), v.getY()); }
	default Vec2d addN(float scalar) { return addN(scalar, scalar); }
	default Vec2d addN(double scalar) { return addN(scalar, scalar); }
	default Vec2d addN(float x, float y) { return clone().add(x, y); }
	default Vec2d addN(double x, double y) { return clone().add(x, y); }
	
	default Vec2d subN(Vec2dBase v) { return subN(v.getX(), v.getY()); }
	default Vec2d subN(float scalar) { return subN(scalar, scalar); }
	default Vec2d subN(double scalar) { return subN(scalar, scalar); }
	default Vec2d subN(float x, float y) { return clone().sub(x, y); }
	default Vec2d subN(double x, double y) { return clone().sub(x, y); }
	
	default Vec2d mulN(Vec2dBase v) { return mulN(v.getX(), v.getY()); }
	default Vec2d mulN(float scalar) { return mulN(scalar, scalar); }
	default Vec2d mulN(double scalar) { return mulN(scalar, scalar); }
	default Vec2d mulN(float x, float y) { return clone().sub(x, y); }
	default Vec2d mulN(double x, double y) { return clone().sub(x, y); }
	
	default Vec2d divN(Vec2dBase v) { return divN(v.getX(), v.getY()); }
	default Vec2d divN(float scalar) { return divN(scalar, scalar); }
	default Vec2d divN(double scalar) { return divN(scalar, scalar); }
	default Vec2d divN(float x, float y) { return clone().sub(x, y); }
	default Vec2d divN(double x, double y) { return clone().sub(x, y); }
	
	
	
	default double dot(Vec2dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec2dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec2dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
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
	
	default Vec2d inverted() { return clone().invert(); }
	
	default Vec2d normalized() { return clone().normalize(); }
	
	default Vec2d floorN() { return clone().floor(); }
	default Vec2d ceilN() { return clone().ceil(); }
	default Vec2d roundN() { return clone().round(); }
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(getX());
		dos.writeDouble(getY());
	}
}
