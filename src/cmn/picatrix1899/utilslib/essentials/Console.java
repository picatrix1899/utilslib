package cmn.picatrix1899.utilslib.essentials;

import java.util.List;

/**
 * 

 * @author picatrix1899
 *
 */
public class Console
{
	
	public static void println(String arg0) { System.out.println(arg0); }
	
	public static void println(boolean arg0) { System.out.println(arg0); }
	
	public static void println(int arg0) { System.out.println(arg0); }
	
	public static void println(double arg0) { System.out.println(arg0); }
	
	public static void println(long arg0) { System.out.println(arg0); }
	
	public static void println(byte arg0) { System.out.println(arg0); }
	
	public static void println(short arg0) { System.out.println(arg0); }
	
	public static void println(Object arg0) { System.out.println(arg0); }
	
	
	
	public static void print(String arg0) { System.out.print(arg0); }
	
	public static void print(boolean arg0) { System.out.print(arg0); }
	
	public static void print(int arg0) { System.out.print(arg0); }
	
	public static void print(double arg0) { System.out.print(arg0); }
	
	public static void print(long arg0) { System.out.print(arg0); }
	
	public static void print(byte arg0) { System.out.print(arg0); }
	
	public static void print(short arg0) { System.out.print(arg0); }
	
	public static void print(Object arg0) { System.out.print(arg0); }
	
	
	

	public static void println(Object... arg0)
	{
		printlnf(" ", arg0);
	}
		
	public static void printlnf(String arg0, Object... arg1)
	{
		
		for(int i = 0; i < arg1.length; i++)
		{
			
			if(!(i == arg1.length - 1))
			{
				print(arg1[i]);				
				print(arg0);						
			}
			else
			{
				println(arg1[i]);
			}
			
		}
	}

	public static void println(List<?> arg0)
	{
		
		for(int i = 0; i < arg0.size(); i++)
		{
			
			if(!(i == arg0.size() - 1))
			{
				print(arg0.get(i));				
				print(" ");						
			}
			else
			{
				println(arg0.get(i));
			}
			
		}
	}
}
