
package cmn.utilslib.color;



import cmn.utilslib.dmap.DMap4;
import cmn.utilslib.essentials.Auto;



/**
 * The format used to compress and decompress a color-code.<br>
 * <br>
 * The letters represents the order of color components.<br>
 * The number represents the bits used in the integer color-code <b> not the bits used for one single component.</b>.
 * @author picatrix1899
 * @category Color
 */
public enum ColorFormat
{
	
	/**	Compressing/Decompressing method: 32 bit code with 3 components. each component fills 8 bit. the component order is R, G, B. */
	RGB_32(ColorWriter.RGB_32, ColorReader.RGB_32),
	
	/**	Compressing/Decompressing method: 32 bit code with 3 components. each component fills 8 bit. the component order is B, G, R. */
	BGR_32(ColorWriter.BGR_32, ColorReader.BGR_32),
	
	/**	Compressing/Decompressing method: 32 bit code with 4 components. each component fills 8 bit. the component order is R, G, B, A. */
	RGBA_32(ColorWriter.RGBA_32, ColorReader.RGBA_32),
	
	/** Compressing/Decompressing method: 32 bit code with 4 components. each component fills 8 bit. the component order is B, G, R, A. */
	BGRA_32(ColorWriter.BGRA_32, ColorReader.BGRA_32),
	
	/** Compressing/Decompressing method: 32 bit code with 4 components. each component fills 8 bit. the component order is A, R, G, B. */
	ARGB_32(ColorWriter.ARGB_32, ColorReader.ARGB_32),
	
	/** Compressing/Decompressing method: 32 bit code with 4 components. each component fills 8 bit. the component order is A, B, G, R. */
	ABGR_32(ColorWriter.ABGR_32, ColorReader.ABGR_32),
	
	/** Compressing/Decompressing method: 16 bit code with 3 components. each component fills 4 bit. the component order is R, G, B. */
	RGB_16(ColorWriter.RGB_16, ColorReader.RGB_16),
	
	/** Compressing/Decompressing method: 16 bit code with 3 components. each component fills 4 bit. the component order is B, G, R. */
	BGR_16(ColorWriter.BGR_16, ColorReader.BGR_16),
	
	/** Compressing/Decompressing method: 16 bit code with 4 components. each component fills 4 bit. the component order is R, G, B, A. */
	RGBA_16(ColorWriter.RGBA_16, ColorReader.RGBA_16),
	
	/** Compressing/Decompressing method: 16 bit code with 4 components. each component fills 4 bit. the component order is B, G, R, A. */
	BGRA_16(ColorWriter.BGRA_16, ColorReader.BGRA_16),
	
	/** Compressing/Decompressing method: 16 bit code with 4 components. each component fills 4 bit. the component order is A, R, G, B. */
	ARGB_16(ColorWriter.ARGB_16, ColorReader.ARGB_16),
	
	/** Compressing/Decompressing method: 16 bit code with 4 components. each component fills 4 bit. the component order is A, B, G, R. */
	ABGR_16(ColorWriter.ABGR_16, ColorReader.ABGR_16);
	
	
	
	private ColorWriter writer;
	private ColorReader reader;
	
	
	
	private ColorFormat(ColorWriter writer, ColorReader reader)
	{
		this.writer = writer;
		this.reader = reader;
	}
	
	
	
	/**
	 * Compresses a color to a color-code.
	 * @param r : The red component.
	 * @param g : The green component.
	 * @param b : The blue component.
	 * @param a : The alpha component.
	 * @return The compressed color-code.
	 */
	public int write(byte r, byte g, byte b, byte a)
	{
		return this.writer.write(r, g, b, a);
	}
	
	
	
	/**
	 * Decompress a color-code.
	 * @param i : The color-code.
	 * @return The decompressed color as DMap4 packet.
	 */
	public DMap4<Byte,Byte,Byte,Byte> read(int i)
	{
		return this.reader.read(i);
	}
	
	
	
	private static abstract class ColorReader
	{
		
		public abstract DMap4<Byte,Byte,Byte,Byte> read(int i);
		
		
		
		public static int _16Bit(int i , int shift) { return (int)Math.round(((int)((byte)(i >> shift)) & 0x0F) / 15.0f * 255); }
		
		public static int _32Bit(int i, int shift) { return (int)((byte)(i >> shift)) & 0xFF; }
		
		
		
