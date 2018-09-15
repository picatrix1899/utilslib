import cmn.utilslib.trees.btree.AABB3fBTree;
import cmn.utilslib.trees.btree.AABB3fBTreeBuilder;
import cmn.utilslib.trees.btree.AABB3fBTreeWalker;
import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.vector.Vector3f;

public class Main
{

	public static void main(String[] args)
	{
		
		AABB3fBTree<String> tree = new AABB3fBTree<String>();
		AABB3fBTreeBuilder<String> builder = new AABB3fBTreeBuilder<String>(tree);
		AABB3fBTreeWalker<String> walker = new AABB3fBTreeWalker<String>(tree);
		
		builder.add("A", new AABB3f(new Vector3f(11,11,11), new Vector3f(20,20,20)));
		builder.add("B", new AABB3f(new Vector3f(40,40,40), new Vector3f(60,60,60)));
		builder.add("A-C", new AABB3f(new Vector3f(0,0,0), new Vector3f(10,10,10)));
		
		walker.refreshLeafList();
		
		System.out.println(walker.getValueList());
		
		System.out.println(walker.walk(new AABB3f(new Vector3f(11,11,11), new Vector3f(15,15,15))));
		System.out.println(walker.walk(new AABB3f(new Vector3f(41,41,41), new Vector3f(44,44,44))));
		System.out.println(walker.walk(new AABB3f(new Vector3f(1,1,1), new Vector3f(3,3,3))));
	}

}
