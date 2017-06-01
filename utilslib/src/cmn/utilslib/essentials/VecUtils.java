package cmn.utilslib.essentials;

import cmn.utilslib.vector.api.Vec2d;
import cmn.utilslib.vector.api.Vec2dBase;
import cmn.utilslib.vector.api.Vec2f;
import cmn.utilslib.vector.api.Vec2fBase;
import cmn.utilslib.vector.api.Vec3d;
import cmn.utilslib.vector.api.Vec3dBase;
import cmn.utilslib.vector.api.Vec3f;
import cmn.utilslib.vector.api.Vec3fBase;
import cmn.utilslib.vector.api.Vec4d;
import cmn.utilslib.vector.api.Vec4dBase;
import cmn.utilslib.vector.api.Vec4f;
import cmn.utilslib.vector.api.Vec4fBase;

public class VecUtils
{
	public static Vec2f floorN(Vec2fBase v) { return floor(v.clone()); }
	public static Vec2f floorN(Vec2fBase v, boolean x, boolean y) { return floor(v.clone(), x, y); }
	public static Vec2f floor(Vec2f v) { return floor(v, true, true); }
	public static Vec2f floor(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		return v;
	}
	
	public static Vec3f floorN(Vec3fBase v) { return floor(v.clone()); }
	public static Vec3f floorN(Vec3fBase v, boolean x, boolean y, boolean z) { return floor(v.clone(), x, y, z); }
	public static Vec3f floor(Vec3f v) { return floor(v, true, true, true); }
	public static Vec3f floor(Vec3f v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(y) v.setZ(Math.floor(v.getZ()));
		return v;
	}
	
