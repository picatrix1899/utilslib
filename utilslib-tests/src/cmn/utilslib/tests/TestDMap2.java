package cmn.utilslib.tests;

import cmn.utilslib.dmap.dmaps.DMap2;
import cmn.utilslib.testing.IUnitTest;

public class TestDMap2 implements IUnitTest
{
	@IUnitTest.Test("new DMap2()")
	public boolean testConstructor1()
	{
		try
		{
			@SuppressWarnings("unused")
			DMap2<Integer,Integer> map = new DMap2<Integer,Integer>();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	@IUnitTest.Test("new DMap2(A,B)")
	public boolean testConstructor2()
	{
		try
		{
			@SuppressWarnings("unused")
			DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	@IUnitTest.Test("new DMap2(DMap2<A,B>)")
	public boolean testConstructor3()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		
		try
		{
			@SuppressWarnings("unused")
			DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(mapA);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	@IUnitTest.Test("getA()")
	public boolean testGetA()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);
		
		return map.getA() == 1;
	}
	
	@IUnitTest.Test("getB()")
	public boolean testGetB()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);
		
		return map.getB() == 2;
	}
	
	@IUnitTest.Test("<- setA(A)")
	public boolean testSetAResult()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		return map.setA(3) == map;
	}
	
	@IUnitTest.Test("<- setB(B)")
	public boolean testSetBResult()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		return map.setB(3) == map;
	}
	
	@IUnitTest.Test("<- set(A,B)")
	public boolean testSet1Result()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		return map.set(1,3) == map;
	}
}
