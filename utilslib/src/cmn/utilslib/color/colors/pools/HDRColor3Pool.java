package cmn.utilslib.color.colors.pools;

import cmn.utilslib.Pool;
import cmn.utilslib.color.colors.HDRColor3;
import cmn.utilslib.color.colors.api.IColor3Base;

public class HDRColor3Pool 
{
	public static Pool<HDRColor3> pool = new Pool<HDRColor3>(HDRColor3.class);

	public static HDRColor3 get() { return pool.get(); }
	
	public static HDRColor3 get(int r, int g, int b) { return pool.get().set(r, g, b); }
	
	public static HDRColor3 get(float r, float g, float b) { return pool.get().setUnity(r, g, b); }
	
	public static HDRColor3 get(int brightness) { return pool.get().set(brightness); }
	
	public static HDRColor3 get(float brightness) { return pool.get().setUnity(brightness); }
	
	public static HDRColor3 get(IColor3Base color) { return pool.get().set(color); }
	
	public static void store(HDRColor3 color) { pool.store(color); }
}
