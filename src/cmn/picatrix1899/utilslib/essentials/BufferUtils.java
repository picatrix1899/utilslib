
package cmn.picatrix1899.utilslib.essentials;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import cmn.picatrix1899.utilslib.vector.Vector2f;
import cmn.picatrix1899.utilslib.vector.Vector3f;
import cmn.picatrix1899.utilslib.vector.Vector4f;

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
	
	public final static FloatBuffer wrapVector2FBuffer(Vector2f... v)
	{
		float[] f = new float[v.length * Vector2f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].x;
			f[i + 1] = v[i].y;
		}
		
		return wrapFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapVector3FBuffer(Vector3f... v)
	{
		float[] f = new float[v.length * Vector3f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].x;
			f[i + 1] = v[i].y;
			f[i + 2] = v[i].z;
		}
		
		return wrapFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapVector4FBuffer(Vector4f... v)
	{
		float[] f = new float[v.length * Vector4f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i + 0] = v[i].x;
			f[i + 1] = v[i].y;
			f[i + 2] = v[i].z;
			f[i + 3] = v[i].a;
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
	
	public final static FloatBuffer wrapFlippedVector2FBuffer(Vector2f... v)
	{
		float[] f = new float[v.length * Vector2f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 2 + 0] = v[i].x;
			f[i * 2 + 1] = v[i].y;
		}
		
		return wrapFlippedFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapFlippedVector3FBuffer(Vector3f... v)
	{
		float[] f = new float[v.length * Vector3f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 3 + 0] = v[i].x;
			f[i * 3 + 1] = v[i].y;
			f[i * 3+ 2] = v[i].z;
		}
		
		return wrapFlippedFloatBuffer(f);
	}
	
	public final static FloatBuffer wrapFlippedVector4FBuffer(Vector4f... v)
	{
		float[] f = new float[v.length * Vector4f.DIMENSIONS];
		
		for(int i = 0; i < v.length; i++)
		{
			f[i * 4 + 0] = v[i].x;
			f[i * 4 + 1] = v[i].y;
			f[i * 4 + 2] = v[i].z;
			f[i * 4 + 3] = v[i].a;
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
