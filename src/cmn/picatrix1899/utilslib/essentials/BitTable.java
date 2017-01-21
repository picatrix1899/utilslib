package cmn.picatrix1899.utilslib.essentials;

/**
 * 

 * @author picatrix1899
 *
 */
public enum BitTable
{
	
	BYTE(8),
	SHORT(16),
	INT(32),
	LONG(64),
	DOUBLE(64),
	STRING(16),
	BOOLEAN(1),
	FLAG8(8),
	FLAG16(16),
	FLAG32(32),
	FLAG64(64),
	VECTOR3D(192),
	VECTOR3F(96)
	;
	
	
	public final int bits;
	
	private BitTable(int bits)
	{
		this.bits = bits;
	}
	
}
