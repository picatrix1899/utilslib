package cmn.utilslib.tests;

import java.util.ArrayList;

import cmn.utilslib.essentials.ReusableIterator;
import cmn.utilslib.testing.IUnitTest;

public class TestReusableIterator implements IUnitTest
{
	@IUnitTest.Test("singlerun()")
	public boolean testSingleRun()
	{

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ReusableIterator<String> it = new ReusableIterator<String>((i) -> { return list.get(i); }, (v) -> { return list.size(); });
		
		int index = 0;
		
		while(it.hasNext())
		{
			
			if(!(it.next().equals(list.get(index)))) return false;
			
			index++;
		}
		
		return true;
	}
}
