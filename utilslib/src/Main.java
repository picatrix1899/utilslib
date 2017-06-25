
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import cmn.utilslib.math.geometry.Area3f;
import cmn.utilslib.math.geometry.Plane3f;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.geometry.StraightLine3f;
import cmn.utilslib.math.vector.Vector3f;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
		byte b1 = (byte)0;
		byte b2 = (byte)5;
		
		byte[] b = { 1, 2, 3, 4 };
		
		ByteArrayOutputStream streamo = new ByteArrayOutputStream();
		streamo.write(b1);
		streamo.write(b);
		streamo.write(b2);
		
		
		byte[] data = streamo.toByteArray();
		
		ByteArrayInputStream streami = new ByteArrayInputStream(data);
		
		byte _b1 = (byte)(streami.read() & 0xFF);
		
		streami.skip(b.length -1);
		
		byte _b2 = (byte)(streami.read() & 0xFF);
		
		System.out.println(_b1);
		System.out.println(_b2);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
