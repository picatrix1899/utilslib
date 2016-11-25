package cmn.picatrix1899.utilslib.essentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LoggingPrintStream extends PrintStream
{

	public LoggingPrintStream(File arg0) throws FileNotFoundException
	{
		super(arg0);
	}

}
