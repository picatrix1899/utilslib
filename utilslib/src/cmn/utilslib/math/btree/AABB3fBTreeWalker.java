package cmn.utilslib.math.btree;

import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.vector.Vector3f;

public class AABB3fBTreeWalker<T> extends BTreeWalker<T, AABB3f>
{

	public AABB3fBTreeWalker(BTree<T,AABB3f> tree)
	{
		super(tree);
	}

	public T walk(AABB3f aabb)
	{
		return super.walk((AABB3f oldAABB) -> { return isOverlapping(oldAABB, aabb);
			
		});
	}

	protected boolean isOverlapping(AABB3f oldEvalData, AABB3f newEvalData)
	{
		Vector3f minA = newEvalData.getMin();
		Vector3f maxA = newEvalData.getMax();
		
		return isPointInside(minA, oldEvalData) || isPointInside(maxA, oldEvalData);
		
		
	}
	
	private boolean isPointInside(Vector3f point, AABB3f area)
	{
		Vector3f minB = area.getMin();
		Vector3f maxB = area.getMax();
		
		return minB.x <= point.x && point.x <= maxB.x &&
			   minB.y <= point.y && point.y <= maxB.y &&
			   minB.z <= point.z && point.z <= maxB.z;
	}
}
