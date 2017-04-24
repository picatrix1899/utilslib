
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.IVec2fBase;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec2f implements IVec2fBase<Vec2f>
{

	/** {@inheritDoc} */ @Override
	public Vec2f clone() { return new Vec2f(this); }
	
	/** {@inheritDoc} */ @Override
	 public Vec2f inverted() { return clone().invert(); }

	
	/** {@inheritDoc} */ @Override
	public Vec2f normalized() { return clone().normalize(); }

	/** {@inheritDoc} */ @Override
	public Vec2f floorN() { return clone().floor(); }

	/** {@inheritDoc} */ @Override
	public Vec2f ceilN() { return clone().ceil(); }

	/** {@inheritDoc} */ @Override
	public Vec2f roundN() { return clone().round(); }

	
	/** {@inheritDoc} */ @Override
	public Vec2f addN(float x, float y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(double x, double y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(float x, double y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(float x, int y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(double x, float y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(double x, int y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(int x, float y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f addN(int x, double y) { return clone().add(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(float x, float y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(double x, double y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(float x, double y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(float x, int y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(double x, float y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(double x, int y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(int x, float y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f subN(int x, double y) { return clone().sub(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(float x, float y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(double x, double y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(float x, double y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(float x, int y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(double x, float y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(double x, int y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(int x, float y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f mulN(int x, double y) { return clone().mul(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(float x, float y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(double x, double y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(float x, double y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(float x, int y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(double x, float y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(double x, int y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(int x, float y) { return clone().div(x, y); }

	/** {@inheritDoc} */ @Override
	public Vec2f divN(int x, double y) { return clone().div(x, y); }
	
	/** {@inheritDoc} */ @Override
	public Vec2f absN(boolean x, boolean y) { return clone().abs(x, y); }
	
	
	/** generates a new persistent vector2f */
	public static PVec2f gen(final float x, final float y)
	{
		return new PVec2f()
		{

			/** {@inheritDoc} */ @Override
			public float getX() { return x; }
			
			/** {@inheritDoc} */ @Override
			public float getY() { return y; }

		};
	}
	
}
