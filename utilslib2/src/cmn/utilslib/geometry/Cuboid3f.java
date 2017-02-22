package cmn.utilslib.geometry;

import cmn.utilslib.matrix.Matrix4f;

public class Cuboid3f
{
	
	// assume we have a righthanded system where p0 is the lowest-left-front point, joining in the other points counterclockwise and 
	// the point p7 is the highest-right-back point
	
	public Point3f p0 = new Point3f();
	public Point3f p1 = new Point3f();
	public Point3f p2 = new Point3f();
	public Point3f p3 = new Point3f();
	public Point3f p4 = new Point3f();
	public Point3f p5 = new Point3f();
	public Point3f p6 = new Point3f();
	public Point3f p7 = new Point3f();
	public Point3f pc = new Point3f();
	
	public Cuboid3f()
	{
		
	}
	
	public Cuboid3f(Point3f p0, Point3f p7)
	{
		this.p0 = p0;
		this.p1 = new Point3f(p7.x, p0.y, p0.z);
		this.p2 = new Point3f(p7.x, p0.y, p7.z);
		this.p3 = new Point3f(p0.x, p0.y, p7.z);
		this.p4 = new Point3f(p0.x, p7.y, p7.z);
		this.p5 = new Point3f(p0.x, p7.y, p0.z);
		this.p6 = new Point3f(p7.x, p7.y, p0.z);
		this.p7 = p7;
		this.pc = p0.add(p0.directionTo(p7).mul(0.5f));
	}
	
	public Cuboid3f transform(Matrix4f m)
	{
		m.transform(p0);
		m.transform(p1);
		m.transform(p2);
		m.transform(p3);
		m.transform(p4);
		m.transform(p5);
		m.transform(p6);
		m.transform(p7);
		
		return this;	
	}
	
	public Cuboid3f transformed(Matrix4f m)
	{
		return clone().transform(m);
	}
	
	public Cuboid3f clone()
	{
		Cuboid3f c = new Cuboid3f();
		c.p0 = this.p0.clone();
		c.p1 = this.p1.clone();
		c.p2 = this.p2.clone();
		c.p3 = this.p3.clone();
		c.p4 = this.p4.clone();
		c.p5 = this.p5.clone();
		c.p6 = this.p6.clone();
		c.p7 = this.p7.clone();
		return c;
	}
}
