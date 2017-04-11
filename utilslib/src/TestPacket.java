import java.io.OutputStream;

import cmn.utilslib.net.common.OutgoingPacket;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TestPacket implements OutgoingPacket
{

	@Override
	public void write(OutputStream stream)
	{
		throw new NotImplementedException();
	}

}
