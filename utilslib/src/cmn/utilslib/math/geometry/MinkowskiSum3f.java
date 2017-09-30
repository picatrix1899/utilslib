package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.Vector3f;

public class MinkowskiSum3f implements ConvexPolygonalShape3f
{
	private Point3f[] points;
	
	public MinkowskiSum3f(ConvexPolygonalShape3f a, ConvexPolygonalShape3f b)
	{
		this(a, b, false);
	}
	
	public MinkowskiSum3f(ConvexPolygonalShape3f a, ConvexPolygonalShape3f b, boolean difference)
	{
		Point3f[] pointsA = a.getPoints();
		Point3f[] pointsB = b.getPoints();
		
		ArrayList<Point3f> sumPoints = Auto.ArrayList();
		
		if(difference)
		{
			for(Point3f as : pointsA)
			{
				sumPoints.addAll(calculatePointDifference(as, pointsB));
			}
		}
		else
		{
			for(Point3f as : pointsA)
			{
				sumPoints.addAll(calculatePointSum(as, pointsB));
			}
		}
		
		ArrayList<Point3f> filtered = Auto.ArrayList();
		
		for(Point3f v : sumPoints)
		{
			if(!filtered.contains(v))
				filtered.add(v);
		}
		
		this.points = (Point3f[]) filtered.toArray();
	}
	
	public Point3f[] getPoints()
	{
		return this.points;
	}
	
	public List<Point3f> getPointList()
	{
		return Auto.ArrayList(this.points);
	}
	
	private List<Point3f> calculatePointSum(Point3f a, Point3f[] b)
	{
		ArrayList<Point3f> out = Auto.ArrayList();
		
		Point3f next;
		
		for(Point3f bs : b)
		{
			next = new Point3f(a.asVector3f(Vector3f.TEMP0).add(bs.asVector3f(Vector3f.TEMP1)));
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
	
	private List<Point3f> calculatePointDifference(Point3f a, Point3f[] b)
	{
		ArrayList<Point3f> out = Auto.ArrayList();
		
		Point3f next;
		
		for(Point3f bs : b)
		{
			next = new Point3f(a.asVector3f(Vector3f.TEMP0).sub(bs.asVector3f(Vector3f.TEMP1)));
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}

	public AABB3f getAABBf(Matrix4f t, AABB3f aabb)
	{
		return null;
	}

	public OBB3f getOBBf(Matrix4f t)
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref(Matrix4f t)
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElipsoidf(Matrix4f t)
	{
		return null;
	}

	public AABB3f getAABBf(AABB3f aabb)
	{
		return null;
	}

	public OBB3f getOBBf()
	{
		return null;
	}

	public BoundingSpheref getBoundingSpheref()
	{
		return null;
	}

	public BoundingElipsoidf getBoundingElisoidf()
	{
		return null;
	}

	public Point3f[] getPoints(Matrix4f t)
	{
		return null;
	}

	public ConvexPolygonalShape3f transform(Matrix4f t)
	{
		return null;
	}
	

}
