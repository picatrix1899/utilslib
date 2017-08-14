
package cmn.utilslib.essentials;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import cmn.utilslib.math.vector.api.Vec2fBase;
import cmn.utilslib.math.vector.api.Vec3fBase;
import cmn.utilslib.math.vector.api.Vec4fBase;

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
		return ByteBuffer.allocateDirect(size << 1).order(ByteOrder.nativeOrder()).asShortBuffer();
	}
	
	public final static IntBuffer createIntBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
	}
	
	public final static LongBuffer createLongBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(ByteOrder.nativeOrder()).asLongBuffer();
	}	
	
	public final static FloatBuffer createFloatBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
	}		
	
	public final static DoubleBuffer createDoubleBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(ByteOrder.nativeOrder()).asDoubleBuffer();
	}
	


	
	
	
	public final static ByteBuffer wrapByteBuffer(byte... b)
	{
		ByteBuffer buffer = ByteBuffer.allocateDirect(b.length).order(ByteOrder.nativeOrder());
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static ShortBuffer wrapShortBuffer(short... b)
	{
		ShortBuffer buffer = ByteBuffer.allocateDirect(b.length << 1).order(ByteOrder.nativeOrder()).asShortBuffer();
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static IntBuffer wrapIntBuffer(int... b)
	{
		IntBuffer buffer = ByteBuffer.allocateDirect(b.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
		
		buffer.put(b);
		
		return buffer;
	}	
	
	public final static LongBuffer wrapLongBuffer(long... b)
	{
		LongBuffer buffer = ByteBuffer.allocateDirect(b.length << 3).order(ByteOrder.nativeOrder()).asLongBuffer();
		
		buffer.put(b);
		
		return buffer;
	}	
	
	public final static FloatBuffer wrapFloatBuffer(float... b)
	{
		FloatBuffer buffer = ByteBuffer.allocateDirect(b.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(b);
		
		return buffer;
	}
	
	public final static FloatBuffer wrapVector2FBuffer(Vec2fBase... v)
	{
		
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec2fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		
		return buffer;
	}
	
	public final static FloatBuffer wrapVector3FBuffer(Vec3fBase... v)
	{
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec3fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		
		return buffer;
	}
	
	public final static FloatBuffer wrapVector4FBuffer(Vec4fBase... v)
	{
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec4fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
			f[block + 3] = current.getA();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		
		return buffer;
	}
	
	public final static DoubleBuffer wrapDoubleBuffer(double... b)
	{
		DoubleBuffer buffer = ByteBuffer.allocateDirect(b.length << 3).order(ByteOrder.nativeOrder()).asDoubleBuffer();
		
		buffer.put(b);
		
		return buffer;
	}
	
	
	
	
	
	public final static ByteBuffer wrapFlippedByteBuffer(byte... b)
	{
		ByteBuffer buffer = ByteBuffer.allocateDirect(b.length).order(ByteOrder.nativeOrder());
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static ShortBuffer wrapFlippedShortBuffer(short... b)
	{
		ShortBuffer buffer = ByteBuffer.allocateDirect(b.length << 1).order(ByteOrder.nativeOrder()).asShortBuffer();
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static IntBuffer wrapFlippedIntBuffer(int... b)
	{
		IntBuffer buffer = ByteBuffer.allocateDirect(b.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}	
	
	public final static LongBuffer wrapFlippedLongBuffer(long... b)
	{
		LongBuffer buffer = ByteBuffer.allocateDirect(b.length << 3).order(ByteOrder.nativeOrder()).asLongBuffer();
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}	
	
	public final static FloatBuffer wrapFlippedFloatBuffer(float... b)
	{
		FloatBuffer buffer = ByteBuffer.allocateDirect(b.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(b);
		buffer.flip();
		return buffer;
	}
	
	public final static FloatBuffer wrapFlippedVector2FBuffer(Vec2fBase... v)
	{
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec2fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		buffer.flip();
		return buffer;
	}
	
	public final static FloatBuffer wrapFlippedVector3FBuffer(Vec3fBase... v)
	{
		
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec3fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[0];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		buffer.flip();
		return buffer;
	}
	
	public final static FloatBuffer wrapFlippedVector4FBuffer(Vec4fBase... v)
	{
		int dim = v[0].getDimensions();
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		Vec4fBase current;
		
		for(int i = 0; i < v.length; i++)
		{
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
			f[block + 3] = current.getA();
			
			block = i * dim;
		}
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(f.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		buffer.put(f);
		buffer.flip();
		return buffer;
	}
	
	public final static DoubleBuffer wrapFlippedDoubleBuffer(double... b)
	{
		DoubleBuffer buffer = ByteBuffer.allocateDirect(b.length << 3).order(ByteOrder.nativeOrder()).asDoubleBuffer();
		
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
