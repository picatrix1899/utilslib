package cmn.utilslib.math.vector;

import cmn.utilslib.math.vector.api.Vec3d;
import cmn.utilslib.math.vector.api.Vec3dBase;

public class Vector3dRounding
{
	
	public static Vector3d floorN(Vector3d v)
	{
		Vector3d out = v.clone();
		out.x = (float)Math.floor(out.x);
		out.y = (float)Math.floor(out.y);
		out.z = (float)Math.floor(out.z);
		return out;
	}
	public static Vector3d floorN(Vector3d v, boolean x, boolean y, boolean z)
	{
		Vector3d out = v.clone();
		if(x) out.x = (float)Math.floor(out.x);
		if(y) out.y = (float)Math.floor(out.y);
		if(y) out.z = (float)Math.floor(out.z);
		return out;
	}
	public static Vec3d floorN(Vec3dBase v)
	{
		Vec3d out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		out.setZ(Math.floor(out.getZ()));
		return out;
	}
	public static Vec3d floorN(Vec3dBase v, boolean x, boolean y, boolean z)
	{
		Vec3d out = v.clone();
		if(x) out.setX(Math.floor(out.getX()));
		if(y) out.setY(Math.floor(out.getY()));
		if(y) out.setZ(Math.floor(out.getZ()));
		return out;
	}
	public static Vector3d floor(Vector3d v)
	{
		v.x = (float)Math.floor(v.x);
		v.y = (float)Math.floor(v.y);
		v.z = (float)Math.floor(v.z);
		return v;
	}
	public static Vector3d floor(Vector3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.x = (float)Math.floor(v.x);
		if(y) v.y = (float)Math.floor(v.y);
		if(z) v.z = (float)Math.floor(v.z);
		return v;
	}
	public static Vec3d floor(Vec3d v)
	{
		v.setX(Math.floor(v.getX()));
		v.setY(Math.floor(v.getY()));
		v.setZ(Math.floor(v.getZ()));
		return v;
	}
	public static Vec3d floor(Vec3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(y) v.setZ(Math.floor(v.getZ()));
		return v;
	}
	
	
	
	public static Vector3d ceilN(Vector3d v)
	{
		Vector3d out = v.clone();
		out.x = (float)Math.ceil(out.x);
		out.y = (float)Math.ceil(out.y);
		out.z = (float)Math.ceil(out.z);
		return out;
	}
	public static Vector3d ceilN(Vector3d v, boolean x, boolean y, boolean z)
	{
		Vector3d out = v.clone();
		if(x) out.x = (float)Math.ceil(out.x);
		if(y) out.y = (float)Math.ceil(out.y);
		if(y) out.z = (float)Math.ceil(out.z);
		return out;
	}
	public static Vec3d ceilN(Vec3dBase v)
	{
		Vec3d out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		out.setZ(Math.floor(out.getZ()));
		return out;
	}
	public static Vec3d ceilN(Vec3dBase v, boolean x, boolean y, boolean z)
	{
		Vec3d out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		out.setZ(Math.floor(out.getZ()));
		return out;
	}
	public static Vector3d ceil(Vector3d v)
	{
		v.x = (float)Math.ceil(v.x);
		v.y = (float)Math.ceil(v.y);
		v.z = (float)Math.ceil(v.z);
		return v;
	}
	public static Vector3d ceil(Vector3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.x = (float)Math.ceil(v.x);
		if(y) v.y = (float)Math.ceil(v.y);
		if(z) v.z = (float)Math.ceil(v.z);
		return v;
	}
	public static Vec3d ceil(Vec3d v)
	{
		v.setX(Math.ceil(v.getX()));
		v.setY(Math.ceil(v.getY()));
		v.setZ(Math.ceil(v.getZ()));
		return v;
	}
	public static Vec3d ceil(Vec3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(y) v.setZ(Math.ceil(v.getZ()));
		return v;
	}
	
	
	
