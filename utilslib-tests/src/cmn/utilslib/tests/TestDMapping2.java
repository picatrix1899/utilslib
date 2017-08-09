package cmn.utilslib.tests;

import java.util.List;

import cmn.utilslib.dmap.dmappings.DMapping2;
import cmn.utilslib.dmap.dmappings.api.IDMapping2;
import cmn.utilslib.dmap.dmaps.DMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.testing.IUnitTest;

public class TestDMapping2 implements IUnitTest
{
	@IUnitTest.Test("add(A,B) v1")
	public boolean testAddA1()
	{
		
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.size() == 10;
	}
	
	@IUnitTest.Test("add(A,B) v2")
	public boolean testAddA2()
	{
		
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.size() == 20;
	}

	@IUnitTest.Test("add(DMap2<A,B>) v1")
	public boolean testAddB1()
	{
		
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(new DMap2<Integer,Integer>(0,9));
		map.add(new DMap2<Integer,Integer>(1,8));
		map.add(new DMap2<Integer,Integer>(2,7));
		map.add(new DMap2<Integer,Integer>(3,6));
		map.add(new DMap2<Integer,Integer>(4,5));
		map.add(new DMap2<Integer,Integer>(5,4));
		map.add(new DMap2<Integer,Integer>(6,3));
		map.add(new DMap2<Integer,Integer>(7,2));
		map.add(new DMap2<Integer,Integer>(8,1));
		map.add(new DMap2<Integer,Integer>(9,0));
		
		return map.size() == 10;
	}
	
	@IUnitTest.Test("add(DMap2<A,B>) v2")
	public boolean testAddB2()
	{
		
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(new DMap2<Integer,Integer>(0,9));
		map.add(new DMap2<Integer,Integer>(1,8));
		map.add(new DMap2<Integer,Integer>(2,7));
		map.add(new DMap2<Integer,Integer>(3,6));
		map.add(new DMap2<Integer,Integer>(4,5));
		map.add(new DMap2<Integer,Integer>(5,4));
		map.add(new DMap2<Integer,Integer>(6,3));
		map.add(new DMap2<Integer,Integer>(7,2));
		map.add(new DMap2<Integer,Integer>(8,1));
		map.add(new DMap2<Integer,Integer>(9,0));
		map.add(new DMap2<Integer,Integer>(0,9));
		map.add(new DMap2<Integer,Integer>(1,8));
		map.add(new DMap2<Integer,Integer>(2,7));
		map.add(new DMap2<Integer,Integer>(3,6));
		map.add(new DMap2<Integer,Integer>(4,5));
		map.add(new DMap2<Integer,Integer>(5,4));
		map.add(new DMap2<Integer,Integer>(6,3));
		map.add(new DMap2<Integer,Integer>(7,2));
		map.add(new DMap2<Integer,Integer>(8,1));
		map.add(new DMap2<Integer,Integer>(9,0));
		
		return map.size() == 20;
	}
	
	@IUnitTest.Test("get(int)")
	public boolean testGet()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		
		IDMap2Base<Integer,Integer> r = map.get(1);
		
