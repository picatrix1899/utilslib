import cmn.utilslib.essentials.Profiler;
import cmn.utilslib.exp.Vector3f;

public class Main
{

	public static void main(String[] args)
	{
		Vector3f v1 = new Vector3f(1, 1, 1);
		Vector3f v2 = new Vector3f(1, 1, 1);
		
		Vector3f v3 = new Vector3f(100, 100, 100);
		
		Profiler p = new Profiler();
		
		int c = 10;
		
		int _va = 0;
		int _vb = 0;
		
		for(int a = 0; a < c; a++)
		{
		
			long nanoA = 0;
			long nanoB = 0;
			
			int cycles = 100;
			
			for(int i = 0; i < cycles; i++)
			{
				
				p.start("a" + i);
				{
					v1.add(v3);
				}
				p.stop("a" + i);
				
				nanoA += p.nano("a" + i);
				
			}
			
			for(int i = 0; i < cycles; i++)
			{

				p.start("b" + i);
				{
					//v2.mul(v3);
					v2.add(v3.getX(), v3.getY(), v3.getZ());
				}
				p.stop("b" + i);
				
				nanoB += p.nano("b" + i);
				
			}
			
			nanoA /= cycles;
			nanoB /= cycles;
		
			if(nanoA < nanoB) _va++;
			if(nanoB < nanoA) _vb++;
			
		}
		System.out.println(_va + "/" + _vb);
		
	}

}