	public static Vec4f floorN(Vec4fBase v) { return floor(v.clone()); }
	public static Vec4f floorN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a) { return floor(v.clone(), x, y, z, a); }
	public static Vec4f floor(Vec4f v) { return floor(v, true, true, true, true); }
	public static Vec4f floor(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(z) v.setZ(Math.floor(v.getZ()));
		if(a) v.setA(Math.floor(v.getA()));
		return v;
	}
	
	public static Vec2d floorN(Vec2dBase v) { return floor(v.clone()); }
	public static Vec2d floorN(Vec2dBase v, boolean x, boolean y) { return floor(v.clone(), x, y); }
	public static Vec2d floor(Vec2d v) { return floor(v, true, true); }
	public static Vec2d floor(Vec2d v, boolean x, boolean y)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		return v;
	}
	
	public static Vec3d floorN(Vec3dBase v) { return floor(v.clone()); }
	public static Vec3d floorN(Vec3dBase v, boolean x, boolean y, boolean z) { return floor(v.clone(), x, y, z); }
	public static Vec3d floor(Vec3d v) { return floor(v, true, true, true); }
	public static Vec3d floor(Vec3d v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(y) v.setZ(Math.floor(v.getZ()));
		return v;
	}
	
	public static Vec4d floorN(Vec4dBase v) { return floor(v.clone()); }
	public static Vec4d floorN(Vec4dBase v, boolean x, boolean y, boolean z, boolean a) { return floor(v.clone(), x, y, z, a); }
	public static Vec4d floor(Vec4d v) { return floor(v, true, true, true, true); }
	public static Vec4d floor(Vec4d v, boolean x, boolean y, boolean z, boolean a)
	{
		if(x) v.setX(Math.floor(v.getX()));
		if(y) v.setY(Math.floor(v.getY()));
		if(z) v.setZ(Math.floor(v.getZ()));
		if(a) v.setA(Math.floor(v.getA()));
		return v;
	}
	
	
	public static Vec2f ceilN(Vec2fBase v) { return ceil(v.clone()); }
	public static Vec2f ceilN(Vec2fBase v, boolean x, boolean y) { return ceil(v.clone(), x, y); }
	public static Vec2f ceil(Vec2f v) { return ceil(v, true, true); }
	public static Vec2f ceil(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		return v;
	}
	
	public static Vec3f ceilN(Vec3fBase v) { return ceil(v.clone()); }
	public static Vec3f ceilN(Vec3fBase v, boolean x, boolean y, boolean z) { return floor(v.clone(), x, y, z); }
	public static Vec3f ceil(Vec3f v) { return ceil(v, true, true, true); }
	public static Vec3f ceil(Vec3f v, boolean x, boolean y, boolean z)
	{
		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(y) v.setZ(Math.ceil(v.getZ()));
		return v;
	}
	
	public static Vec4f ceilN(Vec4fBase v) { return ceil(v.clone()); }
	public static Vec4f ceilN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a) { return ceil(v.clone(), x, y, z, a); }
	public static Vec4f ceil(Vec4f v) { return ceil(v, true, true, true, true); }
	public static Vec4f ceil(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(z) v.setZ(Math.ceil(v.getZ()));
		if(a) v.setA(Math.ceil(v.getA()));
		return v;
	}
	
	public static Vec2d ceilN(Vec2dBase v) { return ceil(v.clone()); }
	public static Vec2d ceilN(Vec2dBase v, boolean x, boolean y) { return ceil(v.clone(), x, y); }
	public static Vec2d ceil(Vec2d v) { return ceil(v, true, true); }
	public static Vec2d ceil(Vec2d v, boolean x, boolean y)
	{

		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		return v;
	}
	
	public static Vec3d ceilN(Vec3dBase v) { return ceil(v.clone()); }
	public static Vec3d ceilN(Vec3dBase v, boolean x, boolean y, boolean z) { return floor(v.clone(), x, y, z); }
	public static Vec3d ceil(Vec3d v) { return ceil(v, true, true, true); }
	public static Vec3d ceil(Vec3d v, boolean x, boolean y, boolean z)
	{

		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(y) v.setZ(Math.ceil(v.getZ()));
		return v;
	}
	
	public static Vec4d ceilN(Vec4dBase v) { return ceil(v.clone()); }
	public static Vec4d ceilN(Vec4dBase v, boolean x, boolean y, boolean z, boolean a) { return ceil(v.clone(), x, y, z, a); }
	public static Vec4d ceil(Vec4d v) { return ceil(v, true, true, true, true); }
	public static Vec4d ceil(Vec4d v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.ceil(v.getX()));
		if(y) v.setY(Math.ceil(v.getY()));
		if(z) v.setZ(Math.ceil(v.getZ()));
		if(a) v.setA(Math.ceil(v.getA()));
		return v;
	}
	
	
	public static Vec2f roundN(Vec2fBase v) { return round(v.clone()); }
	public static Vec2f roundN(Vec2fBase v, boolean x, boolean y) { return round(v.clone(), x, y); }
	public static Vec2f round(Vec2f v) { return round(v, true, true); }
	public static Vec2f round(Vec2f v, boolean x, boolean y)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		return v;
	}
	
	public static Vec3f roundN(Vec3fBase v) { return round(v.clone()); }
	public static Vec3f roundN(Vec3fBase v, boolean x, boolean y, boolean z) { return round(v.clone(), x, y, z); }
	public static Vec3f round(Vec3f v) { return round(v, true, true, true); }
	public static Vec3f round(Vec3f v, boolean x, boolean y, boolean z)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(y) v.setZ(Math.round(v.getZ()));
		return v;
	}
	
	public static Vec4f roundN(Vec4fBase v) { return round(v.clone()); }
	public static Vec4f roundN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a) { return round(v.clone(), x, y, z, a); }
	public static Vec4f round(Vec4f v) { return round(v, true, true, true, true); }
	public static Vec4f round(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(z) v.setZ(Math.round(v.getZ()));
		if(a) v.setA(Math.round(v.getA()));
		return v;
	}
	
	public static Vec2d roundN(Vec2dBase v) { return round(v.clone()); }
	public static Vec2d roundN(Vec2dBase v, boolean x, boolean y) { return round(v.clone(), x, y); }
	public static Vec2d round(Vec2d v) { return round(v, true, true); }
	public static Vec2d round(Vec2d v, boolean x, boolean y)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		return v;
	}
	
	public static Vec3d roundN(Vec3dBase v) { return round(v.clone()); }
	public static Vec3d roundN(Vec3dBase v, boolean x, boolean y, boolean z) { return round(v.clone(), x, y, z); }
	public static Vec3d round(Vec3d v) { return round(v, true, true, true); }
	public static Vec3d round(Vec3d v, boolean x, boolean y, boolean z)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(y) v.setZ(Math.round(v.getZ()));
		return v;
	}
	
	public static Vec4d roundN(Vec4dBase v) { return round(v.clone()); }
	public static Vec4d roundN(Vec4dBase v, boolean x, boolean y, boolean z, boolean a) { return round(v.clone(), x, y, z, a); }
	public static Vec4d round(Vec4d v) { return round(v, true, true, true, true); }
	public static Vec4d round(Vec4d v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.round(v.getX()));
		if(y) v.setY(Math.round(v.getY()));
		if(z) v.setZ(Math.round(v.getZ()));
		if(a) v.setA(Math.round(v.getA()));
		return v;
	}
	
	public static Vec2f absN(Vec2fBase v) { return abs(v.clone()); }
	public static Vec2f absN(Vec2fBase v, boolean x, boolean y) { return abs(v.clone(), x, y); }
	public static Vec2f abs(Vec2f v) { return abs(v, true, true); }
	public static Vec2f abs(Vec2f v, boolean x, boolean y)
	{
		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		return v;
	}
	
	public static Vec3f absN(Vec3fBase v) { return abs(v.clone()); }
	public static Vec3f absN(Vec3fBase v, boolean x, boolean y, boolean z) { return abs(v.clone(), x, y, z); }
	public static Vec3f abs(Vec3f v) { return abs(v, true, true, true); }
	public static Vec3f abs(Vec3f v, boolean x, boolean y, boolean z)
	{

		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(y) v.setZ(Math.abs(v.getZ()));
		return v;
	}
	
	public static Vec4f absN(Vec4fBase v) { return abs(v.clone()); }
	public static Vec4f absN(Vec4fBase v, boolean x, boolean y, boolean z, boolean a) { return abs(v.clone(), x, y, z, a); }
	public static Vec4f abs(Vec4f v) { return abs(v, true, true, true, true); }
	public static Vec4f abs(Vec4f v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(z) v.setZ(Math.abs(v.getZ()));
		if(a) v.setA(Math.abs(v.getA()));
		return v;
	}
	
	public static Vec2d absN(Vec2dBase v) { return abs(v.clone()); }
	public static Vec2d absN(Vec2dBase v, boolean x, boolean y) { return abs(v.clone(), x, y); }
	public static Vec2d abs(Vec2d v) { return abs(v, true, true); }
	public static Vec2d abs(Vec2d v, boolean x, boolean y)
	{

		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		return v;
	}
	
	public static Vec3d absN(Vec3dBase v) { return abs(v.clone()); }
	public static Vec3d absN(Vec3dBase v, boolean x, boolean y, boolean z) { return abs(v.clone(), x, y, z); }
	public static Vec3d abs(Vec3d v) { return abs(v, true, true, true); }
	public static Vec3d abs(Vec3d v, boolean x, boolean y, boolean z)
	{

		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(y) v.setZ(Math.abs(v.getZ()));
		return v;
	}
	
	public static Vec4d absN(Vec4dBase v) { return abs(v.clone()); }
	public static Vec4d absN(Vec4dBase v, boolean x, boolean y, boolean z, boolean a) { return abs(v.clone(), x, y, z, a); }
	public static Vec4d abs(Vec4d v) { return abs(v, true, true, true, true); }
	public static Vec4d abs(Vec4d v, boolean x, boolean y, boolean z, boolean a)
	{

		if(x) v.setX(Math.abs(v.getX()));
		if(y) v.setY(Math.abs(v.getY()));
		if(z) v.setZ(Math.abs(v.getZ()));
		if(a) v.setA(Math.abs(v.getA()));
		return v;
	}
}