		return r.getA() == 1 && r.getB() == 8;
	}
	
	@IUnitTest.Test("get(int[])")
	public boolean testMultiGet()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		List<IDMap2Base<Integer,Integer>> r = map.get(1,3,7,9);
		
		if(!(r.size() == 4)) return false;
		if(!(r.get(0).getA() == 1 && r.get(0).getB() == 8)) return false;
		if(!(r.get(1).getA() == 3 && r.get(1).getB() == 6)) return false;
		if(!(r.get(2).getA() == 7 && r.get(2).getB() == 2)) return false;
		if(!(r.get(3).getA() == 9 && r.get(3).getB() == 0)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getA(int)")
	public boolean testGetA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		
		Integer r = map.getA(1);
		
		return r == 1;
	}
	
	
	@IUnitTest.Test("getA(int[])")
	public boolean testMultiGetA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		List<Integer> r = map.getA(1,3,7,9);
		
		if(!(r.size() == 4)) return false;
		if(!(r.get(0) == 1)) return false;
		if(!(r.get(1) == 3)) return false;
		if(!(r.get(2) == 7)) return false;
		if(!(r.get(3) == 9)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getB(int)")
	public boolean testGetB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		
		Integer r = map.getB(1);
		
		return r == 8;
	}
	
	
	@IUnitTest.Test("getB(int[])")
	public boolean testMultiGetB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		List<Integer> r = map.getB(1,3,7,9);
		
		if(!(r.size() == 4)) return false;
		if(!(r.get(0) == 8)) return false;
		if(!(r.get(1) == 6)) return false;
		if(!(r.get(2) == 2)) return false;
		if(!(r.get(3) == 0)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getByA(A)")
	public boolean testGetByA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(3, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(3, 2);
		map.add(8, 1);
		map.add(3, 0);
		
		List<IDMap2Base<Integer,Integer>> r = map.getByA(3);
		
		if(!(r.size() == 4)) return false;
		if(!(r.get(0).getB() == 8)) return false;
		if(!(r.get(1).getB() == 6)) return false;
		if(!(r.get(2).getB() == 2)) return false;
		if(!(r.get(3).getB() == 0)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getByB(B)")
	public boolean testGetByB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 3);
		map.add(2, 7);
		map.add(3, 3);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 3);
		map.add(8, 1);
		map.add(9, 3);
		
		List<IDMap2Base<Integer,Integer>> r = map.getByB(3);
		
		if(!(r.size() == 5)) return false;
		if(!(r.get(0).getA() == 1)) return false;
		if(!(r.get(1).getA() == 3)) return false;
		if(!(r.get(2).getA() == 6)) return false;
		if(!(r.get(3).getA() == 7)) return false;
		if(!(r.get(4).getA() == 9)) return false;
		
		return true;
	}
	
	
	@IUnitTest.Test("getFirstByA(A)")
	public boolean testGetFirstByA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(3, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(3, 2);
		map.add(8, 1);
		map.add(3, 0);
		
		IDMap2Base<Integer,Integer> r = map.getFirstByA(3);
		
		return r.getB() == 8;
	}
	
	@IUnitTest.Test("getFirstByB(B)")
	public boolean testGetFirstByB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 3);
		map.add(2, 7);
		map.add(3, 3);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 3);
		map.add(8, 1);
		map.add(9, 3);
		
		IDMap2Base<Integer,Integer> r = map.getFirstByB(3);
		
		return r.getA() == 1;
	}
	
	@IUnitTest.Test("getBByA(A)")
	public boolean testGetBByA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(3, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(3, 2);
		map.add(8, 1);
		map.add(3, 0);
		
		List<Integer> r = map.getBByA(3);
		
		if(!(r.size() == 4)) return false;
		if(!(r.get(0) == 8)) return false;
		if(!(r.get(1) == 6)) return false;
		if(!(r.get(2) == 2)) return false;
		if(!(r.get(3) == 0)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getAByB(B)")
	public boolean testGetAByB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 3);
		map.add(2, 7);
		map.add(3, 3);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 3);
		map.add(8, 1);
		map.add(9, 3);
		
		List<Integer> r = map.getAByB(3);
		
		if(!(r.size() == 5)) return false;
		if(!(r.get(0) == 1)) return false;
		if(!(r.get(1) == 3)) return false;
		if(!(r.get(2) == 6)) return false;
		if(!(r.get(3) == 7)) return false;
		if(!(r.get(4) == 9)) return false;
		
		return true;
	}
	
	@IUnitTest.Test("getFirstBByA(A)")
	public boolean testGetFirstBByA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(3, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(3, 2);
		map.add(8, 1);
		map.add(3, 0);
		
		int r = map.getFirstBByA(3);
		
		return r == 8;
	}
	
	@IUnitTest.Test("getFirstAByB(B)")
	public boolean testGetFirstAByB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 3);
		map.add(2, 7);
		map.add(3, 3);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 3);
		map.add(8, 1);
		map.add(9, 3);
		
		int r = map.getFirstAByB(3);
		
		return r == 1;
	}
	
	@IUnitTest.Test("size()")
	public boolean testSize()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 3);
		map.add(2, 7);
		map.add(3, 3);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 3);
		map.add(8, 1);
		map.add(9, 3);
		
		return map.size() == 10;
	}
	
	@IUnitTest.Test("contains(A,B)")
	public boolean testContains1()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.contains(3,6);
	}
	
	@IUnitTest.Test("contains(DMap2<A,B>)")
	public boolean testContains2()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.contains(new DMap2<Integer,Integer>(2,7));
	}
	
	@IUnitTest.Test("contains(A)")
	public boolean testContainsA()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.containsA(3);
	}
	
	@IUnitTest.Test("contains(B)")
	public boolean testContainsB()
	{
		IDMapping2<Integer,Integer> map = new DMapping2<Integer,Integer>();
		
		map.add(0, 9);
		map.add(1, 8);
		map.add(2, 7);
		map.add(3, 6);
		map.add(4, 5);
		map.add(5, 4);
		map.add(6, 3);
		map.add(7, 2);
		map.add(8, 1);
		map.add(9, 0);
		
		return map.containsB(7);
	}
}
