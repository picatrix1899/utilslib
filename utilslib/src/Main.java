import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.btree.BTree;
import cmn.utilslib.math.btree.BTreeEvaluation;
import cmn.utilslib.math.btree.BTreeLeaf;
import cmn.utilslib.math.btree.BTreeNode;
import cmn.utilslib.math.btree.BTreeWalker;
import cmn.utilslib.math.geometry.AABB3f;
import cmn.utilslib.math.geometry.CollisionResolver;
import cmn.utilslib.math.geometry.OBB3f;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.geometry.RayOBBResolver;
import cmn.utilslib.math.matrix.Matrix2f;
import cmn.utilslib.math.matrix.Matrix3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec2fBase;

public class Main
{
	public static void main(String[] args)
	{
//		Matrix4f m = Matrix4f.identity();
//		
//		Quaternion q = Quaternion.getFromAxis(Vector3f.aZ, 45);
//		
//		 m = m.initRotation(q);
//		
//		Point3f c = new Point3f(0,0,0);
//		Vector3f e = new Vector3f(20);
//		
//		OBB3f obb = new OBB3f(c, e, m);
//		
//		for(Point3f p : obb.getPoints())
//		{
//			System.out.println(p);
//		}
		
		testBTree();
	}
	
	public static Point3f test(Vector3f halfExtend, Matrix3f modelSpace)
	{
		Vector3f v = new Vector3f();
		
		Matrix3f objToWorld = new Matrix3f();
		
		objToWorld.m0.x = modelSpace.m0.x;
		objToWorld.m0.y = modelSpace.m1.x;
		objToWorld.m0.z = modelSpace.m2.x;
		objToWorld.m1.x = modelSpace.m0.y;
		objToWorld.m1.y = modelSpace.m1.y;
		objToWorld.m1.z = modelSpace.m2.y;
		objToWorld.m2.x = modelSpace.m0.z;
		objToWorld.m2.y = modelSpace.m1.z;
		objToWorld.m2.z = modelSpace.m2.z;
		
		v = modelSpace.transformN(halfExtend);

		System.out.println(v);
		
		return new Point3f(objToWorld.transform(new Vector3f(v.x, v.y, v.z)));
	}
	
	public static void a()
	{
		Vector2f o = Vector2f.ZERO.clone();
		Vector2f vx = new Vector2f(1, -1).normalize();
		Vector2f vy = new Vector2f(1, 1).normalize();
		Vector2f v = new Vector2f(0.3, 1).normalize();
		
		Vector2f min = new Vector2f(10, 30);
		Vector2f a = new Vector2f(30, 50);
		Vector2f max = new Vector2f(50, 30);
		Vector2f b = new Vector2f(30, 10);
		
		Vector2f omin = min.subN(o);
		Vector2f omax = max.subN(o);
		
		double oMinX = omin.dot(vx);
		double oMaxX = omax.dot(vx);
		double oMinY = omin.dot(vy);
		double oMaxY = omax.dot(vy);
		
		double dx = v.dot(vx);
		double dy = v.dot(vy);
		
		boolean result;
		
		double tmin = oMinX / dx;
	    double tmax = oMaxX / dx;
	    
	    if(tmin > tmax)
	    {
	    	double temp0 = tmin;
	    	tmin = tmax;
	    	tmax = temp0;
	    }
	    
	    double tymin = oMinY / dy;
	    double tymax = oMaxY / dy;
	    
	    if(tmin > tmax)
	    {
	    	double temp0 = tymin;
	    	tymin = tymax;
	    	tymax = temp0;
	    }
	    
	    

	    if ((tmin > tymax) || (tymin > tmax)) 
	    	result = false;
	    else
	    	result = true;
		
		System.out.println(result);
		
		
		//Vector2f vx = new Vector2f(0.5,-0.5).normalize();
		//Vector2f vy = new Vector2f(0.5,0.5).normalize();
		
		
		
		//Matrix2f m = Matrix2f.rotation(vy, vx);
		
		//boolean b = intersect(Vector2f.ZERO, new Vector2f(1, 3).normalize(), m, new Vector2f(25,25), new Vector2f(15,15));

		//System.out.println(b);
	}
	
//	public static boolean intersect(Vec2fBase orig, Vector2f dir, Matrix2f m, Vector2f center, Vector2f halfExtend)
//	{
//		Vector2f torig = Matrix2f.transform(m, orig, null);
//		Vector2f tdir = Matrix2f.transform(m, dir, null).normalize();
//		
//		Vector2f oMin = center.subN(halfExtend);
//		Vector2f oMax = center.addN(halfExtend);
//		
//		Vector2f[] p = new Vector2f[4];
//		p[0] = Matrix2f.transform(m, oMin, null);
//		p[1] = Matrix2f.transform(m, new Vector2f(oMax.x, oMin.y), null);
//		p[2] = Matrix2f.transform(m, oMax, null);
//		p[3] = Matrix2f.transform(m, new Vector2f(oMin.x, oMax.y), null);
//		
//		
//		
//		float minX = Float.POSITIVE_INFINITY;
//		float minY = Float.POSITIVE_INFINITY;
//		
//		float maxX = Float.NEGATIVE_INFINITY;
//		float maxY = Float.NEGATIVE_INFINITY;
//		
//		for(Vector2f v : p)
//		{
//			
//			if(v.x < minX) minX = v.x;
//			
//			if(v.x > maxX) maxX = v.x;
//			
//			if(v.y < minY) minY = v.y;
//			
//			if(v.y > maxY) maxY = v.y;
//			
//		}
//
//		float tmin = (min.x - torig.getX()) / tdir.x; 
//	    float tmax = (max.x - torig.getX()) / tdir.x; 
//	    
//	    if(tmin > tmax)
//	    {
//	    	float temp0 = tmin;
//	    	tmin = tmax;
//	    	tmax = temp0;
//	    }
//	    
//	    float tymin = (min.y - torig.getY()) / tdir.y; 
//	    float tymax = (max.y - torig.getY()) / tdir.y; 
//	    
//	    if(tmin > tmax)
//	    {
//	    	float temp0 = tymin;
//	    	tymin = tymax;
//	    	tymax = temp0;
//	    }
//	    
//	    
//
//	    if ((tmin > tymax) || (tymin > tmax)) 
//	        return false; 
//
//	    return true;
//	}
	
