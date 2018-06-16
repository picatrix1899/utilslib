package cmn.utilslib.math.vector;

import cmn.utilslib.math.vector.api.Vec2d;
import cmn.utilslib.math.vector.api.Vec2dBase;

public class Vector2dRounding
{
	
	public static Vector2d floorN(Vector2d v)
	{
		Vector2d out = v.clone();
		out.x = Math.floor(out.x);
		out.y = Math.floor(out.y);
		return out;
	}
	public static Vector2d floorN(Vector2d v, boolean x, boolean y)
	{
		Vector2d out = v.clone();
		if(x) out.x = Math.floor(out.x);
		if(y) out.y = Math.floor(out.y);
		return out;
	}
	public static Vec2d floorN(Vec2dBase v)
	{
		Vec2d out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		return out;
	}
	public static Vec2d floorN(Vec2dBase v, boolean x, boolean y)
	{
		Vec2d out = v.clone();
		if(x) out.setX(Math.floor(out.getX()));
		if(y) out.setY(Math.floor(out.getY()));
		return out;
	}
	public static Vector2d floor(Vector2d v)
	{
		v.x = Math.floor(v.x);
		v.y = Math.floor(v.y);
		return v;
	}
	public static Vector2d floor(Vector2d v, boolean x, boolean y)
	{
		if(x) v.x = Math.floor(v.x);
		if(y) v.y = Math.floor(v.y);
		return v;
	}
	public static Vec2d floor(Vec2d v)
	{
		v.setX(Math.floor(v.getX()));
		v.setY(Math.floor(v.getY()));
		return v;
	}
	public static Vec2d floor(Vec2d v, boolean x, boolean y)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		return v;
	}
	
	
	
	public static Vector2d ceilN(Vector2d v)
	{
		Vector2d out = v.clone();
		out.x = Math.ceil(out.x);
		out.y = Math.ceil(out.y);
		return out;
	}
	public static Vector2d ceilN(Vector2d v, boolean x, boolean y)
	{
		Vector2d out = v.clone();
		if(x) out.x = Math.ceil(out.x);
		if(y) out.y = Math.ceil(out.y);
		return out;
	}
	public static Vec2d ceilN(Vec2dBase v)
	{
		Vec2d out = v.clone();
		out.setX(Math.ceil(out.getX()));
		out.setY(Math.ceil(out.getY()));
		return out;
	}
	public static Vec2d ceilN(Vec2dBase v, boolean x, boolean y)
	{
		Vec2d out = v.clone();
		if(x) out.setX(Math.ceil(out.getX()));
		if(y) out.setY(Math.ceil(out.getY()));
		return out;
	}
	public static Vector2d ceil(Vector2d v)
	{
		v.x = Math.ceil(v.x);
		v.y = Math.ceil(v.y);
		return v;
	}
	public static Vector2d ceil(Vector2d v, boolean x, boolean y)
	{
		if(x) v.x = Math.ceil(v.x);
		if(y) v.y = Math.ceil(v.y);
		return v;
	}
	public static Vec2d ceil(Vec2d v)
	{
		v.setX(Math.ceil(v.getX()));
		v.setY(Math.ceil(v.getY()));
		return v;
	}
	public static Vec2d ceil(Vec2d v, boolean x, boolean y)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		return v;
	}
	
	
	
	public static Vector2d roundN(Vector2d v)
	{
		Vector2d out = v.clone();
		out.x = Math.round(out.x);
		out.y = Math.round(out.y);
		return out;
	}
	public static Vector2d roundN(Vector2d v, boolean x, boolean y)
	{
		Vector2d out = v.clone();
		if(x) out.x = Math.round(out.x);
		if(y) out.y = Math.round(out.y);
		return out;
	}
	public static Vec2d roundN(Vec2dBase v)
	{
		Vec2d out = v.clone();
		out.setX(Math.round(out.getX()));
		out.setY(Math.round(out.getY()));
		return out;
	}
	public static Vec2d roundN(Vec2dBase v, boolean x, boolean y)
	{
		Vec2d out = v.clone();
		if(x) out.setX(Math.round(out.getX()));
		if(y) out.setY(Math.round(out.getY()));
		return out;
	}
	public static Vector2d round(Vector2d v)
	{
		v.x = Math.round(v.x);
		v.y = Math.round(v.y);
		return v;
	}
	public static Vector2d round(Vector2d v, boolean x, boolean y)
	{
		if(x) v.x = Math.round(v.x);
		if(y) v.y = Math.round(v.y);
		return v;
	}
	public static Vec2d round(Vec2d v)
	{
		v.setX(Math.round(v.getX()));
		v.setY(Math.round(v.getY()));
		return v;
	}
	public static Vec2d round(Vec2d v, boolean x, boolean y)
	{
		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		return v;
	}
	
	
	
	public static Vector2d absN(Vector2d v)
	{
		Vector2d out = v.clone();
		out.x = Math.abs(out.x);
		out.y = Math.abs(out.y);
		return out;
	}
	public static Vector2d absN(Vector2d v, boolean x, boolean y)
	{
		Vector2d out = v.clone();
		if(x) out.x = Math.abs(out.x);
		if(y) out.y = Math.abs(out.y);
		return out;
	}
	public static Vec2d absN(Vec2dBase v)
	{
		Vec2d out = v.clone();
		out.setX(Math.abs(out.getX()));
		out.setY(Math.abs(out.getY()));
		return out;
	}
	public static Vec2d absN(Vec2dBase v, boolean x, boolean y)
	{
		Vec2d out = v.clone();
		if(x) out.setX(Math.abs(out.getX()));
		if(y) out.setY(Math.abs(out.getY()));
		return out;
	}
	public static Vector2d abs(Vector2d v)
	{
		v.x = Math.abs(v.x);
		v.y = Math.abs(v.y);
		return v;
	}
	public static Vector2d abs(Vector2d v, boolean x, boolean y)
	{
		if(x) v.x = Math.abs(v.x);
		if(y) v.y = Math.abs(v.y);
		return v;
	}
	public static Vec2d abs(Vec2d v)
	{
		v.setX(Math.abs(v.getX()));
		v.setY(Math.abs(v.getY()));
		return v;
	}
	public static Vec2d abs(Vec2d v, boolean x, boolean y)
	{
		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		return v;
	}
	
}
