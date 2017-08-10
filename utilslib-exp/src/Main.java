import cmn.utilslib.dmap.dmaps.DMap2;
import cmn.utilslib.dmap.dmaps.LinkedDMap2;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;

public class Main
{

	public static void main(String[] args)
	{
		IDMap2Base<Integer,Integer> map = new LinkedDMap2<Integer,Integer>();
		
		map.equals(1);
	}

	public static interface T
	{
		
	}
	
	public static class A implements T
	{
		public boolean equals(Object obj)
		{
			System.out.println("A");
			
			return true;
		}
	}
	
	public static class B implements T
	{
		public boolean equals(Object obj)
		{
			
			System.out.println("B");
			
			return true;
		}
	}
}
