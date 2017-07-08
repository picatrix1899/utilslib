package cmn.utilslib.math.vector.api;


public interface Vec2f extends Vec2fBase
{
	
	Vec2f setZero();
	Vec2f set(Vec2fBase v);
	Vec2f set(Vec2dBase v);
	Vec2f set(float scalar);
	Vec2f set(double scalar);
	Vec2f set(float x, float y);
	Vec2f set(double x, double y);
	
	Vec2f setX(float x);
	Vec2f setX(double x);
	Vec2f setY(float y);
	Vec2f setY(double y);

	Vec2f add(Vec2fBase v);
	Vec2f add(Vec2dBase v);
	Vec2f add(float scalar);
	Vec2f add(double scalar);
	Vec2f add(float x, float y);
	Vec2f add(double x, double y);
	
	Vec2f sub(Vec2fBase v);
	Vec2f sub(Vec2dBase v);
	Vec2f sub(float scalar);
	Vec2f sub(double scalar);
	Vec2f sub(float x, float y);
	Vec2f sub(double x, double y);

	Vec2f mul(Vec2fBase v);
	Vec2f mul(Vec2dBase v);
	Vec2f mul(float scalar);
	Vec2f mul(double scalar);
	Vec2f mul(float x, float y);
	Vec2f mul(double x, double y);

	Vec2f div(Vec2fBase v);
	Vec2f div(Vec2dBase v);
	Vec2f div(float scalar);
	Vec2f div(double scalar);
	Vec2f div(float x, float y);
	Vec2f div(double x, double y);

	 
	
	Vec2f normalize();
	Vec2f invert();
	
}
