package cmn.utilslib.tests;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.testing.IUnitTest;

public class TestAuto implements IUnitTest
{
	@IUnitTest.Test("Auto.ArrayList()")
	public boolean testArrayList1()
	{

		ArrayList<Integer> list = Auto.ArrayList();
		
		if(list == null) return false;
		
		return list.size() == 0;
	}
	
	@IUnitTest.Test("Auto.ArrayList(...) - a")
	public boolean testArrayList2a()
	{

		ArrayList<Integer> list = Auto.ArrayList(1,2,3,4);
		
		if(list == null) return false;
		
		return list.size() == 4;
	}
	
	@IUnitTest.Test("Auto.ArrayList(...) - b")
	public boolean testArrayList2b()
	{

		Integer[] arr = new Integer[] {1,2,3,4};
		
		ArrayList<Integer> list = Auto.ArrayList(arr);
		
		if(list == null) return false;
		
		return list.size() == 4;
	}
}
