package cmn.utilslib.math.vector;

import cmn.utilslib.math.vector.api.Vec2f;
import cmn.utilslib.math.vector.api.Vec2fBase;

public class Vector2fRounding
{
	
	public static Vector2f floorN(Vector2f v)
	{
		Vector2f out = v.clone();
		out.x = (float)Math.floor(out.x);
		out.y = (float)Math.floor(out.y);
		return out;
	}
	public static Vector2f floorN(Vector2f v, boolean x, boolean y)
	{
		Vector2f out = v.clone();
		if(x) out.x = (float)Math.floor(out.x);
		if(y) out.y = (float)Math.floor(out.y);
		return out;
	}
	public static Vec2f floorN(Vec2fBase v)
	{
		Vec2f out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		return out;
	}
	public static Vec2f floorN(Vec2fBase v, boolean x, boolean y)
	{
		Vec2f out = v.clone();
		if(x) out.setX(Math.floor(out.getX()));
		if(y) out.setY(Math.floor(out.getY()));
		return out;
	}
	public static Vector2f floor(Vector2f v)
	{
		v.x = (float)Math.floor(v.x);
		v.y = (float)Math.floor(v.y);
		return v;
	}
	public static Vector2f floor(Vector2f v, boolean x, boolean y)
	{
		if(x) v.x = (float)Math.floor(v.x);
		if(y) v.y = (float)Math.floor(v.y);
		return v;
	}
	public static Vec2f floor(Vec2f v)
	{
		v.setX(Math.floor(v.getX()));
		v.setY(Math.floor(v.getY()));
		return v;
	}
	public static Vec2f floor(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		return v;
	}
	
	
	
	public static Vector2f ceilN(Vector2f v)
	{
		Vector2f out = v.clone();
		out.x = (float)Math.ceil(out.x);
		out.y = (float)Math.ceil(out.y);
		return out;
	}
	public static Vector2f ceilN(Vector2f v, boolean x, boolean y)
	{
		Vector2f out = v.clone();
		if(x) out.x = (float)Math.ceil(out.x);
		if(y) out.y = (float)Math.ceil(out.y);
		return out;
	}
	public static Vec2f ceilN(Vec2fBase v)
	{
		Vec2f out = v.clone();
		out.setX(Math.ceil(out.getX()));
		out.setY(Math.ceil(out.getY()));
		return out;
	}
	public static Vec2f ceilN(Vec2fBase v, boolean x, boolean y)
	{
		Vec2f out = v.clone();
		if(x) out.setX(Math.ceil(out.getX()));
		if(y) out.setY(Math.ceil(out.getY()));
		return out;
	}
	public static Vector2f ceil(Vector2f v)
	{
		v.x = (float)Math.ceil(v.x);
		v.y = (float)Math.ceil(v.y);
		return v;
	}
	public static Vector2f ceil(Vector2f v, boolean x, boolean y)
	{
		if(x) v.x = (float)Math.ceil(v.x);
		if(y) v.y = (float)Math.ceil(v.y);
		return v;
	}
	public static Vec2f ceil(Vec2f v)
	{
		v.setX(Math.ceil(v.getX()));
		v.setY(Math.ceil(v.getY()));
		return v;
	}
	public static Vec2f ceil(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		return v;
	}
	
	
	
	public static Vector2f roundN(Vector2f v)
	{
		Vector2f out = v.clone();
		out.x = (float)Math.round(out.x);
		out.y = (float)Math.round(out.y);
		return out;
	}
	public static Vector2f roundN(Vector2f v, boolean x, boolean y)
	{
		Vector2f out = v.clone();
		if(x) out.x = (float)Math.round(out.x);
		if(y) out.y = (float)Math.round(out.y);
		return out;
	}
	public static Vec2f roundN(Vec2fBase v)
	{
		Vec2f out = v.clone();
		out.setX(Math.round(out.getX()));
		out.setY(Math.round(out.getY()));
		return out;
	}
	public static Vec2f roundN(Vec2fBase v, boolean x, boolean y)
	{
		Vec2f out = v.clone();
		if(x) out.setX(Math.round(out.getX()));
		if(y) out.setY(Math.round(out.getY()));
		return out;
	}
	public static Vector2f round(Vector2f v)
	{
		v.x = (float)Math.round(v.x);
		v.y = (float)Math.round(v.y);
		return v;
	}
	public static Vector2f round(Vector2f v, boolean x, boolean y)
	{
		if(x) v.x = (float)Math.round(v.x);
		if(y) v.y = (float)Math.round(v.y);
		return v;
	}
	public static Vec2f round(Vec2f v)
	{
		v.setX(Math.round(v.getX()));
		v.setY(Math.round(v.getY()));
		return v;
	}
	public static Vec2f round(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		return v;
	}
	
	
	
	public static Vector2f absN(Vector2f v)
	{
		Vector2f out = v.clone();
		out.x = (float)Math.abs(out.x);
		out.y = (float)Math.abs(out.y);
		return out;
	}
	public static Vector2f absN(Vector2f v, boolean x, boolean y)
	{
		Vector2f out = v.clone();
		if(x) out.x = (float)Math.abs(out.x);
		if(y) out.y = (float)Math.abs(out.y);
		return out;
	}
	public static Vec2f absN(Vec2fBase v)
	{
		Vec2f out = v.clone();
		out.setX(Math.abs(out.getX()));
		out.setY(Math.abs(out.getY()));
		return out;
	}
	public static Vec2f absN(Vec2fBase v, boolean x, boolean y)
	{
		Vec2f out = v.clone();
		if(x) out.setX(Math.abs(out.getX()));
		if(y) out.setY(Math.abs(out.getY()));
		return out;
	}
	public static Vector2f abs(Vector2f v)
	{
		v.x = (float)Math.abs(v.x);
		v.y = (float)Math.abs(v.y);
		return v;
	}
	public static Vector2f abs(Vector2f v, boolean x, boolean y)
	{
		if(x) v.x = (float)Math.abs(v.x);
		if(y) v.y = (float)Math.abs(v.y);
		return v;
	}
	public static Vec2f abs(Vec2f v)
	{
		v.setX(Math.abs(v.getX()));
		v.setY(Math.abs(v.getY()));
		return v;
	}
	public static Vec2f abs(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		return v;
	}
	
}
