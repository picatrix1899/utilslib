package cmn.utilslib.math;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.vector.Vector3f;

public class MinkowskiSum3f
{
	private Vector3f[] points;
	
	public MinkowskiSum3f(Vector3f[] a, Vector3f[] b)
	{
		this(a, b, false);
	}
	
	public MinkowskiSum3f(Vector3f[] a, Vector3f[] b, boolean difference)
	{
		
		ArrayList<Vector3f> sumPoints = Auto.ArrayList();
		
		if(difference)
		{
			for(Vector3f as : a)
			{
				sumPoints.addAll(calculatePointDifference(as, b));
			}
		}
		else
		{
			for(Vector3f as : a)
			{
				sumPoints.addAll(calculatePointSum(as, b));
			}
		}
		
		ArrayList<Vector3f> filtered = Auto.ArrayList();
		
		for(Vector3f v : sumPoints)
		{
			if(!filtered.contains(v))
				filtered.add(v);
		}
		
		this.points = (Vector3f[]) filtered.toArray();
	}
	
	public Vector3f[] getPoints()
	{
		return this.points;
	}
	
	public List<Vector3f> getPointList()
	{
		return Auto.ArrayList(this.points);
	}
	
	private List<Vector3f> calculatePointSum(Vector3f a, Vector3f[] b)
	{
		ArrayList<Vector3f> out = Auto.ArrayList();
		
		Vector3f next;
		
		for(Vector3f bs : b)
		{
			next = a.addN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
	
	private List<Vector3f> calculatePointDifference(Vector3f a, Vector3f[] b)
	{
		ArrayList<Vector3f> out = Auto.ArrayList();
		
		Vector3f next;
		
		for(Vector3f bs : b)
		{
			next = a.subN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
}
