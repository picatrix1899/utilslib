package cmn.utilslib.vector.api;


import cmn.utilslib.essentials.Maths;
import cmn.utilslib.vector.PVector2d;

public interface Vec2dBase extends Vecd
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

	
	
	@Override
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: return 0.0d;
		}
	}

	@Override
	default int getDimensions() { return DIMENSIONS; }
	

	
	Vec2d clone();
	


	Vec2d addN(Vec2dBase v);
	Vec2d addN(float scalar); 
	Vec2d addN(double scalar); 
	Vec2d addN(float x, float y);
	Vec2d addN(double x, double y);
	
	Vec2d subN(Vec2dBase v); 
	Vec2d subN(float scalar); 
	Vec2d subN(double scalar); 
	Vec2d subN(float x, float y); 
	Vec2d subN(double x, double y);
	
	Vec2d mulN(Vec2dBase v);
	Vec2d mulN(float scalar); 
	Vec2d mulN(double scalar); 
	Vec2d mulN(float x, float y); 
	Vec2d mulN(double x, double y);
	
	Vec2d divN(Vec2dBase v);
	Vec2d divN(float scalar); 
	Vec2d divN(double scalar);
	Vec2d divN(float x, float y); 
	Vec2d divN(double x, double y);
	
	Vec2d inverted();
	
	Vec2d normalized();
	
	
	
	default double dot(Vec2dBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec2dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec2dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	default double max() { return Math.max(this.getX(), this.getY()); }
	default double min() { return Math.min(this.getX(), this.getY()); }
	
	default double length() { return Math.sqrt(squaredLength()); }
	default double squaredLength() { return getX() * getX() + getY() * getY(); }

}
