package cmn.utilslib.math.vector;

import cmn.utilslib.math.vector.api.Vec4f;
import cmn.utilslib.math.vector.api.Vec4fBase;

public class Vector4fRounding
{

	public static Vector4f floorN(Vector4f v)
	{
		Vector4f out = v.clone();
		out.x = (float)Math.floor(out.x);
		out.y = (float)Math.floor(out.y);
		out.z = (float)Math.floor(out.z);
		out.a = (float)Math.floor(out.a);
		return out;
	}
	public static Vector4f floorN(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		Vector4f out = v.clone();
		if(x) out.x = (float)Math.floor(out.x);
		if(y) out.y = (float)Math.floor(out.y);
		if(z) out.z = (float)Math.floor(out.z);
		if(a) out.a = (float)Math.floor(out.a);
		return out;
	}
	public static Vec4f floorN(Vec4fBase v)
	{
		Vec4f out = v.clone();
		out.setX(Math.floor(out.getX()));
		out.setY(Math.floor(out.getY()));
		out.setZ(Math.floor(out.getZ()));
		out.setA(Math.floor(out.getA()));
		return out;
	}
	public static Vec4f floorN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a)
	{
		Vec4f out = v.clone();
		if(x) out.setX(Math.floor(out.getX()));
		if(y) out.setY(Math.floor(out.getY()));
		if(z) out.setZ(Math.floor(out.getZ()));
		if(a) out.setA(Math.floor(out.getA()));
		return out;
	}
	public static Vector4f floor(Vector4f v)
	{
		v.x = (float)Math.floor(v.x);
		v.y = (float)Math.floor(v.y);
		v.z = (float)Math.floor(v.z);
		v.a = (float)Math.floor(v.a);
		return v;
	}
	public static Vector4f floor(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.x = (float)Math.floor(v.x);
		if(y) v.y = (float)Math.floor(v.y);
		if(z) v.z = (float)Math.floor(v.z);
		if(a) v.a = (float)Math.floor(v.a);
		return v;
	}
	public static Vec4f floor(Vec4f v)
	{
		v.setX(Math.floor(v.getX()));
		v.setY(Math.floor(v.getY()));
		v.setZ(Math.floor(v.getZ()));
		v.setA(Math.floor(v.getA()));
		return v;
	}
	public static Vec4f floor(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(z) v.setZ(Math.floor(v.getZ()));
		if(a) v.setA(Math.floor(v.getA()));
		return v;
	}
	
	
	
	public static Vector4f ceilN(Vector4f v)
	{
		Vector4f out = v.clone();
		out.x = (float)Math.ceil(out.x);
		out.y = (float)Math.ceil(out.y);
		out.z = (float)Math.ceil(out.z);
		out.a = (float)Math.ceil(out.a);
		return out;
	}
	public static Vector4f ceilN(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		Vector4f out = v.clone();
		if(x) out.x = (float)Math.ceil(out.x);
		if(y) out.y = (float)Math.ceil(out.y);
		if(z) out.z = (float)Math.ceil(out.z);
		if(a) out.a = (float)Math.ceil(out.a);
		return out;
	}
	public static Vec4f ceilN(Vec4fBase v)
	{
		Vec4f out = v.clone();
		out.setX(Math.ceil(out.getX()));
		out.setY(Math.ceil(out.getY()));
		out.setZ(Math.ceil(out.getZ()));
		out.setA(Math.ceil(out.getA()));
		return out;
	}
	public static Vec4f ceilN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a)
	{
		Vec4f out = v.clone();
		if(x) out.setX(Math.ceil(out.getX()));
		if(y) out.setY(Math.ceil(out.getY()));
		if(z) out.setZ(Math.ceil(out.getZ()));
		if(a) out.setA(Math.ceil(out.getA()));
		return out;
	}
	public static Vector4f ceil(Vector4f v)
	{
		v.x = (float)Math.ceil(v.x);
		v.y = (float)Math.ceil(v.y);
		v.z = (float)Math.ceil(v.z);
		v.a = (float)Math.ceil(v.a);
		return v;
	}
	public static Vector4f ceil(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.x = (float)Math.ceil(v.x);
		if(y) v.y = (float)Math.ceil(v.y);
		if(z) v.z = (float)Math.ceil(v.z);
		if(a) v.a = (float)Math.ceil(v.a);
		return v;
	}
	public static Vec4f ceil(Vec4f v)
	{
		v.setX(Math.ceil(v.getX()));
		v.setY(Math.ceil(v.getY()));
		v.setZ(Math.ceil(v.getZ()));
		v.setA(Math.ceil(v.getA()));
		return v;
	}
	public static Vec4f ceil(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(z) v.setZ(Math.ceil(v.getZ()));
		if(a) v.setA(Math.ceil(v.getA()));
		return v;
	}
	
	
	
	public static Vector4f roundN(Vector4f v)
	{
		Vector4f out = v.clone();
		out.x = (float)Math.round(out.x);
		out.y = (float)Math.round(out.y);
		out.z = (float)Math.round(out.z);
		out.a = (float)Math.round(out.a);
		return out;
	}
	public static Vector4f roundN(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		Vector4f out = v.clone();
		if(x) out.x = (float)Math.round(out.x);
		if(y) out.y = (float)Math.round(out.y);
		if(z) out.z = (float)Math.round(out.z);
		if(a) out.a = (float)Math.round(out.a);
		return out;
	}
	public static Vec4f roundN(Vec4fBase v)
	{
		Vec4f out = v.clone();
		out.setX(Math.round(out.getX()));
		out.setY(Math.round(out.getY()));
		out.setZ(Math.round(out.getZ()));
		out.setA(Math.round(out.getA()));
		return out;
	}
	public static Vec4f roundN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a)
	{
		Vec4f out = v.clone();
		if(x) out.setX(Math.round(out.getX()));
		if(y) out.setY(Math.round(out.getY()));
		if(z) out.setZ(Math.round(out.getZ()));
		if(a) out.setA(Math.round(out.getA()));
		return out;
	}
	public static Vector4f round(Vector4f v)
	{
		v.x = (float)Math.round(v.x);
		v.y = (float)Math.round(v.y);
		v.z = (float)Math.round(v.z);
		v.a = (float)Math.round(v.a);
		return v;
	}
	public static Vector4f round(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.x = (float)Math.round(v.x);
		if(y) v.y = (float)Math.round(v.y);
		if(z) v.z = (float)Math.round(v.z);
		if(a) v.a = (float)Math.round(v.a);
		return v;
	}
	public static Vec4f round(Vec4f v)
	{
		v.setX(Math.round(v.getX()));
		v.setY(Math.round(v.getY()));
		v.setZ(Math.round(v.getZ()));
		v.setA(Math.round(v.getA()));
		return v;
	}
	public static Vec4f round(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(z) v.setZ(Math.round(v.getZ()));
		if(a) v.setA(Math.round(v.getA()));
		return v;
	}
	
	
	
	public static Vector4f absN(Vector4f v)
	{
		Vector4f out = v.clone();
		out.x = (float)Math.abs(out.x);
		out.y = (float)Math.abs(out.y);
		out.z = (float)Math.abs(out.z);
		out.a = (float)Math.abs(out.a);
		return out;
	}
	public static Vector4f absN(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		Vector4f out = v.clone();
		if(x) out.x = (float)Math.abs(out.x);
		if(y) out.y = (float)Math.abs(out.y);
		if(z) out.z = (float)Math.abs(out.z);
		if(a) out.a = (float)Math.abs(out.a);
		return out;
	}
	public static Vec4f absN(Vec4fBase v)
	{
		Vec4f out = v.clone();
		out.setX(Math.abs(out.getX()));
		out.setY(Math.abs(out.getY()));
		out.setZ(Math.abs(out.getZ()));
		out.setA(Math.abs(out.getA()));
		return out;
	}
	public static Vec4f absN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a)
	{
		Vec4f out = v.clone();
		if(x) out.setX(Math.abs(out.getX()));
		if(y) out.setY(Math.abs(out.getY()));
		if(z) out.setZ(Math.abs(out.getZ()));
		if(a) out.setA(Math.abs(out.getA()));
		return out;
	}
	public static Vector4f abs(Vector4f v)
	{
		v.x = (float)Math.abs(v.x);
		v.y = (float)Math.abs(v.y);
		v.z = (float)Math.abs(v.z);
		v.a = (float)Math.abs(v.a);
		return v;
	}
	public static Vector4f abs(Vector4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.x = (float)Math.abs(v.x);
		if(y) v.y = (float)Math.abs(v.y);
		if(z) v.z = (float)Math.abs(v.z);
		if(a) v.a = (float)Math.abs(v.a);
		return v;
	}
	public static Vec4f abs(Vec4f v)
	{
		v.setX(Math.abs(v.getX()));
		v.setY(Math.abs(v.getY()));
		v.setZ(Math.abs(v.getZ()));
		v.setA(Math.abs(v.getA()));
		return v;
	}
	public static Vec4f abs(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(z) v.setZ(Math.abs(v.getZ()));
		if(a) v.setA(Math.abs(v.getA()));
		return v;
	}

}
