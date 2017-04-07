import java.util.Comparator;

import cmn.utilslib.dmap.IDMap2Base;
import cmn.utilslib.dmap.LinkedMapping;
import cmn.utilslib.essentials.MemoryIterator;

public class Main
{

	public static void main(String[] args)
	{
		LinkedMapping<Integer,String> a = new LinkedMapping<Integer,String>();
		
		a.add(0,"0");
		a.add(1,"1");
		a.add(2,"2");
		a.add(3,"3");
		a.add(4,"4");
		a.add(5,"5");
		a.add(6,"6");
		a.add(6,"6");
		a.add(6,"6");
		a.add(6,"6");
		a.add(7,"7");
		a.add(8,"8");
		
		
		a.sortByA(new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2)
			{
				if(o1 == o2)
				{
					return 0;
				}
				else if(o1 < o2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}


		}.reversed());
		
		
		MemoryIterator<IDMap2Base<Integer,String>> i = a.iterator();
		
		while(i.hasNext())
		{
			i.next();
			System.out.println(i.current().getA() + " " + i.current().getB());
		}
		
	}

}
