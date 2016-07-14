package cmn.picatrix1899.utilslib.physics.shapes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;
import cmn.picatrix1899.utilslib.vector.Vector2f;

public class Point2f implements DataHolder
{
	private Vector2f pos;
	
	public Point2f()
	{
		pos = new Vector2f();
	}
	
	public Point2f(Vector2f pos)
	{
		set(pos);
	}
	
	public Point2f(Point2f p)
	{
		set(p);
	}
	
	public Point2f set(Point2f p)
	{
		return set(p.getPos());
	}
	
	public Point2f set(Vector2f v)
	{
		return setPos(v);
	}
	
	public Point2f setPos(Vector2f v)
	{
		this.pos = v.clone();
		
		return this;
	}
	
	public Vector2f getPos()
	{
		return this.pos;
	}

	public void readData(InputStream stream) throws IOException
	{
		pos.readData(stream);
	}

	public void writeData(OutputStream stream) throws IOException
	{
		pos.writeData(stream);
	}
}
