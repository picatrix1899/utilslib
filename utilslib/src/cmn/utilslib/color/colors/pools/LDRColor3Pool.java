package cmn.utilslib.color.colors.pools;

import cmn.utilslib.Pool;
import cmn.utilslib.color.colors.LDRColor3;
import cmn.utilslib.color.colors.api.IColor3Base;

public class LDRColor3Pool 
{
	public static Pool<LDRColor3> pool = new Pool<LDRColor3>(LDRColor3.class);

	public static LDRColor3 get() { return pool.get(); }
	
	public static LDRColor3 get(int r, int g, int b) { return pool.get().set(r, g, b); }
	
	public static LDRColor3 get(float r, float g, float b) { return pool.get().setUnity(r, g, b); }
	
	public static LDRColor3 get(int brightness) { return pool.get().set(brightness); }
	
	public static LDRColor3 get(float brightness) { return pool.get().setUnity(brightness); }
	
	public static LDRColor3 get(IColor3Base color) { return pool.get().set(color); }
	
	public static void store(LDRColor3 color) { pool.store(color); }
}