	public static void testBTree()
	{
		BTreeLeaf<String,AABB3f> leaf1 = new BTreeLeaf<String,AABB3f>();
		leaf1.evalData = new AABB3f(new Vector3f(-60, -60, -20), new Vector3f(-20,-20,20));
		leaf1.data = "Leaf1 (-60,-60) - (-20,-20)";
		
		BTreeLeaf<String,AABB3f> leaf2 = new BTreeLeaf<String,AABB3f>();
		leaf2.evalData = new AABB3f(new Vector3f(-120, -60,-20), new Vector3f(-80,-20,20));
		leaf2.data = "Leaf2 (-120,-60) - (-80,-20)";
		
		BTreeNode<String,AABB3f> nodeA = new BTreeNode<String,AABB3f>();
		nodeA.a = leaf1;
		nodeA.b = leaf2;
		nodeA.evalData = new AABB3f(new Vector3f(-120,-60,-20), new Vector3f(-20,-20,20));
		
		
		BTreeLeaf<String,AABB3f> leaf3 = new BTreeLeaf<String,AABB3f>();
		leaf3.evalData = new AABB3f(new Vector3f(-180, -60, -20), new Vector3f(-140,-20,20));
		leaf3.data = "Leaf3 (-180,-60) - (-140,-20)";
		
		BTreeLeaf<String,AABB3f> leaf4 = new BTreeLeaf<String,AABB3f>();
		leaf4.evalData = new AABB3f(new Vector3f(-240, -60,-20), new Vector3f(-200,-20,20));
		leaf4.data = "Leaf4 (-240,-60) - (-200,-20)";
		
		BTreeNode<String,AABB3f> nodeB = new BTreeNode<String,AABB3f>();
		nodeB.a = leaf3;
		nodeB.b = leaf4;
		nodeB.evalData = new AABB3f(new Vector3f(-240,-60,-20), new Vector3f(-140,-20,20));
		
		
		BTreeLeaf<String,AABB3f> leaf5 = new BTreeLeaf<String,AABB3f>();
		leaf5.evalData = new AABB3f(new Vector3f(-120, -120, -20), new Vector3f(-80,-80,20));
		leaf5.data = "Leaf5 (-120,-120) - (-80,-80)";
		
		BTreeLeaf<String,AABB3f> leaf6 = new BTreeLeaf<String,AABB3f>();
		leaf6.evalData = new AABB3f(new Vector3f(-60, -120,-20), new Vector3f(-20,-80,20));
		leaf6.data = "Leaf6 (-60,-120) - (-20,-80)";
		
		BTreeNode<String,AABB3f> nodeC = new BTreeNode<String,AABB3f>();
		nodeC.a = leaf5;
		nodeC.b = leaf6;
		nodeC.evalData = new AABB3f(new Vector3f(-120,-120,-20), new Vector3f(-20,-80,20));
		
		
		BTreeLeaf<String,AABB3f> leaf7 = new BTreeLeaf<String,AABB3f>();
		leaf7.evalData = new AABB3f(new Vector3f(-60, -180, -20), new Vector3f(-20,-140,20));
		leaf7.data = "Leaf7 (-60,-180) - (-20,-140)";
		
		BTreeLeaf<String,AABB3f> leaf8 = new BTreeLeaf<String,AABB3f>();
		leaf8.evalData = new AABB3f(new Vector3f(-60, -240,-20), new Vector3f(-20,-200,20));
		leaf8.data = "Leaf8 (-60,-240) - (-20,-200)";
		
		BTreeNode<String,AABB3f> nodeD = new BTreeNode<String,AABB3f>();
		nodeD.a = leaf7;
		nodeD.b = leaf8;
		nodeD.evalData = new AABB3f(new Vector3f(-60,-240,-20), new Vector3f(-20,-140,20));
		
		
		BTreeNode<String,AABB3f> nodeAB = new BTreeNode<String,AABB3f>();
		nodeAB.a = nodeA;
		nodeAB.b = nodeB;
		nodeAB.evalData = new AABB3f(new Vector3f(-240,-60,-20), new Vector3f(-140,-20,20));
		
		BTreeNode<String,AABB3f> nodeCD = new BTreeNode<String,AABB3f>();
		nodeCD.a = nodeC;
		nodeCD.b = nodeD;
		nodeCD.evalData = new AABB3f(new Vector3f(-120,-240,-20), new Vector3f(-20,-80,20));
		
		
		BTreeNode<String,AABB3f> nodeABCD = new BTreeNode<String,AABB3f>();
		nodeABCD.a = nodeAB;
		nodeABCD.b = nodeCD;
		nodeABCD.evalData = new AABB3f(new Vector3f(-240,-240,-20), new Vector3f(-20,-20,20));
		
		
		
		
		BTreeLeaf<String,AABB3f> leaf9 = new BTreeLeaf<String,AABB3f>();
		leaf1.evalData = new AABB3f(new Vector3f(20, 20, -20), new Vector3f(60,60,20));
		leaf1.data = "Leaf9 (20,20) - (60,60)";
		
		
		BTreeLeaf<String,AABB3f> leaf10 = new BTreeLeaf<String,AABB3f>();
		leaf2.evalData = new AABB3f(new Vector3f(80, 20,-20), new Vector3f(120,60,20));
		leaf2.data = "Leaf10 (80,20) - (120,60)";
		
		BTreeLeaf<String,AABB3f> leaf11 = new BTreeLeaf<String,AABB3f>();
		leaf3.evalData = new AABB3f(new Vector3f(80, 80, -20), new Vector3f(120,120,20));
		leaf3.data = "Leaf11 (80,80) - (120,120)";
		
		BTreeNode<String,AABB3f> nodeE = new BTreeNode<String,AABB3f>();
		nodeE.a = leaf10;
		nodeE.b = leaf11;
		nodeE.evalData = new AABB3f(new Vector3f(80,20,-20), new Vector3f(120,120,20));
		
		BTreeNode<String,AABB3f> nodeEF = new BTreeNode<String,AABB3f>();
		nodeEF.a = leaf9;
		nodeEF.b = nodeE;
		nodeEF.evalData = new AABB3f(new Vector3f(20,20,-20), new Vector3f(120,120,20));
		
		
		
		BTree<String,AABB3f> btree = new BTree<String,AABB3f>();
		
		btree.a = nodeABCD;
		btree.b = nodeEF;
		
		
		AABB3f player = new AABB3f(new Point3f(-200,-40,0), new Vector3f(10,10,10));
		
		BTreeEvaluation<AABB3f> eval = (e) ->
		{
			return CollisionResolver.iAABBAABB3f(e, player);
		};
		
		BTreeWalker<String,AABB3f> walker = new BTreeWalker<String,AABB3f>(btree);
		
		String s = walker.walk(eval);
		
		System.out.println(s);
	}
}
