package cmn.picatrix1899.utilslib.physics;

import cmn.picatrix1899.utilslib.vector.Vector3f;

public class AABB
{
	private Vector3f min;
	private Vector3f max;
	private Vector3f center;
	private Vector3f extend;
	
	private AABB() { }
	
	public static AABB getAABBFromMinMax(Vector3f min, Vector3f max)
	{
		AABB aabb = new AABB();
		
		aabb.min = Vector3f.minVal(min, max);
		aabb.max = Vector3f.maxVal(max, min);
		aabb.center = aabb.min.addN(aabb.max.subN(aabb.min).div(2.0f));
		aabb.extend = aabb.max.subN(aabb.center);
		
		return  aabb;
	}
	
	public static AABB getAABBFromCenterExtend(Vector3f center, Vector3f extend)
	{
		AABB aabb = new AABB();
		
		aabb.center = center;
		aabb.extend = extend;
		aabb.min = aabb.center.subN(aabb.extend);
		aabb.max = aabb.center.addN(aabb.extend);
		
		return aabb;
	}
	
	
	
	public Vector3f getMin()
	{
		return this.min;
	}
	
	public Vector3f getMax()
	{
		return this.max;
	}
	
	public Vector3f getCenter()
	{
		return this.center;
	}
	
	public Vector3f getExtend()
	{
		return this.extend;
	}
	
	public Vector3f getSize()
	{
		return this.extend.mulN(2.0f);
	}
	
	public AABB minkowskiDifference(AABB b)
	{
		Vector3f topleft = this.min.subN(b.max);
		
		Vector3f fullsize = getSize().addN(b.getSize());
		
		Vector3f halfsize = fullsize.mulN(0.5f);
		
		return AABB.getAABBFromCenterExtend(topleft.addN(halfsize), halfsize);
	}
	
	public Vector3f closestPointInBoundsToPoint(Vector3f p)
	{
		return null;
	}
}