		public static ColorReader RGB_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 16), (byte)_32Bit(i, 8), (byte)_32Bit(i, 0), (byte)255); }
		};
		
		public static ColorReader BGR_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 0), (byte)_32Bit(i, 8), (byte)_32Bit(i, 16), (byte)255); }
		};
		
		public static ColorReader RGBA_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 24), (byte)_32Bit(i, 16), (byte)_32Bit(i, 8), (byte)_32Bit(i, 0)); }
		};
		
		public static ColorReader BGRA_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 8), (byte)_32Bit(i, 16), (byte)_32Bit(i, 24), (byte)_32Bit(i, 0)); }
		};
		
		public static ColorReader ARGB_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 16), (byte)_32Bit(i, 8), (byte)_32Bit(i, 0), (byte)_32Bit(i, 24)); }
		};
		
		public static ColorReader ABGR_32 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_32Bit(i, 0), (byte)_32Bit(i, 8), (byte)_32Bit(i, 16), (byte)_32Bit(i, 24)); }
		};
		
		
		
		public static ColorReader RGB_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 8), (byte)_16Bit(i, 4), (byte)_16Bit(i, 0), (byte)255); }
		};
		
		public static ColorReader BGR_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 0), (byte)_16Bit(i, 4), (byte)_16Bit(i, 8), (byte)255); }
		};
		
		public static ColorReader RGBA_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 12), (byte)_16Bit(i, 8), (byte)_16Bit(i, 4), (byte)_16Bit(i, 0)); }
		};
		
		public static ColorReader BGRA_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 4), (byte)_16Bit(i, 8), (byte)_16Bit(i, 12), (byte)_16Bit(i, 0)); }
		};
		
		public static ColorReader ARGB_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 8), (byte)_16Bit(i, 4), (byte)_16Bit(i, 0), (byte)_16Bit(i, 12)); }
		};
		
		public static ColorReader ABGR_16 = new ColorReader()
		{
			public DMap4<Byte, Byte, Byte, Byte> read(int i) { return Auto.DMap4((byte)_16Bit(i, 0), (byte)_16Bit(i, 4), (byte)_16Bit(i, 8), (byte)_16Bit(i, 12)); }
		};
		
	}

	
	
	private static abstract class ColorWriter
	{
		
		public abstract int write(byte r, byte g, byte b, byte a);
		
		
		
		public static int _16Bit(byte b, int shift) { return ((int)Math.round(((int)b & 0xFF) / 255.0f * 15)) << shift; }
		
		public static int _32Bit(byte b, int shift) { return ((int)b & 0xFF) << shift; }
		
		
		
		public static ColorWriter RGB_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(r, 16) | _32Bit(g, 8) | _32Bit(b, 0); }
		};
		
		public static ColorWriter BGR_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(b, 16) | _32Bit(g, 8) | _32Bit(r, 0); }
		};
		
		public static ColorWriter RGBA_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(r, 24) | _32Bit(g, 16) | _32Bit(b, 8) | _32Bit(a, 0); }
		};
		
		public static ColorWriter BGRA_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(b, 24) | _32Bit(g, 16) | _32Bit(r, 8) | _32Bit(a, 0); }
		};
		
		public static ColorWriter ARGB_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(a, 24) | _32Bit(r, 16) | _32Bit(g, 8) | _32Bit(b, 0); }
		};
		
		public static ColorWriter ABGR_32 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _32Bit(a, 24) | _32Bit(b, 16) | _32Bit(g, 8) | _32Bit(r, 0); }
		};
		
		
		
		public static ColorWriter RGB_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(r, 8) | _16Bit(g, 4)| _16Bit(b, 0); }
		};
		
		public static ColorWriter BGR_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(b, 8) | _16Bit(g, 4)| _16Bit(r, 0); }
		};
		
		public static ColorWriter RGBA_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(r, 12) | _16Bit(g, 8) | _16Bit(b, 4)| _16Bit(a, 0); }
		};
		
		public static ColorWriter BGRA_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(b, 12) | _16Bit(g, 8) | _16Bit(r, 4)| _16Bit(a, 0); }
		};
		
		public static ColorWriter ARGB_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(a, 12) | _16Bit(r, 8) | _16Bit(g, 4)| _16Bit(b, 0); }
		};
		
		public static ColorWriter ABGR_16 = new ColorWriter()
		{
			public int write(byte r, byte g, byte b, byte a) { return 0 | _16Bit(a, 12) | _16Bit(b, 8) | _16Bit(g, 4)| _16Bit(r, 0); }
		};
		
	}

}
