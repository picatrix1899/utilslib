package tests;

import cmn.utilslib.validation.Validate;

public class Main
{

	public static void main(String[] args)
	{
		Validate.isNull(null, "test", null, 0);
	}

}