	public static Vector3d roundN(Vector3d v)
	{
		Vector3d out = v.clone();
		out.x = (float)Math.round(out.x);
		out.y = (float)Math.round(out.y);
		out.z = (float)Math.round(out.z);
		return out;
	}
	public static Vector3d roundN(Vector3d v, boolean x, boolean y, boolean z)
	{
		Vector3d out = v.clone();
		if(x) out.x = (float)Math.round(out.x);
		if(y) out.y = (float)Math.round(out.y);
		if(y) out.z = (float)Math.round(out.z);
		return out;
	}
	public static Vec3d roundN(Vec3dBase v)
	{
		Vec3d out = v.clone();
		out.setX(Math.round(out.getX()));
		out.setY(Math.round(out.getY()));
		out.setZ(Math.round(out.getZ()));
		return out;
	}
	public static Vec3d roundN(Vec3dBase v, boolean x, boolean y, boolean z)
	{
		Vec3d out = v.clone();
		if(x) out.setX(Math.round(out.getX()));
		if(y) out.setY(Math.round(out.getY()));
		if(z) out.setZ(Math.round(out.getZ()));
		return out;
	}
	public static Vector3d round(Vector3d v)
	{
		v.x = (float)Math.round(v.x);
		v.y = (float)Math.round(v.y);
		v.z = (float)Math.round(v.z);
		return v;
	}
	public static Vector3d round(Vector3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.x = (float)Math.round(v.x);
		if(y) v.y = (float)Math.round(v.y);
		if(z) v.z = (float)Math.round(v.z);
		return v;
	}
	public static Vec3d round(Vec3d v)
	{
		v.setX(Math.round(v.getX()));
		v.setY(Math.round(v.getY()));
		v.setZ(Math.round(v.getZ()));
		return v;
	}
	public static Vec3d round(Vec3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(y) v.setZ(Math.round(v.getZ()));
		return v;
	}
	
	
	
	public static Vector3d absN(Vector3d v)
	{
		Vector3d out = v.clone();
		out.x = (float)Math.abs(out.x);
		out.y = (float)Math.abs(out.y);
		out.z = (float)Math.abs(out.z);
		return out;
	}
	public static Vector3d absN(Vector3d v, boolean x, boolean y, boolean z)
	{
		Vector3d out = v.clone();
		if(x) out.x = (float)Math.abs(out.x);
		if(y) out.y = (float)Math.abs(out.y);
		if(y) out.z = (float)Math.abs(out.z);
		return out;
	}
	public static Vec3d absN(Vec3dBase v)
	{
		Vec3d out = v.clone();
		out.setX(Math.abs(out.getX()));
		out.setY(Math.abs(out.getY()));
		out.setZ(Math.abs(out.getZ()));
		return out;
	}
	public static Vec3d absN(Vec3dBase v, boolean x, boolean y, boolean z)
	{
		Vec3d out = v.clone();
		if(x) out.setX(Math.abs(out.getX()));
		if(y) out.setY(Math.abs(out.getY()));
		if(z) out.setZ(Math.abs(out.getZ()));
		return out;
	}
	public static Vector3d abs(Vector3d v)
	{
		v.x = (float)Math.abs(v.x);
		v.y = (float)Math.abs(v.y);
		v.z = (float)Math.abs(v.z);
		return v;
	}
	public static Vector3d abs(Vector3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.x = (float)Math.abs(v.x);
		if(y) v.y = (float)Math.abs(v.y);
		if(z) v.z = (float)Math.abs(v.z);
		return v;
	}
	public static Vec3d abs(Vec3d v)
	{
		v.setX(Math.abs(v.getX()));
		v.setY(Math.abs(v.getY()));
		v.setZ(Math.abs(v.getZ()));
		return v;
	}
	public static Vec3d abs(Vec3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(y) v.setZ(Math.abs(v.getZ()));
		return v;
	}
	
}
