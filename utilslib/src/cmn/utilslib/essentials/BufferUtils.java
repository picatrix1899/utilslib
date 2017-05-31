
package cmn.utilslib.essentials;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import cmn.utilslib.vector.Vec2f;
import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.Vec4f;
import cmn.utilslib.vector.api.Vector2fBase;
import cmn.utilslib.vector.api.Vector3fBase;
import cmn.utilslib.vector.api.Vector4fBase;

/**
 * 
 * @author picatrix1899
 *
 */
public final class BufferUtils
{
	
	public final static ByteBuffer createByteBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
	}
	
	public final static ShortBuffer createShortBuffer(int size)
	{
		return createByteBuffer(size << 1).asShortBuffer();
	}
	
	public final static IntBuffer createIntBuffer(int size)
	{
		return createByteBuffer(size << 2).asIntBuffer();
	}
	
	public final static LongBuffer createLongBuffer(int size)
	{
		return createByteBuffer(size << 3).asLongBuffer();
	}	
	
	public final static FloatBuffer createFloatBuffer(int size)
	{
		return createByteBuffer(size << 2).asFloatBuffer();
	}		
	
	public final static DoubleBuffer createDoubleBuffer(int size)
	{
		return createByteBuffer(size << 3).asDoubleBuffer();
	}
	


	
	
	
	public final static ByteBuffer wrapByteBuffer(byte... b)
	{
		ByteBuffer buffer = BufferUtils.createByteBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static ShortBuffer wrapShortBuffer(short... b)
	{
		ShortBuffer buffer = BufferUtils.createShortBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static IntBuffer wrapIntBuffer(int... b)
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}	
	
	public final static LongBuffer wrapLongBuffer(long... b)
	{
		LongBuffer buffer = BufferUtils.createLongBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}	
	
	public final static FloatBuffer wrapFloatBuffer(float... b)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static FloatBuffer wrapVector2FBuffer(Vector2fBase... v)
	{
		float[] f = new float[v.length * Vec2f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].getX();
			f[i + 1] = v[i].getY();
		}
		
		return wrapFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapVector3FBuffer(Vector3fBase... v)
	{
		float[] f = new float[v.length * Vec3f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].getX();
			f[i + 1] = v[i].getY();
			f[i + 2] = v[i].getZ();
		}
		
		return wrapFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapVector4FBuffer(Vector4fBase... v)
	{
		float[] f = new float[v.length * Vec4f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].getX();
			f[i + 1] = v[i].getY();
			f[i + 2] = v[i].getZ();
			f[i + 3] = v[i].getA();
		}
		
		return wrapFloatBuffer(f);
	}
	
	public final static DoubleBuffer wrapDoubleBuffer(double... b)
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(b.length);
		
		buffer.put(b);
		
		return buffer;
	}
	
	
	
	
	
	public final static ByteBuffer wrapFlippedByteBuffer(byte... b)
	{
		ByteBuffer buffer = BufferUtils.createByteBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static ShortBuffer wrapFlippedShortBuffer(short... b)
	{
		ShortBuffer buffer = BufferUtils.createShortBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static IntBuffer wrapFlippedIntBuffer(int... b)
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}	
	
	public final static LongBuffer wrapFlippedLongBuffer(long... b)
	{
		LongBuffer buffer = BufferUtils.createLongBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}	
	
	public final static FloatBuffer wrapFlippedFloatBuffer(float... b)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static FloatBuffer wrapFlippedVector2FBuffer(Vector2fBase... v)
	{
		float[] f = new float[v.length * Vec2f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 2 + 0] = v[i].getX();
			f[i * 2 + 1] = v[i].getY();
		}
		
		return wrapFlippedFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapFlippedVector3FBuffer(Vector3fBase... v)
	{
		float[] f = new float[v.length * Vec3f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 3 + 0] = v[i].getX();
			f[i * 3 + 1] = v[i].getY();
			f[i * 3 + 2] = v[i].getZ();
		}
		
		return wrapFlippedFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapFlippedVector4FBuffer(Vector4fBase... v)
	{
		float[] f = new float[v.length * Vec4f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 4 + 0] = v[i].getX();
			f[i * 4 + 1] = v[i].getY();
			f[i * 4 + 2] = v[i].getZ();
			f[i * 4 + 3] = v[i].getA();
		}
		
		return wrapFlippedFloatBuffer(f);
	}
	
	public final static DoubleBuffer wrapFlippedDoubleBuffer(double... b)
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(b.length);
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	
	
	
	
	public final static byte[] unwrapIntBuffer(ByteBuffer buffer)
	{
		buffer.flip();
		
		byte[] out = new byte[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
	public final static short[] unwrapShortBuffer(ShortBuffer buffer)
	{
		buffer.flip();
		
		short[] out = new short[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
	public final static int[] unwrapIntBuffer(IntBuffer buffer)
	{
		buffer.flip();
		
		int[] out = new int[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
	public final static long[] unwrapLongBuffer(LongBuffer buffer)
	{
		buffer.flip();
		
		long[] out = new long[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
	public final static float[] unwrapFloatBuffer(FloatBuffer buffer)
	{
		buffer.flip();
		
		float[] out = new float[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
	public final static double[] unwrapDoubleBuffer(DoubleBuffer buffer)
	{
		buffer.flip();
		
		double[] out = new double[buffer.limit()];
		
		buffer.get(out);
		
		return out;
	}
	
}
