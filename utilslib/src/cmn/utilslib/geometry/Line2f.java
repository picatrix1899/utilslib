package cmn.utilslib.geometry;

import cmn.utilslib.vector.api.Vector2f;

public class Line2f
{
	public Point2f p1;
	public Point2f p2;
	
	public Line2f()
	{
		p1 = new Point2f();
		p2 = new Point2f();
	}
	
	public Line2f(Point2f p1, Point2f p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	private Line2f(Line2f l)
	{
		this.p1 = l.p1;
		this.p2 = l.p2;
	}
	
	public Vector2f vector()
	{
		return this.p1.vectorTo(this.p2);
	}
	
	public Vector2f direction()
	{
		return vector().normalize();
	}
	
	public String toString()
	{
		return "line2f(" + p1 + ", " + p2 + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Line2f)
		{
			Line2f l = (Line2f)obj;
			return this.p1.equals(l.p1) && this.p2.equals(l.p2);
		}
		
		return false;
	}
	
	public Line2f clone()
	{
		return new Line2f(this);
	}
}
