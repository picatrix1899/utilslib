package cmn.utilslib.math.vector.api;



import cmn.utilslib.math.Maths;
import cmn.utilslib.math.vector.PVector2f;

public interface Vec2fBase extends Vecf
{
	
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	/** The x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2f aX = PVector2f.gen(1.0f, 0.0f);
	/** The y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2f aY = PVector2f.gen(0.0f, 1.0f);
	
	/** The inverted x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2f aNX = PVector2f.gen(-1.0f, 0.0f);
	/** The inverted y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	static final PVector2f aNY = PVector2f.gen(0.0f, -1.0f);
	
	static final PVector2f ZERO = PVector2f.gen(0.0f, 0.0f);
	static final PVector2f ONE = PVector2f.gen(1.0f, 1.0f);
	
	static int DIMENSIONS = 2;
	
	
	
	float getX();
	float getY();

	@Override
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: return 0.0f;
		}
	}

	@Override
	default int getDimensions() { return DIMENSIONS; }
	
	Vec2f clone();
	


	
	
	Vec2f addN(Vec2fBase v);
	Vec2f addN(float scalar);
	Vec2f addN(double scalar);
	Vec2f addN(float x, float y);
	Vec2f addN(double x, double y);
	
	Vec2f subN(Vec2fBase v);
	Vec2f subN(float scalar);
	Vec2f subN(double scalar);
	Vec2f subN(float x, float y);
	Vec2f subN(double x, double y);
	
	Vec2f mulN(Vec2fBase v);
	Vec2f mulN(float scalar);
	Vec2f mulN(double scalar);
	Vec2f mulN(float x, float y);
	Vec2f mulN(double x, double y);
	
	Vec2f divN(Vec2fBase v);
	Vec2f divN(float scalar);
	Vec2f divN(double scalar);
	Vec2f divN(float x, float y);
	Vec2f divN(double x, double y);
	
	Vec2f inverted();
	
	Vec2f normalized();
	
	
	default float dot(Vec2fBase v) { return this.getX() * v.getX() + this.getY() * v.getY(); }
	
	default double angleRad(Vec2fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	default double angleDeg(Vec2fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	default float max() { return Math.max(this.getX(), this.getY()); }
	default float min() { return Math.min(this.getX(), this.getY()); }
	
	default float length() { return (float)Math.sqrt(squaredLength()); }
	default float squaredLength() { return getX() * getX() + getY() * getY(); }
	
}
