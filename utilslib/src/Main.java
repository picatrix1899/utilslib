
import cmn.utilslib.dmap.DMapping2;
import cmn.utilslib.dmap.IDMap2;
import cmn.utilslib.dmap.IDMap2Base;
import cmn.utilslib.essentials.Auto;
import cmn.utilslib.interfaces.MemoryIterator;

public class Main
{

	public static void main(String[] args)
	{
		DMapping2<Integer,String> a = new DMapping2<Integer,String>();
		
		IDMap2<Integer,String> m = Auto.DMap2(10,"Test");
		
		a.add(3,"3");
		a.add(4,"4");		
		a.add(1,"1");
		a.add(2,"2");
		a.add(5,"5");
		a.add(6,"6");
		a.add(7,"7");		
		a.add(0,"0");		
		a.add(8,"8");
		a.add(m);

		m = (IDMap2<Integer,String>)a.getFirstByA(10);
		
		m.setA(11);
		
		
		a.sortByA((o1,o2) ->
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
		});
		

		MemoryIterator<IDMap2Base<Integer,String>> i = a.iterator();
		
		while(i.hasNext())
		{
			i.next();
			System.out.println(i.current().getA() + " " + i.current().getB());
		}

	}

	
}
