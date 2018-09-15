package cmn.utilslib.trees.btree;


import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.vector.Vector3f;

public class AABB3fBTreeBuilder<T> extends BTreeBuilder<T,AABB3f>
{

	public AABB3fBTreeBuilder(BTree<T,AABB3f> tree)
	{
		super(tree);
	}

	protected void recalculateEvalData(BTreeNode<T,AABB3f> node)
	{
		if(node.b != null)
			node.evalData = mergeAABBs(node.a.evalData, node.b.evalData);
		else
			node.evalData = node.a.evalData;
	}
	
	public AABB3f mergeAABBs(AABB3f a, AABB3f b)
	{
		Vector3f minA = a.getMin();
		Vector3f maxA = a.getMax();
		Vector3f minB = b.getMin();
		Vector3f maxB = b.getMax();
		
		float minX = minA.x <= minB.x ? minA.x : minB.x;
		float minY = minA.y <= minB.y ? minA.y : minB.y;
		float minZ = minA.z <= minB.z ? minA.z : minB.z;
		
		float maxX = maxA.x >= maxB.x ? maxA.x : maxB.x;
		float maxY = maxA.y >= maxB.y ? maxA.y : maxB.y;
		float maxZ = maxA.z >= maxB.z ? maxA.z : maxB.z;

		return new AABB3f(new Vector3f(minX, minY, minZ), new Vector3f(maxX, maxY, maxZ));
	}

	protected boolean isInRange(AABB3f oldEvalData, AABB3f newEvalData)
	{
		Vector3f minA = newEvalData.getMin();
		Vector3f minB = oldEvalData.getMin();
		Vector3f maxA = newEvalData.getMax();
		Vector3f maxB = oldEvalData.getMax();
		
		if(minA.x < minB.x) return false;
		if(minA.y < minB.y) return false;
		if(minA.z < minB.z) return false;
		
		if(maxA.x > maxB.x) return false;
		if(maxA.y > maxB.y) return false;
		if(maxA.z > maxB.z) return false;
		
		return true;
	}
	


	protected boolean getClosest(BTreeContent<T,AABB3f> a, BTreeContent<T,AABB3f> b,
			AABB3f newEvalData)
	{
		
		
		float distMinXA = a.evalData.getMin().x - newEvalData.getMin().x;
		float distMinYA = a.evalData.getMin().y - newEvalData.getMin().y;
		float distMinZA = a.evalData.getMin().z - newEvalData.getMin().z;
		float distMinA = distMinXA * distMinXA + distMinYA * distMinYA + distMinZA * distMinZA;
		
		float distMinXB = b.evalData.getMin().x - newEvalData.getMin().x;
		float distMinYB = b.evalData.getMin().y - newEvalData.getMin().y;
		float distMinZB = b.evalData.getMin().z - newEvalData.getMin().z;
		float distMinB = distMinXB * distMinXB + distMinYB * distMinYB + distMinZB * distMinZB;
		
		float distMaxXA = a.evalData.getMax().x - newEvalData.getMax().x;
		float distMaxYA = a.evalData.getMax().y - newEvalData.getMax().y;
		float distMaxZA = a.evalData.getMax().z - newEvalData.getMax().z;
		float distMaxA = distMaxXA * distMaxXA + distMaxYA * distMaxYA + distMaxZA * distMaxZA;
		
		float distMaxXB = b.evalData.getMax().x - newEvalData.getMax().x;
		float distMaxYB = b.evalData.getMax().y - newEvalData.getMax().y;
		float distMaxZB = b.evalData.getMax().z - newEvalData.getMax().z;
		float distMaxB = distMaxXB * distMaxXB + distMaxYB * distMaxYB + distMaxZB * distMaxZB;

		float smallestX = distMinA;
		boolean out = true;
		
		if(distMinB < smallestX)
		{
			smallestX = distMinB;
			out = false;
		}
		
		if(distMaxA < smallestX)
		{
			smallestX = distMaxA;
			out = true;
		}
		
		if(distMaxB < smallestX)
		{
			smallestX = distMaxB;
			out = false;
		}
		
		return out;
	}
}
