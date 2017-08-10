package cmn.utilslib.tests;

import cmn.utilslib.dmap.dmaps.DMap2;
import cmn.utilslib.dmap.dmaps.LinkedDMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.testing.IUnitTest;

public class TestDMap2 implements IUnitTest
{
	@IUnitTest.Test("new DMap2()")
	public boolean testConstructor1()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>();
			
		return map.getA() == null && map.getB() == null;
	}
	
	@IUnitTest.Test("new DMap2(A,B)")
	public boolean testConstructor2()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);
			
		return map.getA() == 1 && map.getB() == 2;
	}
	
	@IUnitTest.Test("new DMap2(IDMap2Base<A,B>)")
	public boolean testConstructor3()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);

		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(mapA);
		
		return map.getA() == 1 && map.getB() == 2;

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
	
	@IUnitTest.Test("<- set(IDMap2Base<A,B>)")
	public boolean testSet2Result()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		return map.set(new DMap2<Integer,Integer>(1,4)) == map;
	}
	
	@IUnitTest.Test("set(A)")
	public boolean testSetA()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		map.setA(4);
		
		return map.getA() == 4;
	}
	
	@IUnitTest.Test("set(B)")
	public boolean testSetB()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		map.setB(3);
		
		return map.getB() == 3;
	}
	
	@IUnitTest.Test("set(A,B)")
	public boolean testSet1()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		map.set(8,3);
		
		return map.getA() == 8 && map.getB() == 3;
	}
	
	@IUnitTest.Test("set(IDMap2Base<A,B>)")
	public boolean testSet2()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		map.set(new DMap2<Integer,Integer>(8,3));
		
		return map.getA() == 8 && map.getB() == 3;
	}
	
	@IUnitTest.Test("clone()")
	public boolean testClone()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		map = map.clone();
		
		return map.getA() == 1 && map.getB() == 2;
	}
	
	@IUnitTest.Test("toString()")
	public boolean testToString()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);

		String s = "DMap2(\n1\n,\n2\n)";
		
		return map.toString().equals(s);
	}
	
	@IUnitTest.Test("equals(DMap2) - true")
	public boolean testEquals1()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		DMap2<Integer,Integer> mapB = new DMap2<Integer,Integer>(1,2);
		
		return mapA.equals(mapB);
	}
	
	@IUnitTest.Test("equals(DMap2) - false")
	public boolean testEquals2()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		DMap2<Integer,Integer> mapB = new DMap2<Integer,Integer>(4,2);
		
		return !mapA.equals(mapB);
	}
	
	@IUnitTest.Test("equals(IDMap2Base) - true")
	public boolean testEquals3()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		IDMap2Base<Integer,Integer> mapB = new IDMap2Base<Integer,Integer>()
		{

			@Override
			public Integer getA()
			{
				return 1;
			}

			@Override
			public Integer getB()
			{
				return 2;
			}
			
		};
		
		return mapA.equals(mapB);
	}
	
	@IUnitTest.Test("equals(IDMap2Base) - false")
	public boolean testEquals4()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		IDMap2Base<Integer,Integer> mapB = new IDMap2Base<Integer,Integer>()
		{

			@Override
			public Integer getA()
			{
				return 4;
			}

			@Override
			public Integer getB()
			{
				return 2;
			}
			
		};
		
		return !mapA.equals(mapB);
	}
	
	@IUnitTest.Test("IDMap2Base.equals(DMap2)")
	public boolean testEquals5()
	{
		DMap2<Integer,Integer> mapA = new DMap2<Integer,Integer>(1,2);
		IDMap2Base<Integer,Integer> mapB = new LinkedDMap2<Integer,Integer>(1,2);
		
		return mapB.equals(mapA);
	}
	
	@IUnitTest.Test("hashcode() - null,null")
	public boolean testHashcode1()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>();
		
		return map.hashCode() == 0;
	}
	
	@IUnitTest.Test("hashcode() - x,null")
	public boolean testHashcode2()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>();
		
		map.setA(1);
		
		return map.hashCode() == 37;
	}
	
	@IUnitTest.Test("hashcode() - null,x")
	public boolean testHashcode3()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>();
		
		map.setB(1);
		
		return map.hashCode() == 1;
	}
	
	@IUnitTest.Test("hashcode() - x,x")
	public boolean testHashcode4()
	{
		DMap2<Integer,Integer> map = new DMap2<Integer,Integer>(1,2);
		
		return map.hashCode() == 39 ;
	}
}
