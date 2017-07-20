package cmn.utilslib.math.geometry;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.math.vector.Vector2f;

public class MinkowskiSum2f
{
	private Vector2f[] points;
	
	public MinkowskiSum2f(Vector2f[] a, Vector2f[] b)
	{
		this(a, b, false);
	}
	
	public MinkowskiSum2f(Vector2f[] a, Vector2f[] b, boolean difference)
	{
		
		ArrayList<Vector2f> sumPoints = Auto.ArrayList();
		
		if(difference)
		{
			for(Vector2f as : a)
			{
				sumPoints.addAll(calculatePointDifference(as, b));
			}
		}
		else
		{
			for(Vector2f as : a)
			{
				sumPoints.addAll(calculatePointSum(as, b));
			}
		}
		
		ArrayList<Vector2f> filtered = Auto.ArrayList();
		
		for(Vector2f v : sumPoints)
		{
			if(!filtered.contains(v))
				filtered.add(v);
		}
		
		this.points = (Vector2f[]) filtered.toArray();
	}
	
	public Vector2f[] getPoints()
	{
		return this.points;
	}
	
	public List<Vector2f> getPointList()
	{
		return Auto.ArrayList(this.points);
	}
	
	private List<Vector2f> calculatePointSum(Vector2f a, Vector2f[] b)
	{
		ArrayList<Vector2f> out = Auto.ArrayList();
		
		Vector2f next;
		
		for(Vector2f bs : b)
		{
			next = a.addN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
	
	private List<Vector2f> calculatePointDifference(Vector2f a, Vector2f[] b)
	{
		ArrayList<Vector2f> out = Auto.ArrayList();
		
		Vector2f next;
		
		for(Vector2f bs : b)
		{
			next = a.subN(bs);
			if(!out.contains(next))
				out.add(next);
		}
		
		return out;
	}
}
